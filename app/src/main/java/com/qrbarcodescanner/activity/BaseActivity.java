package com.qrbarcodescanner.activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;




/**
 * Created by Kishan Thakkar on 3/19/2019.
 * RapidBox
 * Kishanpujara127@gmail.com
 */

public class BaseActivity extends AppCompatActivity {

    Thread.UncaughtExceptionHandler defHandler;

    @Override
    protected void onStart() {
        super.onStart();
    }



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //registerMessageReceivers();



//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
//                //    Crashlytics.logException(paramThrowable.getCause());
//                //  Intent intent = new Intent(BaseActivity.this, MainActivity.class);
//                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
//                //      | Intent.FLAG_ACTIVITY_CLEAR_TASK
//                //    | Intent.FLAG_ACTIVITY_NEW_TASK);
//                // intent.putExtra(AppConstants.fragmentName, AppConstants.HOME_FRAGMENT);
//                // PendingIntent pendingIntent = PendingIntent.getActivity(BaseActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//                // AlarmManager mgr = (AlarmManager) BaseActivity.this.getSystemService(Context.ALARM_SERVICE);
//                // mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 200, pendingIntent);
//                // finish();
//                //System.exit(2);
//            }
//        });

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(messageReceiver);
      //  DialogUtil.dismissDialog();
    }

    protected void onPause() {
        super.onPause();

    }

    protected void onStop() {
        super.onStop();
    }

    protected void onResume() {
        super.onResume();
//        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver, filter);

    }





    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //QLog.m11v("Class:" + getClass().getSimpleName());
        super.onActivityResult(requestCode, resultCode, data);

    }

    class ExceptionHandler implements
            Thread.UncaughtExceptionHandler {
        private final Activity myContext;

        public ExceptionHandler(Activity context) {
            myContext = context;
        }

        public void uncaughtException(Thread thread, Throwable exception) {
            defHandler.uncaughtException(thread, exception);

            exception.printStackTrace();
            Intent intent = new Intent(myContext, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK
                    | Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
            AlarmManager mgr = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 500, pendingIntent);
            finish();
            System.exit(2);

//            Intent i = getBaseContext().getPackageManager()
//                    .getLaunchIntentForPackage( getBaseContext().getPackageName() );
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(i);

        }

    }
}
