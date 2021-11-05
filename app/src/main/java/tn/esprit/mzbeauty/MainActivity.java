package tn.esprit.mzbeauty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnfrag1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnfrag1 = findViewById(R.id.btnfrag1);
        btnfrag1.setOnClickListener(view -> showFragment(new FragAccueil()));
    }
    void  showFragment (Fragment frag )
    {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,frag)
                .commit();

    }
}