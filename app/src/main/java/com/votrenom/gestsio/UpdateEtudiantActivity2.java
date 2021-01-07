package com.votrenom.gestsio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

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

import static com.votrenom.gestsio.NewEtudiantActivity.EXTRA_REPLY_NEW;

public class UpdateEtudiantActivity2 extends AppCompatActivity{
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
    private Bundle bundle;

    private Etudiant etudiant;
    private String etudiantId;
    private ViewModel etudiantModel;


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

        final Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");


       /* bundle = etudiant;


        if (bundle != null) {
            etudiantId = bundle.getString("etudiant");
        }
        /*etudiantModel = ViewModelProviders.of(this).get(EtudiantViewModel.class);
        etudiant = etudiantModel.get(noteId);
        note.observe(this, new Observer<Etudiant>() {
            @Override
            public void onChanged(@Nullable Etudiant etudiant) {
                etNote.setText(note.getNote());
            }
        });*/


        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditNomView.getText())) {
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

                    //ajout pour sauvegarde

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

                     
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}

