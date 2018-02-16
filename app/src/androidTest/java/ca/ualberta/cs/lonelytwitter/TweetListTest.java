package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Diane B on 2018-02-15.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAdd(){

        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a normal Tweet");

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));

    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a normal Tweet");

        assertFalse(tweets.hasTweet(tweet));

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a normal Tweet");

        tweets.add(tweet);

        Tweet returnedTweet = tweets.getTweet(0); //0 is the index

        assertEquals(returnedTweet.getDate(), tweet.getDate()); //check that they are the same by checking the date
    }

    public void testDeleteTwee(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding a normal Tweet");

        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding a normal Tweet");
        Tweet tweet2 = new NormalTweet("adding");
        Tweet tweet3 = new NormalTweet("hello");

        tweets.add(tweet);
        tweets.add(tweet2);
        tweets.add(tweet3);

        int count = tweets.getCount();
        assertEquals(3, count);
    }

    public void testAddTweet(){
        Throwable ex;
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding a normal Tweet");
        Tweet tweet2 = new NormalTweet("adding a normal Tweet");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
        //Source: https://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
        //Accessed on February 15, 2018
        try{
            tweets.addTweet(tweet2);
        } catch (IllegalArgumentException e){
            ex = e;
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }







}
