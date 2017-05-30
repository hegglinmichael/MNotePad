package com.example.mike.michaelsnotepad;

//this class will define what a note is

/**
 * Created by Michael Hegglin on 8/19/2015.
 */
public class Note {

    //String that holds the name of a note
    private String title = "";
    //String that holds what the note says
    private String body = "";

    //constructor for a note if only a name is entered
    public Note(String title){
        //sets the name entered to the variable in the class
        this.title = title;
    }

    //constructoe for a note if both body and title text is entered
    public Note(String title, String body){
        //sets the name entered to the variable in the class
        this.title = title;
        //sets the body entered to the variable in the class
        this.body = body;
    }

    //sets a new title for the note
    public void setTitle(String newTitle){
        //setting the variable to new text
        title = newTitle;
    }

    //sets a new body for the note
    public void setBody(String newBody){
        //setting the variable to new text
        body = newBody;
    }

    //gets the name/title of the note
    public String getTitle(){
        return title;
    }

    //gets the body of the note
    public String getBody(){
        return body;
    }
}
