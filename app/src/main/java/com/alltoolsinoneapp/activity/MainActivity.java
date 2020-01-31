package com.alltoolsinoneapp.activity;


import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.alltoolsinoneapp.R;
import com.alltoolsinoneapp.ui.OnFragmentInteractionListener;
import com.alltoolsinoneapp.ui.UiConstants;
import com.alltoolsinoneapp.ui.homescreen.HomeScreenFragment;
import com.alltoolsinoneapp.ui.scanner.ScannerFragment;

public class MainActivity extends BaseActivity implements OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateScreen();
    }

    private void updateScreen() {
        onFragmentInteraction(UiConstants.HOME_SCREEN_FRAGMENT, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private int mCurrentFragment;

    @Override
    public void onFragmentInteraction(int fragmentId, Object data) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        mCurrentFragment = fragmentId;
        String mFragmentTag = String.valueOf(fragmentId);
        switch (fragmentId) {
            case UiConstants.HOME_SCREEN_FRAGMENT:
                mFragmentManager.beginTransaction().addToBackStack(mFragmentTag).replace(R.id.fragment_main, HomeScreenFragment.newInstance(), mFragmentTag).commitAllowingStateLoss();
                break;
            case UiConstants.SCANNER_FRAGMENT:
                mFragmentManager.beginTransaction().addToBackStack(mFragmentTag).replace(R.id.fragment_main, ScannerFragment.newInstance(), mFragmentTag).commitAllowingStateLoss();
                break;
        }
    }

    @Override
    public void onFragmentUpdate(int type, Object data) {

    }
}
