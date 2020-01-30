package com.qrbarcodescanner.activity;


import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.qrbarcodescanner.R;
import com.qrbarcodescanner.ui.OnFragmentInteractionListener;
import com.qrbarcodescanner.ui.UiConstants;
import com.qrbarcodescanner.ui.scanner.ScannerFragment;

public class MainActivity extends BaseActivity implements OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateScreen();
    }

    private void updateScreen() {
        onFragmentInteraction(UiConstants.SCANNER_FRAGMENT, null);
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
            case UiConstants.SCANNER_FRAGMENT:
                mFragmentManager.beginTransaction().addToBackStack(mFragmentTag).replace(R.id.fragment_main, ScannerFragment.newInstance(), mFragmentTag).commitAllowingStateLoss();
                break;
        }
    }

    @Override
    public void onFragmentUpdate(int type, Object data) {

    }
}
