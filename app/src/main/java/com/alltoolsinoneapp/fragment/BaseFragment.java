package com.alltoolsinoneapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.alltoolsinoneapp.ui.OnFragmentInteractionListener;


public abstract class BaseFragment extends Fragment {
    Activity activity;
    public OnFragmentInteractionListener mListener;
    private AppCompatActivity mActivity;

    private static Snackbar snackbar;


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        // QLog.m11v("Class:" + getClass().getSimpleName());

        super.onViewCreated(view, savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //      // QLog.m11v("Class:" + getClass().getSimpleName());

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void showError(String error) {
        if (error != null) {
            if (getView() != null) {
                snackbar = Snackbar.make(getView(), error, Snackbar.LENGTH_INDEFINITE).setActionTextColor(Color.WHITE).setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (getView() != null) {
                            if (snackbar != null) {
                                snackbar.dismiss();
                            }
                        }
                    }
                });
                snackbar.show();
            } else if (activity != null) {
              //  DialogUtil.customToast(activity, error);
            }

        }
    }





    public void onCreate(Bundle savedInstanceState) {
        //  // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onCreate(savedInstanceState);

        if (snackbar != null && snackbar.isShown()) {
            snackbar.dismiss();
            snackbar = null;
        }


    }

    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attrs, Bundle savedInstanceState) {
        //// // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onInflate(activity, attrs, savedInstanceState);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onActivityCreated(savedInstanceState);
    }

    public void onStart() {
        // // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onStart();
    }

    public void onResume() {
        // QLog.m11v("Class:" + getClass().getSimpleName());

        super.onResume();
    }

    public void onPause() {
        // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onPause();
    }

    public void onStop() {
        // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onStop();
        if (getView() != null) {
           // DialogUtil.hideKeyboard(getView().findFocus(), getActivity());
        }
    }

    public void onDestroyView() {
        // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onDestroyView();

    }

    public void onDestroy() {
        // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onDestroy();
        if (snackbar != null && snackbar.isShown()) {
            snackbar.dismiss();
            snackbar = null;
        }
    }


    public void onLowMemory() {
        // QLog.m11v("Class:" + getClass().getSimpleName());
        super.onLowMemory();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        ((MainActivity)getActivity()).setEventListner((EventListner)context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        mActivity = null;
        if (snackbar != null && snackbar.isShown()) {
            snackbar.dismiss();
            snackbar = null;
        }
    }











}
