package vocapp.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import vocapp.database.DBHelper;
import vocapp.database.WordTable;

public class MainActivity extends AppCompatActivity
{
    public static String wordToSearch;
    DBHelper helper;

    public void createDatabase()
    {
        helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        ContentValues values2 = new ContentValues();

        values1.put(WordTable.WORD, "friend");
        values1.put(WordTable.SYNONYM, "companion");
        values1.put(WordTable.ANTONYM, "foe");

        values2.put(WordTable.WORD, "beautiful");
        values2.put(WordTable.SYNONYM, "pretty");
        values2.put(WordTable.ANTONYM, "ugly");

        db.insert(WordTable.TABLE_NAME, null, values1);
        db.insert(WordTable.TABLE_NAME, null, values2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDatabase();
    }

    /** Called when the user taps the GO button */
    public void searchForWord(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        wordToSearch = editText.getText().toString();

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                WordTable.TABLE_NAME,                     // The table to query
                new String[] {WordTable.SYNONYM, WordTable.ANTONYM},   // The columns to return
                WordTable.WORD + " = ?",                   // The columns for the WHERE clause
                new String[] {wordToSearch},               // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        String searchResult = "";
        while(cursor.moveToNext())
        {
            searchResult = "Synonym: " + cursor.getString(0) + "\n" +
                    "Antonym: " + cursor.getString(1);
        }
        cursor.close();

        Intent intent = new Intent(this, DisplaySearchResultActivity.class);
        intent.putExtra(wordToSearch, searchResult);
        startActivity(intent);
    }

}
