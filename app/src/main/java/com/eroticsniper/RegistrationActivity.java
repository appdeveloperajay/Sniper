package com.eroticsniper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RegistrationActivity extends DemoSniper {

    LinearLayout Back;
    Button btn_Next;
    ProgressDialog progress;
    EditText edt_Name, edt_Email, edt_Password, edt_Confirm_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edt_Name = (EditText) findViewById(R.id.edt_Name);
        edt_Name.getBackground().mutate().setColorFilter(getResources().getColor(R.color.WHITE), PorterDuff.Mode.SRC_ATOP);

        edt_Email = (EditText) findViewById(R.id.edt_Email);
        edt_Email.getBackground().mutate().setColorFilter(getResources().getColor(R.color.WHITE), PorterDuff.Mode.SRC_ATOP);

        edt_Password = (EditText) findViewById(R.id.edt_Password);
        edt_Password.getBackground().mutate().setColorFilter(getResources().getColor(R.color.WHITE), PorterDuff.Mode.SRC_ATOP);

        edt_Confirm_Password = (EditText) findViewById(R.id.edt_Confirm_Password);
        edt_Confirm_Password.getBackground().mutate().setColorFilter(getResources().getColor(R.color.WHITE), PorterDuff.Mode.SRC_ATOP);

        Back = (LinearLayout) findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btn_Next = (Button) findViewById(R.id.btn_Next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new HitRegisteration().execute();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent().setClass(RegistrationActivity.this, RegisterAsActivity.class);
        startActivity(i);
        finish();
    }


    private class HitRegisteration extends AsyncTask<String, String, String> {
        StringBuilder stringBuilder = new StringBuilder();
        String nme, eml, pass;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            nme = edt_Name.getText().toString().trim();
            eml = edt_Email.getText().toString().trim();
            pass = edt_Password.getText().toString().trim();
            progress = new ProgressDialog(RegistrationActivity.this);
            progress.setMessage("Please wait");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);
            progress.setProgress(0);
            progress.show();
        }

        @Override
        protected String doInBackground(String... params) {
            int id = 2;
            try {
                String query = "name=" + nme + "&email=" + eml + "&password=" + pass + "&type=2";
                URL url = new URL("http://eroticsniper.96.lt/eroticsniper/sp_registration.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(query);
                wr.flush();
                wr.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                int responseCode = httpURLConnection.getResponseCode();
                Log.d("AJU", "" + responseCode);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String data;

                while ((data = bufferedReader.readLine()) != null) {
                    stringBuilder.append(data);
                }
            } catch (MalformedURLException e) {
                Log.d("AJU", "" + e);

                e.printStackTrace();
            } catch (IOException e) {
                Log.d("AJU", "" + e);
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonRootObject = new JSONObject(s);
                String a = jsonRootObject.optString("status");
                if (a.trim().equals("1")) {
//                    Toast.makeText(RegistrationActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent().setClass(RegistrationActivity.this, Register_Success.class);
                    startActivity(i);
                    finish();
                }
                if (a.trim().equals("2")) {
                    Toast.makeText(RegistrationActivity.this, "User already registered ", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            progress.dismiss();
        }
    }

}
