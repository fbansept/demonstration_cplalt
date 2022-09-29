package edu.fbansept.demonstration_cplalt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailProduit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produit);

        int idProduit = getIntent().getExtras().getInt("idProduit");

        TextView tvProductDetailTitle = findViewById(R.id.tvProductDetailTitle);
        tvProductDetailTitle.setText(Integer.toString(idProduit));
    }

}