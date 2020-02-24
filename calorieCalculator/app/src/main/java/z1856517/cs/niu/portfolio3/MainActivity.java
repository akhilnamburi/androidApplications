package z1856517.cs.niu.portfolio3;
/*

 Name: Akhil Namburi
 Zid: Z1856517
 Purpose: Calculates the Calories for the selected input such as burger and cheeses
 */

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private RadioGroup pattyRG, cheeseRG;
    private CheckBox baconCB;
    private SeekBar sauceSB;
    private TextView caloriesTV;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the variables to the objects on the screen
        pattyRG = findViewById(R.id.pattyRadioGroup);
        cheeseRG = findViewById(R.id.cheeseRadioGroup);
        baconCB = findViewById(R.id.baconCheckBox);
        sauceSB = findViewById(R.id.sauceSeekBar);
        caloriesTV = findViewById(R.id.calorieTextView);

        //create the burger
        burger = new Burger();

        displayCalories();

        //set up named listener for the patty selection
        pattyRG.setOnCheckedChangeListener( pattyListener );

        //set up the anon. listener for the cheese selection
        cheeseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radiogroup, int checkedID)
            {
                switch(checkedID)
                {
                    case R.id.noCheeseRadioButton: burger.setCheeseCalories(0);
                        break;
                    case R.id.cheddarRadioButton: burger.setCheeseCalories(Burger.CHEDDAR);
                        break;
                    case R.id.mozzRadioButton: burger.setCheeseCalories(Burger.MOZZ);
                        break;
                }

                displayCalories();
            }
        });

        //set up the named listner for the bacon checkbox
        baconCB.setOnClickListener( baconListener );

        //set up the named listener for the same seekbar
        sauceSB.setOnSeekBarChangeListener( sauceListener );
    }//end onCreate

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            burger.setSauceCalories( seekBar.getProgress() );
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {

        }
    };

    private View.OnClickListener baconListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            if( ((CheckBox) view).isChecked() )
            {
                burger.setBaconCalories(true);
            }
            else
            {
                burger.setBaconCalories(false);
            }

            displayCalories();
        }
    };

    private RadioGroup.OnCheckedChangeListener pattyListener = new RadioGroup.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedID)
        {
            switch (checkedID)
            {
                case R.id.chickenRadioButton: burger.setPattyCalories( Burger.CHICKEN);
                    break;
                case R.id.turkeyRadioButton: burger.setPattyCalories(Burger.TURKEY);
                    break;
                case R.id.veggieRadioButton: burger.setPattyCalories(Burger.VEGGIE);
                    break;
            }

            displayCalories();
        }
    };

    private void displayCalories()
    {
        //bring the string to be displayed
        String caloriesText = "Calories: " + burger.getTotalCalories();
        //display the String in the text view
        caloriesTV.setText( caloriesText );
    }//end displayCalories

}//end MainActivity