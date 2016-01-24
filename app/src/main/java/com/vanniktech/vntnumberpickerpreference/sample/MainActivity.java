package com.vanniktech.vntnumberpickerpreference.sample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int DEFAULT_BODY_SIZE = 180;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);

        final TextView checkItOutOnGitHubTextView = (TextView) this.findViewById(R.id.check_it_out_on_github);
        checkItOutOnGitHubTextView.setMovementMethod(LinkMovementMethod.getInstance());
        checkItOutOnGitHubTextView.setText(Html.fromHtml(this.getString(R.string.check_it_out_on_github)));

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final TextView bodySizeTextView = (TextView) this.findViewById(R.id.body_size);
        bodySizeTextView.setTextSize(sharedPreferences.getInt("preference_font_size", this.getResources().getInteger(R.integer.font_size_default_value)));
        bodySizeTextView.setText(this.getString(R.string.body_size).concat(" - " + sharedPreferences.getInt("preference_body_size", DEFAULT_BODY_SIZE)));
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.action_settings) {
            this.startActivity(SettingsActivity.start(this));
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
