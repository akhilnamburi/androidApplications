/***************************************************************************
 * Instructor Name : Amy Byrnes
 *
 * ASSIGNMENT : 5 - To Do List
 *
 * Assignment Team Members : 1) Akhil Namburi(Z1856517)
 *                           2) Anurag Gudipati(Z1862977)
 *
 * Purpose : To write an application that will use a database to store information.
 *          The application should function as a list-making tool.
 ***************************************************************************/
package z1856517.cs.niu.edu.asssignment5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private DatbaseManager datbaseManager;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        datbaseManager = new DatbaseManager(this);
        scrollView = (ScrollView)findViewById(R.id.listScrollView);
       updateView();
    }

    @Override
    protected void onResume(){
        super.onResume();
        updateView();
    }

    public void updateView() {

        ArrayList<Item> items= datbaseManager.selectAll();
        int numItems = items.size();
        if(numItems > 0){

            scrollView.removeAllViewsInLayout();

            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            for( Item item : items ){
                CheckBox cb = new CheckBox(getApplicationContext());
                cb.setText(item.getName());
                linearLayout.addView(cb);
            }//end for

            //add the gridlayout to the scrollview
            scrollView.addView(linearLayout);
        }//end if
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add)
        {
            Toast.makeText(this, "Add was selected", Toast.LENGTH_SHORT).show();
            Log.d("onOptionsItemSelected", "ADD was selected");

            Intent insertIntent = new Intent(MainActivity.this, Insert.class);
            startActivity(insertIntent);

            return true;
        }
        else if( id == R.id.action_delete)
        {
            Toast.makeText(this, "Delete was selected", Toast.LENGTH_SHORT).show();
            Log.d("onOptionsItemSelected", "DELETE was selected");

            Intent deleteIntent = new Intent(MainActivity.this, DeleteActivity.class);
            startActivity(deleteIntent);

            return true;
        }
        else if( id == R.id.action_update)
        {
            Toast.makeText(this, "Update was selected", Toast.LENGTH_SHORT).show();
            Log.d("onOptionsItemSelected", "UPDATE was selected");

            Intent updateIntent = new Intent(MainActivity.this, UpdateActivity.class);
            startActivity(updateIntent);
            return true;
        }
        else if( id == R.id.action_resetAll) {
            Toast.makeText(this, "Delete All was selected", Toast.LENGTH_SHORT).show();
            Log.d("onOptionsItemSelected", "Delete All was selected");

            deleteDatabase("listdb");
        }

        return super.onOptionsItemSelected(item);
    }


}
