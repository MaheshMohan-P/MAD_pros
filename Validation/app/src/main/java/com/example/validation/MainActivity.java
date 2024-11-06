package com.example.validation;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText UserName,Email,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = findViewById(R.id.UserName);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        Button buttonSubmit=findViewById(R.id.buttonSubmit);
        
        buttonSubmit.setOnClickListener(v -> {
            if(TextUtils.isEmpty(UserName.getText())){
                UserName.setError("UserName Required");
            } else if (TextUtils.isEmpty(Email.getText()) || !Patterns.EMAIL_ADDRESS.matcher(Email.getText()).matches()) {
                Email.setError("Enter a valid email");
            } else if (Password.getText().length()<6) {
                Password.setError("Password doesn't meet the requirements");
            }else {
                Toast.makeText(this,"All inputs are valid",Toast.LENGTH_SHORT).show();
            }
        });
    }
}