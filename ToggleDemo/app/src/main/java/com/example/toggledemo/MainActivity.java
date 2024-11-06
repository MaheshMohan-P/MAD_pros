package com.example.toggledemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button toggle;
    private boolean isImage1=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        toggle=findViewById(R.id.toggle);

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isImage1){
                    imageView.setImageResource(R.drawable.dev);
                }else {
                    imageView.setImageResource(R.drawable.me);
                }
                isImage1=!isImage1;
            }
        });
    }
}