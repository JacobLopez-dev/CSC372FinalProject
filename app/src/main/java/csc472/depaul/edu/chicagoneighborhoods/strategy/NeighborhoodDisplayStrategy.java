package csc472.depaul.edu.chicagoneighborhoods.strategy;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.data.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import csc472.depaul.edu.chicagoneighborhoods.R;

public class NeighborhoodDisplayStrategy implements MapDisplayStrategy {

    public void displaySelectedData(Context appContext, GoogleMap googleMap) {
        addNeighborhoodsLayerToMap(appContext, googleMap);
    }

    private void addNeighborhoodsLayerToMap(Context appContext, GoogleMap map) {
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
