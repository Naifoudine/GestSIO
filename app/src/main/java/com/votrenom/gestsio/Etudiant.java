package com.votrenom.gestsio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "table_etudiant")
public class Etudiant {

    @PrimaryKey(autoGenerate = true)
    private Long mIdEtudiant;


    @ColumnInfo(name = "nomEtudiant")
    private String mNomEtudiant;

    @ColumnInfo(name = "prenomEtudiant")
    private String mPrenomEtudiant;



    public Long getIdEtudiant(){
        return this.mIdEtudiant;
    }

    public void setIdEtudiant(Long mIdEtudiant) {
        this.mIdEtudiant = mIdEtudiant;
    }


    public String getNomEtudiant(){
        return this.mNomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.mNomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant(){return this.mPrenomEtudiant;}

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.mPrenomEtudiant = prenomEtudiant;
    }
}


