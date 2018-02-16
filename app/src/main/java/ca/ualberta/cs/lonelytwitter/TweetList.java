package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Diane B on 2018-02-15.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){

        tweets.add(tweet);

    }

    public boolean hasTweet(Tweet tweet){

        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){

        return tweets.get(index);
    }

    public void delete(Tweet tweet){

        tweets.remove(tweet);

    }

    public int getCount(){
        return tweets.size();

    }

    public void addTweet(Tweet tweet) throws IllegalArgumentException{
        if(tweets.contains(tweet)) {
            throw new IllegalArgumentException("Tweet already exists");
        }
        tweets.add(tweet);
    }

    public ArrayList<Tweet> getTweets(TweetList tweetList){
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet t){
                return tweet.getDate().compareTo(t.getDate());

            }
        });
        return tweets;


    }





}
