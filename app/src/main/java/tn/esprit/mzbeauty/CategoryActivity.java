package tn.esprit.mzbeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity {

    Button soins;
    Button Parfums;
    Button Maquillage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        soins = findViewById(R.id.soins);
        soins.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openProduitActivity();
            }

        });

       Parfums = findViewById(R.id.Parfums);
        Parfums.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openParfumsActivity();
            }

        });

        Maquillage = findViewById(R.id.Maquillage);
        Maquillage.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMaquillageActivity();
            }

        });
    }

    private void openParfumsActivity() {
        Intent intent = new Intent(this,ParfumsActivity.class);
        startActivity(intent);
    }

    private void openMaquillageActivity() {
        Intent intent = new Intent(this,MaquillageActivity.class);
        startActivity(intent);
    }

    private void openAccueilActivity() {
        Intent intent = new Intent(this,AccueilActivity.class);
        startActivity(intent);
    }
    private void openProduitActivity() {
        Intent intent = new Intent(this,ProduitActivity.class);
        startActivity(intent);
    }
    private void openCategoryActivity() {
        Intent intent = new Intent(this,CategoryActivity.class);
        startActivity(intent);
    }
}