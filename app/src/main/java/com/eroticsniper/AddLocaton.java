package com.eroticsniper;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddLocaton extends AppCompatActivity implements View.OnClickListener {

    private Button btn_mon, btn_tue, btn_wed, btn_thr, btn_fri, btn_sat, btn_sun, btn_next;
    private int str_sun = 0, str_mon = 0, str_tues = 0, str_wed = 0, str_thr = 0, str_fri = 0, str_sat = 0;
    private EditText et_Name, et_Email, et_input_Phone, et_input_website, et_input_description;
    private String Name, Email, input_Phone, input_website, input_description;

    String CatId = "0";
    private Button btnSelect;
    private ImageView ivImage;
    private String userChoosenTask;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;

    de.hdodenhof.circleimageview.CircleImageView mainImage;
    private ImageView Image1, Image2, Image3, Image4;

    String Base64_Image = "";
    static final int CAMERA_REQUEST = 1888;
    int SELECT_FILE = 1;
    Bitmap bitmap = null;
    int SelectImageView = 0;
    String mainimage = "", image1 = "", image2 = "", image3 = "", image4 = "";

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

        mainImage = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.MainImage);
        Image1 = (ImageView) findViewById(R.id.Image1);
        Image2 = (ImageView) findViewById(R.id.Image2);
        Image3 = (ImageView) findViewById(R.id.Image3);
        Image4 = (ImageView) findViewById(R.id.Image4);

        mainImage.setOnClickListener(this);
        Image1.setOnClickListener(this);
        Image2.setOnClickListener(this);
        Image3.setOnClickListener(this);
        Image4.setOnClickListener(this);

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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.MainImage:
                selectImage();
                SelectImageView = 0;
                break;
            case R.id.Image1:
                selectImage();
                SelectImageView = 1;
                break;
            case R.id.Image2:
                selectImage();
                SelectImageView = 2;
                break;
            case R.id.Image3:
                selectImage();
                SelectImageView = 3;
                break;
            case R.id.Image4:
                selectImage();
                SelectImageView = 4;
                break;
        }
    }

    protected void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAMERA_REQUEST);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private Bitmap onCaptureImageResult(Intent data) {
        bitmap = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        Base64_Image = Base64.encodeToString(bytes.toByteArray(), Base64.DEFAULT);
        switch (SelectImageView) {
            case 0: {
                mainImage.setImageBitmap(bitmap);
                mainimage = Base64_Image;
                break;
            }
            case 1: {
                Image1.setImageBitmap(bitmap);
                image1 = Base64_Image;
                break;
            }
            case 2: {
                Image2.setImageBitmap(bitmap);
                image2 = Base64_Image;
                break;
            }
            case 3: {
                Image3.setImageBitmap(bitmap);
                image3 = Base64_Image;
                break;
            }
            case 4: {
                Image4.setImageBitmap(bitmap);
                image4 = Base64_Image;
                break;
            }
        }
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @SuppressWarnings("deprecation")
    //image selection from image gallery
    private Bitmap onSelectFromGalleryResult(Intent data) {
        Uri uri = data.getData();
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            ByteArrayOutputStream bytes2 = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes2);

            Base64_Image = Base64.encodeToString(bytes2.toByteArray(), Base64.DEFAULT);
            switch (SelectImageView) {
                case 0: {
                    mainImage.setImageBitmap(bitmap);
                    mainimage = Base64_Image;
                    break;
                }
                case 1: {
                    Image1.setImageBitmap(bitmap);
                    image1 = Base64_Image;
                    break;
                }
                case 2: {
                    Image2.setImageBitmap(bitmap);
                    image2 = Base64_Image;
                    break;
                }
                case 3: {
                    Image3.setImageBitmap(bitmap);
                    image3 = Base64_Image;
                    break;
                }
                case 4: {
                    Image4.setImageBitmap(bitmap);
                    image4 = Base64_Image;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    // image choosen result
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE) {
                onSelectFromGalleryResult(data);
            } else if (requestCode == CAMERA_REQUEST) {
                onCaptureImageResult(data);
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }
}
