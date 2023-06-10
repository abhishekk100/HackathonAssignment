package com.example.coworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworking.register.UserData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


private EditText emailMobile,editTextPassword;
private Button login;
    private List<UserData> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView createView = findViewById(R.id.createView);
        createView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MainActivity2
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        emailMobile = findViewById(R.id.emailMobile);
        editTextPassword = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.loginbtn);
        Intent intent = getIntent();
        dataList = intent.getParcelableArrayListExtra("userDataList");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailmob = emailMobile.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
if(dataList.isEmpty())
{
    Toast.makeText(MainActivity2.this, "Database is empty First create user", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
    startActivity(intent);
    finish();

}
                if (validateInput(emailmob,password)) {

                    int count=0;
                    for(UserData user:dataList)
                    {
                        if(user.getPassword().equals(password))
                        {
                            if(isMobile(emailmob)) {
                            if(user.getMobileNumber()==Integer.parseInt(emailmob)){
                                count++;
                    Toast.makeText(MainActivity2.this, "Login successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                                startActivity(intent);
                                finish();
                    break;
                            }
                            }
                            else {
                                if(user.getEmailId().equals(emailmob)){
                                    count++;
                                    Toast.makeText(MainActivity2.this, "Login successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                                    startActivity(intent);
                                    finish();
                                break;
                                }
                                }

                            }
                        }
                    if (count==0){
                        Toast.makeText(MainActivity2.this, "Login Not successful", Toast.LENGTH_SHORT).show();}
            }
                }
            private boolean isMobile(String emailmob) {

                for(char ch:emailmob.toCharArray())
                {
                 if(ch<'0'||ch>'9')
                     return false;
                }
                return true;
            }
        });
    }
    private boolean validateInput(String emailmob, String password) {
        // Add your validation logic here
        if (emailmob.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity2.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
            return false;
        }
        // You can add more validation rules as per your requirements
        return true;
    }
}