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

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Location(String name, String description, boolean locked, boolean lockedWithPasscode) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.lockedWithPasscode = lockedWithPasscode;
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

    public List<Item> getItems() {
        return items;
    }

    public boolean isLocked() {
        return locked;
    }

    public void openLock(Boolean locked) {
        if (this.locked == true) {
            this.locked = false;
        }
    }

    public boolean isLockedWithPasscode() {
        return lockedWithPasscode;
    }

    @Override
    public String toString() {
        return name ;
    }
}
