package com.votrenom.gestsio;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * declaration de la base de données Room avec la liste des entités et la version.
 */

@Database(entities = {Etudiant.class}, version = 1, exportSchema = false)
public abstract class EtudiantRoomDatabase extends RoomDatabase {

    /**
     * Définition du Dao qui sera utilisé avec la base.
     */
    public abstract EtudiantDao etudiantDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile  EtudiantRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    /**
     * création de la base de données Room comme étant un singleton
     * singleton : patron de conception (design pattern) dont l'objectif est de restreindre
     * l'instanciation d'une classe à un seul objet (ou bien à quelques objets seulement).
     * voir : https://fr.wikipedia.org/wiki/Singleton_(patron_de_conception)
     */

    static EtudiantRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EtudiantRoomDatabase.class) {
                if (INSTANCE == null) {
                    /**
                     * Création de la base de données nommée etudiant_database en utilisant Room.
                     */
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EtudiantRoomDatabase.class, "etudiant_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 12.1. Creation du callback pour le remplissage de la base
     */
    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        //public void onOpen(@NonNull SupportSQLiteDatabase db) {
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                EtudiantDao dao = INSTANCE.etudiantDao();

                //Décommentez la ligne ci dessous si vous souhaitez supprimer le contenu de la base à chaque lancement.
                //dao.deleteAll();

                //permet d'insérer un étudiant en exemple :
                Etudiant etudiant = new Etudiant();
                etudiant.setNomEtudiant("MOHAMMED");
                etudiant.setPrenomEtudiant("Ali");
                dao.insert(etudiant);

            });
        }
    };
}