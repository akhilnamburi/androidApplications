package z1862977.cs.niu.edu.madLibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StoryTwo extends AppCompatActivity {

    EditText boyNameET, noun1ET, occupationET, measurementET, noun2ET, adjective1ET,
             gameET, adjective2ET, nounPluralET, verbIngET;

    TextView storyTV2;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_two);

        //connect the variable to the objects on the screen
        boyNameET = (EditText)findViewById(R.id.boyName);
        noun1ET = (EditText)findViewById(R.id.noun1);
        occupationET = (EditText)findViewById(R.id.occupation);
        measurementET = (EditText)findViewById(R.id.measurement);
        noun2ET = (EditText)findViewById(R.id.noun2);
        adjective1ET = (EditText)findViewById(R.id.adjective1);
        gameET = (EditText)findViewById(R.id.game);
        adjective2ET = (EditText)findViewById(R.id.adjective2);
        nounPluralET = (EditText)findViewById(R.id.nounPlural);
        verbIngET = (EditText)findViewById(R.id.verbIng);

        storyTV2 = (TextView)findViewById(R.id.story2Screen);

        submitButton = (Button)findViewById(R.id.story2Button);


        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (    boyNameET.getText().toString().matches("") ||
                        noun1ET.getText().toString().matches("") ||
                        occupationET.getText().toString().matches("") ||
                        measurementET.getText().toString().matches("") ||
                        noun2ET.getText().toString().matches("") ||
                        adjective1ET.getText().toString().matches("") ||
                        gameET.getText().toString().matches("") ||
                        adjective2ET.getText().toString().matches("") ||
                        nounPluralET.getText().toString().matches("") ||
                        verbIngET.getText().toString().matches("")         )
                {
                    //Display a toast message and log message
                    Toast.makeText(view.getContext(), "Cannot Have Empty Fields", Toast.LENGTH_LONG).show();
                }
                else {
                    String boyNameText = boyNameET.getText().toString();
                    String noun1Text = noun1ET.getText().toString();
                    String occupationText = occupationET.getText().toString();
                    String measurementText = measurementET.getText().toString();
                    String noun2Text = noun2ET.getText().toString();
                    String adjective1Text = adjective1ET.getText().toString();
                    String gameText = gameET.getText().toString();
                    String adjective2Text = adjective2ET.getText().toString();
                    String nounPluralText = nounPluralET.getText().toString();
                    String verbIngText = verbIngET.getText().toString();


                    storyTV2.setText("On his 11th birthday, young " + boyNameText + " Potter discovers the " +
                            noun1Text + " he never knew he had, the " + noun1Text + " of a/an " +
                            occupationText + "." + " In his first " + measurementText + " at Hogwarts School " +
                            " of Witchcraft and " + noun2Text + ", he meets his two " + adjective1Text +
                            " friends Ron Weasley, an expert " + " at Wizard " + gameText + ", and Hermione Granger, " +
                            "a girl with " + adjective2Text + " parents. " + boyNameText + " learns the game of " +
                            "Quiditch and Wizard " + gameText + " on his way to facing a Dark " + nounPluralText +
                            " teacher who is bent on " + verbIngText + " him." + "\n\n");
                }
            }
        });
    }//end onCreate
}//end StoryTwo
