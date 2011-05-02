/*
 * 
 * 
 * 
 * Sources:
 * http://developer.android.com/resources/tutorials/views/hello-mapview.html
 * */
package edu.ucdavis.ttp.hydrostations;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class stationmap extends MapActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        Intent myIntent = new Intent(android.content.Intent.ACTION_VIEW,
        		Uri.parse("geo:0,0?q=http://gis.its.ucdavis.edu/hydrogen/feeds/dynamic/stations.kml"));
        		startActivity(myIntent);

    }
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}