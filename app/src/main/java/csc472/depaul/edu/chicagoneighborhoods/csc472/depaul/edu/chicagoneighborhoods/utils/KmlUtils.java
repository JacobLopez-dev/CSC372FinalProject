package csc472.depaul.edu.chicagoneighborhoods.csc472.depaul.edu.chicagoneighborhoods.utils;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.data.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class KmlUtils {

    public static void addLayerToMap(Context appContext, GoogleMap map, int kmlId) {
        try {
            KmlLayer layer = new KmlLayer(map, kmlId, appContext);
            layer.addLayerToMap();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
