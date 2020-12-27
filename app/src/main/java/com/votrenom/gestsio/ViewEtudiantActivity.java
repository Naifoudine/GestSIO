package com.votrenom.gestsio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewEtudiantActivity extends AppCompatActivity {

    private TextView txtNomEtudiant;
    private TextView txtPrenomEtudiant;
    private TextView txtDateDeNaissanceEtudiant;
    private TextView txtOptionEtudiant;
    private TextView txtAdresseEtudiant;
    private TextView txtCodePostalEtudiant;
    private TextView txtVilleEtudiant;
    private TextView txtNuméroDeTéléphoneEtudiant;
    private TextView txtCourrielEtudiant;
    private TextView txtObservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_etudiant);

        // Obtention des références sur les composants
        txtNomEtudiant = (TextView)findViewById(R.id.nomEtudiant);

        //txtNomEtudiant.setText("DUPOND");

        txtPrenomEtudiant = (TextView)findViewById(R.id.prenomEtudiant);
        txtDateDeNaissanceEtudiant = (TextView)findViewById(R.id.naissanceEtudiant);
        txtOptionEtudiant = (TextView)findViewById(R.id.optionEtudiant);
        txtAdresseEtudiant = (TextView)findViewById(R.id.adresseEtudiant);
        txtCodePostalEtudiant = (TextView)findViewById(R.id.codePostalEtudiant);
        txtVilleEtudiant = (TextView)findViewById(R.id.villeEtudiant);
        txtNuméroDeTéléphoneEtudiant = (TextView)findViewById(R.id.numéroDeTéléphoneEtudiant);
        txtCourrielEtudiant = (TextView)findViewById(R.id.courrielEtudiant);
        txtObservation = (TextView)findViewById(R.id.observationsEtudiant);

        final Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");

        loadEtudiant(etudiant);

        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ViewEtudiantActivity.this);
                builder.setTitle("Etes-vous sûr ?");
                builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteEtudiant(etudiant);
                    }
                });
                builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();
            }
        });

    }

    private void loadEtudiant(Etudiant etudiant){
        txtNomEtudiant.setText(etudiant.getNomEtudiant());
        txtPrenomEtudiant.setText(etudiant.getNomEtudiant());
        txtDateDeNaissanceEtudiant.setText(etudiant.getNaissanceEtudiant());
        txtOptionEtudiant.setText(etudiant.getOptionEtudiant());
        txtAdresseEtudiant.setText(etudiant.getAdresseEtudiant());
        txtCodePostalEtudiant.setText(etudiant.getCodePostalEtudiant());
        txtVilleEtudiant.setText(etudiant.getVilleEtudiant());
        txtNuméroDeTéléphoneEtudiant.setText(etudiant.getPhoneEtudiant());
        txtCourrielEtudiant.setText(etudiant.getCourrielEtudiant());
        txtObservation.setText(etudiant.getObservationsEtudiant());
    }

    private void deleteEtudiant(final Etudiant etudiant) {
        class DeleteTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                EtudiantRoomDatabase.getDatabase(getApplicationContext())
                        .etudiantDao()
                        .delete(etudiant);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Etudiant supprimé", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(ViewEtudiantActivity.this, MainActivity.class));
            }
        }

        DeleteTask dt = new DeleteTask();
        dt.execute();

    }


    @Override
    protected void onResume() {
        super.onResume();


    }

}