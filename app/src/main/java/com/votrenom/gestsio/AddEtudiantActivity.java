package com.votrenom.gestsio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class AddEtudiantActivity extends AppCompatActivity {
    EditText editNom;
    EditText editPrenomEtudiant;
    EditText editDateDeNaissanceEtudiant;
    EditText editAdresseEtudiant;
    EditText editCodePostalEtudiant;
    EditText editVilleEtudiant;
    EditText editNuméroDeTéléphoneEtudiant;
    EditText editCourrielEtudiant;
    EditText editObservation;

    Button btnOk;
    int compteur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        // Obtention des références sur les composants
        editNom = (EditText)findViewById(R.id.nomEtudiant);
        editPrenomEtudiant = (EditText)findViewById(R.id.nomEtudiant);
        editDateDeNaissanceEtudiant = (EditText)findViewById(R.id.naissanceEtudiant);
        editAdresseEtudiant = (EditText)findViewById(R.id.adresseEtudiant);
        editCodePostalEtudiant = (EditText)findViewById(R.id.codePostalEtudiant);
        editVilleEtudiant = (EditText)findViewById(R.id.villeEtudiant);
        editNuméroDeTéléphoneEtudiant = (EditText)findViewById(R.id.numéroDeTéléphoneEtudiant);
        editCourrielEtudiant = (EditText)findViewById(R.id.courrielEtudiant);
        editObservation = (EditText)findViewById(R.id.observationsEtudiant);

        btnOk = (Button)findViewById(R.id.addEtudiantBtnOk);

        if (savedInstanceState!=null) {
            compteur = savedInstanceState.getInt("compteur");
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("compteur", compteur);


    }
}