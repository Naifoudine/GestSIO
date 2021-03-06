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
    private Etudiant etudiant;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_etudiant);
        mEditNomView = findViewById(R.id.edit_nom);
        mEditPrenomView = findViewById(R.id.edit_prenom);


        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditNomView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String nomEtudiant = mEditNomView.getText().toString();
                    String prenomEtudiant = mEditPrenomView.getText().toString();

                    //ajout pour sauvegarde
                    EtudiantRoomDatabase.databaseWriteExecutor.execute(() -> {
                        // Populate the database in the background.
                        // If you want to start with more words, just add them.
                        Etudiant etudiant = new Etudiant();
                        etudiant.setNomEtudiant(nomEtudiant);
                        etudiant.setPrenomEtudiant(prenomEtudiant);

                        EtudiantRoomDatabase.getDatabase(getApplicationContext())
                                .etudiantDao()
                                .insert(etudiant);
                    });
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}