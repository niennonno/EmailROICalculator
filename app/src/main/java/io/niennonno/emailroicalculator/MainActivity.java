package io.niennonno.emailroicalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double audienceSize, responseRate, conversionRate, avgTicketSize, campaignCost,
            numOfResponders, numOfConv,revenue, profit, costperConv, ROI;

    TextView result1View, result2View;

    DecimalFormat precision = new DecimalFormat("0.0000");
    DecimalFormat precision1 = new DecimalFormat("0");
    DecimalFormat precision2 = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText as, rr, cr, ats, cc;
        as = (EditText)findViewById(R.id.audience_size);
        rr = (EditText)findViewById(R.id.response_rate);
        cr = (EditText)findViewById(R.id.conv_rate);
        ats = (EditText)findViewById(R.id.avg_ticket_size);
        cc = (EditText)findViewById(R.id.campaign_cost);

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
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
