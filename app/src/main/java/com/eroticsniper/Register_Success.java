package com.eroticsniper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Register_Success extends AppCompatActivity {
    LinearLayout back;
    TextView txt_here;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__success);
        back = (LinearLayout) findViewById(R.id.back);
        back.setVisibility(View.GONE);
        txt_here = (TextView) findViewById(R.id.txt_here);
        txt_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent().setClass(Register_Success.this, SignInActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
