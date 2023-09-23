package com.example.calculatorapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    private Button  btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,
            btn_ac,buttonBackSpace,btn_plus,btn_minus,btn_multiplication,buttonDivide,btn_model,btn_dot,btn_equal;
    private double first;

    TextView inputTXT, OutTxt;
    String data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"1");

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data + "4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"9");
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+".");
            }
        });
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText("");
                OutTxt.setText("");
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"+");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"-");
            }
        });
        btn_model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"%");
            }
        });

        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTXT.getText().toString();
                inputTXT.setText(data+"×");
            }
        });

      btn_equal.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              data=inputTXT.getText().toString();
              Toast.makeText(MainActivity.this,""+data,Toast.LENGTH_LONG);
              Log.e(TAG,"on click"+data );
              data=data.replaceAll("×","*");
              data=data.replaceAll("%","/100");
              data=data.replaceAll("÷","/");

              Context rhino= Context.enter();
              rhino.setOptimizationLevel(-1);

              String finalResult="";
              Scriptable scriptable=rhino.initStandardObjects();
              finalResult=rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();

              OutTxt.setText(finalResult);




          }
      });

        buttonBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Backspace=null;
                if(inputTXT.getText().length()>0)
                {

                    StringBuilder stringBuilder=new StringBuilder(inputTXT.getText());
                    stringBuilder.deleteCharAt(inputTXT.getText().length()-1);

                    Backspace=stringBuilder.toString();
                    inputTXT
                            .setText(Backspace);

                }
            }
        });
        buttonDivide .setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                data=inputTXT.getText().toString();
                inputTXT.setText(data+"÷");
            }
        });



    }

    @SuppressLint("WrongViewCast")
    private void init(){
        OutTxt =findViewById(R.id.OutTxt);
        inputTXT=findViewById(R.id.inputTxt);
        OutTxt=findViewById(R.id.OutTxt);
        btn_0=findViewById(R.id.btn_0);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_9=findViewById(R.id.btn_9);
        btn_8=findViewById(R.id.btn_8);
        btn_ac=findViewById(R.id.btn_ac);
        buttonBackSpace=findViewById(R.id.buttonBackspace);
        btn_model=findViewById(R.id.buttonPercent);
        btn_minus=findViewById(R.id.btn_minus);
        buttonDivide=findViewById(R.id.buttonDivide);
        btn_dot=findViewById(R.id.btn_dot);
        btn_plus=findViewById(R.id.buttonPlus);
        btn_multiplication=findViewById(R.id.buttonMultiply);
        btn_equal=findViewById(R.id.btn_equal);


    }
}