package com.example.android.solarpopquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private static final String LOG_TAG = QuizActivity.class.getSimpleName();
    //Question 1
    RadioButton question1_mercury;
    //Question 2
    CheckBox question2_yes;
    CheckBox question2_no;
    //Question 3
    EditText question3_answer;
    //Question 4
    RadioButton question4_earth;
    //Question 5
    CheckBox question5_true;
    CheckBox question5_false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.QuizActivity);
    }


    public void submitAnswers(View view) {
        CharSequence resultDisplay;
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int final_score;
        // correct answer for question 1 is mercury

        boolean answer1;
        question1_mercury = (RadioButton) this.findViewById(R.id.question1_mercury);
        answer1 = question1_mercury.isChecked();
        if (answer1) {
            answer1_score = 3;
        } else {
            answer1_score = 0;
        }

        //Question 2: the correct answer is yes
        boolean answer2_yes;
        boolean answer2_no;
        question2_yes = (CheckBox) this.findViewById(R.id.question2_yes);
        question2_no = (CheckBox) this.findViewById(R.id.question2_no);
        answer2_yes = question2_yes.isChecked();
        answer2_no = question2_no.isChecked();
        if (answer2_yes && !answer2_no) {
            answer2_score = 3;
        } else {
            answer2_score = 0;
        }

        //Question 3: the correct answer is 8

        String answer3;
        question3_answer = (EditText) this.findViewById(R.id.question3_answer);
        answer3 = question3_answer.getText().toString().toLowerCase();
        if (answer3.equals("8")) {
            answer3_score = 2;
        } else {
            answer3_score = 0;
        }

        //Question 4: the correct answer is the Earth
        boolean answer4;
        question4_earth = (RadioButton) this.findViewById(R.id.question4_earth);
        answer4 = question4_earth.isChecked();
        if (answer4) {
            answer4_score = 3;
        } else {
            answer4_score = 0;
        }

        //Question 5: the correct answer is false
        boolean answer5_true;
        boolean answer5_false;
        question5_true = (CheckBox) this.findViewById(R.id.question5_true);
        question5_false = (CheckBox) this.findViewById(R.id.question5_false);
        answer5_true = question5_true.isChecked();
        answer5_false = question5_false.isChecked();
        if (answer5_false && !answer5_true) {
            answer5_score = 3;
        } else {
            answer5_score = 0;
        }


        // Final score: the sum of all the points for the correct answers or wrong answers.

        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;
        if (final_score == 8) {
            resultDisplay = "You are the Best!";
        } else {
            resultDisplay = "Whatever, you lose!";
        }

        // the Intent that display the message of the final score.
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();}

        /*
        This method displays the High Score on the screen
         */

    private void displayHighScore(String Message) {
        TextView highScoreTextView = (TextView) findViewById(R.id.highscore_text_view);
        highScoreTextView.setText(Message);
    }

}



