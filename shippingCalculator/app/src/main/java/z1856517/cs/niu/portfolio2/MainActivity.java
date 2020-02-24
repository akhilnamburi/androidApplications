/*
Name: Akhil Namburi

ZID: Z1856517

Portfolio 2: Shipping Calculator

Due Date: 02/12/2020

*/

package z1856517.cs.niu.portfolio2;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{

    // Data Members

    private Shipping_Item item;

    private EditText weightET;
    private TextView baseTV, addedTV, totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the EditText and TextViews to the items on the screen

        weightET = findViewById(R.id.weightEditText);

        baseTV = findViewById(R.id.baseCostTextView);

        addedTV = findViewById(R.id.addedCostTextView);

        totalTV = findViewById(R.id.totalCostTextView);

        // Create the shipping item

        item = new Shipping_Item();

        // Place the application's initial focus on the EditText

        weightET.requestFocus();

        // Attach the TextWatcher to the EditText

        weightET.addTextChangedListener( weightWatcher );


    } // end onCreate

    // Create the named TextWatcher

    public TextWatcher weightWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            // Try to update the weight for the item being shipped

            try
            {
                // Set the weight for shipping item

                item.setWeight(Integer.parseInt(s.toString()));
            }

            catch ( NumberFormatException nfe )
            {
                // If user typed bad data, set it to zero

                item.setWeight( 0 );
            }

            // Formatting the costs

            DecimalFormat df = new DecimalFormat( "#0.00");

            // Displaying the costs

            baseTV.setText("$" + df.format(item.getBaseCost()));
            addedTV.setText("$" + df.format(item.getAddedCost()));
            totalTV.setText("$" + df.format(item.getTotalCost()));

        } //End OnTextChanged

        @Override
        public void afterTextChanged(Editable s)
        {

        }
    }; // End weightWatcher


} // end MainActivity
