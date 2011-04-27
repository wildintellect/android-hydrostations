/*
 * 
 * 
 * 
 * Sources:
 * http://developer.android.com/resources/tutorials/views/hello-mapview.html
 * */
package edu.ucdavis.ttp.hydrostations;

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
    }
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}