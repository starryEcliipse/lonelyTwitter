/**
 *  Tweet
 *
 *  Version 1.0
 *
 *  Feb 01, 2018
 *
 *  Copyright © 2018 Team X, CMPUT301, University of Alberta - All Rights Reserved.
 *  You may use, distribute, or modify this code under terms and conditions of Code of Student Behavior at
 *  University of Alberta.
 *  You can find a copy of this license in this project. Otherwise, please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Represents a Tweet
 *
 * @author dezfuli
 *
 * @version 1.0
 */


public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Constructs a Tweet instance using the given message
     *
     * @param message the message of the tweet
     */

    Tweet(String message){

        this.message = message;
        date = new Date();
//        message = message;
    }

    /**
     * Constructs a Tweet instance using the given message
     * @param message - the message of the tweet
     * @param date - the date of the tweet
     */

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     *
     * @return returns the Tweet message
     */

    public String getMessage(){
        return message;
    }

    /**
     * Sets the message of the tweet
     *
     * @param message - the new message of the tweet
     * @throws TweetTooLongException - is thrown when the message is over 140 characters
     *
     * @see ImportantTweet
     * @see NormalTweet
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    /**
     *
     * @return returns the Tweet date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Sets the date of the tweet
     * @param date the new date of the tweet
     * @see ImportantTweet
     * @see NormalTweet
     *
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     *
     * @return returns True if tweet is important, subclasses override this method
     */
    public abstract Boolean isImportant();

    /**
     * @return returns String representation of tweet
     */
    //Added in the lab
    public String toString() {
        return date.toString() + " | " + message;
    }
}
