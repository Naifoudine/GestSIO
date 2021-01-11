package com.votrenom.gestsio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int compteur;
    private EtudiantViewModel mEtudiantViewModel;
    public static final int NEW_ETUDIANT_ACTIVITY_REQUEST_CODE = 1;
    public static final int UPDATE_ETUDIANT_ACTIVITY_REQUEST_CODE = 2;
    public static final int DELETE_ETUDIANT_ACTIVITY_REQUEST_CODE =3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final EtudiantListAdapter adapter = new EtudiantListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mEtudiantViewModel = new ViewModelProvider(this).get(EtudiantViewModel.class);

        mEtudiantViewModel.getAllEtudiants().observe(this, new Observer<List<Etudiant>>() {
            @Override
            public void onChanged(@Nullable final List<Etudiant> etudiants) {
                // Update the cached copy of the words in the adapter.
                adapter.setEtudiants(etudiants);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewEtudiantActivity.class);
                startActivityForResult(intent, NEW_ETUDIANT_ACTIVITY_REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("compteur", compteur);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_ETUDIANT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Etudiant etudiant = (Etudiant) data.getExtras().getSerializable(NewEtudiantActivity.EXTRA_REPLY_NEW);
            mEtudiantViewModel.insert(etudiant);
            Toast.makeText(
                    getApplicationContext(),
                    R.string.saved,
                    Toast.LENGTH_LONG).show();


        } else if (requestCode == UPDATE_ETUDIANT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            //Etudiant etudiant = (Etudiant) data.getExtras().getSerializable(UpdateEtudiantActivity.EXTRA_REPLY_UPDATE);
            Etudiant etudiant = (Etudiant) data.getExtras().getSerializable(UpdateEtudiantActivity2.EXTRA_REPLY_UPDATE);
            mEtudiantViewModel.updateEtudiant(etudiant);
            Toast.makeText(
                    getApplicationContext(),
                    R.string.updated,
                    Toast.LENGTH_LONG).show();


        } /*else if (requestCode == DELETE_ETUDIANT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            //Etudiant etudiant = (Etudiant) data.getExtras().getSerializable(ViewEtudiantActivity.EXTRA_REPLY_DELETE);
            Etudiant etudiant = (Etudiant) data.getExtras().getSerializable(ViewEtudiantActivity.EXTRA_REPLY_DELETE);
            mEtudiantViewModel.deleteEtudiant(etudiant);
            Toast.makeText(
                    getApplicationContext(),
                    R.string.deleted,
                    Toast.LENGTH_LONG).show();
        }*/
        else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}