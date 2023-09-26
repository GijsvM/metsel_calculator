package com.example.metselcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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
    public static final String SHARED_PREFS = "sharedPrefs";

    public static final String LENGTESTEEN = "lengtesteen";
    public static final String MUURDIKTE = "muurdikte";
    public static final String HOOGTESTEEN = "hoogtesteen";
    public static final String LAGENMAAT = "lagenmaat";
    public static final String AANTALM = "aantalm";
    public static final String AANTALSTENEN = "aantalstenen";
    public static final String METSELZAND = "metselzand";
    public static final String VOEGZAND = "voegzand";
    public static final String PORTLANDCEMENT = "portlandcement";
    public static final String METSELCEMENT = "metselcement";
    public static final String STENEN = "stenen";
    public static final String OPPERVLAKTE = "oppervlakte";
    public static final String STOOTVOEG = "stootvoeg";

    private String lengtesteen;
    private String muurdikte;
    private String hoogtesteen;
    private String lagenmaat;
    private String aantalm;
    private String aantalstenen;
    private String metselzandP;
    private String voegzandP;
    private String portlandcementP;
    private String metselcementP;
    private String stenenP;
    private String oppervlakteP;
    private String stootvoegP;

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

                //checken of alles in is gevuld

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
                saveData();

            }
        });


        loadData();
        updateViews();

    }


    public void saveData() {

        //slaat alle nummers op

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(LENGTESTEEN, lengteSteenInput.getText().toString());
        editor.putString(MUURDIKTE, muurdikteInput.getText().toString());
        editor.putString(HOOGTESTEEN, hoogteSteenInput.getText().toString());
        editor.putString(LAGENMAAT, lagenmaatInput.getText().toString());
        editor.putString(AANTALM, aantalMInput.getText().toString());
        editor.putString(AANTALSTENEN, aantalStenenInput.getText().toString());
        editor.putString(METSELCEMENT, metselcement.getText().toString());
        editor.putString(VOEGZAND, voegzand.getText().toString());
        editor.putString(PORTLANDCEMENT, portlandcement.getText().toString());
        editor.putString(METSELZAND, metselzand.getText().toString());
        editor.putString(STENEN, stenen.getText().toString());
        editor.putString(OPPERVLAKTE, oppervlakte2.getText().toString());
        editor.putString(STOOTVOEG, stootvoegInput.getText().toString());

        editor.apply();

    }

    public void loadData() {

        //zet alle opgeslagen nummers in een var
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        lengtesteen = sharedPreferences.getString(LENGTESTEEN, "");
        muurdikte = sharedPreferences.getString(MUURDIKTE, "");
        hoogtesteen = sharedPreferences.getString(HOOGTESTEEN, "");
        lagenmaat = sharedPreferences.getString(LAGENMAAT, "");
        aantalm = sharedPreferences.getString(AANTALM, "0");
        aantalstenen = sharedPreferences.getString(AANTALSTENEN, "0");
        metselcementP = sharedPreferences.getString(METSELCEMENT, "");
        voegzandP = sharedPreferences.getString(VOEGZAND, "");
        portlandcementP = sharedPreferences.getString(PORTLANDCEMENT, "");
        metselzandP = sharedPreferences.getString(METSELZAND, "");
        stenenP = sharedPreferences.getString(STENEN, "");
        oppervlakteP = sharedPreferences.getString(OPPERVLAKTE, "");
        stootvoegP = sharedPreferences.getString(STOOTVOEG, "");

    }
    public void updateViews() {

        //zet alle vars op het scherm
        lengteSteenInput.setText(lengtesteen);
        muurdikteInput.setText(muurdikte);
        hoogteSteenInput.setText(hoogtesteen);
        lagenmaatInput.setText(lagenmaat);
        aantalMInput.setText(aantalm);
        aantalStenenInput.setText(aantalstenen);
        metselcement.setText(metselcementP);
        voegzand.setText(voegzandP);
        portlandcement.setText(portlandcementP);
        metselzand.setText(metselzandP);
        stenen.setText(stenenP);
        oppervlakte2.setText(oppervlakteP);
        stootvoegInput.setText(stootvoegP);
    }

    public void calculate() {

        //alle berekeningen delen: / keer: * en + -
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

            //rond de nummers af

            int benodigdPortlandcement2 = (int) Math.ceil(benodigdPortlandCement);
            int benodigdMetselCement2 = (int) Math.ceil(benodigdMetselCement);
            int aantalStenenF2 = (int) ((int) aantalStenenF*1.03);
            int aantalStenenF3 = (int) Math.ceil(aantalStenenF2);
            double benodigdMetselzand2 = Math.ceil(benodigdMetselzand * 100) / 100;
            double benodigdVoegzand2 = Math.ceil(benodigdVoegzand * 100) / 100;
            double oppervlakte1 = Math.ceil(oppervlakte * 100) / 100;


            //print de nummers op het scherm

            metselzand.setText(Float.toString((float) benodigdMetselzand2));
            voegzand.setText(Float.toString((float) benodigdVoegzand2));
            portlandcement.setText(Integer.toString(benodigdPortlandcement2));
            metselcement.setText(Integer.toString(benodigdMetselCement2));
            stenen.setText(Integer.toString(aantalStenenF3));
            oppervlakte2.setText(Float.toString((float) oppervlakte1));
        }

}}
        