package z1856517.cs.niu.edu.portfolio11;

/*********************************************
 Portfolio: 11

 Name: Akhil Namburi

 Zid: Z1856517

 DueDate: 04/22/2020 11:59 pm
 **********************************************/

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Handler;

import android.os.Message;

import android.view.View;

import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
{
    // Two threads to handle the workload
    private Thread calculateMovementThread,drawMovementThread;

    // Constants
    private static final int N_objects=19,N_coord=2,x_pos=0,y_pos=1;

    private int[][] currentPosition = new int[N_objects][N_coord], finalDestination= new int[N_objects][N_coord];

    // For drawing the circles
    private ArtWorkView artWorkView;

    private RelativeLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the two arrays of integers initialized
        initialize();

        mainLayout=findViewById(R.id.relativeLayout);

        // Create the artwork view
        artWorkView= new ArtWorkView(this);

        // Add the artwork to the layout
        mainLayout.addView(artWorkView);

        // Connect the threads with the runnables
        calculateMovementThread= new Thread(calculateMovement);
        drawMovementThread= new Thread(drawMovement);

        // Start the two threads
        calculateMovementThread.start();
        drawMovementThread.start();


    }// End oncreate


    // Method to put some values into current position and the final destination array
    private void initialize()
    {
        for(int sub=0;sub<N_objects;sub++)
        {
            // X and Y coordinates for finalDestination
            finalDestination[sub][x_pos]=200;
            finalDestination[sub][y_pos]=200;

            // X and Y coordinates for currentPosition
            currentPosition[sub][x_pos]=20;
            currentPosition[sub][y_pos]=20;

        }
    }// End of initialize

    public void createA(View view)
    {
        for(int sub=0;sub<N_objects;sub++)
        {
            finalDestination[sub][x_pos]=ArtDesign.artA[sub][x_pos];
            finalDestination[sub][y_pos]=ArtDesign.artA[sub][y_pos];

        }
    }// End of createA

    public void createB(View view)
    {
        for(int sub=0;sub<N_objects;sub++)
        {
            finalDestination[sub][x_pos]=ArtDesign.artB[sub][x_pos];
            finalDestination[sub][y_pos]=ArtDesign.artB[sub][y_pos];

        }
    }// End of createB

    public void createC(View view)
    {
        for(int sub=0;sub<N_objects;sub++)
        {
            finalDestination[sub][x_pos]=ArtDesign.artC[sub][x_pos];
            finalDestination[sub][y_pos]=ArtDesign.artC[sub][y_pos];

        }
    }// End of createC

    // Handler for the messages that will update the artwork
    public Handler threadHandler = new Handler()
    {
        @Override
        public void handleMessage(@NonNull Message msg)
        {
            // Update the circles
            artWorkView.update(currentPosition);
        }
    };// End of thread handler

    // Runnables
    // 1st to compute the positions of the circles on the screen
    // Position is calculated after every 200 ms
    // Current position are based on distance to the target position divided by 5

    private Runnable calculateMovement = new Runnable()
    {
        // Cretae a constant to hold for 200 ms
        private static final int Delay=200;

        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    for(int sub=0;sub<N_objects;sub++)
                    {
                        currentPosition[sub][x_pos] += (finalDestination[sub][x_pos] - currentPosition[sub][x_pos])/5;
                        currentPosition[sub][y_pos] += (finalDestination[sub][y_pos] - currentPosition[sub][y_pos])/5;
                    }
                    Thread.sleep(Delay);
                }
            }
            catch (InterruptedException ie){}

        }
    };// End of Runnable calculateMovement

    // Runnable that sends message every 200 ms
    private Runnable drawMovement= new Runnable()
    {
        // Create a consttant to hold for 200 ms
        private static final int Delay=200;
        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    Thread.sleep(Delay);
                    threadHandler.sendEmptyMessage(0);
                }
            }
            catch (InterruptedException ie){}
        }
    };// End drawMovement


}// End MainActivity
