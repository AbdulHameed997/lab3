package com.csis401.rteams;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void changeChoices(View v) {
        final String[] difficulties = {"2", "4", "6", "8"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setTitle("choices");
        builder.setSingleChoiceItems(difficulties, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
                editor.putInt("c", Integer.parseInt(difficulties[which]));
                editor.apply();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void changeRegion(View v) {
        final String[] difficulties = {"Region1", "Region2", "Region3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setTitle("region");
        builder.setSingleChoiceItems(difficulties, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
                editor.putInt("r", which);
                editor.apply();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}
