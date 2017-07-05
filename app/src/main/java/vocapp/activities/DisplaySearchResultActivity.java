package vocapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import vocapp.activities.R;

public class DisplaySearchResultActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search_result);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.wordToSearch);

        // Capture the layout's TextView and set the string as its text
        TextView upperTextView = (TextView) findViewById(R.id.keyword);
        upperTextView.setText(MainActivity.wordToSearch);

        TextView lowerTextView = (TextView) findViewById(R.id.resultBox);
        lowerTextView.setText(message);
    }
}
