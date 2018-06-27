package newGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    private String name;
    private String description;
    private Map<Integer, Location> exits = new HashMap<>();
    private List<Item> items = new ArrayList<>();
    private boolean locked = false;
    private boolean lockedWithPasscode = false;
    private int passcode = 1234;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Location(String name, String description, boolean locked, boolean lockedWithPasscode, int passcode) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.lockedWithPasscode = lockedWithPasscode;
        this.passcode = passcode;
    }

    public void addExit (int directionNumber, Location exitFromPresent)   {
        exits.put(directionNumber,exitFromPresent);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<Integer, Location> getExits() {
        return exits;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isLocked() {
        return locked;
    }

    public void openLock() {
        this.locked = false;
    }

    public void openWithPasscode(){
        this.lockedWithPasscode = false;
    }

    public boolean isLockedWithPasscode() {
        return lockedWithPasscode;
    }

    public int getPasscode() {
        return passcode;
    }

    @Override
    public String toString() {
        return name ;
    }
}
