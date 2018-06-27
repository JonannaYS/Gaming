package newGame;

public class Item {
    private String name;
    private String description;
    private int weight;
    private boolean movable;

    public Item(String name, String description, int weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public Item(String name, String description, int weight, boolean movable) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.movable = movable;
    }

    //Minimum constructor for an item: Name and weight
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName () {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name;
    }


}
