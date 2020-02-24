/**************************
 *  Instructor Name: Amy Byrnes
 *
 * Portfolio 1 : Simple calculator
 *
 * Name: Akhil Namburi
 *
 *  Zid : Z1856517
 *
 *  Assignment Due Date: Friday, feb 5, 2020
 *
 *  Purpose: simple calculator
 *
 *************************/
package z1856517.cs.niu.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText num1E,num2E;
    private TextView anstextview;
    private Button addbtn,subbtn,mulbtn,divbtn,clearbtn;
    private Integer num1,num2,result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect to edit text obj to the screen
        num1E = findViewById(R.id.num1EditText);
        num2E = findViewById(R.id.num2EditText);

        //connect to text view
        anstextview = findViewById(R.id.answerTextView);

        //connect to button obj to screen
        addbtn = findViewById(R.id.addButton);
        subbtn = findViewById(R.id.subButton);
        mulbtn = findViewById(R.id.multiplyButton);
        divbtn = findViewById(R.id.divideButton);
        clearbtn = findViewById(R.id.clearButton);

        //attach the named listener to the buttons
        addbtn.setOnClickListener(mathlistener);
        subbtn.setOnClickListener(mathlistener);
        mulbtn.setOnClickListener(mathlistener);
        divbtn.setOnClickListener(mathlistener);

        //attach an anonymous lostener to the clear button
        clearbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1E.setText("");
                num2E.setText("");
                anstextview.setText("");

                //focus on the first number field
                num1E.requestFocus();
            }
        }); //end of on click listenre
    }
    //Named listener to handle the math
    //select on click listener with view class
    private View.OnClickListener mathlistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //check if info was supplied in edit text fields
            if(num1E.getText().toString().matches("") || num2E.getText().toString().matches("") )
            {
                //display a toast message with an error message
                Toast.makeText(v.getContext(), "Naumber fields cannot be empty", Toast.LENGTH_SHORT).show();

                //exit the listener
                return;
            }

            //Get the users 2 no.'s
            num1 = Integer.parseInt(num1E.getText().toString());
            num2 = Integer.parseInt(num2E.getText().toString());


            //HAndle the 4 buttons
            //use a decision statement:
            switch(v.getId())
            {
                case R.id.addButton:
                    Toast.makeText(v.getContext(),"Add btn clicked",Toast.LENGTH_SHORT).show();
                    result=num1+num2;
                    break;

                case R.id.subButton:
                    Toast.makeText(v.getContext(),"sub btn clicked",Toast.LENGTH_SHORT).show();
                    result=num1-num2;
                    break;
                case R.id.multiplyButton:
                    Toast.makeText(v.getContext(),"mul btn clicked",Toast.LENGTH_SHORT).show();
                    result=num1*num2;
                    break;

                case R.id.divideButton:
                    Toast.makeText(v.getContext(),"div btn clicked",Toast.LENGTH_SHORT).show();
                    result=num1/num2;
                    break;

                default:
                    Toast.makeText(v.getContext(),"Add btn clicked",Toast.LENGTH_SHORT).show();
            }//end of switch


            //display the calculated result
            anstextview.setText(result.toString());


        } //end on clcik
    }; //end of math listener //add semi colon to end on click listener
}