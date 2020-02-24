/************************************************************************************
 CSCI 522 - portfolio 4a
 Name: Akhil Namburi
 Zid: Z1856517
 Purpose: Shipping Calculator
 **************************************************************************************/
package z1856517.niu.shippingcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import z1856517.niu.shippingcalculator.R;

public class MainActivity extends Activity
{
    //Instance variables
    ShippingItem item;

    EditText weightET;
    TextView baseTV, addedTV, totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the EditText and TextViews to the objects on the screen
        weightET = findViewById(R.id.weightEditText);

        baseTV = findViewById(R.id.baseCostTextView);
        addedTV = findViewById(R.id.addedCostTextView);
        totalTV = findViewById(R.id.totalCostTextView);

        //create the shipping item
        item = new ShippingItem();

        //put the focus to the edittext
        weightET.requestFocus();

        //add the TextWatcher to the EditText field
        weightET.addTextChangedListener( weightWatcher );

    }// end onCreate

    TextWatcher weightWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                item.setWeight( Integer.parseInt( s.toString() ) );
            }
            catch (NumberFormatException nfe)
            {
                item.setWeight(0);
            }

            DecimalFormat df = new DecimalFormat("#0.00");

            //put the costs in the textviews
            baseTV.setText("$"+df.format(item.getBaseCost()));
            addedTV.setText("$"+df.format(item.getAddedCost()));
            totalTV.setText("$"+df.format(item.getTotalCost()));
        }

        @Override
        public void afterTextChanged(Editable s)
        {

        }
    };


    //method to handle clicking the help button
    public void getHelp(View view)
    {
        Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);

        //go to HelpActivity
        startActivity(helpIntent);
    }//end getHelp
}//end MainActivity class
