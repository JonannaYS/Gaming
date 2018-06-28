package newGame;

public class Item {
    private String name;
    private String description;
    private int weight = 0;
    private boolean movable;
    private boolean usable;
    private boolean actionable;


    public Item(String name, String description, int weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public Item(String name, String description, int weight, boolean movable, boolean usable, boolean actionable) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.movable = movable;
        this.usable = usable;
        this.actionable = actionable;
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

    public String getName () { return name; }

    public String getDescription() {
        return description;

    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name;
    }

    public boolean isMovable() { return movable; }

    public boolean usable() { return usable; }

    public boolean actionable() { return actionable; }
}
