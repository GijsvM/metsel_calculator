package com.example.metselcalculator;

import android.annotation.SuppressLint;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity2 extends AppCompatActivity {

    private EditText lengteSteenInput;
    private EditText muurdikteInput;
    private EditText hoogteSteenInput;
    private EditText lagenmaatInput;
    private EditText stootvoegInput;
    private EditText aantalMInput;
    private EditText aantalStenenInput;
    private TextView metselzand;
    private TextView voegzand;
    private TextView portlandcement;
    private TextView metselcement;
    private TextView stenen;
    private TextView oppervlakte2;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        //transporting the variables from MainActivity.java to MainActivity2.java

        lengteSteenInput = findViewById(R.id.lengteSteenInput);
        muurdikteInput = findViewById(R.id.muurdikteInput);
        hoogteSteenInput = findViewById(R.id.hoogteSteenInput);
        lagenmaatInput = findViewById(R.id.lagenmaatInput);
        stootvoegInput = findViewById(R.id.stootvoegInput);
        aantalMInput = findViewById(R.id.aantalMInput);
        aantalStenenInput = findViewById(R.id.aantalStenenInput);

        metselzand = findViewById(R.id.metselzand);
        voegzand = findViewById(R.id.voegzand);
        portlandcement = findViewById(R.id.portlandcement);
        metselcement = findViewById(R.id.metselcement);
        stenen = findViewById(R.id.stenen);
        oppervlakte2 = findViewById(R.id.oppervlakte2);


        float lengteSteenF = bundle.getFloat("lengtesteen");
        float muurdikteF = bundle.getFloat("muurdikte");
        float hoogteSteenF = bundle.getFloat("hoogtesteen");
        float lagenmaatF = bundle.getFloat("lagenmaat");
        float aantalM2F = bundle.getFloat("aantalm2");
        String stootvoegB = bundle.getString("stootvoeg");
        float aantalStenenF = bundle.getFloat("aantalStenen");

        //calculations
        //float oppervlakte = (aantalStenenF / (1000 / lagenmaatF) * (1000 / lengteSteenF));
        float lintvoeg = ((lengteSteenF / 1000) * (lagenmaatF - hoogteSteenF) / 1000) * (muurdikteF / 1000);
        float stootvoeg = ((lagenmaatF / 1000) * (lagenmaatF - hoogteSteenF) / 1000) * (muurdikteF / 1000);

        if (aantalM2F > 0) {
            float aantalstenen = (1000 / lengteSteenF) * (1000 / lagenmaatF) * aantalM2F;

            float benodigdMetselzand;
            if (stootvoegB.equals("ja")) {
                benodigdMetselzand = (float) (((lintvoeg + stootvoeg) * 1.1) * aantalstenen);

            } else {
                benodigdMetselzand = (float) ((lintvoeg * 1.1) * aantalstenen);
            }

            float benodigdMetselCement = (benodigdMetselzand * 250) / 25;
            float aantalStenen2 = (float) (aantalstenen * 1.03);
            float benodigdVoegzand = 0;
            if (stootvoegB.equals("ja")) {
                benodigdVoegzand = (float) (((lintvoeg + stootvoeg) * 1.2) * aantalstenen * 0.15);
            } else{
                benodigdVoegzand = (float) ((lintvoeg * 1.2) * aantalstenen * 0.15);
            }
            float benodigdPortlandCement = (benodigdVoegzand * 250) / 25;

            //rounding the numbers

            int benodigdPortlandcement2 = (int) Math.ceil(benodigdPortlandCement);
            int benodigdMetselCement2 = (int) Math.ceil(benodigdMetselCement);
            int aantalStenen1 = (int) Math.ceil(aantalStenen2);
            double benodigdMetselzand2 = Math.ceil(benodigdMetselzand * 100) / 100;
            double benodigdVoegzand2 = Math.ceil(benodigdVoegzand * 100) / 100;
            //double oppervlakte1 = Math.ceil(oppervlakte * 100) / 100;


            //print the numbers to the screen

            metselzand.setText(Float.toString((float) benodigdMetselzand2));
            voegzand.setText(Float.toString((float) benodigdVoegzand2));
            portlandcement.setText(Integer.toString(benodigdPortlandcement2));
            metselcement.setText(Integer.toString(benodigdMetselCement2));
            stenen.setText(Integer.toString(aantalStenen1));
            oppervlakte2.setText(Float.toString((float) aantalM2F));

        } else {
            //float aantalstenen = (1000 / lengteSteenF) * (1000 / lagenmaatF) * aantalM2F;
            float oppervlakte = aantalStenenF / ((1000 / lagenmaatF) * (1000 / lengteSteenF));

            float benodigdMetselzand;
            if (stootvoegB.equals("ja")) {
                benodigdMetselzand = (float) (((lintvoeg + stootvoeg) * 1.1) * aantalStenenF);

            } else {
                benodigdMetselzand = (float) ((lintvoeg * 1.1) * aantalStenenF);
            }

            float benodigdMetselCement = (benodigdMetselzand * 250) / 25;
            float aantalStenen2 = (float) (aantalStenenF * 1.03);
            float benodigdVoegzand = 0;
            if (stootvoegB.equals("ja")) {
                benodigdVoegzand = (float) (((lintvoeg + stootvoeg) * 1.2) * aantalStenenF * 0.15);
            } else {
                benodigdVoegzand = (float) ((lintvoeg * 1.2) * aantalStenenF * 0.15);
            }
            float benodigdPortlandCement = (benodigdVoegzand * 250) / 25;

            //rounding the numbers

            int benodigdPortlandcement2 = (int) Math.ceil(benodigdPortlandCement);
            int benodigdMetselCement2 = (int) Math.ceil(benodigdMetselCement);
            int aantalStenenF2 = (int) ((int) aantalStenenF*1.03);
            int aantalStenenF3 = (int) Math.ceil(aantalStenenF2);
            double benodigdMetselzand2 = Math.ceil(benodigdMetselzand * 100) / 100;
            double benodigdVoegzand2 = Math.ceil(benodigdVoegzand * 100) / 100;
            double oppervlakte1 = Math.ceil(oppervlakte * 100) / 100;


            //print the numbers to the screen

            metselzand.setText(Float.toString((float) benodigdMetselzand2));
            voegzand.setText(Float.toString((float) benodigdVoegzand2));
            portlandcement.setText(Integer.toString(benodigdPortlandcement2));
            metselcement.setText(Integer.toString(benodigdMetselCement2));
            stenen.setText(Integer.toString(aantalStenenF3));
            oppervlakte2.setText(Float.toString((float) oppervlakte1));
        }


    }}