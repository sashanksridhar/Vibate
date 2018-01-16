package com.example.sashank.vibate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public Vibrator vib;
    private Button b1, b2;

    long[] pattern = {10, 100, 100, 1000};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                vib.vibrate(pattern, 0);

                dispatchTakePictureIntent();

            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                vib.cancel();
            }

        });
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);

    startActivity(takePictureIntent);
}


}

