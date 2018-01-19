package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Diane B on 2018-01-18.
 */

public class NormalTweet extends Tweet {

    //Constructors
    public NormalTweet(String message){
        super(message);
    }
    public NormalTweet(String message, Date date){
        super(message, date);
    }

    @Override //keyword
    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
