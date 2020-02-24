package z1856517.niu.shippingcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import z1856517.niu.shippingcalculator.R;

public class HelpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }//end onCreate

    //method to handle the button click
    public void goBack(View view)
    {
        //go back to the MainActivity
        finish();
    }//end goBack
}
