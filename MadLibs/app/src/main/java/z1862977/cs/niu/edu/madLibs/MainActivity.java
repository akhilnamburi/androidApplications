package z1862977.cs.niu.edu.madLibs;

/********************************************************************************************
 * Instructor: Amy Brynes
 * Names: Akhil Namburi(Z1856517)
 *        Anurag Gudipati(Z1862977)
 * CSCI 522
 * Graduate Project : This is a Mad Libs application that will ask the user to enter various
 *               types of words (noun, verb, adverb, part of the body, etc...) and then
 *               use the values entered by the user to fill in a story with missing parts.
 *               The key to Mad Libs (and what makes it fun) is that the user only knows the
 *               title of the story when they're entering the words. For each word, the user
 *               will be able to enter their own word. list.
 *
 ********************************************************************************************/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button OneBtn, TwoBtn, ThreeBtn, FourBtn, FiveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OneBtn = (Button)findViewById(R.id.storyOneButton);
        TwoBtn = (Button)findViewById(R.id.storyTwoButton);
        ThreeBtn = (Button)findViewById(R.id.storyThreeButton);
        FourBtn = (Button)findViewById(R.id.storyFourButton);
        FiveBtn = (Button)findViewById(R.id.storyFiveButton);
        OneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryOne.class));
            }
        });
        TwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryTwo.class));
            }
        });
        ThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryThree.class));
            }
        });
        FourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryFour.class));
            }
        });
        FiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryFive.class));
            }
        });
    }//end onCreate
}//end MainActivity
