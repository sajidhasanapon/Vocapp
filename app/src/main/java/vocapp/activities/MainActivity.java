package vocapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    public static String wordToSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the GO button */
    public void searchForWord(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        wordToSearch = editText.getText().toString();

        String searchResult = "Habijabi bla bla bla" + "\n\n" + "Supposed to come from database query" + "\n";
        // String searchResult = dbHelper.getFromDatabase(wordToSearch);

        Intent intent = new Intent(this, DisplaySearchResultActivity.class);
        intent.putExtra(wordToSearch, searchResult);
        startActivity(intent);
    }

}
