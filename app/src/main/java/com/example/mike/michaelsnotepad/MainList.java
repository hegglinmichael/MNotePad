package com.example.mike.michaelsnotepad;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainList extends AppCompatActivity {

    //creates a filter to see if stuff is happening
    private static final String TAG = "michael'sFilter";

    //creating references to TextViews, Buttons, etc...
    private Button delete = null;
    private Button add = null;
    private EditText input = null;
    private ListView noteListTitles = null;

    //creates a DBHandler to input notes into the database
    DBHandler dbHandler = null;

    //creates an arraylist to hold all notes
    ArrayList<Note> noteList = new ArrayList<Note>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        //saying the oncreate method has been called
        Log.i(TAG, "onCreate Called");

        //filling up the arraylist after the phone or the app was completely stoped
        fillArrayList();

        //setting up references to the xml
        delete = (Button)findViewById(R.id.delete_button);
        add = (Button)findViewById(R.id.createNote_button);
        input = (EditText)findViewById(R.id.input);
        noteListTitles = (ListView)findViewById(R.id.noteTitle_listView);

        //creates dbHandler object
        dbHandler = new DBHandler(this, null, null, 1);


    }

    //deletes a note
    public void deleteNote(View v) {
        //saying that this method is being called(filter)
        Log.i(TAG, "deleteNote method called");
        //calls the delete method to delete note from the database
        //dbHandler.deleteNote();
    }

    //adds a note
    public void addNote(View v) {
        //saying that this method is being called(filter)
        Log.i(TAG, "addNote method called");
        //adds a note object
        Note note = new Note(input.getText().toString(), "");
        //calls the methid to add a note into the database
        dbHandler.addNote(note);
        //adds the new note to the arrayList
        noteList.add(note);
    }

    public void fillArrayList(){

    }
}
