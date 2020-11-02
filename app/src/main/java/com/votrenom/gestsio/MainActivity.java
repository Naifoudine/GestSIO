package com.votrenom.gestsio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int compteur;
    private EtudiantViewModel mEtudiantViewModel;


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
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("compteur", compteur);
    }
}