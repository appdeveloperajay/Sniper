package com.eroticsniper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by Varun Sood on 12-Mar-17.
 */
public class DemoSniper extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    protected void ShowToast(String ToastText) {
        Toast.makeText(DemoSniper.this, ToastText, Toast.LENGTH_SHORT).show();
    }

}
