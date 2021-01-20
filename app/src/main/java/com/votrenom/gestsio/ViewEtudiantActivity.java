package com.votrenom.gestsio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.votrenom.gestsio.MainActivity.DELETE_ETUDIANT_ACTIVITY_REQUEST_CODE;
import static com.votrenom.gestsio.MainActivity.UPDATE_ETUDIANT_ACTIVITY_REQUEST_CODE;

public class ViewEtudiantActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_DELETE = "com.votrenom.gestsio.etudiant";
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";
    public static final String EXTRA_DATA_UPDATE_ETUDIANT = "extra_etudiant_to_be_updated";
    public static final int TEXT_REQUEST = 6;
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
    private Context mContext;
    private List<Etudiant> mEtudiants;
    private EtudiantViewModel mEtudiantViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_etudiant);

        // Obtention des références sur les composants
        txtNomEtudiant = findViewById(R.id.nomEtudiant);

        //txtNomEtudiant.setText("DUPOND");

        txtPrenomEtudiant = findViewById(R.id.prenomEtudiant);
        txtDateDeNaissanceEtudiant = findViewById(R.id.naissanceEtudiant);
        txtOptionEtudiant = findViewById(R.id.optionEtudiant);
        txtAdresseEtudiant = findViewById(R.id.adresseEtudiant);
        txtCodePostalEtudiant = findViewById(R.id.codePostalEtudiant);
        txtVilleEtudiant = findViewById(R.id.villeEtudiant);
        txtNuméroDeTéléphoneEtudiant = findViewById(R.id.numéroDeTéléphoneEtudiant);
        txtCourrielEtudiant = findViewById(R.id.courrielEtudiant);
        txtObservation = findViewById(R.id.observationsEtudiant);

        final Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");


        loadEtudiant(etudiant);

        // Setup the EtudiantViewModel
        //mEtudiantViewModel = ViewModelProviders.of(this).get(EtudiantViewModel.class);

        final Button buttonEdit = findViewById(R.id.button_edit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchUpdateEtudiantActivity(etudiant);
            }
        });

        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AlertDialog.Builder builder = new AlertDialog.Builder(ViewEtudiantActivity.this);
                builder.setTitle("Etes-vous sûr ?");
                builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent replyIntent = new Intent();
                       // Etudiant etudiant = mEtu;

                        replyIntent.putExtra(EXTRA_REPLY_DELETE, etudiant);
                        setResult(RESULT_OK, replyIntent);
                        /*Intent intent = new Intent(ViewEtudiantActivity.this, MainActivity.class);*/
                        //startActivityForResult(replyIntent, DELETE_ETUDIANT_ACTIVITY_REQUEST_CODE);


                        //mEtudiantViewModel.deleteEtudiant(etudiant);
                        //deleteEtudiant(etudiant);
                        if (1 + 1 != 2){
                            setResult(RESULT_CANCELED, replyIntent);
                        }else {sendDeleteEtudiantIntent(etudiant);}
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
        txtPrenomEtudiant.setText(etudiant.getPrenomEtudiant());
        txtDateDeNaissanceEtudiant.setText(etudiant.getNaissanceEtudiant());
        txtOptionEtudiant.setText(etudiant.getOptionEtudiant());
        txtAdresseEtudiant.setText(etudiant.getAdresseEtudiant());
        txtCodePostalEtudiant.setText(etudiant.getCodePostalEtudiant());
        txtVilleEtudiant.setText(etudiant.getVilleEtudiant());
        txtNuméroDeTéléphoneEtudiant.setText(etudiant.getPhoneEtudiant());
        txtCourrielEtudiant.setText(etudiant.getCourrielEtudiant());
        txtObservation.setText(etudiant.getObservationsEtudiant());
    }
    public void launchUpdateEtudiantActivity( Etudiant etudiant) {
        /*Intent intent = new Intent(this, UpdateEtudiantActivity2.class);
        intent.putExtra(EXTRA_DATA_UPDATE_ETUDIANT, etudiant);
        //intent.putExtra(EXTRA_DATA_ID, word.getId());
        startActivityForResult(intent, UPDATE_ETUDIANT_ACTIVITY_REQUEST_CODE);*/

        Intent intent = new Intent(ViewEtudiantActivity.this, UpdateEtudiantActivity.class);
        intent.putExtra("etudiant", etudiant);
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();

    }

    public void sendDeleteEtudiantIntent( Etudiant etudiant) {
        /*Intent intent = new Intent(this, UpdateEtudiantActivity2.class);
        intent.putExtra(EXTRA_DATA_UPDATE_ETUDIANT, etudiant);
        //intent.putExtra(EXTRA_DATA_ID, word.getId());
        startActivityForResult(intent, UPDATE_ETUDIANT_ACTIVITY_REQUEST_CODE);*/

        /*Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("etudiant", etudiant);
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();*/

        Intent replyIntent = new Intent(getApplicationContext(), MainActivity.class);
        replyIntent.putExtra(EXTRA_REPLY_DELETE, etudiant);
        setResult(RESULT_OK, replyIntent);
        startActivityForResult(replyIntent, MainActivity.DELETE_ETUDIANT_ACTIVITY_REQUEST_CODE);
        //finish();
    }

    /*private void deleteEtudiant(final Etudiant etudiant) {
        class DeleteEtudiant extends AsyncTask<Void, Void, Void> {

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

        DeleteEtudiant dt = new DeleteEtudiant();
        dt.execute();

    }*/


    /*@Override
    protected void onResume() {
        super.onResume();


    }*/

}