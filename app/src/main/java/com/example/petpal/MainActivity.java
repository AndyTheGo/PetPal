package com.example.petpal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    TextView myTextView2;
    TextView myTextView3;
    TextView ghost;
    int track;
    int track2;
    int track3;
    ProgressBar myProgressBar;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
    ImageView ghostly;
    public int images [] = {R.drawable.coolghost , R.drawable.snapchat, R.drawable.sad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.time);
        myTextView2 = findViewById(R.id.time2);
        myTextView3 = findViewById(R.id.time3);
        ghost = findViewById(R.id.textView8);
        track = 0;
        track2 = 0;
        track3 = 0;
        myProgressBar = findViewById(R.id.progress1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        ghostly = findViewById(R.id.imageView3);
        myProgressBar.setMax(1000);
        progressBar2.setMax(1000);
        progressBar3.setMax(1000);




        new CountDownTimer(1000000000,2000){
            @Override
            public void onTick(long millisUntilFinished) {
                //Log.i("ontick", String.valueOf(track3));
                if (track3 > 0){
                    track3--;
                    myTextView3.setText("" + track3);
                }
                progressBar3.setProgress(track3);

                if (track2 > 0){
                    track2--;
                    myTextView2.setText(""+ track2);
                }
                progressBar2.setProgress(track2);

                if (track > 0){
                    track--;
                    myTextView.setText(""+ track);
                }
                myProgressBar.setProgress(track);

                if (track2 >= 10 && track3 >= 15){
                    track = track + 5;
                    myTextView.setText(""+ track);
                }

                if (track >= 50 && track2 >= 50 && track3 >= 50){
                    ghostly.setImageResource(images[1]);
                    ghost.setText("Happy Ghostly!");

                }

                if (track >= 100 && track2 >=100 && track3 >= 100){
                    ghostly.setImageResource(images[0]);
                    ghost.setText("Lit Ghostly!");
                }

                if (track < 100 && track > 50 && track2 < 100 && track2 > 50 && track3 < 100 && track3 > 50){
                    ghostly.setImageResource(images[1]);
                    ghost.setText("Happy Ghostly!");
                }

                if (track3 < 50 && track2 < 50 && track < 50){
                    ghostly.setImageResource(images[2]);
                    ghost.setText("Sad Ghostly!");
                }




            }
            @Override
            public void onFinish() {
                Toast myToast = Toast.makeText(getApplicationContext(),"Timer Finished", Toast.LENGTH_SHORT);
                myToast.show();
            }

        }.start();

    }

    public void food(View view){
        track2++;
        myTextView2.setText(""+ track2);
        progressBar2.setProgress(track2);

    }

    public void health(View view){
        track++;
        myTextView.setText("" +track);
        myProgressBar.setProgress(track);
    }

    public void sleep(View view){
        track3++;
        myTextView3.setText(""+ track3);
        progressBar3.setProgress(track3);
    }
}
