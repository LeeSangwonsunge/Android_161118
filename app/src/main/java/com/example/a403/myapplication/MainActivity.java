package com.example.a403.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;
    Button btn_plus, btn_minus, btn_mul, btn_div, btn_mod;
    View.OnClickListener OCL;
    double a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        btn_plus = (Button)findViewById(R.id.btn_add);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_mul = (Button)findViewById(R.id.btn_mul);
        btn_div = (Button)findViewById(R.id.btn_div);
        btn_mod = (Button)findViewById(R.id.btn_mod);
        result = (TextView)findViewById(R.id.Result);

        OCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Double.parseDouble(num1.getText().toString());
                b = Double.parseDouble(num2.getText().toString());

                switch(v.getId()){
                    case R.id.btn_add :
                        c = a + b;
                        break;
                    case R.id.btn_minus :
                        c = a - b;
                        break;
                    case R.id.btn_mul :
                        c = a * b;
                        break;
                    case R.id.btn_div :
                        if(a==0){
                            Toast.makeText(MainActivity.this, "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            c = a / b;
                            break;
                        }
                    case R.id.btn_mod :
                        c = a % b;
                        break;
                }
                result.setText(String.valueOf(c));
            }
        };
        btn_plus.setOnClickListener(OCL);
        btn_minus.setOnClickListener(OCL);
        btn_mul.setOnClickListener(OCL);
        btn_div.setOnClickListener(OCL);
        btn_mod.setOnClickListener(OCL);

    }
}