package newGame;

import java.io.File;
import java.util.*;

public class GameData {
    private Map<String, Location> locations = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();

    public Location initialize(){
        // create locations and add them to a collection
        locations.put("elevator1", new Location("elevator","You are in an elevator and the doors are shut."));
        locations.put("hallway2", new Location("hallway", "You are in a hallway in front of elevators. " +
                                                                            "There is an open office to the west and " +
                                                                            "the hallway continues to the east."));
        locations.put("office3", new Location("office","You arrived in the office. " +
                                                                            "You see some desks and chairs, one laptop on the nearest desk.\n" +
                                                                            "There are some papers with coffee cup stains on the papers scattered on the floor." +
                                                                            "\nThere is a printer in the corner.\n"));

        locations.put("conference4", new Location("conference room","You are in a mid-size negotiating room. " +
                                                                            "There is a table with six chairs around it and a large monitor on the \n" +
                                                                            "north wall above the table. There is a window to the east, \n" +
                                                                            "the orange window shades are pulled open and some office buildings \n" +
                                                                            "can be seen from the window.\n" +
                                                                            "You see a door to the east.\n"));

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
        locations.put("couch7", new Location("living room","You are in the livingroom. \\n\" +\n" +
                                                             "                \"There are large couches and chairs around you."));
        locations.put("diningRoom8", new Location("dining room","You are in a hall. In the north there appears to be a kitchen.\\n\" +\n" +
                                                            "                \" In the south there are some couches."));
        locations.put("hallway9", new Location("hallway","You are in a hallway to the south there is a \" +\n" +
                                                            "                \"hallway leading to west around the wall to the east you see a \\n \" +\n" +
                                                            "                \"thick grey woollen felt wall hanging from the roof. It looks \\n \" +\n" +
                                                            "                \"sturdy. To the northwest there is a door to a toilet and  \\n \" +\n" +
                                                            "                \"to west there is a door to a maintenance room.  To southwest \\n \" +\n" +
                                                            "                \"there is door to another toilet. To north there is a large open \\n\" +\n" +
                                                            "                \" kitchen, you can smell a nice aroma of coffee from the kitchen. \\n\" +\n" +
                                                            "                \"What do you want to do?"));
        locations.put("toilet10", new Location("toilet","You can't enter the loo, you fool!"));
        locations.put("maintenance11", new Location("maintenance","The door is locked. You hear hushed sounds coming from the maintenance room!"));
        locations.put("toilet12", new Location("toilet","You can't enter the loo, you fool!"));
        locations.put("kitchen13", new Location("kitchen","You enter the kitchen. What do you do?"));
        locations.put("hallway14a", new Location("hallway","You are in a hallway. Hallway continues to the west. \\n\" +\n" +
                                                            "                \"There are two doors: one to the north and another to the east. \\n\" +\n" +
                                                            "                \"In the south there is a kitchen."));
        locations.put("hallway14b", new Location("hallway","You are in a hallway. Hallway continues to the north and to the east.\\n\" +\n" +
                                                             "                \" There is a door to the west. In the south there is a corner with a TV."));
        locations.put("conference15", new Location("conference room","You are in a room. There is currently nothing interesting in this room."));
        locations.put("accenture16", new Location("classroom","It's a classroom. You notice that the air in the room is thick and stale."));
        locations.put("conference17", new Location("conference room","You are in a room. There is currently nothing interesting in this room."));
        locations.put("hallway18", new Location("hallway","You are in a hallway of some sort. There is an exit in the west. \\n\" +\n" +
                                                            "                \"There is also two rooms north and north-east. \\n\" +\n" +
                                                            "                \"The hallway continues southwards."));
        locations.put("conference19", new Location("conference room","You are in a room. There is currently nothing interesting in this room."));
        locations.put("cSharp20", new Location("classroom","You are in a classroom. There is currently nothing interesting in this room."));
        locations.put("beanbags21", new Location("the beanbags","There are a few large and colourful beanbag chairs omn the floors.\\n\" +\n" +
                                                            "                \"They look very inviting. On the south wall there is a large monitor \\n\" +\n" +
                                                            "                \"where you see Fortnite running and waiting on a Playstation. \\n\" +\n" +
                                                            "                \"It appears even more inviting.\" +\n" +
                                                            "                \"What do you want to do?"));
        locations.put("exit22", new Location("exit"," "));
        locations.put("exit23", new Location("exit"," "));
        locations.put("toilet24", new Location("toilet","You can't enter the loo, you fool!"));
        locations.put("toilet25", new Location("toilet","You enter the toilet. As usual, there's no paper there. What do you do?"));
        locations.put("toilets26",new Location("toilets", "You are at toilets."));

        // add exits to locations
        addExits(locations);

        // create items and add them to a list
        List<Item> items = new ArrayList<>();

        // add items to locations
        addItems(items);

        //set starting location
        Location currentLocation = locations.get("hallway2");
        return currentLocation;

    }

    private void addItems(List<Item> items) {

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
