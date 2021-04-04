package com.example.brithday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class MainActivity2 extends AppCompatActivity {
    String URl;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // ActivityCompat.requestPermissions(this,new String[]{WRITE_EXTERNAL_STORAGE, } );

        URl = getIntent().getExtras().getString("web");
        text = findViewById(R.id.text1);
        text.setText(URl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.sharebtn:
                Intent sharingIntent = new Intent((Intent.ACTION_SEND));
                sharingIntent.setType("image/plain");
                String shareBody = "Your Body Here";
                String shareSubject="Your Subject Here";

                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);

                startActivity(Intent.createChooser(sharingIntent, "Share Using"));

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
