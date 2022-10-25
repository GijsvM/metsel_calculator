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

    TextView lengteSteenInput;
    TextView muurdikteInput;
    TextView hoogteSteenInput;
    TextView lagenmaatInput;
    TextView stootvoegInput;
    TextView aantalMInput;
    TextView aantalStenenInput;


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


                openMainActivity2();
            }

            public void openMainActivity2() {
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

                Intent intent = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    intent = new Intent(MainActivity.this, MainActivity2.class);
                }
                intent.putExtra("lengtesteen", lengteSteenF);
                intent.putExtra("muurdikte", muurdikteF);
                intent.putExtra("hoogtesteen", hoogteSteenF);
                intent.putExtra("lagenmaat",lagenmaatF);
                intent.putExtra("aantalm2", aantalM2F);
                intent.putExtra("stootvoeg", stootvoegB);
                intent.putExtra("aantalStenen", aantalStenenF);

                startActivity(intent);
            }
        });
        }}
        