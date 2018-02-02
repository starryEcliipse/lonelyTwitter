package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweet_list.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	//Added these in the lab
	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) { //what you want your activity to do immediately once its created
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main); //this is where you define which layout this shows


		//widgets id.body connects to body in the main.xml
		bodyText = (EditText) findViewById(R.id.body); //findView gets the part in the field
		Button saveButton = (Button) findViewById(R.id.save);
		//Create clear button object
		Button clearButton = (Button) findViewById(R.id.clear); //declare clear button by id
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				setResult(RESULT_OK);
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK); //every onclicklistener needs this
				String text = bodyText.getText().toString(); //get this from widget and turn it into the string

				//Added this in the lab
				Tweet tweet = new NormalTweet(text); //This is Tweet.java, it does the default constructor which creates its own date
				tweetList.add(tweet);
				adapter.notifyDataSetChanged(); //an adapter connects the list to the view, if you want to display your list you need an adapter

				saveInFile(); //Removed parameters in lab


			}
		});
	}

	@Override
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>( this, R.layout.list_item, tweetList); //This does not want your main view it just wants a list view aka list_item.xml this is a separate
		//view that you create that is a blank text view. Your list should show up in main.xml

		oldTweetsList.setAdapter(adapter);

	}

	private void loadFromFile() { //changed from String[] in lab

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			//Added in the lab
			Gson gson = new Gson();
			//Taken from https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			//Accessed 2018-01-25
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} /*catch (IOException e) {
			e.printStackTrace();
			//throw new RuntimeException();
		}*/

	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE); //changed from MODE_APPEND in the lab

			//Added in the lab
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush(); //clears buffer


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}