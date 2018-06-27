package newGame;

import java.util.*;

public class GameData {
    private Map<String, Location> locations = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();

    public Location initialize(){
        // create locations and add them to a collection
        locations.put("elevator1", new Location("elevator","You are in an elevator and the doors are shut."));
        locations.put("hallway2", new Location("hallway", "You are in a hallway in front of elevators. " +
                                                                            "There is an open office to the west and " +
                                                                            "the hallway continues to the east." +
                                                                            "What would you like to do now?"));
        locations.put("office3", new Location("office","You arrived in the office. " +
                                                                            "You see some desks and chairs, one laptop on the nearest desk.\n " +
                                                                            "There are some papers with coffee cup stains on the papers scattered on the floor." +
                                                                            "\nThere is a printer in the corner.\n" +
                                                                            "What would you like to do now?"));

        locations.put("conference4", new Location("conference","You are in a mid-size negotiating room. " +
                                                                            "There is a table with six chairs around it and a large monitor on the \n" +
                                                                            "north wall above the table. There is a window to the east, \n" +
                                                                            "the orange window shades are pulled open and some office buildings \n" +
                                                                            "can be seen from the window.\n" +
                                                                            "You see a door to the east. What do you want to do?\n"));

        locations.put("leasegreen5", new Location("classroom","You are in a semi large classroom. \\n\" +\n" +
                                                            "                \"There is a U-shaped table in the middle\\n\" +\n" +
                                                            "                \"and some tables also by the east side of the wall. \\n\" +\n" +
                                                            "                \"The windows open to the west and you can see some office \\n\" +\n" +
                                                            "                \"buildings with white walls from the window across the street. \\n\" +\n" +
                                                            "                \"The room may be leased; it has a greenish feeling... \\n\" +\n" +
                                                            "                \"What do you want to do?"));
        locations.put("hallway6", new Location("hallway","You are in a hallway. There are elevators to the west.\\n\" +\n" +
                                                            "                \"To the east is a large open space surrounded by very cozy couches.\\n\" +\n" +
                                                            "                \"There is a large whitescreen to the south. The space is airy and \\n\" +\n" +
                                                            "                \"surrounded by windows to the south and east.\\n\" +\n" +
                                                            "                \"What do you want to do?"));
        locations.put("elevator1", new Location("livingroom","You are in the livingroom. \\n\" +\n" +
                                                             "                \"There are large couches and chairs around you."));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));
        locations.put("elevator1", new Location("elevator",""));

        // add exits to locations
        addExits(locations);

        // create items and add them to a list
        List<Item> items = new ArrayList<>();

        // add items to locations
        addItems(items);

        //set starting location
        Location currentLocation = locations.get("elevator1");
        return currentLocation;

    }

    private void addItems(List<Item> items) {

    }

    private void addExits(Map<String, Location> locations) {
        locations.get("elevator1")addExit(8, locations.get("hallway2"));

    }

    public Map<String, Location> getLocations() {
        return locations;
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
