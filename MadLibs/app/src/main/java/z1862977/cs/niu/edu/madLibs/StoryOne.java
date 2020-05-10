package z1862977.cs.niu.edu.madLibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StoryOne extends AppCompatActivity {
    EditText noun1ET, noun2ET, noun3ET, occupationET, verbET, placeET, verb_ending_in_edET, noun4ET,
            verb_ending_in_ingET, noun_pluralET, noun5ET, emotionET;

    TextView storyTV1;

    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_one);

        //connect the variable to the objects on the screen
        noun1ET = (EditText) findViewById(R.id.noun1);
        noun2ET = (EditText)findViewById(R.id.noun2);
        noun3ET = (EditText)findViewById(R.id.noun3);
        occupationET = (EditText) findViewById(R.id.occupation);
        verbET = (EditText) findViewById(R.id.verb);
        placeET = (EditText) findViewById(R.id.place);
        verb_ending_in_edET = (EditText)findViewById(R.id.verb_ending_ED);
        noun4ET = (EditText)findViewById(R.id.noun4);
        verb_ending_in_ingET = (EditText)findViewById(R.id.verb_ending_ING);
        noun_pluralET = (EditText)findViewById(R.id.noun_plural);
        noun5ET = (EditText)findViewById(R.id.noun5);
        emotionET = (EditText)findViewById(R.id.emotion);

        storyTV1 = (TextView)findViewById(R.id.story1Screen);

        submitButton = (Button)findViewById(R.id.story1Button);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (    noun1ET.getText().toString().matches("") ||
                        noun2ET.getText().toString().matches("") ||
                        noun3ET.getText().toString().matches("") ||
                        occupationET.getText().toString().matches("") ||
                        verbET.getText().toString().matches("") ||
                        placeET.getText().toString().matches("") ||
                        verb_ending_in_edET.getText().toString().matches("") ||
                        noun4ET.getText().toString().matches("") ||
                        verb_ending_in_ingET.getText().toString().matches("") ||
                        noun_pluralET.getText().toString().matches("") ||
                        noun5ET.getText().toString().matches("") ||
                        emotionET.getText().toString().matches("")    )
                {
                    //Display a toast message and log message
                    Toast.makeText(view.getContext(), "Cannot Have Empty Fields", Toast.LENGTH_LONG).show();
                }
                else {
                    String noun1Text = noun1ET.getText().toString();
                    String noun2Text = noun2ET.getText().toString();
                    String noun3Text = noun3ET.getText().toString();
                    String occupationText = occupationET.getText().toString();
                    String verbText = verbET.getText().toString();
                    String placeText = placeET.getText().toString();
                    String verb_EDText = verb_ending_in_edET.getText().toString();
                    String noun4Text = noun4ET.getText().toString();
                    String verb_INGText = verb_ending_in_ingET.getText().toString();
                    String noun_pluralText = noun_pluralET.getText().toString();
                    String noun5Text = noun5ET.getText().toString();
                    String emotionText = emotionET.getText().toString();

                    storyTV1.setText("It was during the battle of " + noun1Text + " when I was running through " +
                            " a " + noun2Text + " when a " + noun3Text + " went off right next to my platoon. " +
                            " Our " + occupationText + " yelled for us to " + verbText + " to the nearest " +
                            placeText + " we could find." + " When we got to the " + placeText + " we " +
                            verb_EDText + " to start a fire." + " As we are starting the fire the enemy saw the " +
                            noun4Text + " from the fire and started " + verb_INGText + noun_pluralText + " at us." +
                            " We all quickly ducked behind the " + noun5Text + " at the " + placeText +
                            " and returned fire. We quickly eliminated the enemy and were " + emotionText +
                            " that we had won the battle." + "\n\n");
                }
            }
        });

    }//end onCreate
}//end StoryOne
