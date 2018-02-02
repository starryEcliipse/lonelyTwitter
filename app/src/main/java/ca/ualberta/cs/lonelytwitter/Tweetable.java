/**
 *  Tweetable
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
 * Interface for Tweet class
 * implements the getMessage and getDate methods of Tweet class
 *
 * @author dezfuli
 *
 * @version 1.0
 */


public interface Tweetable {
    /**
     * @return returns the message of the tweet
     */
    public String getMessage();

    /**
     * @return returns the date of the tweet
     */
    public Date getDate();
}
