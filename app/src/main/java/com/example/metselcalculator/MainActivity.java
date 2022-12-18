package com.example.metselcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float lengteSteenF;
    float muurdikteF;
    float hoogteSteenF;
    float lagenmaatF;
    String stootvoegB;
    float aantalM2F;
    float aantalStenenF;

    private TextView lengteSteenInput;
    private TextView muurdikteInput;
    private TextView hoogteSteenInput;
    private TextView lagenmaatInput;
    private TextView stootvoegInput;
    private TextView aantalMInput;
    private TextView aantalStenenInput;
    private TextView metselzand;
    private TextView voegzand;
    private TextView portlandcement;
    private TextView metselcement;
    private TextView stenen;
    private TextView oppervlakte2;


    Button berekenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lengteSteenInput = (EditText) findViewById(R.id.lengteSteenInput);
        muurdikteInput = (EditText) findViewById(R.id.muurdikteInput);
        hoogteSteenInput = (EditText) findViewById(R.id.hoogteSteenInput);
        lagenmaatInput = (EditText) findViewById(R.id.lagenmaatInput);
        stootvoegInput = (EditText) findViewById(R.id.stootvoegInput);
        aantalMInput = (EditText) findViewById(R.id.aantalMInput);
        aantalStenenInput = (EditText) findViewById(R.id.aantalStenenInput);

        metselzand = findViewById(R.id.metselzand);
        voegzand = findViewById(R.id.voegzand);
        portlandcement = findViewById(R.id.portlandcement);
        metselcement = findViewById(R.id.metselcement);
        stenen = findViewById(R.id.stenen);
        oppervlakte2 = findViewById(R.id.oppervlakte2);

        berekenButton = (Button) findViewById(R.id.berekenButton);
        berekenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(lengteSteenInput.getText().toString())){
                    lengteSteenInput.setError("vul aub alles in");
                    return;
                }
                if (TextUtils.isEmpty(muurdikteInput.getText().toString())){
                    muurdikteInput.setError("vul aub alles in");
                    return;
                }
                if (TextUtils.isEmpty(hoogteSteenInput.getText().toString())){
                    hoogteSteenInput.setError("vul aub alles in");
                    return;
                }
                if (TextUtils.isEmpty(lagenmaatInput.getText().toString())){
                    lagenmaatInput.setError("vul aub alles in");
                    return;
                }

                if (TextUtils.isEmpty(aantalMInput.getText().toString())){
                    aantalMInput.setError("vul aub een 0 in");
                    return;
                }
                if (TextUtils.isEmpty(aantalStenenInput.getText().toString())){
                    aantalStenenInput.setError("vul aub een 0 in");
                    return;
                }
                if (TextUtils.isEmpty(stootvoegInput.getText().toString())){
                    stootvoegInput.setError("vul ja of nee in");
                    return;
                }


                if (lengteSteenInput.getText().toString().contains(",")){
                    lengteSteenInput.setError("verander de , in een .");
                    return;
                }
                if (muurdikteInput.getText().toString().contains(",")){
                    muurdikteInput.setError("verander de , in een .");
                    return;
                }
                if (hoogteSteenInput.getText().toString().contains(",")){
                    hoogteSteenInput.setError("verander de , in een .");
                    return;
                }
                if (lagenmaatInput.getText().toString().contains(",")){
                    lagenmaatInput.setError("verander de , in een .");
                    return;
                }
                if (aantalMInput.getText().toString().contains(",")){
                    aantalMInput.setError("verander de , in een .");
                    return;
                }
                if (aantalStenenInput.getText().toString().contains(",")){
                    aantalStenenInput.setError("verander de , in een .");
                    return;
                }


                calculate();
            }

            public void calculate() {
                lengteSteenInput = (EditText) findViewById(R.id.lengteSteenInput);
                muurdikteInput = (EditText) findViewById(R.id.muurdikteInput);
                hoogteSteenInput = (EditText) findViewById(R.id.hoogteSteenInput);
                lagenmaatInput = (EditText) findViewById(R.id.lagenmaatInput);
                stootvoegInput = (EditText) findViewById(R.id.stootvoegInput);
                aantalMInput = (EditText) findViewById(R.id.aantalMInput);
                aantalStenenInput = (EditText) findViewById(R.id.aantalStenenInput);

                float lengteSteenF = Float.parseFloat(lengteSteenInput.getText().toString());
                float muurdikteF =  Float.parseFloat(muurdikteInput.getText().toString());
                float hoogteSteenF =  Float.parseFloat(hoogteSteenInput.getText().toString());
                float lagenmaatF =  Float.parseFloat(lagenmaatInput.getText().toString());
                float aantalM2F =  Float.parseFloat(aantalMInput.getText().toString());
                String stootvoegB = stootvoegInput.getText().toString();
                float aantalStenenF = Float.parseFloat(aantalStenenInput.getText().toString());

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
            }
        });
        }}
        