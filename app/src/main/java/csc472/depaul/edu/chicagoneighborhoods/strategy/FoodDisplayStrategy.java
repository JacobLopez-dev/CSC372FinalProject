package csc472.depaul.edu.chicagoneighborhoods.strategy;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import csc472.depaul.edu.chicagoneighborhoods.R;

public class FoodDisplayStrategy implements MapDisplayStrategy {

    @Override
    public void displaySelectedData(Context context, GoogleMap googleMap) {
        parseFileAndAddToMap(context, googleMap, R.raw.restaurants);
    }

    private void parseFileAndAddToMap(Context appContext, GoogleMap googleMap, int resource) {
    InputStream inputStream = appContext.getResources().openRawResource(resource);
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String markerEntry;

        try {
                while ((markerEntry = bufferedReader.readLine()) != null)  {
                    String[] markerData = markerEntry.split("\\|");
                    String title = markerData[0];
                    double lat = Double.parseDouble(markerData[1]);
                    double lng = Double.parseDouble(markerData[2]);

                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(lat, lng))
                            .title(title));
                }
        } catch (IOException | IndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}