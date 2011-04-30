package edu.ucdavis.ttp.hydrostations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HydroWindow extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startwindow);
        
        Button invokingButton = (Button)findViewById(R.id.mapbutton);
        invokingButton.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		Intent stationmap = new Intent(HydroWindow.this,stationmap.class);
        		startActivity(stationmap);
        	}
        });
    }
}