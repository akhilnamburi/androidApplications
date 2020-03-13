/*

Name: Akhil Namburi

ZID: Z1856517 , CSCI - 522

Portfolio: 5

Title: Spinners

*/


package z1856517.cs.niu.portfolio5_spineers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Spinner;

import android.widget.Toast;

import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private Spinner xmlspin,classSpin,listSpin;
    List<String> listvalues= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner populated by data from strings.xml file
        xmlspin=findViewById(R.id.xmlspinner);

        //create the array adapter with the information
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getApplicationContext(),R.array.spinnerArray,R.layout.spinner_view);
        xmlspin.setAdapter(adapter1);

        xmlspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selection1;

                selection1=parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),"The flavour of ice cream selected is " + selection1,Toast.LENGTH_SHORT).show();
            } //End  xmlspin.onItemSelected

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            } //End onNothingSelected
        }); // End setOnItemSelectedListener

        //populate the spinner using information from a class
        classSpin = findViewById(R.id.classspinner);

        ArrayAdapter<String> adapter2=new ArrayAdapter<>(getApplication(),R.layout.spinner_view,SpinnerInfo.valueArray);
        classSpin.setAdapter(adapter2);
        classSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selection2;
                selection2=parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),"Topping selected is "+ selection2,Toast.LENGTH_SHORT).show();
            } // End onItemSelected

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            } //End onNothingSelected
        });//End classSpin.setOnItemSelectedListener

        //Spinner populated from a list object

        listvalues.add("Cup");
        listvalues.add("Waffle Cone");
        listvalues.add("Cake Cone");
        listvalues.add("Sugar Cone");
        listvalues.add("Waffle Bowls");
        listSpin = findViewById(R.id.listspinner);

        //ArrayAdapter<String> adapter3= new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,listvalues);

        ArrayAdapter<String> adapt3 = new ArrayAdapter<>(getApplication(),R.layout.spinner_view,listvalues);
        listSpin.setAdapter(adapt3);

        listSpin.setOnItemSelectedListener(spinnerlistener);
    }//end oncreate
    AdapterView.OnItemSelectedListener spinnerlistener= new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            Toast.makeText(MainActivity.this,"The base for ice cream selected is : "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
        } //End onItemSelected

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {

        } //End onNothingSelected
    }; //End  AdapterView.OnItemSelectedListener
} //End Main Activity


