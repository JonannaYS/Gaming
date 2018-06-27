package newGame;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private int maximumWeight;
    private List<Item> inventory;

    public Bag(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.inventory = new ArrayList<>();
    }

    public int getMaximumWeight() {
        return maximumWeight;
    }

    public int getWeight() {
        int weight = 0;
        for (Item item : inventory) {
            weight += item.getWeight();
        }
        return weight;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public boolean addItem(Item item) {
        // checks if bag can have more items put into
        if (this.getWeight() + item.getWeight() <= this.maximumWeight) {
            inventory.add(item);
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return inventory.size();
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "The bag appears to be empty now. \n" +
                    "What if you put some item you found in the bag? ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The bag contains ").append(this.size()).append(" items:");

        for (Item item : inventory) {
            sb.append("\n").append(item.getName());
        }
        return sb.toString();
    }
}

