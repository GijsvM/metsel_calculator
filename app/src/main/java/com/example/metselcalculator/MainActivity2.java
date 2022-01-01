package com.example.metselcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView lengteSteenInput;
    private TextView muurdikteInput;
    private TextView hoogteSteenInput;
    private TextView lagenmaatInput;
    private TextView stootvoegInput;
    private TextView aantalMInput;
    private TextView metselzand;
    private TextView voegzand;
    private TextView portlandcement;
    private TextView metselcement;
    private TextView stenen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        //transporting the variables from MainActivity.java to MainActivity2.java

        lengteSteenInput = (EditText) findViewById(R.id.lengteSteenInput);
        muurdikteInput = (EditText) findViewById(R.id.muurdikteInput);
        hoogteSteenInput = (EditText) findViewById(R.id.hoogteSteenInput);
        lagenmaatInput = (EditText) findViewById(R.id.lagenmaatInput);
        stootvoegInput = (EditText) findViewById(R.id.stootvoegInput);
        aantalMInput = (EditText) findViewById(R.id.aantalMInput);

        float lengteSteenF = bundle.getFloat("lengtesteen");
        float muurdikteF = bundle.getFloat("muurdikte");
        float hoogteSteenF = bundle.getFloat("hoogtesteen");
        float lagenmaatF = bundle.getFloat("lagenmaat");
        float aantalM2F = bundle.getFloat("aantalm2");
        String stootvoegB = getIntent().getStringExtra("stootvoeg");

        lengteSteenInput.setText(String.valueOf(lengteSteenF));
        muurdikteInput.setText(String.valueOf(muurdikteF));
        hoogteSteenInput.setText(String.valueOf(hoogteSteenF));
        lagenmaatInput.setText(String.valueOf(lagenmaatF));
        aantalMInput.setText(String.valueOf(aantalM2F));
        stootvoegInput.setText(String.valueOf(stootvoegB));

        //string -> float

        float lengteSteenInputF = Float.parseFloat(String.valueOf(lengteSteenInput));
        float muurdikteInputF = Float.parseFloat(String.valueOf(muurdikteInput));
        float hoogteSteenInputF = Float.parseFloat(String.valueOf(hoogteSteenInput));
        float lagenmaatInputF = Float.parseFloat(String.valueOf(lagenmaatInput));
        float aantalM2InputF = Float.parseFloat(String.valueOf(aantalMInput));
        boolean stootvoegInputB = Boolean.parseBoolean(String.valueOf(stootvoegInput));

        //defining variables for the upcoming if statements
        float benodigdMetselzand;
        float benodigdVoegzand;

        //calculations

        float lintvoeg = ((lengteSteenInputF/1000)*(lagenmaatInputF-hoogteSteenInputF)/1000)*(muurdikteInputF/1000);
        float stootvoeg = ((lagenmaatInputF/1000)*(lagenmaatInputF-hoogteSteenInputF)/1000)*(muurdikteInputF/1000);
        float aantalstenen = (1000/lengteSteenInputF)*(1000/lagenmaatInputF)*aantalM2InputF;

        if (stootvoegInputB = Boolean.parseBoolean("ja")){
            benodigdMetselzand = (float) (((lintvoeg + stootvoeg) * 1.1) * aantalstenen);

    }
        else{
            benodigdMetselzand = (float) ((lintvoeg * 1.1) * aantalstenen);
        }

        float benodigdMetselCement =  (benodigdMetselzand*250)/25;
        float aantalStenen2 = (float) (aantalstenen*1.03);

        if(stootvoegInputB = Boolean.parseBoolean("ja")){
            benodigdVoegzand = (float) (((lintvoeg+stootvoeg)*1.2)*aantalstenen*0.15);
}
        else{
            benodigdVoegzand = (float) ((lintvoeg*1.2)*aantalstenen*0.15);
    }
        float benodigdPortlandCement = (benodigdVoegzand*250)/25;

        //print the numbers to the screen

        metselzand.setText(Float.toString(benodigdMetselzand));
        voegzand.setText(Float.toString(benodigdVoegzand));
        portlandcement.setText(Float.toString(benodigdPortlandCement));
        metselcement.setText(Float.toString(benodigdMetselCement));
        stenen.setText(Float.toString(aantalStenen2));






}}