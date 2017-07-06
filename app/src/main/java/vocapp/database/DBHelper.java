package vocapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by apon on 7/6/17.
 */

public class DBHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATAABSE_NAME = "Vocapp_DB";

    public DBHelper(Context context)
    {
        super(context, DATAABSE_NAME, null, DATABASE_VERSION);
    }

    // override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(WordTable.TABLE_CREATE_COMMAND);
    }

    //override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerssion)
    {
        // who cares
    }

    //override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVerssion)
    {
        // who cares
    }
}
