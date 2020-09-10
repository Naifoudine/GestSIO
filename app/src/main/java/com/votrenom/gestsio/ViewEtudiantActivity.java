package com.votrenom.gestsio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewEtudiantActivity extends AppCompatActivity {

    private TextView txtNomEtudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_etudiant);

        // Obtention des références sur les composants
        txtNomEtudiant = (TextView)findViewById(R.id.nomEtudiant);

        //txtNomEtudiant.setText("DUPOND");


    }
    @Override
    protected void onResume() {
        super.onResume();

        txtNomEtudiant.setText("DURAND");

    }

}