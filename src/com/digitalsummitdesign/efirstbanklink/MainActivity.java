package com.digitalsummitdesign.efirstbanklink;
            
import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.view.KeyEvent;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.*;
import com.google.ads.*;
 


public class MainActivity extends Activity {

	WebView mywebview;
	private AdView myAdView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	       myAdView = new AdView(this, AdSize.BANNER, "a1510fe4a747746");
	        
		mywebview = (WebView) findViewById(R.id.webview);
		mywebview.setWebViewClient(new MyWebViewClient());
		mywebview.setInitialScale(70);
		mywebview.loadUrl("http://www.efirstbank.com/");
		WebSettings webSettings = mywebview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setBuiltInZoomControls(true);
		mywebview.setWebViewClient(new WebViewClient());
	
        // get layoutView
        // RelativeLayout rootView = (RelativeLayout)this.findViewById(R.id.rootViewGroup);
        // RelativeLayout.LayoutParams layoutParams = new LayoutParams(480, 75);
        // rootView.addView(myAdView, 0, layoutParams);        
        
        AdRequest re = new AdRequest();
        re.setGender(AdRequest.Gender.FEMALE);
        //re.setTestDevices(testDevices);
        //re.setTesting(testing)
        myAdView.loadAd(re);

	
	}
	
	private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
            }
	}
	
	@Override
	public void onBackPressed() {
	    // Check if the key event was the Back button and if there's history
	   
	        if (mywebview.canGoBack()) {
	            mywebview.goBack();
	           
	        }
	        else
	        {
	         AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setMessage("Are you sure you want to exit?")
	           .setCancelable(false)
	           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                    finish();
	               }
	           })
	           .setNegativeButton("No", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                    dialog.cancel();
	               }
	           });
	    AlertDialog alert = builder.create();
	    alert.show();

	        }

	}
	
	
	

}

