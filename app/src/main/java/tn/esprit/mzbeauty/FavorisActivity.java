package tn.esprit.mzbeauty;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FavorisActivity extends AppCompatActivity {
    EditText name, contact, dob;
    Button insert, update, delete, view;
    Favoris DB;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new Favoris(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dobTXT = dob.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(FavorisActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(FavorisActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = dob.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(FavorisActivity.this, "Favoris Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(FavorisActivity.this, "Favoris Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(FavorisActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){

                    buffer.append("Product : "+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(FavorisActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
        sp = getSharedPreferences(DetailActivity.FILE_NAME, MODE_PRIVATE);

        if (!sp.getString("Add To Wish List", "").isEmpty()){
            dob.setText(""+ sp.getString("Add To Wish List", ""));
        }
    }}