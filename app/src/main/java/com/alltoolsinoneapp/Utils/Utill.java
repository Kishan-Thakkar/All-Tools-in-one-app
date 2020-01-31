package com.alltoolsinoneapp.Utils;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Kishan Thakkar on 2/1/2020.
 * RapidBox
 * Kishanpujara127@gmail.com
 */
public class Utill {
    public static void setText(TextView textView, String string) {
        if (textView != null) {
            if (string != null && !string.equalsIgnoreCase("null")) {
                textView.setText(string);
                textView.setVisibility(View.VISIBLE);
            } else {
                textView.setVisibility(View.GONE);
            }
        }
    }
}
