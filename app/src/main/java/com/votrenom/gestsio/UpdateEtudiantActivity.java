 package com.votrenom.gestsio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


 public class UpdateEtudiantActivity extends AppCompatActivity {

     private EditText mEditNomView;
     private EditText mEditPrenomView;
     private EditText mEditNaissanceView;
     private EditText mEditOptionView;
     private EditText mEditAdresseView;
     private EditText mEditCodePostalView;
     private EditText mEditVilleView;
     private EditText mEditPhoneView;
     private EditText mEditCourrielView;
     private EditText mEditObservationsViews;
     private Etudiant etudiant;
     private Bundle bundle;
     public static final String EXTRA_REPLY_UPDATE = "com.votrenom.gestsio.etudiant";




     private Context mContext;
     private List<Etudiant> mEtudiants;
     private Object aVoid;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_etudiant);


        // Obtention des références sur les composants
        mEditNomView = findViewById(R.id.edit_nom);

        //editNomEtudiant.setText("DUPOND");

        mEditPrenomView = findViewById(R.id.edit_prenom);
        mEditNaissanceView = findViewById(R.id.edit_naissanceEtudiant);
        mEditOptionView = findViewById(R.id.edit_optionEtudiant);
        mEditAdresseView = findViewById(R.id.edit_adresseEtudiant);
        mEditCodePostalView = findViewById(R.id.edit_codePostalEtudiant);
        mEditVilleView = findViewById(R.id.edit_villeEtudiant);
        mEditPhoneView = findViewById(R.id.edit_numéroDeTéléphoneEtudiant);
        mEditCourrielView = findViewById(R.id.edit_courrielEtudiant);
        mEditObservationsViews = findViewById(R.id.edit_observationsEtudiant);

        final Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");

        loadEtudiant(etudiant);

         /*bundle = getIntent().getExtras();

         if (bundle != null) {
             final Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");
         }

         noteModel = ViewModelProviders.of(this).get(EditNoteViewModel.class);
         note = noteModel.getNote(noteId);
         note.observe(this, new Observer<Note>() {
             @Override
             public void onChanged(@Nullable Note note) {
                 etNote.setText(note.getNote());
             }
         });
     }*/



         //final Button button = findViewById(R.id.button_save);
         findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
                 updateEtudiant(etudiant);
                /* Intent intent = new Intent();
                 ((Activity) mContext).startActivityForResult(intent,MainActivity.UPDATE_ETUDIANT_ACTIVITY_REQUEST_CODE);*/
             finish();
             }
         });

        /*Bundle bundle = getIntent().getExtras();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if ((TextUtils.isEmpty(mEditNomView.getText()) )
                        || (TextUtils.isEmpty(mEditPrenomView.getText())) || (TextUtils.isEmpty(mEditNaissanceView.getText()))) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String nomEtudiant = mEditNomView.getText().toString();
                    String prenomEtudiant = mEditPrenomView.getText().toString();
                    String naissanceEtudiant = mEditNaissanceView.getText().toString();
                    String adresseEtudiant = mEditAdresseView.getText().toString();
                    String optionEtudiant = mEditOptionView.getText().toString();
                    String codePostalEtudiant = mEditCodePostalView.getText().toString();
                    String villeEtudiant = mEditVilleView.getText().toString();
                    String phoneEtudiant = mEditPhoneView.getText().toString();
                    String courrielEtudiant = mEditCourrielView.getText().toString();
                    String observationsEtudiant = mmEditObservationsViewsView.getText().toString();

                    /**
                     * TP5 : Nous allons ensuite supprimer les lignes
                     * qui permettaient de sauvegarder l’étudiant dans la base de données,
                     * supprimez les lignes suivantes :

                     //ajout pour sauvegarde
                     EtudiantRoomDatabase.databaseWriteExecutor.execute(() -> {
                     // Populate the database in the background.
                     // If you want to start with more words, just add them.
                     Etudiant etudiant = new Etudiant();
                     etudiant.setNomEtudiant(nomEtudiant);
                     etudiant.setPrenomEtudiant(prenomEtudiant);
                     etudiant.setNaissanceEtudiant(naissanceEtudiant);
                     etudiant.setOptionEtudiant(optionEtudiant);
                     etudiant.setAdresseEtudiant(adresseEtudiant);
                     etudiant.setCodePostalEtudiant(codePostalEtudiant);
                     etudiant.setVilleEtudiant(villeEtudiant);
                     etudiant.setPhoneEtudiant(phoneEtudiant);
                     etudiant.setCourrielEtudiant(courrielEtudiant);
                     etudiant.setObservationsEtudiant(observationsEtudiant);

                     EtudiantRoomDatabase.getDatabase(getApplicationContext())
                     .etudiantDao()
                     .insert(etudiant);
                     });*/
                   /* replyIntent.putExtra(EXTRA_REPLY_NEW, etudiant);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });*/

    }

     private void loadEtudiant(Etudiant etudiant) {
         mEditNomView.setText(etudiant.getNomEtudiant());
         mEditPrenomView.setText(etudiant.getPrenomEtudiant());
         mEditNaissanceView.setText(etudiant.getNaissanceEtudiant());
         mEditOptionView.setText(etudiant.getOptionEtudiant());
         mEditAdresseView.setText(etudiant.getAdresseEtudiant());
         mEditCodePostalView.setText(etudiant.getCodePostalEtudiant());
         mEditVilleView.setText(etudiant.getVilleEtudiant());
         mEditPhoneView.setText(etudiant.getPhoneEtudiant());
         mEditCourrielView.setText(etudiant.getCourrielEtudiant());
         mEditObservationsViews.setText(etudiant.getObservationsEtudiant());
     }

     private void updateEtudiant(final Etudiant etudiant) {
         final String nomEtudiant = mEditNomView.getText().toString().trim();
         final String prenomEtudiant= mEditPrenomView.getText().toString().trim();
         final String naissanceEtudiant = mEditNaissanceView.getText().toString().trim();
         final String adresseEtudiant = mEditOptionView.getText().toString().trim();
         final String optionEtudiant = mEditAdresseView.getText().toString().trim();
         final String codePostalEtudiant = mEditCodePostalView.getText().toString().trim();
         final String villeEtudiant = mEditVilleView.getText().toString().trim();
         final String phoneEtudiant = mEditPhoneView.getText().toString().trim();
         final String courrielEtudiant = mEditCourrielView.getText().toString().trim();
         final String observationsEtudiant = mEditObservationsViews.getText().toString().trim();

     class updateEtudiant extends AsyncTask<Void, Void, Void> {

         @Override
         protected Void doInBackground(Void... voids) {
             etudiant.setNomEtudiant(nomEtudiant);
             etudiant.setPrenomEtudiant(prenomEtudiant);
             etudiant.setNaissanceEtudiant(naissanceEtudiant);
             etudiant.setOptionEtudiant(optionEtudiant);
             etudiant.setAdresseEtudiant(adresseEtudiant);
             etudiant.setCodePostalEtudiant(codePostalEtudiant);
             etudiant.setVilleEtudiant(villeEtudiant);
             etudiant.setPhoneEtudiant(phoneEtudiant);
             etudiant.setCourrielEtudiant(courrielEtudiant);
             etudiant.setObservationsEtudiant(observationsEtudiant);
             EtudiantRoomDatabase.getDatabase(getApplicationContext())
                     .etudiantDao()
                     .update(etudiant);
             return null;
         }
         }


        /* @Override
         protected void onPostExecute(Void aVoid) {
             super.onPostExecute(aVoid);
             Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
             finish();
             startActivity(new Intent(UpdateEtudiantActivity.this, MainActivity.class));
         }*/


     updateEtudiant ut = new updateEtudiant();
        ut.execute();
 }

 }