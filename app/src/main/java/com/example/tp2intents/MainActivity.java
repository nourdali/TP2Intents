package com.example.tp2intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText note1,note2,note3,coeff1,coeff2,coeff3;
    Button calcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note1 = findViewById(R.id.Note1);
        note2 = findViewById(R.id.Note2);
        note3 = findViewById(R.id.Note3);
        coeff1 = findViewById(R.id.Coeff1);
        coeff2 = findViewById(R.id.Coeff2);
        coeff3 = findViewById(R.id.Coeff3);
        calcul = findViewById(R.id.button);

        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input1=note1.getText().toString();
                String input2=note2.getText().toString();
                String input3=note3.getText().toString();
                String input4=coeff1.getText().toString();
                String input5=coeff2.getText().toString();
                String input6=coeff3.getText().toString();

                if(input1.equals("")||input2.equals("")||input3.equals("")||input4.equals("")||input5.equals("")||input6.equals("")){
                    Toast.makeText(MainActivity.this,"verifier votre remplire de champs",Toast.LENGTH_SHORT).show();
                }
                else{

                    Float notee1 = Float.parseFloat(note1.getText().toString());
                    Float notee2 = Float.parseFloat(note2.getText().toString());
                    Float notee3 = Float.parseFloat(note3.getText().toString());

                    int coef1 = Integer.parseInt(coeff1.getText().toString());
                    int coef2 = Integer.parseInt(coeff2.getText().toString());
                    int coef3 = Integer.parseInt(coeff3.getText().toString());

                    Float resultat =((notee1+coef1)+(notee2+coef2)+(notee3+coef3))/(coef1+coef2+coef3);
                    if (resultat >= 10){
                        Intent i =new Intent(MainActivity.this,Success.class);
                        i.putExtra("success",resultat);
                        startActivity(i);
                    }else if (resultat < 10){
                        Intent i =new Intent(MainActivity.this,Fail.class);
                        i.putExtra("fail",resultat);
                        startActivity(i);
                    }

                }

            }
        });
    }
}