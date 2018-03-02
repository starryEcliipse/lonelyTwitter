package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Intent intent = getIntent(); //get the intent
        String message = intent.getStringExtra("message");

        TextView viewTweets = (TextView) findViewById(R.id.EditTweet);
        viewTweets.setText(message);



    }
}
