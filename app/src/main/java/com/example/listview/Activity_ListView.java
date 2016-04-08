package com.example.listview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class Activity_ListView extends AppCompatActivity {


	ListView my_listview;
	ArrayList<String> spinnerSort = new ArrayList<>();
	customAdapter adapter;
	ArrayList<BikeData> arrayList = new ArrayList<>();
	String url = "http://www.tetonsoftware.com/bikes/bikes.json";
	JSONArray jsonArray;
	JSONHelper helperActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Change title to indicate sort by
		setTitle("Sort by:");

		//listview that you will operate on
		my_listview = (ListView)findViewById(R.id.lv);

		//custom adapter
		DownloadTask myTask = new DownloadTask(helperActivity);
		myTask.execute(url);
		adapter = new customAdapter(Activity_ListView.this, R.layout.listview_row_layout, helperActivity.parseAll(url));

		//toolbar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();

		spinnerSort.add("Company");
		spinnerSort.add("Location");
		spinnerSort.add("Price");
		setupSimpleSpinner();

		//set the listview onclick listener
		setupListViewOnClickListener();

		//TODO call a thread to get the JSON list of bikes
		//TODO when it returns it should process this data with bindData
	}

	private void setJSON(int i) {
		jsonArray = new JSONArray();
		if(jsonArray == null){
			return;
		}

		try{
			JSONObject jsonObject = jsonArray.getJSONObject(i);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setupListViewOnClickListener() {

		//TODO you want to call my_listviews setOnItemClickListener with a new instance of android.widget.AdapterView.OnItemClickListener() {
	}

	/**
	 * Takes the string of bikes, parses it using JSONHelper
	 * Sets the adapter with this list using a custom row layout and an instance of the CustomAdapter
	 * binds the adapter to the Listview using setAdapter
	 *
	 * @param JSONString  complete string of all bikes
	 */
	private void bindData(String JSONString) {

	}

	Spinner spinner;

	private void setupSimpleSpinner() {
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Activity_ListView.this, R.layout.spinner_item, spinnerSort);
		spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(dataAdapter);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public static final int SELECTED_ITEM = 0;

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (parent.getChildAt(SELECTED_ITEM) != null) {
					((TextView) parent.getChildAt(SELECTED_ITEM)).setTextColor(Color.WHITE);
					Toast.makeText(Activity_ListView.this, (String) parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();

					//This is where we will sort the list view
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

			default:
				break;
		}
		return true;
	}
}
