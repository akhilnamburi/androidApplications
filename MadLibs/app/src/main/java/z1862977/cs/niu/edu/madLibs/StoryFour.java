package z1862977.cs.niu.edu.madLibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StoryFour extends AppCompatActivity {

    EditText verbIng1ET, verbIng2ET, verbEdET, placeET, verb1ET, verb2ET;

    TextView storyTV4;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_four);

        //connect the variable to the objects on the screen
        verbIng1ET = (EditText)findViewById(R.id.verb_ending_ING1);
        verbIng2ET = (EditText)findViewById(R.id.verb_ending_ING2);
        verbEdET = (EditText)findViewById(R.id.verb_ending_ED);
        placeET = (EditText)findViewById(R.id.place);
        verb1ET = (EditText)findViewById(R.id.verb1);
        verb2ET = (EditText)findViewById(R.id.verb2);

        storyTV4 = (TextView)findViewById(R.id.story4Screen);

        submitButton = (Button)findViewById(R.id.story4Button);

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if (    verbIng1ET.getText().toString().matches("") ||
                        verbIng2ET.getText().toString().matches("") ||
                        verbEdET.getText().toString().matches("") ||
                        placeET.getText().toString().matches("") ||
                        verb1ET.getText().toString().matches("") ||
                        verb2ET.getText().toString().matches("")    )
                {
                    //Display a toast message and log message
                    Toast.makeText(view.getContext(), "Cannot Have Empty Fields", Toast.LENGTH_LONG).show();
                }
                else
                    {
                    String verbIng1Text = verbIng1ET.getText().toString();
                    String verbIng2Text = verbIng2ET.getText().toString();
                    String verbEdText = verbEdET.getText().toString();
                    String placeText = placeET.getText().toString();
                    String verb1Text = verb1ET.getText().toString();
                    String verb2Text = verb2ET.getText().toString();

                    storyTV4.setText("Tommorrow is a new day full of new suprises and new adventures.\n" +
                                   "Such as " + verbIng1Text + " and " + verbIng2Text + ". Tommorrow leads you to the life " +
                                   "you haven`t " + verbEdText + " yet. So why not plan to live today with the most" +
                                   " adventurious and positive outlook. Because today is yesterday`s " +
                                   "tommorrow and we all know that it`s good to do things differently." +
                                   " So let`s go to " + placeText + " and " + verb1Text + " with someone cool. Or you could " +
                                   "just let it " + verb2Text + " right by." + "\n\n");
                }
            }
        });
    }//end onCreate
}//end StoryFour
