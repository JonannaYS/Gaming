package newGame;

import java.io.File;
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
        initializeTheLocations();

        // add exits to locations
        addExits(locations);

        // create items from a text file and add them to a map
        initializeItems();

        // add items to locations
        addItemsToLocations(locations,items);

        //set starting location
        return locations.get("elevator1");
    }

    private void addItemsToLocations(Map<String,Location> locations, Map<String,Item> items) {

        ArrayList<String> locationsOrdered = new ArrayList<>(locations.keySet());
        // The item locations are randomized
        for (Item item: items.values()) {
            String randomLocation = locationsOrdered.get(random.nextInt(locationsOrdered.size()));
            if (item.isMovable()) {
                locations.get(randomLocation).addItem(item);
            }
        }
        // One fixed item is added to the elevator: The code to exit the elevator
        locations.get("elevator1").addItem(new Item("A paper note","There are numbers 9372 written on the note",0,true,true,true));
    }

    private void initializeItems() {
        try (Scanner fileReader = new Scanner(new File("src/main/text/items.txt"))){

            while (fileReader.hasNextLine()) {
                String name = fileReader.nextLine().toLowerCase();
                String description = fileReader.nextLine();
                int weight = Integer.parseInt(fileReader.nextLine());
                String attributes = fileReader.nextLine();
                Item item = new Item(name,description,weight);
                items.put(name, item);

                if (attributes.contains("move")) item.setMovable(true);
                if (attributes.contains("eat")) item.setConsumable(true);
                if (attributes.contains("use")) item.setUsable(true);
                if (attributes.contains("act")) item.setActionable(true);





//                boolean movable = fileReader.nextBoolean();
//                if (fileReader.hasNextLine()) { fileReader.nextLine(); }
//                boolean usable = fileReader.nextBoolean();
//                if (fileReader.hasNextLine()) { fileReader.nextLine(); }
//                boolean actionable = fileReader.nextBoolean();
//                if (fileReader.hasNextLine()) {
//                    fileReader.nextLine();
//                }
//                items.put(name,new Item(name,description,weight,movable,usable,actionable));

            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeTheLocations() {
        try (Scanner fileReader = new Scanner(new File("src/main/text/Locations2.txt"))){

            while (fileReader.hasNextLine()) {
                String key = fileReader.nextLine();
                String name = fileReader.nextLine();
                StringBuilder sb = new StringBuilder();
                while (fileReader.hasNextLine()) {
                    String partialDescription = fileReader.nextLine();
                    if (partialDescription.isEmpty()) break;
                    sb.append(partialDescription).append("\n");
                }
                String description = sb.toString();
                locations.put(key,new Location(name, description));
                if (key.equals("hallway2")) {
                    lockWithPasscodeAtBeginning(key, name);

                }
                if (key.equals("exit22") || key.equals("exit23")) {
                    lockWithPasscodeAtBeginning(key, name);
                }
            }
            // The passcode to exit to hallway2 from the elevator is set.
            locations.get("hallway2").setPasscode(9372);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lockWithPasscodeAtBeginning(String key, String exitPointName){
        locations.put(key, locations.get(key)).lockWithPasscode();
    }

    public void createLocation (String key, Location location ) {
        locations.put(key, location);
    }

    private void addExits(Map<String, Location> locations) {
        try (Scanner fileReader = new Scanner(new File("src/main/text/exits2.txt"))){

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
