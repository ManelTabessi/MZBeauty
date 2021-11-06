package tn.esprit.mzbeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccueilActivity extends AppCompatActivity {
    Button btnfrag1;
    Button btnfrag2;
    Button btnfrag3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        btnfrag1 = findViewById(R.id.btnfrag1);
        btnfrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccueilActivity();
            }
        });
        btnfrag2 = findViewById(R.id.btnfrag2);
        //btnfrag2.setOnClickListener(view -> showFragment(new FragProduit()));
        btnfrag3 = findViewById(R.id.btnfrag3);
        btnfrag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCompteActivity();
            }
        });
    }

    private void openAccueilActivity() {
        Intent intent = new Intent(this,AccueilActivity.class);
        startActivity(intent);
    }

    private void openCompteActivity() {
        Intent intent = new Intent(this,CompteActivity.class);
        startActivity(intent);
    }
    
}