package com.alltoolsinoneapp.ui.scanner;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.alltoolsinoneapp.Utils.AppConstants;
import com.alltoolsinoneapp.R;
import com.alltoolsinoneapp.Utils.DialogUtil;
import com.alltoolsinoneapp.fragment.BaseFragment;
import com.alltoolsinoneapp.ui.UiConstants;

import java.io.IOException;

import static androidx.core.content.ContextCompat.checkSelfPermission;

/**
 * Created by Kishan Thakkar on 1/30/2020.
 * RapidBox
 * Kishanpujara127@gmail.com
 */
public class ScannerFragment extends BaseFragment {
    private View root_view;
    private Activity activity;
    private SurfaceView surfaceView;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private String scanResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.fragment_scanner, container, false);
        activity = getActivity();
        initViews();
        return root_view;
    }

    private void initViews() {
        surfaceView=root_view.findViewById(R.id.surfaceView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mListener.onFragmentUpdate(AppConstants.updateFragmentId, UiConstants.SCANNER_FRAGMENT);
        if (checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    AppConstants.MY_CAMERA_SCAN_PERMISSION);
        } else {
            initialiseDetectorsAndSources();
        }

    }

    public static Fragment newInstance() {
        return new ScannerFragment();
    }
    private void initialiseDetectorsAndSources() {

        Toast.makeText(activity, "Barcode scanner started", Toast.LENGTH_SHORT).show();
        surfaceView.setVisibility(View.VISIBLE);
        barcodeDetector = new BarcodeDetector.Builder(activity)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();


        cameraSource = new CameraSource.Builder(activity, barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true)//you should add this feature
                .build();


        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                try {
                    if (checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSource.start(surfaceView.getHolder());
                    } else {
                        requestPermissions(new String[]{Manifest.permission.CAMERA},
                                AppConstants.MY_CAMERA_SCAN_PERMISSION);
                    }


                } catch (IOException e) {
                    // e.printStackTrace();
                }


            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                // DialogUtil.showToast(activity, "stop");
                //  Toast.makeText(activity, "To prevent memory leaks barcode scanner has been stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() != 0) {

                    surfaceView.post(new Runnable() {

                        @Override
                        public void run() {

                           if(barcodes.valueAt(0).wifi!=null)
                           {
                               DialogUtil.showToast(activity,"Wifi");
                           }else {
                               scanResult = barcodes.valueAt(0).displayValue;
                               DialogUtil.showToast(activity,"normal");
                           }

                            //scanResult=   barcodes.valueAt(0).wifi;
                            //DialogUtil.showToast(activity,scanResult);

                        }

                    });

                }
            }
        });
    }
}
