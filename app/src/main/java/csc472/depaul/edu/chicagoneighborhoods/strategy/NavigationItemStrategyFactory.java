package csc472.depaul.edu.chicagoneighborhoods.strategy;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;

import csc472.depaul.edu.chicagoneighborhoods.R;

public class NavigationItemStrategyFactory {
    public static MapDisplayStrategy getMapObjectStrategy(Context appContext, MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.kml_id:
                Toast.makeText(appContext, "Neighborhood layer", Toast.LENGTH_LONG).show();
                return new NeighborhoodDisplayStrategy();
            case R.id.food_id:
                Toast.makeText(appContext, "food layer", Toast.LENGTH_LONG).show();
                return new FoodDisplayStrategy();
            case R.id.drink_id:
                Toast.makeText(appContext, "drink layer", Toast.LENGTH_LONG).show();
                return new DrinkDisplayStrategy();
            case R.id.transit_id:
                Toast.makeText(appContext, "transit layer", Toast.LENGTH_LONG).show();
                return new TransitDisplayStrategy();
            case R.id.crime_id:
                Toast.makeText(appContext, "crime layer", Toast.LENGTH_LONG).show();
                return new CrimeDisplayStrategy();
             default:
                 return new NeighborhoodDisplayStrategy();
        }
    }
}