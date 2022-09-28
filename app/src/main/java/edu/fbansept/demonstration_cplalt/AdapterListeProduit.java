package edu.fbansept.demonstration_cplalt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListeProduit extends RecyclerView.Adapter<AdapterListeProduit.ProduitViewHolder> {

    private ArrayList<Product> listeProduits;

    public AdapterListeProduit(ArrayList<Product> listeProduits) {
        this.listeProduits = listeProduits;
    }

    static class ProduitViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitleProduct;
        private final TextView tvPriceProduct;

        public ProduitViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitleProduct = itemView.findViewById(R.id.titleProduct);
            tvPriceProduct = itemView.findViewById(R.id.priceProduct);
        }

        public TextView getTvTitleProduct() {
            return tvTitleProduct;
        }

        public TextView getTvPriceProduct() {
            return tvPriceProduct;
        }
    }

    @NonNull
    @Override
    public ProduitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vueItem = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_produit,parent,false);

        return new ProduitViewHolder(vueItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitViewHolder holder, int position) {
        Product produit = listeProduits.get(position);
        holder.getTvTitleProduct().setText(produit.getTitle());
        holder.getTvPriceProduct().setText(produit.getPrice() + "€");


    }

    @Override
    public int getItemCount() {
        return listeProduits.size();
    }
}
