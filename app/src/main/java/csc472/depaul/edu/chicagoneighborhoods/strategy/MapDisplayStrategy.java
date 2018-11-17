package csc472.depaul.edu.chicagoneighborhoods.strategy;

import android.content.Context;
import com.google.android.gms.maps.MapView;

public interface MapDisplayStrategy {
    public void display(Context appContext, MapView mapView);
}
