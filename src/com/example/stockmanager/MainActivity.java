package com.example.stockmanager;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.net.Network;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
	private EditText mTitleEdit;
	private EditText mMsgEdit;
	private Button mBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTitleEdit = (EditText) findViewById(R.id.title);
		mMsgEdit = (EditText) findViewById(R.id.msg);
		mBtn = (Button) findViewById(R.id.send);
		
		mBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread httpJob = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						sendGcmData(mTitleEdit.getText().toString(), mMsgEdit.getText().toString());		
					}
				});
				httpJob.start();
				
				
			}
		});
		
	}
	
	private void sendGcmData(String title, String msg){
		// Add custom implementation, as needed.
		
//		URL url = null;
//		Log.e("kyungman", "kyungman title : " + title);
//		Log.e("kyungman", "kyungman msg : " + msg);
//		try {
//			// url = new URL("http://suah.iptime.org:9000/savegcm");
//			String urlTxt = "http://192.168.129.133:9000/sendgcm?title="+title+"&message="+msg;
//			url = new URL(urlTxt);
//			Log.e("kyungman", "kyungman url : " + url.getPath());
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			Log.e("kyungman", "MalformedURLException: " + e.getMessage());
//			e.printStackTrace();
//		}
//		HttpURLConnection conn = null;
//		try {
//			conn = (HttpURLConnection) url.openConnection();
//			
//			conn.setDoOutput(true);
////			conn.setDoInput(true);
//			conn.setRequestMethod("POST");
//			conn.setRequestProperty("Cache-Control", "no-cache");
//			conn.setRequestProperty("Content-Type", "application/json");
//			conn.setRequestProperty("Accept", "application/json");
//			conn.connect();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			Log.e("kyungman", "IOException: " + e.getMessage());
//			e.printStackTrace();
//		}
//
//		Log.e("kyungman", "kyungman url : " + conn.getURL());
//		Log.e("kyungman", "kyungman url toString : " + conn.toString());
////		mTitleEdit.setText("");
////		mMsgEdit.setText("");
		
		
		
		
//		RequestQueue mRequestQueue;
//
//		// Instantiate the cache
//		Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
//
//		// Set up the network to use HttpURLConnection as the HTTP client.
//		Network network = new BasicNetwork(new HurlStack());
//
//		// Instantiate the RequestQueue with the cache and network.
//		mRequestQueue = new RequestQueue(cache, network);
//
//		// Start the queue
//		mRequestQueue.start();
//
//		String url ="http://www.example.com";
//
//		// Formulate the request and handle the response.
//		StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//		        new Response.Listener<String>() {
//		    @Override
//		    public void onResponse(String response) {
//		        // Do something with the response
//		    }
//		},
//		    new Response.ErrorListener() {
//		        @Override
//		        public void onErrorResponse(VolleyError error) {
//		            // Handle error
//		    }
//		});
//
//		// Add the request to the RequestQueue.
//		mRequestQueue.add(stringRequest);

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
