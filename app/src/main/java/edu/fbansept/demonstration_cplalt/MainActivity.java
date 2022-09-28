package edu.fbansept.demonstration_cplalt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button monBouton = findViewById(R.id.button8);

        monBouton.setOnClickListener(view ->
                startActivity(new Intent(this,ListeProduits.class)));

    }
}