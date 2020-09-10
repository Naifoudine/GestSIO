package com.votrenom.gestsio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewEtudiantActivity extends AppCompatActivity {

    private TextView txtNomEtudiant;
    private TextView txtPrenomEtudiant;
    private TextView txtDateDeNaissanceEtudiant;
    private TextView txtAdresseEtudiant;
    private TextView txtCodePostalEtudiant;
    private TextView txtVilleEtudiant;
    private TextView txtNuméroDeTéléphoneEtudiant;
    private TextView txtCourrielEtudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_etudiant);

        // Obtention des références sur les composants
        txtNomEtudiant = (TextView)findViewById(R.id.nomEtudiant);

        //txtNomEtudiant.setText("DUPOND");

        txtPrenomEtudiant = (TextView)findViewById(R.id.prenomEtudiant);
        txtDateDeNaissanceEtudiant = (TextView)findViewById(R.id.dateDeNaissanceEtudiant);
        txtAdresseEtudiant = (TextView)findViewById(R.id.adresseEtudiant);
        txtCodePostalEtudiant = (TextView)findViewById(R.id.codePostalEtudiant);
        txtVilleEtudiant = (TextView)findViewById(R.id.villeEtudiant);
        txtNuméroDeTéléphoneEtudiant = (TextView)findViewById(R.id.numéroDeTéléphoneEtudiant);
        txtCourrielEtudiant = (TextView)findViewById(R.id.courrielEtudiant);




    }
    @Override
    protected void onResume() {
        super.onResume();

        txtNomEtudiant.setText("DURAND");
        txtPrenomEtudiant.setText("Francois");
        txtDateDeNaissanceEtudiant.setText("05/05/2005");
        txtAdresseEtudiant.setText("Av. des Champs-Élysées");
        txtCodePostalEtudiant.setText("75000");
        txtVilleEtudiant.setText("Paris");
        txtNuméroDeTéléphoneEtudiant.setText("+33 1 23 45 67 89");
        txtCourrielEtudiant.setText("DURANDdeLutèce@gmail.com");

    }

}