package com.votrenom.gestsio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "table_etudiant")
public class Etudiant implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long mIdEtudiant;


    @ColumnInfo(name = "nomEtudiant")
    private String mNomEtudiant;

    @ColumnInfo(name = "prenomEtudiant")
    private String mPrenomEtudiant;

    @ColumnInfo(name = "naissanceEtudiant")
    private String mNaissanceEtudiant;

    @ColumnInfo(name = "optionEtudiant")
    private String mOptionEtudiant;

    @ColumnInfo(name = "adresseEtudiant")
    private String mAdresseEtudiant;

    @ColumnInfo(name = "codePostalEtudiant")
    private String mCodePostalEtudiant;

    @ColumnInfo(name = "villeEtudiant")
    private String mVilleEtudiant;

    @ColumnInfo(name = "phoneEtudiant")
    private String mPhoneEtudiant;

    @ColumnInfo(name = "courrielEtudiant")
    private String mCourrielEtudiant;

    @ColumnInfo(name = "observationsEtudiant")
    private String mObservationsEtudiant;


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

    public String getNaissanceEtudiant(){return this.mNaissanceEtudiant;}

    public void setNaissanceEtudiant(String naissanceEtudiant) {
        this.mNaissanceEtudiant = naissanceEtudiant;
    }

    public String getOptionEtudiant(){return this.mOptionEtudiant;}

    public void setOptionEtudiant(String optionEtudiant) {
        this.mOptionEtudiant = optionEtudiant;
    }

    public String getAdresseEtudiant(){return this.mAdresseEtudiant;}

    public void setAdresseEtudiant(String adresseEtudiant) {
        this.mAdresseEtudiant = adresseEtudiant;
    }

    public String getCodePostalEtudiant(){return this.mCodePostalEtudiant;}

    public void setCodePostalEtudiant(String codePostalEtudiant) {
        this.mCodePostalEtudiant = codePostalEtudiant;
    }

    public String getVilleEtudiant(){return this.mVilleEtudiant;}

    public void setVilleEtudiant(String villeEtudiant) {
        this.mVilleEtudiant = villeEtudiant;
    }

    public String getPhoneEtudiant(){return this.mPhoneEtudiant;}

    public void setPhoneEtudiant(String phoneEtudiant) {
        this.mPhoneEtudiant = phoneEtudiant;
    }

    public String getCourrielEtudiant(){return this.mCourrielEtudiant;}

    public void setCourrielEtudiant(String courrielEtudiant) {
        this.mCourrielEtudiant = courrielEtudiant;
    }

    public String getObservationsEtudiant(){return this.mObservationsEtudiant;}

    public void setObservationsEtudiant(String observationsEtudiant) {
        this.mObservationsEtudiant = observationsEtudiant;
    }


}


