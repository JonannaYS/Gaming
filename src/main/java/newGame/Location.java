package newGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Täällä määritellään lokaatiot, joissa pelaaja voi liikkua
public class Location {
    private String name;
    private String description;
    private Map<Integer, Location> exits = new HashMap<>();
    private List<Item> items = new ArrayList<>();
    private boolean locked = false;
    private boolean lockedWithPasscode = false;
    private int passcode = 2613; // Jouni: The default passcode for e.g. the exits.

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
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

    public void lockWithPasscode(){
        this.lockedWithPasscode = true;
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

    public void setPasscode(int passcode) {
        this.passcode = passcode;
    }

    @Override
    public String toString() {
        return name ;
    }
}
