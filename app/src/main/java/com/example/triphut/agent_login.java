package com.example.triphut;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class agent_login extends AppCompatActivity {

    EditText agentuser, agentpass;
    Button btnaglogin;
    String correct_username = "Agent";
    String correct_usernameCar = "Caragent";
    String correct_password = "triphut";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeStatusBarColor();
        setContentView(R.layout.activity_agent_login);


        agentuser = findViewById(R.id.agnusername);
        agentpass = findViewById(R.id.agnpassword);
        btnaglogin = findViewById(R.id.aglogin);

        btnaglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(agentuser.getText().toString()) || TextUtils.isEmpty(agentpass.getText().toString())) {
                    Toast.makeText(agent_login.this, "Invalid User or PassWord", Toast.LENGTH_LONG).show();
                } else if (agentuser.getText().toString().equals(correct_username)) {


                    if (agentpass.getText().toString().equals(correct_password)) {
                        Toast.makeText(agent_login.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), TourData.class));
                    }
                } else if (agentuser.getText().toString().equals(correct_usernameCar)) {


                    if (agentpass.getText().toString().equals(correct_password)) {
                        Toast.makeText(agent_login.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), CarData.class));
                    }
                }
                else {
                    Toast.makeText(agent_login.this, "Invalid User or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void changeStatusBarColor() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }
}