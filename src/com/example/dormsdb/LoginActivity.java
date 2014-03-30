package com.example.dormsdb;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
	
	public final String TAG = LoginActivity.class.getSimpleName();
	
	protected TextView mEmail;
	protected TextView mPassword;
	protected Button mButton;
	protected String mFeedback;
	private TextView mSignUp;
	public String email;
	public String password;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		mEmail = (TextView) findViewById(R.id.email_login);
		mPassword = (TextView) findViewById(R.id.password_login);
		mButton = (Button) findViewById(R.id.login_button);
		mSignUp = (TextView) findViewById(R.id.SignUp);
		
		mSignUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 mSignUp.setTextColor(Color.RED);
				 Uri uri = Uri.parse("https://dormsdb.alexthemitchell.com/register.php");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
				
			}
		});
		
		
		
		
		
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
				email = mEmail.getText().toString();
				password = mPassword.getText().toString();
				
				if (email.isEmpty() || password.isEmpty()){
					
					AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
					builder.setMessage("Please fill in both fields.")
						.setTitle("error")
						.setPositiveButton(android.R.string.ok,null);
					
					AlertDialog dialog = builder.create();
					dialog.show();
					
				}
				
				else if (isNetworkNotAvailable()){
				
					
					AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
					builder.setMessage("Please make sure you are connected to the internet!")
						.setTitle("Error")
						.setPositiveButton(android.R.string.ok,null);
					
					AlertDialog dialog = builder.create();
					dialog.show();
					
				}
				
				
				else if (email.contains("@grinnell.edu")){
					verifyCredentials verifier = new verifyCredentials ();
					verifier.execute();
					
				}
				else {
				AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
				builder.setMessage("Please use a grinnell.edu address")
					.setTitle("error")
					.setPositiveButton(android.R.string.ok,null);
				
				AlertDialog dialog = builder.create();
				dialog.show();
				
				}
				
			}
		});
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	private boolean isNetworkNotAvailable() {
		ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getActiveNetworkInfo();
		
		boolean isAvailable = true;
		if (networkInfo != null && networkInfo.isConnected()) {
			
			isAvailable = false;
		}
		return isAvailable;
	}

	
	private HttpClient createHttpClient() {
		
		 HttpParams params = new BasicHttpParams();
		    HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		    HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
		    HttpProtocolParams.setUseExpectContinue(params, true);

		    SchemeRegistry schReg = new SchemeRegistry();
		    SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
		    socketFactory.setHostnameVerifier((X509HostnameVerifier) org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		    schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
		    schReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
		    ClientConnectionManager conMgr = new ThreadSafeClientConnManager(params, schReg);
		    HttpsURLConnection.setDefaultHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

		    return new DefaultHttpClient(conMgr, params);
	}
	



private class verifyCredentials extends AsyncTask<Object, Void, String>{

    
    
	   
	 
	 int responseCode = -1;
	 String FinalResponse = null;
	 
	 @Override 
	 protected String doInBackground(Object...arg0) {
		 
		try {
			
			HttpPost httppost = new HttpPost("https://dormsdb.alexthemitchell.com/api.php");
			
		
	
			        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			        nameValuePairs.add(new BasicNameValuePair("user", "true"));
			        nameValuePairs.add(new BasicNameValuePair("email", email));
			        nameValuePairs.add(new BasicNameValuePair("password", password));
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			        // Execute HTTP Post Request
			       HttpResponse response = createHttpClient().execute(httppost);
			      
			      
			   
			
			/*HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){

				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					// TODO Auto-generated method stub
					return true;
				}
		});*/
				
			//HttpsURLConnection response = (HttpsURLConnection) url.openConnection();
			
			 
			 responseCode = response.getStatusLine().getStatusCode();
			 
			 
			 Log.v(TAG, Integer.toString(responseCode));
			 
			 
			 if (responseCode == HttpURLConnection.HTTP_OK) {
				 
				  BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
				  String output = reader.readLine();
				  
				  if (output == null) {
					  output = "True";
				  }
				  
				  Log.v("FEEDBACK", "" + output);
				  FinalResponse = output;
					reader.close();
					
					
					//Log.v("FEEDBACK", responseData);

		
				 
				 
			 }
			 else {responseCode = response.getStatusLine().getStatusCode();
				Log.i(TAG, "Code: " + responseCode);
				 
			 }
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			Log.e(TAG, "Exception caught: " + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.e(TAG, "Exception caught: " + e);
		}

		 
		 
		 
		return FinalResponse;
		 
	 }

	 
	 private void handleResponse() {
			if (mFeedback.equals("FALSE")){
		 		AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
				builder.setMessage("Incorrect credentials")
					.setTitle("error")
					.setPositiveButton(android.R.string.ok,null);
				
				AlertDialog dialog = builder.create();
				dialog.show();
		 		
		 	} else {
		 		
		 		
		 		SharedPreferences myPrefs = getSharedPreferences("PREFS", 0);
				Editor editor = myPrefs.edit();
		        editor.putString("Login", email);
		        editor.apply();
		 		
		 		
		 		Intent intent = new Intent(LoginActivity.this, MainActivity.class);
		 		startActivity(intent);
		 		
		 	}
			
		}
	
	 @Override
		protected void onPostExecute (String result) {
		 	
		 	mFeedback = result;
			handleResponse();
			
		}


	

	

}
	
}
