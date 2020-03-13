//NAME        :    AKHIL NAMBURI
//ZID         :    Z1856517
//TITLE       :    PORTFOLIO 4c(Implicit Intents)
//INSTRUCTOR  :    AMY BYRNES

package z1856517.cs.niu.portfolio4c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.implicit.R;

public class MainActivity extends Activity {

    //defining instance variables
    private ImageView pictureTV;
    static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the variables to the objects on screen
        pictureTV=findViewById(R.id.pictureimageview);
    }//end onCreate

    public void doBrowser(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cs.niu.edu"));

        startActivity(browserIntent);
    }//end doBrowser

    public void doPhone(View view)
    {
        Intent phoneIntent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:7083153659"));

        startActivity(phoneIntent);
    }//end doPhone

    public void doPicture(View view)
    {
        Intent pictureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (pictureIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(pictureIntent,REQUEST_CODE);
        }
    }//end doPicture

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode==REQUEST_CODE&&resultCode==RESULT_OK)
        {
            //retrieve the image
            Bundle extras=data.getExtras();
            Bitmap imageBitmap=(Bitmap)extras.get("data");

            //put the bitmap into imageview
            pictureTV.setImageBitmap(imageBitmap);
            Toast.makeText(MainActivity.this,"Successful", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Un-Successful",Toast.LENGTH_LONG).show();
        }

    }//end ActivityResult
}//end MainActivity
