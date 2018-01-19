package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Diane B on 2018-01-18.
 */

public abstract class CurrentMood {

    private Date date;
    private String mood;

    //Constructors
    public CurrentMood (String mood){
        this.mood = mood;
        this.date = new Date();
    }
    public CurrentMood (String mood, Date date){
        this.mood = mood;
        this.date = date;
    }

    //Getters
    public Date getDate() {
        return date;
    }
    public String getMood() {
        return mood;
    }


    //Setters
    public void setDate(Date date) {
        this.date = date;
    }





}
