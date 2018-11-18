package csc472.depaul.edu.chicagoneighborhoods.strategy;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.data.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import csc472.depaul.edu.chicagoneighborhoods.R;
import csc472.depaul.edu.chicagoneighborhoods.csc472.depaul.edu.chicagoneighborhoods.utils.KmlUtils;

public class NeighborhoodDisplayStrategy implements MapDisplayStrategy {

    public void displaySelectedData(Context appContext, GoogleMap googleMap) {
        KmlUtils.addLayerToMap(appContext, googleMap, R.raw.neighorhoods);
    }
}
