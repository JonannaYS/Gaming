package newGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public void startTheUserInterface(Scanner sc, Player player, Location currentLocation){

        //welcome player
        welcome(player, sc);

        while (true) {
            try {
                if (currentLocation.getName().substring(0, 4).equals("exit")) {
                    winGame(player);
                }

                //print the current location
                printCurrentLocation(currentLocation);

                //print options for the player
                printOptions(currentLocation, player);

                int command = Integer.parseInt(sc.nextLine());

                if (command > 0 && command < 10) {
                    currentLocation = moveToLocation(player, currentLocation, sc, command);
                }

                if (command == 11) { // examine room
                    System.out.println("....................................................");
                    examineRoom(currentLocation, sc, player);

                }

                if (command == 22) { // check inventory
                    System.out.println("....................................................");
                    checkInventory(sc, player, currentLocation);
                }

                if (command == 999) { //quit game
                    System.out.println("....................................................");
                    System.out.println("====================================================");
                    System.out.println("Thanks for playing!");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Only numbers, please!");
                System.out.println("====================================================");
            }

        }
    }

    public void welcome(Player player, Scanner sc) {
        System.out.println("==============< ESCAPE FROM ACADEMY >===============");
        System.out.print("Please enter your name: ");
        player.setName(sc.nextLine());
        System.out.println("Hello " + player + "!");
        System.out.println("====================================================");
    }

    private void printCurrentLocation(Location currentLocation) {
        System.out.println("-" + currentLocation.getName().toUpperCase() + "-");
        System.out.println();
        System.out.println("You are currently in the " + currentLocation + ".");
        System.out.println("....................................................");
    }

    public void printOptions(Location currentLocation, Player player){
        // 1-9) possible exits and their directions
        // 11) examine room (reveals a list of items in the room)
        // 12) check your inventory
        // 999) quit game
        Character [] vowelArray = {'a','e','i','o','u','y','ä','ö'};
        List<Character> vowels = new ArrayList<>(Arrays.asList(vowelArray));

        String direction = null;
        System.out.println("<COMMANDS>");
        for (Integer directionNumber: currentLocation.getExits().keySet()) {
            switch (directionNumber) {
                case 1:
                    direction = "southwest";
                    break;
                case 2:
                    direction = "south";
                    break;
                case 3:
                    direction = "southeast";
                    break;
                case 4:
                    direction = "west";
                    break;
                case 6:
                    direction = "east";
                    break;
                case 7:
                    direction = "northwest";
                    break;
                case 8:
                    direction = "north";
                    break;
                case 9:
                    direction = "northeast";
                    break;
            }
            // getting the right article in front of items: a or an depending on the first vowel
            if (vowels.contains(currentLocation.getExits().get(directionNumber).getName().charAt(0))) {
                System.out.println("\t>" + directionNumber + " - continue " + direction + " to an " + currentLocation.getExits().get(directionNumber));
            }

            else {
                System.out.println("\t>" + directionNumber + " - continue " + direction + " to a " + currentLocation.getExits().get(directionNumber));
            }
        }

        System.out.println("\t>11 - examine the " + currentLocation);
        System.out.println("\t>22 - check your inventory");
        System.out.println("\t>999 - quit game");
        System.out.println("====================================================");

    }

    public Location moveToLocation(Player player, Location currentLocation, Scanner sc, int command) {
        Location nextLocation = currentLocation.getExits().get(command);

        if (nextLocation.isLocked()) {
            System.out.println(nextLocation + " is locked.");
            return currentLocation;
        }

        else if (nextLocation.isLockedWithPasscode()) {
            System.out.println("This door is locked with a passcode.");
            while (true) {
                player.checkHungerLevel();
                if (player.tooHungry()) return currentLocation;
                player.increaseHungerLevel();

                System.out.println("....................................................");
                System.out.print("Passcode: ");
                int passcode = Integer.parseInt(sc.nextLine());

                if (passcode == nextLocation.getPasscode()) {
                    System.out.println("....................................................");
                    System.out.println("Correct! The door is now unlocked.");

                    nextLocation.openWithPasscode();
                    break;
                }
                else {
                    System.out.println("....................................................");
                    System.out.println("Wrong passcode! Try again?");
                    System.out.println("\t>1 - Yes");
                    System.out.println("\t>2 - No");
                    int choice = Integer.parseInt(sc.nextLine());

                    if (choice == 1) continue;
                    if (choice == 2) return currentLocation;
                }
            }

        }

        System.out.println("You left the " + currentLocation + " and moved to the " + nextLocation + ".");
        System.out.println("....................................................");
        return nextLocation;
    }

    public void examineRoom(Location currentLocation, Scanner sc, Player player) {
        // if too hungry, can't do anything
        player.checkHungerLevel();
        if (player.tooHungry()) return;

        System.out.print(currentLocation.getDescription());
        if (currentLocation.getItems().isEmpty()) {
            player.increaseHungerLevel();
            player.checkHungerLevel();
            if (player.tooHungry()) return;
            System.out.println("There is nothing interesting in this " + currentLocation + ".");
            System.out.println("....................................................");
        }

        else {
            System.out.println("The " + currentLocation + " seems to contain these items: ");
            for (Item item: currentLocation.getItems()) {
                System.out.println("- " + item);
            }
            int commandIndex = 1;
            List<Item> movableItems = new ArrayList<>();

            for (Item item: currentLocation.getItems()) {
                if (item.isMovable()) {
                    movableItems.add(item);
                }
            }
            System.out.println("....................................................");
            System.out.println("<COMMANDS>");

            for (Item movableItem: movableItems) {
                System.out.println("\t>" + commandIndex + " - examine the " + movableItem + ".");
                commandIndex++;
            }
            System.out.println("\t>" + commandIndex + " - do nothing.");
            System.out.println("====================================================");

            int command = Integer.parseInt(sc.nextLine());
            int index = command-1;
            Item item = movableItems.get(index);

            if (command <= movableItems.size()) {
                examineItem(command,item,player,sc,currentLocation);
            }
        }
    }

    public void checkInventory(Scanner sc, Player player, Location currentLocation) {
        player.checkHungerLevel();
        if (player.tooHungry()) return;
        player.increaseHungerLevel();

        if (player.getInventory().size() == 0) {
            System.out.println("You don't have any items with you.");
            System.out.println("You can carry a maximum of " + player.getMaxInventorySize() + " items.");
            System.out.println("....................................................");
        }
        else {
            System.out.println("You currently carry these items: ");
            for (Item item: player.getInventory()) {
                System.out.println(item);
            }

            System.out.println("You can carry a maximum of " + player.getMaxInventorySize() + " items.");
            System.out.println("....................................................");
            System.out.println("What would you like to do?");
            int commandIndex = 1;

            for (Item item: player.getInventory()) {
                System.out.println("\t>" + commandIndex + " - examine the " + item);
                commandIndex++;
            }

            for (Item item: player.getInventory()) {
                System.out.println("\t>" + commandIndex + " - leave the " + item + " in the " + currentLocation.getName());
                commandIndex++;
            }
            System.out.println("\t>" + commandIndex + " - do nothing.");
            System.out.println("====================================================");

            int command = Integer.parseInt(sc.nextLine());
            int index = command-1;

            if (command <= player.getInventory().size()) {
                System.out.println(player.getInventory().get(index).getDescription());
                System.out.println("....................................................");
                checkInventory(sc,player,currentLocation);
            }


            else if (command <= player.getInventory().size()*2) {
                index -= player.getInventory().size();
                Item item = player.getInventory().get(index);
                currentLocation.addItem(item);
                player.getInventory().remove(index);
                System.out.println("You left the " + item + " in the " + currentLocation);
                System.out.println("....................................................");
            }

        }
    }

    private void examineItem(int command,Item item, Player player, Scanner sc, Location currentLocation) {
        player.checkHungerLevel();
        if (player.tooHungry()) return;

        System.out.println(item.getDescription());
        System.out.println("....................................................");
        int commandIndex = 1;
        int foodCommand = 99999;
        System.out.println("<COMMANDS>");
        System.out.println("\t>" + (commandIndex++) + " - take the " + item + " with you.");
        if (item.isConsumable()) {
            foodCommand = commandIndex;
            System.out.println("\t>" + (commandIndex++) + " - consume the " + item);
        }
        System.out.println("\t>" + (commandIndex) + " - do nothing.");
        System.out.println("====================================================");

        command = Integer.parseInt(sc.nextLine());
        if (command == 1) {
            takeItem(item,player,currentLocation);
        }

        if (command == foodCommand) {
            player.getInventory().remove(item);
            player.setHungerLevel(1);
        }

    }

    private void takeItem(Item item, Player player, Location currentLocation) {

            if (player.addItemToInventory(item)) {
                player.checkHungerLevel();
                if (player.tooHungry()) return;
                player.increaseHungerLevel();
                currentLocation.getItems().remove(item);
                System.out.println("You take the " + item + " with you.");
                System.out.println("....................................................");
            }
            else {
                player.checkHungerLevel();
                if (player.tooHungry()) return;
                player.increaseHungerLevel();
                System.out.println("You can't carry more than "  + player.getMaxInventorySize() + " items.");
                System.out.println("====================================================");
            }

    }

    public void winGame(Player player) {
        System.out.println();
        String congratulations = "Pop the champagne "+ player + "!!! You got succesfully out of the building and won the game!";
        CowSay.callTheCow(congratulations);
        System.exit(0);
    }
}