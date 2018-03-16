package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class); //check if correct activity
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!"); //enter the text
        solo.clickOnButton("Save"); //save the text
        solo.clearEditText((EditText) solo.getView(R.id.body)); //clear the text
        assertTrue(solo.waitForText("Test Tweet!")); //make sure the text has been saved into the listView
        //Fixed typo
        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!", 1, 3000)); //make sure the text has been cleared from the listview
        //looking for 1 instance of "Test Tweet!" and will only wait for 3000 seconds
    }

    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity)solo.getCurrentActivity(); //switch from the current activity to a new activity
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class); //check if correct activity
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!"); //enter the text
        solo.clickOnButton("Save"); //save the text
        solo.clearEditText((EditText) solo.getView(R.id.body)); //clear the text
        assertTrue(solo.waitForText("Test Tweet!")); //make sure the text has been saved into the listview
        final ListView oldTweetsList = activity.getOldTweetsList(); //get the list of old/previous tweets
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0); //Get most recent tweet
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0); //clicks on the first item in the listview
        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class); //check that we are in EditTweetActivity
        assertTrue(solo.waitForText("Test Tweet!")); //test to make sure the tweet went into the EditTweetActivity
        solo.goBack(); //go back to the previous activity
        solo.assertCurrentActivity("Wrong Activity",LonelyTwitterActivity.class); //check that we are in LonelyTwitterActivity


    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}