package com.example.mike.michaelsnotepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//this class backs up all the notes so nothing is deleted unless the user tells it to be deleted

/**
 * Created by mike on 8/19/2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    //creating a variable for the database version
    private static final int NOTEPAD_VERSION = 1;
    //creates a database name
    private static final String NOTEPAD = "notes.db";
    //creating a name of the table
    private static final String NOTEPAD_TABLE="notes";
    //creates identifiers for the table
    public static final String COLUMN_ID="_body";
    public static final String COLUMN_NOTENAME = "note_name";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, NOTEPAD, factory, NOTEPAD_VERSION);
    }

    //sets and creates a table
    @Override
    public void onCreate(SQLiteDatabase db) {
        //creates a string that holds SQL code to execute
        String query = "CREATE TABLE" + NOTEPAD_TABLE + "("
                + COLUMN_ID + " TEXT "
                + COLUMN_NOTENAME + " TEXT " + ");";

        //passing the code to be executed
        db.execSQL(query);
    }

    //deletes old table and calls the oncreate to set up the new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //telling the database to delete the current table
        db.execSQL("DROP_TABLE_IF_EXISTS" + NOTEPAD_TABLE);
        //calls the oncreate method that should have new code in it
        onCreate(db);
    }

    //this method adds a new row to the database (new note to be saved)
    public void addNote(Note note){
        //allows you to set different values for different column all in 1 line
        ContentValues values = new ContentValues();
        //putting a note title in
        values.put(COLUMN_NOTENAME, note.getTitle());
        //putting the body of the note in
        values.put(COLUMN_ID, note.getBody());
        //creating an object "key" to the database
        SQLiteDatabase db = getWritableDatabase();
        //inserts this into the database
        db.insert(NOTEPAD_TABLE, null, values);
        //closes the database
        db.close();
    }

    //this method deletes the note
    public void deleteNote(Note note){
        //creates an object to interact with database
        SQLiteDatabase db = getWritableDatabase();
        //deletes the name of the note
        db.execSQL("DELETE FROM" + NOTEPAD_TABLE + "WHERE" + COLUMN_NOTENAME + "=\""
            + note.getTitle() + "\";");
        //delets the body of the note
        db.execSQL("DELETE FROM" + NOTEPAD_TABLE + "WHERE" + COLUMN_ID + "=\""
            + note.getBody() + "\";");
    }
}
