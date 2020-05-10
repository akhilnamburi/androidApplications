package z1856517.cs.niu.edu.asssignment5;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    private DatbaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        databaseManager = new DatbaseManager(this);
        updateView();
    }

    public void updateView(){
        //Get all of the items in the database
        ArrayList<Item> items = databaseManager.selectAll();
        int numItems = items.size();

        //if there are candies in the database
        if( numItems > 0 ){
            RelativeLayout layout = new RelativeLayout(this);  //parent layout
            ScrollView scrollView = new ScrollView(this);  //to hold lots of data
            GridLayout gridLayout = new GridLayout(this);
            gridLayout.setRowCount(numItems);
            gridLayout.setColumnCount(3);

            TextView[] ids = new TextView[numItems];
            EditText[][] names = new EditText[numItems][1];
            Button[] buttons = new Button[numItems];

            //find the screen width
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);
            int width = size.x;
            int sub = 0;

            for( Item item : items ){
                //fill the textview with an id
                ids[sub] = new TextView(this);
                ids[sub].setGravity(Gravity.CENTER);
                ids[sub].setText( "" + item.getId()  );

                //fill the edit text fields
                names[sub][0] = new EditText(this);
                names[sub][0].setText(item.getName());
                names[sub][0].setId(10 * item.getId());
                //fill the button fields
                buttons[sub] = new Button(this);
                buttons[sub].setText("Update");
                buttons[sub].setId(item.getId());
                buttons[sub].setOnClickListener(buttonHandler);
                gridLayout.addView(ids[sub], width/10, ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(names[sub][0], (int)(width * .45), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(buttons[sub], (int)(width * .35), ViewGroup.LayoutParams.WRAP_CONTENT);

                sub++;
            }//end of for

            Button backButton = new Button(this);
            backButton.setText(R.string.backString);
            backButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    finish();
                }
            });
            scrollView.addView(gridLayout);
            layout.addView(scrollView);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            params.setMargins(0,0,0,50);
            layout.addView(backButton, params);
            setContentView(layout);
        }//end if
    }//end updateView

    //onClickListener for the button
    public View.OnClickListener buttonHandler = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            int itemID = view.getId();
            EditText nameET = (EditText)findViewById( 10 * itemID  );
            String nameStr = nameET.getText().toString();
            databaseManager.updateByID(itemID, nameStr);
            Toast.makeText(UpdateActivity.this, "List Item updated: " + nameStr, Toast.LENGTH_SHORT).show();
            updateView();

        }
    };
}
