package csc472.depaul.edu.chicagoneighborhoods.strategy;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import android.content.Context;


public class CrimeDisplayStrategy implements MapDisplayStrategy, OnMapReadyCallback {

   private Context appContext;
   private MapView mapView;

    public CrimeDisplayStrategy(Context appContext, MapView mapView) {
        this.appContext = appContext;
        this.mapView = mapView;
    }

    @Override
    public void display(Context appContext, MapView mapView) {
        mapView.getMapAsync(this::onMapReady);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}