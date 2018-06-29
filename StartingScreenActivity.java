package com.example.android.solarpopquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        final Button buttonStartQuiz = (Button)findViewById(R.id.get_started_button);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStarted();
            }
        });
    }

    /*
        This method displays the High Score on the screen
         */
    private void displayHighScore(String Message){
        TextView highScoreTextView = (TextView) findViewById(R.id.highscore_text_view);
        highScoreTextView.setText(Message);
    }

    private void getStarted(){
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        startActivity(intent);
    }
}
