package com.votrenom.gestsio;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EtudiantViewModel extends AndroidViewModel {

    //membre privé afin de garder une référence du Répository
    private EtudiantRepository mRepository;

    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<Etudiant>> mAllEtudiants;

    /**
     * Contructeur qui a une référence de EtudiantRepository et récupère la liste des étudiants
     * @param application
     */
    public EtudiantViewModel(Application application) {
        super(application);
        mRepository = new EtudiantRepository(application);
        mAllEtudiants = mRepository.getAllEtudiants();
    }

    /**
     * getter qui renvoie les étudiants
     * @return
     */
    LiveData<List<Etudiant>> getAllEtudiants() {
        return mAllEtudiants;
    }

    /**
     * Méthode wrapper qui appelle la méthode insert du Repository de cette façon la méthode insert est caché de l'UI.
     * @param etudiant
     */
    void insert(Etudiant etudiant) {
        mRepository.insert(etudiant);
    }

    /*          TP5         */

    /**
     * Pour rendre la méthode deleteEtudiant() disponible pour d'autres classes de l'application,
     * en particulier MainActivity
     * @param etudiant
     */
    public void deleteEtudiant(Etudiant etudiant) {
        mRepository.deleteEtudiant(etudiant);

    }

    public void updateEtudiant(Etudiant etudiant) {
        mRepository.updateEtudiant(etudiant);
    }
    /*          FIN TP5         */

}