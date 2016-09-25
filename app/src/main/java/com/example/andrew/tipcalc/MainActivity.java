package com.example.andrew.tipcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View view) {
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText check = (EditText) findViewById(R.id.check);
        if (check.getText().length() == 0){
            return;
        }
        String checkAmt = check.getText().toString();
        EditText percent = (EditText) findViewById(R.id.percent);
        if (check.getText().length() == 0) {
            return;
        }
        String percentAmt = percent.getText().toString();
        double checkNum = Double.valueOf(checkAmt);
        double percentNum = Integer.valueOf(percentAmt);
        checkNum = truncate(checkNum);
        double tip = checkNum * (percentNum / 100);
        double total = checkNum + tip;
        tip = truncate(tip);
        total = truncate(total);
        String tipOut = Double.toString(tip);
        String totalOut = Double.toString(total);
        if ((tip * 100) % 10 == 0) {
            tipOut = tipOut + "0";
        }
        else if ((tip*100)% 100 == 0) {
            tipOut = tipOut + "00";
        }
        if ((total * 100) % 10 == 0) {
            totalOut = totalOut + "0";
        }
        else if ((total*100)% 100 == 0) {
            totalOut = totalOut + "00";
        }
        TextView tipView = (TextView) findViewById(R.id.resultTip);
        tipView.setText("Tip: $" + tipOut);
        TextView checkView = (TextView) findViewById(R.id.resultCheck);
        checkView.setText("Total Payment: $" + totalOut);
    }

    public void clear(View view) {
        EditText check = (EditText) findViewById(R.id.check);
        EditText percent = (EditText) findViewById(R.id.percent);
        TextView tip = (TextView) findViewById(R.id.resultTip);
        TextView total = (TextView) findViewById(R.id.resultCheck);
        check.setText("");
        percent.setText("");
        tip.setText("");
        total.setText("");
    }

    double truncate(double value) {
        int temp = (int) (value * 100);
        double out = (double) temp;
        out = out/100;
        return out;
    }
}
