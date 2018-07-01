package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalNumberOfQuestions = 4;
    double score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param isItKatsina is whether Katsina is selected as state of the president
     * @param isItBayelsa is whether Bayelsa is selected as former president state
     * @param isItKano is selected as state of Babatunde fashola
     * @param isItOneTenure is whether one is selected as number of times he ruled
     * @param isItYaradua is whether Yaradua is selected as the husband of turai
     * @param score is result of quiz participant
     * @return final quiz score
     */
    private double calculateResult(boolean isItKatsina, boolean isItBayelsa, boolean isItKano, boolean isItOneTenure, boolean isItYaradua, double score) {

        //Add 1 to score if Katsina is selected
        if (isItKatsina) {
            score += 1;

        }

        //Add 1 to score if Bayelsa is selected
        if (isItBayelsa) {
            score += 0.5;
        }

        //Add 1 to score if Lagos is selected
        if (isItKano) {
            score += 0.5;
        }

        //Add 1 to score if one goal is selected
        if (isItOneTenure) {
            score += 1;
        }

        //Add 1 to score if Yaradua is selected
        if (isItYaradua) {
            score += 1;
        }

        //Return score of participant
        return score;
    }

    public void submitAnswers (View view) {

        // To get nickname of participant
        TextView nickname = (TextView) findViewById(R.id.name_field);
        String test_name = nickname.getText().toString();

        //If Katsina is checked as state of the president
        RadioButton katsina = (RadioButton) findViewById(R.id.katsina_radio_button);
        boolean isKatsina = katsina.isChecked();

        //If Bayelsa is checked as state of the former president
        CheckBox bayelsa = (CheckBox) findViewById(R.id.bayelsa_checkbox);
        boolean isBayelsa = bayelsa.isChecked();

        //If Kano is checked as state of the governor
        CheckBox kano = (CheckBox) findViewById(R.id.kano_checkbox);
        boolean isKano = kano.isChecked();

        //If one is checked as number of tenure jonathan has ruled
        RadioButton oneTenure = (RadioButton) findViewById(R.id.one_radio_button);
        boolean jonathanOne = oneTenure.isChecked();

        //If Yaradua is checked as the husband of turai
        RadioButton yaraduaIsHusband = (RadioButton) findViewById(R.id.yaradua_radio_button);
        boolean husbandToturai = yaraduaIsHusband.isChecked();

        //To calculate quiz result
        double result = calculateResult(isKatsina, isBayelsa, isKano, jonathanOne, husbandToturai, score);

        //To toast score after test submission
        Toast.makeText(this, test_name + " you scored " + result + " out of " + totalNumberOfQuestions, Toast.LENGTH_SHORT).show();
    }

}

