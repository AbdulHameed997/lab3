package com.csis401.rteams;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] h1 = {"barcelona", "realmadrid", "ajax", "manchesterunited", "valencia", "liverpool", "athleticomadrid", "realbetis", "getafe", "realsoceidad"};
    String[] h2 = {"ahly", "zamalek", "wadidegla", "kafralshiekh", "asmantasyut", "mansora", "pyramids", "talaelgiesh", "safrica", "amazulu"};
    String[] h3 = {"psg", "zenit", "chelsea", "mcity", "rp", "acm", "bm", "dortmond", "arsenal", "wax"};
    ArrayList<String> temp;
    ArrayList<String> T1;
    ArrayList<String> T2;
    ArrayList<String> T3;
    ImageView iv;
    String answer;
    TextView tv;
    TextView tv1;
    Button bt;
    int idd;
    int display;
    int questionNum;
    int score;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mm, menu);
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T1 = new ArrayList<>();
        T2 = new ArrayList<>();
        T3 = new ArrayList<>();
        temp = new ArrayList<>();
        T1.addAll(Arrays.asList(h1));
        T2.addAll(Arrays.asList(h2));
        T3.addAll(Arrays.asList(h3));
        tv = findViewById(R.id.qc);
        iv = findViewById(R.id.imageView);
        tv1 = findViewById(R.id.sc);
        SharedPreferences prefs = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        idd = prefs.getInt("r", 0); //region
        display = prefs.getInt("c", 4); //number of choices
        questionNum = 1;
        score = 0;
        start();
    }

    public void start() {
        reset();
        tv1.setText("Your score: " + score);
        tv.setText("Question " + questionNum + " of 10");
        int random = getRandom(display);
        if (idd == 0) {
            int getRandom = getRandom(T1.size() - 1);
            temp.addAll(Arrays.asList(h1));
            String imageName = T1.get(getRandom);
            String Sid = "Button" + random;
            answer = T1.get(getRandom);
            int resID = getResources().getIdentifier(Sid, "id", getPackageName());
            bt = findViewById(resID);
            bt.setText(answer);
            T1.remove(T1.indexOf(answer));
            temp.remove(temp.indexOf(answer));
            int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
            iv.setImageResource(id);
            for (int i = 1; i <= display; i++) {
                String Sid2 = "Button" + i;
                int resID2 = getResources().getIdentifier(Sid2, "id", getPackageName());
                bt = findViewById(resID2);
                bt.setVisibility(View.VISIBLE);
                if (!bt.getText().equals(answer)) {
                    int getRandom2 = getRandom(temp.size() - 1);
                    bt.setText(temp.get(getRandom2));
                    temp.remove(getRandom2);
                }
            }
        }
        if (idd == 1) {
            int getRandom = getRandom(T2.size() - 1);
            temp.addAll(Arrays.asList(h2));
            String imageName = T2.get(getRandom);
            String Sid = "Button" + random;
            answer = T2.get(getRandom);
            int resID = getResources().getIdentifier(Sid, "id", getPackageName());
            bt = findViewById(resID);
            bt.setText(answer);
            T2.remove(T2.indexOf(answer));
            temp.remove(temp.indexOf(answer));
            int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
            iv.setImageResource(id);
            for (int i = 1; i <= display; i++) {
                String Sid2 = "Button" + i;
                int resID2 = getResources().getIdentifier(Sid2, "id", getPackageName());
                bt = findViewById(resID2);
                bt.setVisibility(View.VISIBLE);
                if (!bt.getText().equals(answer)) {
                    int getRandom2 = getRandom(temp.size() - 1);
                    bt.setText(temp.get(getRandom2));
                    temp.remove(getRandom2);
                }
            }
        }
        if (idd == 2) {
            int getRandom = getRandom(T3.size() - 1);
            temp.addAll(Arrays.asList(h3));
            String imageName = T3.get(getRandom);
            String Sid = "Button" + random;
            answer = T3.get(getRandom);
            int resID = getResources().getIdentifier(Sid, "id", getPackageName());
            bt = findViewById(resID);
            bt.setText(answer);
            T3.remove(T3.indexOf(answer));
            temp.remove(temp.indexOf(answer));
            int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
            iv.setImageResource(id);
            for (int i = 1; i <= display; i++) {
                String Sid2 = "Button" + i;
                int resID2 = getResources().getIdentifier(Sid2, "id", getPackageName());
                bt = findViewById(resID2);
                bt.setVisibility(View.VISIBLE);
                if (!bt.getText().equals(answer)) {
                    int getRandom2 = getRandom(temp.size() - 1);
                    bt.setText(temp.get(getRandom2));
                    temp.remove(getRandom2);
                }
            }
        }
        temp.clear();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
        MainActivity.this.finish();
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        bt = (Button) v;
        if (bt.getText().toString().equals(answer)) {
            score++;
        } else {
            Toast.makeText(getBaseContext(), "YOU ARE WRONG!!", Toast.LENGTH_LONG).show();

        }
        questionNum++;
        if (questionNum == 10) {
            Toast.makeText(getBaseContext(), "You scored " + score + " out of 9", Toast.LENGTH_LONG).show();
            questionNum = 1;
            score = 0;
            if (this.idd == 0) {
                T1.addAll(Arrays.asList(h1));
            } else if (this.idd == 1) {
                T2.addAll(Arrays.asList(h2));
            } else {
                T3.addAll(Arrays.asList(h3));
            }
        }
        start();
    }

    public int getRandom(int max) {
        return 1 + (int) (Math.random() * ((max + 1) - 1));
    }

    public void reset() {
        for (int i = 1; i <= display; i++) {
            String Sid2 = "Button" + i;
            int resID2 = getResources().getIdentifier(Sid2, "id", getPackageName());
            bt = findViewById(resID2);
            bt.setText("Button");
        }
    }
}
