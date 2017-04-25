package com.eroticsniper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SignInActivity extends DemoSniper {

    LinearLayout Back;
    Button SignIn;
    EditText edt_Email, edt_Password;
    ProgressDialog progress;
    Button btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edt_Email = (EditText) findViewById(R.id.edt_Email);

        edt_Email.getBackground().mutate().setColorFilter(getResources().getColor(R.color.WHITE), PorterDuff.Mode.SRC_ATOP);

        edt_Password = (EditText) findViewById(R.id.edt_Password);
        edt_Password.getBackground().mutate().setColorFilter(getResources().getColor(R.color.WHITE), PorterDuff.Mode.SRC_ATOP);

        btn_signin = (Button) findViewById(R.id.btn_signin);

        Back = (LinearLayout) findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SignIn = (Button) findViewById(R.id.btn_signin);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_Email.getText() == null && edt_Email.getText().toString().trim().equals("")) {
                    edt_Email.setError("Fill field");
                } else if (edt_Password.getText() == null && edt_Password.toString().trim().equals("")) {
                    edt_Password.setError("Fill password");
                } else {
                    new HitRegisteration().execute();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    private class HitRegisteration extends AsyncTask<String, String, String> {
        StringBuilder stringBuilder = new StringBuilder();
        String nme, pass;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            nme = edt_Email.getText().toString().trim();
            pass = edt_Password.getText().toString().trim();
            progress = new ProgressDialog(SignInActivity.this);
            progress.setMessage("Please wait");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);
            progress.setProgress(0);
            progress.show();
        }

        @Override
        protected String doInBackground(String... params) {


            try {
                String query = "user_email=" + nme + "&password=" + pass;
                URL url = new URL("http://eroticsniper.96.lt/eroticsniper/Login.php");
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
                String b = jsonRootObject.optString("U_ID");

//                GlobalVariable.UserId = b;
                Toast.makeText(SignInActivity.this, "" + b, Toast.LENGTH_SHORT).show();
                if (a.trim().equals("1")) {
                    Intent i = new Intent().setClass(SignInActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                if (a.trim().equals("2")) {
                    Toast.makeText(SignInActivity.this, "User already registered ", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            progress.dismiss();
        }
    }
}
