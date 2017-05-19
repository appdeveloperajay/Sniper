package com.eroticsniper;

import android.media.browse.MediaBrowser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLocaton extends AppCompatActivity {

    private Button btn_mon, btn_tue, btn_wed, btn_thr, btn_fri, btn_sat, btn_sun, btn_next;
    private int str_sun = 0, str_mon = 0, str_tues = 0, str_wed = 0, str_thr = 0, str_fri = 0, str_sat = 0;
    private EditText et_Name, et_Email, et_input_Phone, et_input_website, et_input_description;
    private String Name, Email, input_Phone, input_website, input_description;

    String CatId = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_locaton);
        CatId = Global.CatId;
        btn_mon = (Button) findViewById(R.id.btn_mon);
        btn_tue = (Button) findViewById(R.id.btn_tue);
        btn_wed = (Button) findViewById(R.id.btn_wed);
        btn_thr = (Button) findViewById(R.id.btn_thr);
        btn_fri = (Button) findViewById(R.id.btn_fri);
        btn_sat = (Button) findViewById(R.id.btn_sat);
        btn_sun = (Button) findViewById(R.id.btn_sun);
        btn_next = (Button) findViewById(R.id.btn_next);

        et_Name = (EditText) findViewById(R.id.et_Name);
        et_Email = (EditText) findViewById(R.id.et_Email);
        et_input_Phone = (EditText) findViewById(R.id.et_input_Phone);
        et_input_website = (EditText) findViewById(R.id.et_input_website);
        et_input_description = (EditText) findViewById(R.id.et_input_description);


        btn_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (str_mon == 0) {
                    str_mon = 1;
                    btn_mon.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval_red));
                } else if (str_mon == 1) {
                    str_mon = 0;
                    btn_mon.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval));
                }

            }
        });

        btn_tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (str_tues == 0) {
                    str_tues = 1;
                    btn_tue.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval_red));
                } else if (str_tues == 1) {
                    str_tues = 0;
                    btn_tue.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval));
                }

            }
        });

        btn_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (str_wed == 0) {
                    str_wed = 1;
                    btn_wed.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval_red));
                } else if (str_wed == 1) {
                    str_wed = 0;
                    btn_wed.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval));
                }

            }
        });

        btn_thr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (str_thr == 0) {
                    str_thr = 1;
                    btn_thr.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval_red));
                } else if (str_thr == 1) {
                    str_thr = 0;
                    btn_thr.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval));
                }

            }
        });

        btn_fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (str_fri == 0) {
                    str_fri = 1;
                    btn_fri.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval_red));
                } else if (str_fri == 1) {
                    str_fri = 0;
                    btn_fri.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval));
                }

            }
        });

        btn_sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (str_sat == 0) {
                    str_sat = 1;
                    btn_sat.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval_red));
                } else if (str_sat == 1) {
                    str_sat = 0;
                    btn_sat.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval));
                }

            }
        });

        btn_sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (str_sun == 0) {
                    str_sun = 1;
                    btn_sun.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval_red));
                } else if (str_sun == 1) {
                    str_sun = 0;
                    btn_sun.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_shape_oval));
                }


            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_Name == null || et_Name.getText().toString().trim().equals("") || et_Name.length() <= 0) {
                    et_Name.setError("Field required");
                    et_Name.requestFocus();
                } else if (et_Email == null || et_Email.getText().toString().trim().equals("") || et_Email.length() <= 0) {
                    et_Email.setError("Field required");
                    et_Email.requestFocus();
                } else if (et_input_Phone == null || et_input_Phone.getText().toString().trim().equals("") || et_input_Phone.length() <= 0) {
                    et_input_Phone.setError("Field required");
                    et_input_Phone.requestFocus();
                } else if (et_input_website == null || et_input_website.getText().toString().trim().equals("") || et_input_website.length() <= 0) {
                    et_input_website.setError("Field required");
                    et_input_website.requestFocus();
                } else if (et_input_description == null || et_input_description.getText().toString().trim().equals("") || et_input_description.length() <= 0) {
                    et_input_description.setError("Field required");
                    et_input_description.requestFocus();
                } else if (str_sun == 0 || str_mon == 0 || str_tues == 0 || str_wed == 0 || str_thr == 0 || str_fri == 0 || str_sat == 0) {
                    Toast.makeText(AddLocaton.this, "select atleast one day ", Toast.LENGTH_SHORT).show();
                } else {
                    Name = et_Name.getText().toString().trim();
                    Email = et_Email.getText().toString().trim();
                    input_Phone = et_input_Phone.getText().toString().trim();
                    input_website = et_input_website.getText().toString().trim();
                    input_description = et_input_description.getText().toString().trim();
                }
            }
        });
    }
}
