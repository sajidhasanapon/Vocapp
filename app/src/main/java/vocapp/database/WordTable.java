package vocapp.database;

/**
 * Created by apon on 7/6/17.
 */

public class WordTable
{
    public static final String TABLE_NAME = "WordTable";
    public static final String WORD = "Word";
    public static final String SYNONYM = "Synonym";
    public static final String ANTONYM = "Antonym";

    public static final String TABLE_CREATE_COMMAND = "CREATE TABLE " + TABLE_NAME + "(" +
            WORD + " TEXT," +
            SYNONYM + " TEXT," +
            ANTONYM + " TEXT)";
}
