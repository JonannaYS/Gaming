package newGame;

public class Item {
    private String name;
    private String description = "This item is not interesting at all.";
    private int weight = 0;
    private boolean movable = false;
    private boolean usable = false;
    private boolean actionable = false;
    private boolean consumable = false;


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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public boolean isActionable() {
        return actionable;
    }

    public void setActionable(boolean actionable) {
        this.actionable = actionable;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
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
