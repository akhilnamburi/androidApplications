/**************************************************************************
 Name: Akhil Namburi(Z1856517)
 Anurag Gudipati(Z1862977)

 ASSIGNMENT : 3

 Due date: 03/13/2020
 */
package z1856517.cs.niu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Spinner xmlSpin;
    private ImageView pictureIV;
    private String selection1 = null;
    private int pos = 0;
    private int[] img = {R.drawable.dohni_india, R.drawable.virak_kohli, R.drawable.sachin_india,
            R.drawable.rohit_sharma,R.drawable.hardik_pandya};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinner populated by data from strings.xml file
        xmlSpin = findViewById(R.id.xmlSpinner);
        pictureIV = findViewById(R.id.imageView);
        //create the array adapter with the information
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.spinnerArray,
                R.layout.spinner_view);
        xmlSpin.setAdapter(adapter1);
        xmlSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection1 = parent.getItemAtPosition(position).toString();
                pos = position;
                pictureIV.setImageResource(img[position]);
                Toast.makeText(getApplicationContext(),"The selection is "+selection1,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }//end onCreate
    //handle button click
    public void getRecipe(View view)
    {
        //create the intent to call NameActivity
        Intent recipeIntent = new Intent(MainActivity.this, SecondActivity.class);
        recipeIntent.putExtra("nameID", selection1);
        recipeIntent.putExtra("position",pos);
        //startActivity();
        startActivity(recipeIntent);
    }//end getRecipe
}// end MainActivity
