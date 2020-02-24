/******************************************************************************
 *  Instructor Name: Amy Byrnes
 *
 *  Assignment 1 : Hello World
 *
 *  Name: Akhil Namburi
 *
 *  Zid : Z1856517
 *
 *  Assignment Due Date: Friday, Jan 31, 2020
 *
 *  Purpose: Write an Android application that will have an interactive greeting/message.
 *
 *******************************************************************************/


package z1856517.cs.niu.edu.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView messageTV;
    private Button changeBtn;

    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up a connection between objects in code
        //and on layout screen

        messageTV = findViewById(R.id.messageTextView);
        changeBtn = findViewById(R.id.changeButton);

        //initialize the boolean variabel
        isFirst = true;

        // handle the button click by setting up an
        // anonymous onclick listner

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isFirst){
                    //change the text to second message
                    messageTV.setText(R.string.message2);
                    //update the boolean variable
                    isFirst = false;

                }
                else{
                    //change the text to the first message
                    messageTV.setText(R.string.message1);
                    //update boolean variable
                    isFirst = true;

                }

            }//end onclick method
        });


    } // end onCreate
}//end MainActivity class
