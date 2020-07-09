package com.example.user.penaltyshooter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    {
    private TextView welcome, shooter;              // TextViews statements
    Animation fromtop, frombottom;                  // We have to do animations statements
    private static long SPLASH_TIME_OUT = 2000;     // This sets the time will remains the MainActivity on the screen

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        welcome = findViewById( R.id.tv_welcome );                  // this line sets the statement with the EditText in the corresponding Layout resource
        shooter = findViewById( R.id.tv_shooter );                  // this line sets the statement with the EditText in the corresponding Layout resource
        fromtop = AnimationUtils.loadAnimation( this, R.anim.fromtop );         // this line finds the animation fromtop
    frombottom = AnimationUtils.loadAnimation( this,R.anim.frombottom );        // this line finds the animation frombottom
        welcome.setAnimation(fromtop);                                                 // this sets the animation fromtop to the first EditText
        shooter.setAnimation( frombottom );                         // this sets teh animation frombottom to the second EditText

        new Handler().postDelayed( new Runnable() {                 // this is the method that holds the main screen during the time settled upside
        @Override
        public void run() {
        Intent loginIntent = new Intent(MainActivity.this, Game.class);         // this is the Intent that will launch
        startActivity(loginIntent);                                             // the next activity (here, Game Activity)
        finish();
        }
        },SPLASH_TIME_OUT);
        }
    }

