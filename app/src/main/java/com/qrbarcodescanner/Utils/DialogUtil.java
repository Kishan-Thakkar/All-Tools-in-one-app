package com.qrbarcodescanner.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


public class DialogUtil {



    public static void hideKeyboard(View view, Context ctx) {
        if (view != null && ctx != null) {
            InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }






    public static void showToast(Context context, String message) {
        if (message == null || TextUtils.isEmpty(message) || context == null)
            return;
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 500);


    }

    public static void showToast(Context context, int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }





 /*   public static void customToast(Context context, String message) {
        if (context == null) {
            return;
        }
        CustomToast customToast = new CustomToast(context);
        customToast.setTextColor(context.getResources().getColor(R.color.white));
        customToast.setBackground(context.getResources().getColor(R.color.black));
        customToast.showSuccessToast(message);
    }*/



   /* public static void chooseImageDialog(Activity pContext, String title, View.OnClickListener cameraListner, View.OnClickListener galleryListner){
        if (pContext == null) {
            return;
        }
        try {
            dismissDialog();

            if(dialogFragment!=null)
                return;

            UploadImageDialog uploadImageDialog = UploadImageDialog.newInstance();
            uploadImageDialog.setTitle(title);
            uploadImageDialog.setCameraListner(cameraListner);
            uploadImageDialog.setGalleryLIstner(galleryListner);
            uploadImageDialog.setCancelable(true);

            uploadImageDialog.show(pContext.getFragmentManager(), uploadImageDialog.getClass().getName());
            dialogFragment = uploadImageDialog;
        } catch (Exception e) {
            //Log.d(TAG, "showDialogWithTwoButton: e"+e.getLocalizedMessage());
        }
    }*/

}
