package csc472.depaul.edu.chicagoneighborhoods.strategy;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csc472.depaul.edu.chicagoneighborhoods.R;

public class CrimeDisplayStrategy implements MapDisplayStrategy {

    private HeatmapTileProvider heatmapTileProvider;
    private TileOverlay tileOverlay;

    @Override
    public void displaySelectedData(Context appContext, GoogleMap googleMap) {
        addCrimeHeatMap(appContext, googleMap);
    }

    private void addCrimeHeatMap(Context appContext, GoogleMap googleMap) {
        List<LatLng> list = null;
        list = readCrimeData(appContext, R.raw.crime);
        heatmapTileProvider = new HeatmapTileProvider.Builder()
                .data(list)
                .build();
        tileOverlay = googleMap.addTileOverlay(new TileOverlayOptions().tileProvider(heatmapTileProvider));
    }

    private ArrayList<LatLng> readCrimeData(Context appContext, int resource) {
        ArrayList<LatLng> list = new ArrayList<LatLng>();
        InputStream inputStream = appContext.getResources().openRawResource(resource);
        Scanner coordinatesScanner = new Scanner(inputStream);

        while (coordinatesScanner.hasNext()) {
            String coordinates = coordinatesScanner.next();
            String[] splitCoordinates = coordinates.split(",");
            double lat = Double.parseDouble(splitCoordinates[0]);
            double lng = Double.parseDouble(splitCoordinates[1]);
            list.add(new LatLng(lat, lng));
        }
        return list;
    }
}