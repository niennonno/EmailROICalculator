package io.niennonno.emailroicalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double audienceSize, responseRate, conversionRate, avgTicketSize, campaignCost,
            numOfResponders, numOfConv, revenue, profit, costPerConv, ROI, costPerResponder, costPerContact;

    TextView result1View, result2View;

    DecimalFormat precision2 = new DecimalFormat("0.0000");
    DecimalFormat precision = new DecimalFormat("0");
    DecimalFormat precision1 = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText as, rr, cr, ats, cc;
        as = (EditText) findViewById(R.id.audience_size);
        rr = (EditText) findViewById(R.id.response_rate);
        cr = (EditText) findViewById(R.id.conv_rate);
        ats = (EditText) findViewById(R.id.avg_ticket_size);
        cc = (EditText) findViewById(R.id.campaign_cost);

        result1View = (TextView) findViewById(R.id.result1);
        result2View = (TextView) findViewById(R.id.result2);

        Button calc = (Button) findViewById(R.id.calculate_but);
        Button reset = (Button) findViewById(R.id.reset_but);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                as.setText("");
                rr.setText("");
                cr.setText("");
                ats.setText("");
                cc.setText("");
                result1View.setText("");
                result2View.setText("");
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String AS, RR, CR, ATS, CC;
                RR = rr.getText().toString();
                AS = as.getText().toString();
                CR = cr.getText().toString();
                ATS = ats.getText().toString();
                CC = cc.getText().toString();

                if(AS.isEmpty()||RR.isEmpty()||CR.isEmpty()||ATS.isEmpty()||CC.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter All the Values!", Toast.LENGTH_SHORT).show();
                } else {
                    audienceSize = Double.parseDouble(AS);
                    responseRate = Double.parseDouble(RR);
                    conversionRate = Double.parseDouble(CR);
                    avgTicketSize = Double.parseDouble(ATS);
                    campaignCost = Double.parseDouble(CC);
                    if (conversionRate > 100) {
                        Toast.makeText(MainActivity.this, "Conversion Rate can't be greater than 100!", Toast.LENGTH_SHORT).show();
                    } else {
                       calculate();
                        InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                    }
                }
            }
        });
    }

    void calculate() {
        numOfResponders = responseRate*audienceSize/100;
        numOfConv = conversionRate* numOfResponders/ 100;
        costPerContact = campaignCost/audienceSize;
        revenue = numOfConv*avgTicketSize;
        profit = revenue - campaignCost;
        costPerResponder= campaignCost/numOfResponders;
        costPerConv = campaignCost/numOfConv;
        ROI = profit/campaignCost*100;

        result1View.setText("No. of Responders: " + precision.format(numOfResponders) +
                "\n\nNo. of Conversions: " + precision.format(numOfConv) +
                "\n\nROI: " + precision2.format(ROI) + "%\n\nCost Per Contact: " + precision1.format(costPerContact));

        result2View.setText("Revenue: " + precision1.format(revenue)
                + "\n\nProfit: " + precision1.format(profit)
                + "\n\nCost per Responder: " + precision1.format(costPerResponder)
                + "\n\nCost per Conversion: " + precision1.format(costPerConv));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
