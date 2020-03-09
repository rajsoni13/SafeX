package com.raj.safex;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_notuser,txt_reg;
    RadioButton radio_user,radio_tp;
    Button btnlogin;
    EditText edtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        txt_reg=findViewById(R.id.txt_reg);
        btnlogin=findViewById(R.id.btn_login);

        edtphone = findViewById(R.id.edt_phone_login);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = edtphone.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MyApp",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("PHONE_NO",str);
                editor.commit();
                String strPhoneNo = edtphone.getText().toString();
                if(strPhoneNo.equals(""))
                {
                    edtphone.setError("Enter Valid Phone Number");
                }
                else {

                    SharedPreferences sp = getSharedPreferences(Constants.DATASTREAM_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString(Constants.DATASTREAM_UUID, "rajsoni2155@gmail.com");
                    edit.apply();

                    Intent i = new Intent(MainActivity.this, NavDrawerMain.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        txt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });




    }
    public void openRegister(){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }


}
