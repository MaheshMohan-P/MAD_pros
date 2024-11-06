package com.example.loginform;

import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput=findViewById(R.id.username_input);
        passwordInput=findViewById(R.id.password_input);
        loginButton=findViewById(R.id.login_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String username=usernameInput.getText().toString().trim();
                String password=passwordInput.getText().toString().trim();

                if(username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "please enter both username and password", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Logging in.....",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}