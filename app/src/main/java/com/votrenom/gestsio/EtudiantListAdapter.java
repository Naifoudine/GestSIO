package com.votrenom.gestsio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EtudiantListAdapter extends RecyclerView.Adapter<EtudiantListAdapter.EtudiantViewHolder> {
    private Context mCtx;
    private final LayoutInflater mInflater;
    private List<Etudiant> mEtudiants; // copie en cache


    class EtudiantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private final TextView nomItemView;
        private final TextView prenomItemView;
        private final TextView naissanceItemView;
        public static final int PHOTO_PICK_REQUEST = 2;




        private EtudiantViewHolder(View itemView) {
            super(itemView);
            nomItemView = itemView.findViewById(R.id.nomTextView);
            prenomItemView = itemView.findViewById(R.id.prenomTextView);
            naissanceItemView = itemView.findViewById(R.id.naissanceItemView);

            itemView.setOnClickListener((View.OnClickListener) this);

        }

        @Override
        public void onClick(View view) {
            Etudiant etudiant = mEtudiants.get(getAdapterPosition());

            Intent intent = new Intent(mCtx, ViewEtudiantActivity.class);
            intent.putExtra("etudiant", etudiant);

            mCtx.startActivity(intent);
        }
    }


    EtudiantListAdapter(Context context) {
        this.mCtx= context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public EtudiantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new EtudiantViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EtudiantViewHolder holder, int position) {
        if (mEtudiants != null) {
            Etudiant current = mEtudiants.get(position);
            holder.nomItemView.setText(current.getNomEtudiant());
            holder.prenomItemView.setText(current.getPrenomEtudiant());
            holder.naissanceItemView.setText(current.getNaissanceEtudiant());


        } else {
            // Covers the case of data not being ready yet.
            holder.nomItemView.setText("Aucun étudiant");
        }
    }

    void setEtudiants(List<Etudiant> etudiants) {
        mEtudiants = etudiants;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mEtudiants != null)
            return mEtudiants.size();
        else return 0;
    }
}