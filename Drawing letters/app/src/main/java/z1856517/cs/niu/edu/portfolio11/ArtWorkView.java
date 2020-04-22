package z1856517.cs.niu.edu.portfolio11;
import android.content.Context;

import android.graphics.Canvas;

import android.graphics.Color;

import android.graphics.Paint;

import android.view.View;

import java.util.Arrays;

public class ArtWorkView extends View
{
    private static final int N_circles=19, N_coord=2;

    private Paint paint;
    private int [][] artPositions;

    public ArtWorkView(Context context)
    {
        super(context);
        // Set the array to hold all of the coordinates
        artPositions = new int[N_circles][N_coord];

        // Set the paint color for drawing the circles
        int circlecolor= Color.CYAN;

        // Create the paint object
        paint = new Paint();

        // Set the type of the line style
        paint.setStyle(Paint.Style.STROKE);

        // Set the width of the paint stroke
        paint.setStrokeWidth(10.0f);

        // Apply the color to the paint stroke
        paint.setColor(circlecolor);
    }// End of constructor

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        // Draw all of teh circle on the canvas
        for(int sub=0;sub<N_circles;sub++)
        {
            canvas.drawCircle(artPositions[sub][0]+200,artPositions[sub][1]+300,60,paint);
        }
    }// End of ondraw

    // Method that updates artPositions array with the new values
    public  void update(int [][] values)
    {
        // Update the artpositions array with the new values
        artPositions = Arrays.copyOf(values,values.length);

        // Re-draw the canvas
        // Canvas must be invalidated before it can re-drawn
        // The invalidate method will ay=uto call the onDraw method
        invalidate();
    }// End update
}// End of ArtWorkView
