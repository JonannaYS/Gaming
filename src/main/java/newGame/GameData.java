package newGame;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private List<Location> locations;
    private List<Item> items;

    public Location initialize(){
        // create locations
        Location currentLocation;
        Location elevator1 = new Location();
        Location hallway2 = new Location();
        Location office3 = new Location();

        // add locations to a list
        locations.add(elevator1);
        locations.add(hallway2);
        locations.add(office3);

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

    private void addExits(List<Location> locations) {

    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Item> getItems() {
        return items;
    }
}
