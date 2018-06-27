package newGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameData {
    private Map<String, Location> locations;
    private Map<String, Item> items;

    public Location initialize(){
        // create locations and add them to a collection
        locations.put("elevator1", new Location("elevator","You are in an elevator"));
        locations.put("hallway2", new Location("Hallway (south)",))


        // add exits to locations
        addExits(locations);

        // create items and add them to a list
        List<Item> items = new ArrayList<>();

        // add items to locations
        addItems(items);

        //set starting location
        return currentLocation;

    }

    private void addItems(List<Item> items) {

    }

    private void addExits(Map<String, Location> locations) {

    }

    public Map<String, Location> getLocations() {
        return locations;
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
