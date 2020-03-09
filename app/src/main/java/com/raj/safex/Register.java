package com.raj.safex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class Register extends AppCompatActivity {
    EditText edtFirstname;
    EditText edtLastname;
    EditText edtPassword;
    EditText edtconfirmPassword;
    RadioGroup radioGroup;
    Button btnregister;
    EditText edtEmail;
    TextView tvDob;
    ImageButton imgDate;
    private int year;
    private int month;
    private int date;
    CircleImageView circleImageView;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        btnregister = findViewById(R.id.btn_reg);

        edtFirstname = findViewById(R.id.edt_fname);
        edtLastname = findViewById(R.id.edt_lname);
        edtEmail = findViewById(R.id.edt_email);
        edtconfirmPassword = findViewById(R.id.edt_copass);

        tvDob = findViewById(R.id.edt_dob);
        Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);



        tvDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this, R.style.cal, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        tvDob.setText(date + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, date);
                datePickerDialog.show();
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = edtEmail.getText().toString();
                if (strEmail.equals("")) {
                    edtEmail.setError("Enter Email Id");
                } else if (!strEmail.matches(emailPattern)) {
                    edtEmail.setError("Enter valid EmailId");
                }
                String Fname = edtFirstname.getText().toString();
                if (Fname.equals("")) {
                    edtFirstname.setError("Enter First Name");
                }
                String Lname = edtLastname.getText().toString();
                if (Lname.equals("")) {
                    edtLastname.setError("Enter Last Name");
                }
                String Dob = tvDob.getText().toString();
                if (Dob.equals("")) {
                    tvDob.setError("Enter Date Of Birth");
                } else {
                    Intent i = new Intent(Register.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });



        /*circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.custom_view, null);


                ImageView imageView = myview.findViewById(R.id.gallery);
                ImageView imageView1 = myview.findViewById(R.id.camera);

                final AlertDialog alertDialog = builder.create();

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (alertDialog.isShowing()) {
                            alertDialog.dismiss();
                        }

                            Intent i = new Intent();
                            i.setAction(Intent.ACTION_PICK);
                            i.setType("image/*");
                            startActivityForResult(i, 1);

                    }
                });
                alertDialog.setView(myview);
                alertDialog.show();

                imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (alertDialog.isShowing()) {
                            alertDialog.dismiss();
                        }
                            Intent i = new Intent();
                            i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(i, 2);
                    }
                });
                alertDialog.setView(myview);
                alertDialog.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Uri uri = data.getData();
            circleImageView.setImageURI(uri);
        } else if (requestCode == 2) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            circleImageView.setImageBitmap(bitmap);
        }

*/
    }
}