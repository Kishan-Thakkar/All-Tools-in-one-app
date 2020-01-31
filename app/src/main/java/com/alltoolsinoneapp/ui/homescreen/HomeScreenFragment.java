package com.alltoolsinoneapp.ui.homescreen;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alltoolsinoneapp.R;
import com.alltoolsinoneapp.Utils.AppConstants;
import com.alltoolsinoneapp.Utils.DialogUtil;
import com.alltoolsinoneapp.fragment.BaseFragment;
import com.alltoolsinoneapp.model.HomeScreenData;
import com.alltoolsinoneapp.ui.OnFragmentListItemSelectListener;
import com.alltoolsinoneapp.ui.UiConstants;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.checkSelfPermission;

/**
 * Created by Kishan Thakkar on 1/30/2020.
 * Kishanpujara127@gmail.com
 */
public class HomeScreenFragment extends BaseFragment implements OnFragmentListItemSelectListener {
    private View root_view;
    private Activity activity;
    private RecyclerView rv_home_screen;
    private HomeScreenAdapter homeScreenAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.fragment_homescreen, container, false);
        activity = getActivity();
        initViews();
        return root_view;
    }

    private void initViews() {
        rv_home_screen = root_view.findViewById(R.id.rv_home_screen);
        rv_home_screen.setLayoutManager(new GridLayoutManager(activity, 4));
        List<HomeScreenData> homeScreenDataList = new ArrayList<>();
        homeScreenDataList.add(new HomeScreenData(R.drawable.ic_code, "Barcode scanner"));
        homeScreenDataList.add(new HomeScreenData(R.drawable.ic_code, "Qr Scanner"));
        homeScreenAdapter = new HomeScreenAdapter(activity, homeScreenDataList);
        homeScreenAdapter.setListner(this);
        rv_home_screen.setAdapter(homeScreenAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mListener.onFragmentUpdate(AppConstants.updateFragmentId, UiConstants.HOME_SCREEN_FRAGMENT);


    }

    public static Fragment newInstance() {
        return new HomeScreenFragment();
    }

    @Override
    public void onListItemSelected(int itemId, Object data) {
        switch (itemId) {
            case R.id.tv_feature_name:
                mListener.onFragmentInteraction(UiConstants.SCANNER_FRAGMENT, null);
                break;
        }
    }

    @Override
    public void onListItemLongClicked(int itemId, Object data) {

    }
}
