package com.example.coworking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coworking.register.UserData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UserData> userDataList = new ArrayList<>();
    private EditText userName;
    private EditText mobileNumber;
    private EditText emailId;
    private UserData userData = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.userName);
        mobileNumber = findViewById(R.id.mobileNumber);
        emailId = findViewById(R.id.emailId);
        EditText password = findViewById(R.id.editPassword);
        Button registerButton = findViewById(R.id.registerButton);
        TextView loginTextView = findViewById(R.id.loginPage);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userData.setUserName(userName.getText().toString());
                userData.setEmailId(emailId.getText().toString());
                userData.setMobileNumber(Integer.parseInt(mobileNumber.getText().toString()));
                userData.setPassword(password.getText().toString());

                if (validateInput(userData.getUserName(), userData.getEmailId(), "" + userData.getMobileNumber(), userData.getPassword())) {
                    userDataList.add(userData);
                    userData = new UserData();
                    Toast.makeText(MainActivity.this, "Account Created successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class).putExtra("userDataList", (ArrayList<UserData>) userDataList);;
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validateInput(String username, String email, String mobile, String password) {
        // Add your validation logic here
        try {

        if (username.isEmpty() || email.isEmpty() || mobile.isEmpty()||password.isEmpty()) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
            return false;
        }
        }
        catch (Exception e){
        // You can add more validation rules as per your requirements
            e.printStackTrace();
        return false;
        }
        return true;
    }
}

