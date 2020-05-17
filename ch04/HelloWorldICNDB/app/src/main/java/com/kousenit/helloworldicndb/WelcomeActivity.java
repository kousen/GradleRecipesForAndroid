package com.kousenit.helloworldicndb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.kousenit.icndb.JokeFinder;

public class WelcomeActivity extends AppCompatActivity {
    private TextView greetingText;
    private TextView jokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String name = getIntent().getStringExtra("name");
        greetingText = findViewById(R.id.greeting_text);
        jokeText = findViewById(R.id.joke_text);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        new JokeFinder().getJoke(jokeText,
                prefs.getString("first", "Hans"),
                prefs.getString("last", "Dockter"));

        String format = getString(R.string.greeting);
        greetingText.setText(String.format(format, name));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_joke:
                final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                new JokeFinder().getJoke(jokeText,
                        prefs.getString("first", "Hans"),
                        prefs.getString("last", "Dockter"));
                return true;
            case R.id.preferences:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
