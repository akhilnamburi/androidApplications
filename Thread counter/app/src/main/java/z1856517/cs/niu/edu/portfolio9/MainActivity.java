package z1856517.cs.niu.edu.portfolio9;

/********************************************************************
 CSCI 522 - Portfolio9 - Spring 2020

 Programmer(s): Akhil Namburi
 Z-Id: Z1856517
 Date Due: 04/21/2020
 *********************************************************************/
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private TextView countTV;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the textview to the screen
        countTV=findViewById(R.id.countTextView);

        //initialize the counter to 0
        counter =0;

        //create the thread and pass a runnable
        Thread thread=new Thread( countNumbers );

        //start the execution of the thread
        thread.start();
    }//end onCreate

    @Override
    protected void onStart()
    {
        super.onStart();
        //reset the counter to 0
        counter=0;
    }//end onStart

    private Runnable countNumbers = new Runnable()
    {
        private static final int DELAY=1000;
        @Override
        public void run()
        {
            while(true)
            {
                //increment the counter by 1
                counter++;

                try
                {
                    Thread.sleep(DELAY);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                //update the UI thread by sending an empty message
                threadHandler.sendEmptyMessage(0);
            }//end while
        }//end run method
    };//end of countNumbers runnable

    public Handler threadHandler =new Handler()
    {
        //code the handleMessage so the UI thread knows what to do
        public void handleMessage(Message message)
        {
            countTV.setText(counter.toString());
        }
    };




}//end MainActivity

