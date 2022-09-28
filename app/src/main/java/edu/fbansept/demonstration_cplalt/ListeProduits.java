package edu.fbansept.demonstration_cplalt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListeProduits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);
        ArrayList<Product> listeProduit = new ArrayList<>();

        RecyclerView rvListeProduit = findViewById(R.id.rvListeProduit);
        rvListeProduit.setLayoutManager(new LinearLayoutManager(this));

        JsonObjectRequest requete = new JsonObjectRequest(
                "https://dummyjson.com/products",
                resultat -> {
                    try {
                        JSONArray listeJson = resultat.getJSONArray("products");
                        for(int i = 0; i < listeJson.length(); i++) {
                            JSONObject json = listeJson.getJSONObject(i);
                            Product produit = new Product(json);
                            listeProduit.add(produit);
                        }

                        rvListeProduit.setAdapter(new AdapterListeProduit(listeProduit));

                        Toast.makeText(
                                this,
                                "Affichage de " + listeProduit.size() + " produits",
                                Toast.LENGTH_LONG).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> error.printStackTrace()
                );

        RequestManager.getInstance(this).addToRequestQueue(requete);
    }
}