package newGame;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class GameData {
    private Map<String, Location> locations = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();
    private Random random;

    public GameData(Random random) {
        this.random = random;
    }

    public Location initializeGame(){
        // create locations and add them to a collection
        initializeLocations();

        // add exits to locations
        addExits(locations);

        // create items from a text file and add them to a map
        initializeItems();

        // add items to locations
        addItemsToLocations(locations,items);

        //set starting location
        Location currentLocation = locations.get("elevator1");
        return currentLocation;
    }

    private void addItemsToLocations(Map<String,Location> locations, Map<String,Item> items) {

//        ArrayList<String> locationsOrdered = new ArrayList<>(locations.keySet());
        ArrayList<String> locationsOrdered = new ArrayList<>();
        locationsOrdered.add("elevator1");

        for (Item item: items.values()) {
            String randomLocation = locationsOrdered.get(random.nextInt(locationsOrdered.size()));
            locations.get(randomLocation).addItem(item);
        }
    }

    private void initializeItems() {
        try (Scanner fileReader = new Scanner(new File("src/main/text/items.txt"))){

            outer:
            while (fileReader.hasNextLine()) {
                String name = fileReader.nextLine();
                String description = fileReader.nextLine();
                int weight = Integer.parseInt(fileReader.nextLine());
                items.put(name,new Item(name,description,weight));
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createLocation (String key, Location location ) {
        locations.put(key, location);
    }

    public void initializeLocations() {
        createLocation("elevator1", new Location("elevator","You are in an elevator and the doors are shut."));
        createLocation("hallway2", new Location("hallway", "You are in a hallway in front of elevators. " +
                "There is an open office to the west and " +
                "the hallway continues to the east."));
        createLocation("office3", new Location("office","You arrived in the office. " +
                "You see some desks and chairs, one laptop on the nearest desk.\n" +
                "There are some papers with coffee cup stains on the papers scattered on the floor." +
                "\nThere is a printer in the corner.\n"));

        createLocation("conference4", new Location("conference room","You are in a mid-size negotiating room. " +
                "There is a table with six chairs around it and a large monitor on the \n" +
                "north wall above the table. There is a window to the east, \n" +
                "the orange window shades are pulled open and some office buildings \n" +
                "can be seen from the window.\n" +
                "You see a door to the east.\n"));

        createLocation("leasegreen5", new Location("classroom","You are in a semi large classroom. \\n\" +\n" +
                "                \"There is a U-shaped table in the middle\\n\" +\n" +
                "                \"and some tables also by the east side of the wall. \\n\" +\n" +
                "                \"The windows open to the west and you can see some office \\n\" +\n" +
                "                \"buildings with white walls from the window across the street. \\n\" +\n" +
                "                \"The room may be leased; it has a greenish feeling... \\n\" +\n" +
                "                \"What do you want to do?"));
        createLocation("hallway6", new Location("hallway","You are in a hallway. There are elevators to the west.\\n\" +\n" +
                "                \"To the east is a large open space surrounded by very cozy couches.\\n\" +\n" +
                "                \"There is a large whitescreen to the south. The space is airy and \\n\" +\n" +
                "                \"surrounded by windows to the south and east.\\n\" +\n" +
                "                \"What do you want to do?"));
        createLocation("couch7", new Location("living room","You are in the livingroom. \\n\" +\n" +
                "                \"There are large couches and chairs around you."));
        createLocation("diningRoom8", new Location("dining room","You are in a hall. In the north there appears to be a kitchen.\\n\" +\n" +
                "                \" In the south there are some couches."));
        createLocation("hallway9", new Location("hallway","You are in a hallway to the south there is a \" +\n" +
                "                \"hallway leading to west around the wall to the east you see a \\n \" +\n" +
                "                \"thick grey woollen felt wall hanging from the roof. It looks \\n \" +\n" +
                "                \"sturdy. To the northwest there is a door to a toilet and  \\n \" +\n" +
                "                \"to west there is a door to a maintenance room.  To southwest \\n \" +\n" +
                "                \"there is door to another toilet. To north there is a large open \\n\" +\n" +
                "                \" kitchen, you can smell a nice aroma of coffee from the kitchen. \\n\" +\n" +
                "                \"What do you want to do?"));
        createLocation("toilet10", new Location("toilet","You can't enter the loo, you fool!"));
        createLocation("maintenance11", new Location("maintenance","The door is locked. You hear hushed sounds coming from the maintenance room!"));
        createLocation("toilet12", new Location("toilet","You can't enter the loo, you fool!"));
        createLocation("kitchen13", new Location("kitchen","You enter the kitchen. What do you do?"));
        createLocation("hallway14a", new Location("hallway","You are in a hallway. Hallway continues to the west. \\n\" +\n" +
                "                \"There are two doors: one to the north and another to the east. \\n\" +\n" +
                "                \"In the south there is a kitchen."));
        createLocation("hallway14b", new Location("hallway","You are in a hallway. Hallway continues to the north and to the east.\\n\" +\n" +
                "                \" There is a door to the west. In the south there is a corner with a TV."));
        createLocation("conference15", new Location("conference room","You are in a room. There is currently nothing interesting in this room."));
        createLocation("accenture16", new Location("classroom","It's a classroom. You notice that the air in the room is thick and stale."));
        createLocation("conference17", new Location("conference room","You are in a room. There is currently nothing interesting in this room."));
        createLocation("hallway18", new Location("hallway","You are in a hallway of some sort. There is an exit in the west. \\n\" +\n" +
                "                \"There is also two rooms north and north-east. \\n\" +\n" +
                "                \"The hallway continues southwards."));
        createLocation("conference19", new Location("conference room","You are in a room. There is currently nothing interesting in this room."));
        createLocation("cSharp20", new Location("classroom","You are in a classroom. There is currently nothing interesting in this room."));
        createLocation("beanbags21", new Location("room with beanbags","There are a few large and colourful beanbag chairs omn the floors.\\n\" +\n" +
                "                \"They look very inviting. On the south wall there is a large monitor \\n\" +\n" +
                "                \"where you see Fortnite running and waiting on a Playstation. \\n\" +\n" +
                "                \"It appears even more inviting.\" +\n" +
                "                \"What do you want to do?"));
        createLocation("exit22", new Location("exit"," ",false,true,1234));
        createLocation("exit23", new Location("exit"," ",false,true,1234));
        createLocation("toilet24", new Location("toilet","You can't enter the loo, you fool!"));
        createLocation("toilet25", new Location("toilet","You enter the toilet. As usual, there's no paper there. What do you do?"));
        createLocation("toilets26",new Location("toilets", "You are at toilets."));
    }

    private void addExits(Map<String, Location> locations) {
        try (Scanner fileReader = new Scanner(new File("src/main/text/exits.txt"))){

            outer:
            while (fileReader.hasNextLine()) {

                Location currentLocation = locations.get(fileReader.nextLine());

                while (fileReader.hasNextLine()) {
                    String [] exitNumberAndName = fileReader.nextLine().split(" ");

                    if (exitNumberAndName[0].equals("")) {
                        continue outer;
                    }

                    int number = Integer.parseInt(exitNumberAndName[0]);
                    Location exit = locations.get(exitNumberAndName[1]);
                    currentLocation.addExit(number,exit);
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Map<String, Location> getLocations() {
        return locations;
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
