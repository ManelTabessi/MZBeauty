package tn.esprit.mzbeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {
    public static final String FILE_NAME = "tn.esprit.mzbeauty.shared";

    private ImageView imageView;
    private TextView titleTExtView, detailTextView;
    private String detailString;
    private Button button3;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        imageView = findViewById(R.id.imageView);
        titleTExtView = findViewById(R.id.textView);
        detailTextView = findViewById(R.id.detailTextView);

        titleTExtView.setText(getIntent().getStringExtra("title"));
        Picasso.get().load(getIntent().getStringExtra("image")).into(imageView);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailTextView.getText().toString().length() > 2
                        ) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Add To Wish List", detailTextView.getText().toString());

                    editor.apply();
                }

                openFavorisActivity();

            }
        });
        Content content = new Content();
        content.execute();

    }

    private void openFavorisActivity() {
        Intent intent = new Intent(this,FavorisActivity.class);
        startActivity(intent);
    }


    private class Content extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            detailTextView.setText(detailString);

        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String baseUrl = "https://www.jumia.com.tn/";
                String detailUrl = getIntent().getStringExtra("detailUrl");

                String url = baseUrl + detailUrl;

                Document doc = Jsoup.connect(url).get();

                Elements data = doc.select("div.col10");

                detailString = data.select("div.-phs")
                        .text();


            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}