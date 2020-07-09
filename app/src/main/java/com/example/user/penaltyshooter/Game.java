package com.example.user.penaltyshooter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;


public class Game extends AppCompatActivity
    {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;                // Statements of all variables and
    private EditText tv_choice;                                                         // components we need for the game
    private TextView tv_remainingAttempts, tv_result, tv_result2, tv_position, tv_score;
    private Button shoot;
    private boolean ispair;
    private Animation fromtop, fromleft, fromright;
    private int player = 0;
    private int goal = 0, score = 0;
    private short remainingAttempts = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game );

        btn1 = findViewById( R.id.btn_1 );          // Links
        btn2 = findViewById( R.id.btn_2 );          // to
        btn3 = findViewById( R.id.btn_3 );          // the
        btn4 = findViewById( R.id.btn_4 );          // components
        btn5 = findViewById( R.id.btn_5 );          // in
        btn6 = findViewById( R.id.btn_6 );          // the
        btn7 = findViewById( R.id.btn_7 );          // corresponding
        btn8 = findViewById( R.id.btn_8 );          // Layout
        btn9 = findViewById( R.id.btn_9 );
        tv_result = findViewById( R.id.tv_result );
        tv_result2 = findViewById( R.id.tv_result2 );
        tv_remainingAttempts = findViewById( R.id.tv_remainingAttempts );
        fromtop = AnimationUtils.loadAnimation( this, R.anim.fromtop );
        fromleft = AnimationUtils.loadAnimation( this, R.anim.fromleft );
        fromright = AnimationUtils.loadAnimation( this, R.anim.fromright );
        tv_position = findViewById( R.id.tv_position );
        tv_score = findViewById( R.id.tv_score );

        tv_remainingAttempts.setText( String.valueOf( remainingAttempts ) );  // This sets the text in TextView remainingAttempts

        btn1.setOnClickListener( new View.OnClickListener()                   // Actions performed when the buuton 1 is clicked
            {
            @Override
            public void onClick(View v)
                {
                selectRandom ();                                              // Calls the method selectRandom()
                player = 1;                                                   // Attributes a value to the variable player
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();                                                     // Calls the method onGame()
                }
            } );

        btn2.setOnClickListener( new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                selectRandom ();
                player = 2;
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();
                }
            } );


        btn3.setOnClickListener( new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                selectRandom ();
                player = 3;
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();
                }
            } );
        btn4.setOnClickListener( new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                selectRandom ();
                player = 4;
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();
                }
            } );
        btn5.setOnClickListener( new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                selectRandom ();
                player = 5;
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();
                }
            } );
        btn6.setOnClickListener( new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                selectRandom ();
                player = 6;
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();
                }
            } );
        btn7.setOnClickListener( new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                selectRandom ();
                player = 7;
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();
                }
            } );
        btn8.setOnClickListener( new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                selectRandom ();
                player = 8;
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();
                }
            } );
        btn9.setOnClickListener( new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                selectRandom();
                player = 9;
                Log.d( "player", String.valueOf( player ) );
                Log.d( "goal", String.valueOf( goal ) );
                onGame();
                }
            } );
        }

    public void onGame()                                    // This method will define what the program will do during the game
        {
        tv_position.setText("");                            // The TextView position is reinitialized
        if (goal != player)                                 // Condition loop: if the player value and the goal value  aren't equals, the player wins
            {
            tv_result.setTextColor( Color.BLACK );          // Sets the Text color
            tv_result.setText( "GOOAAALLLL!!" );            // Sets the Text in case the player wins
            tv_result.setAnimation( fromleft );             // Sets the animation
            tv_result2.setText( "" );                       // In this case this TextView isn't used, it's set to blank
            score++;                                        // Incrementing player's score each time he wins
            } else
            {                                               //  The condition isn't true, then the shoot is blocked, the player loose
            tv_result.setTextColor( Color.RED );            // Sets the text in an other color
            tv_result.setText( "YOU" );                     // Sets the first TextView
            tv_result.setAnimation( fromleft );             // Sets the animation for the second TextView
            tv_result2.setTextColor( Color.RED );
            tv_result2.setText( "FAILED..." );              // Sets the text of the second TextView. In this case, this TextView is used
            tv_result2.setAnimation( fromright );
            tv_position.setText( "The goal was in the case: " + goal );
            }
        remainingAttempts--;                                    // Decrementing the count of remaining attempts after each shoot
        tv_remainingAttempts.setText(String.valueOf(remainingAttempts));  // Sets the TextView of remaining attempts
        tv_score.setText( String.valueOf( score ) );            // Sets the TextView for the player's score
        if (remainingAttempts <= 0)                             // Other condition: when there isn't remaining attempts left, the game is over
        {                                                       // Two possibilities are proposed to the player
            new AlertDialog.Builder( Game.this ).setTitle( "Your score: " + score )  // This sets the AlertDialog and its choices, and shows the player's score in the AlertDialog
                    .setMessage( "Try again?" ).setPositiveButton( "YES", new DialogInterface.OnClickListener()  // Asks to the player if he wants to play again
                {
                @Override
                public void onClick(DialogInterface dialog, int which)
                    {
                    remainingAttempts = 5;                          // If he chooses to start a new game,
                    score=0;                                        // values and TextView are reinitialized to their
                    tv_score.setText( String.valueOf( score ) );    // initial values, so the game can restart.
                    tv_position.setText("");
                    }
                } ).setNegativeButton( "Close app", new DialogInterface.OnClickListener()
                {
                @Override
                public void onClick(DialogInterface dialog, int which)
                    {
                    finishAffinity();                               // If the player choose to stop the game,
                    System.exit( 0 );                         // this will close the application
                    }
                } ).show();
            }
        }

    public int selectRandom ()                                      // Method that picks a random number to set the goal position
        {
            Random r = new Random();                                // Select a random number of Integer type,
            goal = r.nextInt( 10 );                           // between 0 and 10.
            if (goal == 0)                                          // Loop in case if the selected number is 0, to pick an other number
                {
                goal = r.nextInt( 10 );
                }
            return goal;
        }

    public boolean isPair(boolean ispair) {                         // Method checks if a number is pair or not (boolean)

            if (goal%2 == 0) {
            ispair = true;
            }
            else {
            ispair = false;
            }
        return ispair;
    }
}
