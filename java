package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, ba, bs, bm, bd, be, bc, bdot;
    EditText res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.btnone);

        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.btntwo);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.btnthree);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.btnfour);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.btnfive);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.btnsix);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.btnseven);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.btneight);
        b8.setOnClickListener(this);
        b0 = (Button) findViewById(R.id.btnzero);
        b0.setOnClickListener(this);
        ba = (Button) findViewById(R.id.btnadd);
        ba.setOnClickListener(this);
        bs = (Button) findViewById(R.id.btnsub);
        bs.setOnClickListener(this);
        bm = (Button) findViewById(R.id.btnmul);
        bm.setOnClickListener(this);
        bd = (Button) findViewById(R.id.btndiv);
        bd.setOnClickListener(this);
        be = (Button) findViewById(R.id.btnequal);
        be.setOnClickListener(this);
        bdot = (Button) findViewById(R.id.btndot);
        bdot.setOnClickListener(this);
        bc = (Button) findViewById(R.id.btnclear);
        bc.setOnClickListener(this);
        res = (EditText) findViewById(R.id.edit_txt);
        res.setText("");


    }

    @Override
    public void onClick(View v) {
        if (v.equals(b1)) {
            res.append("1");
        } else if (v.equals(b2)) {
            res.append("2");
        }
        else if (v.equals(ba)){
            res.append(("+"));
        }
        else if (v.equals(bs)){
            res.append(("-"));
        }
        if(v.equals(bc))
            res.setText("");
        else if(v.equals(be)){
            try{
                String data = res.getText().toString();

                if(data.contains("+")){
                    add(data);
                }
                if(data.contains("-")){
                    sub(data);
                }
            }
            catch(Exception e) {

                displayInvalidMessage("invalid entry");
            }
        }
    }

    private void displayInvalidMessage(String invalid_entry) {
        Toast.makeText(getApplicationContext(),invalid_entry, Toast.LENGTH_LONG).show();
    }

    private void add(String data) {
        String[] operands= data.split(Pattern.quote("+"));
        if(operands.length==2){
            double op1= Double.parseDouble(operands[0]);
            double op2=  Double.parseDouble(operands[1]);
            double a= op1+op2;
            res.setText(String.valueOf(a));

        }
         else
            displayInvalidMessage("Invalid input");

    }
    private void sub(String data) {
        String[] operands= data.split(Pattern.quote("-"));
        if(operands.length==2){
            double op1= Double.parseDouble(operands[0]);
            double op2=  Double.parseDouble(operands[1]);
            double a= op1-op2;
            res.setText(String.valueOf(a));

        }
         else
            displayInvalidMessage("Invalid input");
    }



}
