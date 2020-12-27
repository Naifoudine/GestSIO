package com.votrenom.gestsio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewEtudiantActivity extends AppCompatActivity {

    private EditText mEditNomView;
    private EditText mEditPrenomView;
    private EditText mEditNaissanceView;
    private EditText mEditOptionView;
    private EditText mEditAdresseView;
    private EditText mEditCodePostalView;
    private EditText mEditVilleView;
    private EditText mEditPhoneView;
    private EditText mEditCourrielView;
    private EditText mEditObservationsView;
    private Etudiant etudiant;
    public static final String EXTRA_REPLY_NEW = "com.votrenom.gestsio.etudiant";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_etudiant);
        mEditNomView = findViewById(R.id.edit_nom);
        mEditPrenomView = findViewById(R.id.edit_prenom);
        mEditNaissanceView = findViewById(R.id.edit_naissanceEtudiant);
        mEditOptionView = findViewById(R.id.edit_optionEtudiant);
        mEditAdresseView = findViewById(R.id.edit_adresseEtudiant);
        mEditCodePostalView = findViewById(R.id.edit_codePostalEtudiant);
        mEditVilleView= findViewById(R.id.edit_villeEtudiant);
        mEditPhoneView = findViewById(R.id.edit_numéroDeTéléphoneEtudiant);
        mEditCourrielView = findViewById(R.id.edit_courrielEtudiant);
        mEditObservationsView = findViewById(R.id.edit_observationsEtudiant);



        final Button button = findViewById(R.id.button_save);
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
                    String observationsEtudiant = mEditObservationsView.getText().toString();

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
                    replyIntent.putExtra(EXTRA_REPLY_NEW, etudiant);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}