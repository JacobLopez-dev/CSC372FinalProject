package csc472.depaul.edu.chicagoneighborhoods.strategy;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.maps.android.data.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import csc472.depaul.edu.chicagoneighborhoods.R;

public class NeighborhoodDisplayStrategy  implements MapDisplayStrategy, OnMapReadyCallback {

    private Context appContext;
    private MapView mapView;

    public NeighborhoodDisplayStrategy(Context appContext, MapView mapView) {
        this.appContext = appContext;
        this.mapView = mapView;
    }

    @Override
    public void display(Context appContext, MapView mapView) {
        mapView.getMapAsync(this::onMapReady);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
       addNeighborhoodsLayerToMap(googleMap);
    }

    private void addNeighborhoodsLayerToMap(GoogleMap map) {
        try {
            KmlLayer layer = new KmlLayer(map, R.raw.neighorhoods, appContext);
            layer.addLayerToMap();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
