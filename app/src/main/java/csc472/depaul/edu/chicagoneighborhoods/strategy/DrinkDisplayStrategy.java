package csc472.depaul.edu.chicagoneighborhoods.strategy;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import csc472.depaul.edu.chicagoneighborhoods.R;

public class DrinkDisplayStrategy implements MapDisplayStrategy {

    int i;

    @Override
    public void displaySelectedData(Context appContext, GoogleMap googleMap) {
        parseFileAndAddToMap(appContext, googleMap, R.raw.drinks);
    }

    private void parseFileAndAddToMap(Context appContext, GoogleMap googleMap, int resource) {
        InputStream inputStream = appContext.getResources().openRawResource(resource);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String markerEntry;

        try {
            while ((markerEntry = bufferedReader.readLine()) != null)  {
                i++;
                List<String> markerData = Arrays.asList(markerEntry.split("\\|"));
                String title = markerData.get(0);
                double lat = Double.parseDouble(markerData.get(1));
                double lng = Double.parseDouble(markerData.get(2));

                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lng))
                        .title(title));
            }
        } catch (IOException | IndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}