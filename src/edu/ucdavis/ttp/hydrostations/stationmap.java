/*
 * 
 * 
 * 
 * Sources:
 * http://developer.android.com/resources/tutorials/views/hello-mapview.html
 * http://www.helloandroid.com/tutorials/how-download-fileimage-url-your-device
 * */
package edu.ucdavis.ttp.hydrostations;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class stationmap extends MapActivity {
    /** Called when the activity is first created. */
	private final String PATH = "/data/data/edu.ucdavis.ttp.hydrostations/";  //put the downloaded file here
	        
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        String kmlurl = "http://gis.its.ucdavis.edu/hydrogen/feeds/dynamic/stations.kml";
        String fileName = "stations.kml";
        File kmlFile = new File(PATH+fileName);
        long timetest = System.currentTimeMillis()-kmlFile.lastModified();
        Log.d("KmlManager","Time Diff:"+timetest);
        if (timetest > 600000){
        	DownloadFromUrl(kmlurl,fileName);
        }
        Intent myIntent = new Intent(android.content.Intent.ACTION_VIEW,
        		//Uri.parse("geo:0,0?q="+kmlurl));
        		Uri.parse("geo:0,0?q="+Uri.fromFile(kmlFile)));
        		//Uri.parse("geo:0,0?q=http://gis.its.ucdavis.edu/hydrogen/feeds/dynamic/stations.kml"));
        		startActivity(myIntent);

    }
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
    public void DownloadFromUrl(String kmlURL, String fileName) {
    	//this is the downloader method
    	try {
    		URL url = new URL(kmlURL); //you can write here any link
    	    File file = new File(fileName); 
    	    long startTime = System.currentTimeMillis();
    	    Log.d("KmlManager", "download begining");
    	    Log.d("KmlManager", "download url:" + url);
    	    Log.d("KmlManager", "downloaded file name:" + fileName);
    	    /* Open a connection to that URL. */
    	    URLConnection ucon = url.openConnection();

			/*
			 * Define InputStreams to read from the URLimport java.lang.System;Connection.
			 */
			InputStream is = ucon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			/*
			* Read bytes to the Buffer until there is nothing more to read(-1).
			*/
			ByteArrayBuffer baf = new ByteArrayBuffer(50);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
			    	
			/* Convert the Bytes read to a String. */
			FileOutputStream fos = new FileOutputStream(PATH+file);
			fos.write(baf.toByteArray());
			fos.close();
			Log.d("KmlManager", "download ready in"
			 + ((System.currentTimeMillis() - startTime) / 1000)
			+ " sec");
			} catch (IOException e) {
			    	
			Log.d("KmlManager", "Error: " + e);
			    	
			}
    	
    }
}
