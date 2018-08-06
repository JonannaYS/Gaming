package newGame;

import java.util.ArrayList;
import java.util.List;

// Tässä määritellään pelaajan ominaisuuksia
// Hungerlevel määrittää sen, että pelaajan hahmon tulee syödä välillä
// voidakseen jatkaa pelaamista
// Kahvitaso on eräs mahdollisuus laajentaa vastaavaan
// ominaisuuteen kahvin juomisen kanssa. Rentoustaso voisi vaatia esim. rentoutumista
// tai vaikka mindfullnessharjoitusta tms.
public class Player {
    private String name;
    private int hungerLevel = 1;
    private int maxHungerLevel = 15;
    private List<Item> inventory = new ArrayList<>();
    private int maxInventorySize = 2;
    //    private int coffeeLevel = 100;
    //    private int relaxationLevel;
    //    private int health = 100;

    public Player (String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public void increaseHungerLevel() {
        if (this.hungerLevel <= 100) {
            this.hungerLevel ++;
        }
    }

    public boolean isTooHungry() {
        if (this.hungerLevel >= maxHungerLevel) {
            return true;
        } else {
            return false;
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void increaseInventorySize(Item bag) {
        if (this.inventory.contains(bag)) {
            this.maxInventorySize = 5;
        }
        else {
            this.maxInventorySize = 2;
        }
    }

    public boolean addItemToInventory(Item item){
        if (item.isMovable() && inventory.size() < maxInventorySize) {
            inventory.add(item);
            return true;
        }
        else {
            return false;
        }
    }

    public int getMaxInventorySize() {
        return maxInventorySize;
    }

    @Override
    public String toString() {
        return name;
    }

    // tällä metodilla tarkistetaan pelaajan hungerlevel taso
    public void checkHungerLevel() {
        if (this.getHungerLevel()==maxHungerLevel-6) {
            System.out.println("\nYou're starting to feel a bit light headed... You hear your stomach growling.\n");
            System.out.println("....................................................");
        } else if (this.getHungerLevel()==maxHungerLevel-3) {
            System.out.println("<WARNING>");
            System.out.println("\nYou should eat or drink something before you pass out.\n");
            System.out.println("....................................................");
        } else if (this.isTooHungry()) {
            System.out.println("\nYou're too hungry to do anything!\n");
            System.out.println("....................................................");
        }
    }
}
