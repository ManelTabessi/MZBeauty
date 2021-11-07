package tn.esprit.mzbeauty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnfrag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
               btnfrag3 = findViewById(R.id.btnfrag3);
        btnfrag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    private void openProduitActivity()
    {Intent intent = new Intent(this,ProduitActivity.class);
        startActivity(intent);
    }
    private void openCategoryActivity()
    {Intent intent = new Intent(this,CategoryActivity.class);
        startActivity(intent);
    }

    private void openAccueilActivity() {
        Intent intent = new Intent(this,AccueilActivity.class);
        startActivity(intent);
    }

    private void openCompteActivity() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    void  showFragment (Fragment frag )
    {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,frag)
                .commit();

    }

}