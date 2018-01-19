package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Diane B on 2018-01-18.
 */

public class Sad extends CurrentMood {

    //Constructors
    public Sad() {
        super("Sad");
    }
    public Sad(Date date){
        super("Sad", date);
    }
}
