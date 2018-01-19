package ca.ualberta.cs.lonelytwitter;
import java.util.Date;
import java.util.List;

/**
 * Created by Diane B on 2018-01-18.
 */

public abstract class Tweet implements Tweetable {

    //Attributes
    private String message;
    private Date date;
    private List<CurrentMood> moods;

    //Constructors
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    //Getters
    public Date getDate() {
        return date;
    }
    public String getMessage() {
        return this.message;
    }

    //Setters
    public void setDate(Date date){
        this.date = date;
    }
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        else {
            this.message = message;
        }
    }
    public void addMood(CurrentMood mood){
        this.moods.add(mood);
    }

    //Abstract methods
    public abstract Boolean isImportant();
}
