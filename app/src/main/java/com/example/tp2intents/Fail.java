package com.example.tp2intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fail extends AppCompatActivity {

    TextView resultat;
    Button sendmessage;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        resultat = findViewById(R.id.resultat);
        sendmessage = findViewById(R.id.message);

        Intent intent = getIntent();
        Float moy = intent.getFloatExtra("fail", 0);
        String Message= "Navré, vous n'avez pas réussi et votre moyenne est de : " + moy;
        resultat.setText(Message);
        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String numero = "28681523";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:" + numero));

                intent.putExtra("sms_body", Message);
                startActivity(intent);

            }
        });
    }
}