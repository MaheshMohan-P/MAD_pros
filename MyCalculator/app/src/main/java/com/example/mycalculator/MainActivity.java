package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd,buttonSub,buttonMul,buttonDiv;
    EditText editText1,editText2;
    TextView textView;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonAdd=findViewById(R.id.add_button);
        buttonSub=findViewById(R.id.sub_button);
        buttonMul=findViewById(R.id.mul_button);
        buttonDiv=findViewById(R.id.div_button);

        editText1=findViewById(R.id.num1);
        editText2=findViewById(R.id.num2);
        textView=findViewById(R.id.result);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        String input1=editText1.getText().toString();
        String input2=editText2.getText().toString();

        if(!input1.isEmpty()&&!input2.isEmpty()){
            num1=Integer.parseInt(input1);
            num2=Integer.parseInt(input2);

            if(v.getId()==R.id.add_button) {
                textView.setText("Result:" + (num1 + num2));
            } else if (v.getId()==R.id.sub_button) {
                textView.setText("Result:"+(num1-num2));
            }else if (v.getId()==R.id.mul_button) {
                textView.setText("Result:"+(num1*num2));
            }else if (v.getId()==R.id.div_button) {
                if(num2!=0){
                    textView.setText("Result:"+(num1/num2));
                }else {
                    textView.setText("Error:Division by zero");
                }
            }
        }else {
            textView.setText("Please Enter both numbers");
        }
    }
}