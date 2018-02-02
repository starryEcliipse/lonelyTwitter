/**
 *  NormalTweet
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
 * Represents a Normal Tweet
 *
 * @author dezfuli
 *
 * @version 1.0
 */

public class ImportantTweet extends Tweet {
    /**
     * Creates a NormalTweet
     * @param message message of the tweet
     */
    ImportantTweet(String message){
        super(message);
    }


    /**
     * Creates a NormalTweet
     * @param message message of the tweet
     * @param date date of the tweet
     */
    ImportantTweet(String message, Date date){
        super(message, date);
    }

    /**
     * determines if the tweet is important
     * @return returns True
     */

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
