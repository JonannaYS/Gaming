package newGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public void printOptions(Location currentLocation, Player player){
        // 1-9) possible exits and their directions
        // 11) examine room (reveals a list of items in the room)
        // 12) check your inventory
        // 999) quit game
        Character [] vowelArray = {'a','e','i','o','u','y','ä','ö'};
        List<Character> vowels = new ArrayList<>(Arrays.asList(vowelArray));

        String direction = null;
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


    }

    public void welcome(Player player, Scanner sc) {
        System.out.println("==============< ESCAPE FROM ACADEMY >===============");
        System.out.print("Please enter your name: ");
        player.setName(sc.nextLine());
        System.out.println("Hello " + player + "!");
        System.out.println("====================================================");
    }

    public void examineRoom(Location currentLocation, Scanner sc, Player player, UserInterface ui) {
        checkHungerlevel(sc, player, currentLocation, ui);

        System.out.print(currentLocation.getDescription());
        if (currentLocation.getItems().isEmpty()) {
            player.increaseHungerLevel();
            checkHungerlevel(sc, player, currentLocation, ui);
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

            int command = sc.nextInt();
            int index = command-1;
            Item item = movableItems.get(index);

            if (command <= movableItems.size()) {
                examineItem(command,item,player,sc,currentLocation,ui);
            }
        }
    }

    private void examineItem(int command,Item item, Player player, Scanner sc, Location currentLocation, UserInterface ui) {
        checkHungerlevel(sc, player, currentLocation, ui);


        System.out.println(item.getDescription());
        System.out.println("....................................................");
        System.out.println("<COMMANDS>");
        System.out.println("\t>1 - take the " + item + " with you.");
        System.out.println("\t>2 - do nothing.");
        System.out.println("====================================================");

        command = sc.nextInt();
        if (command == 1) {
            takeItem(item,player,sc,currentLocation,ui);
        }

    }

    private void takeItem(Item item, Player player, Scanner sc, Location currentLocation, UserInterface ui) {

            if (player.addItemToInventory(item)) {
                checkHungerlevel(sc, player, currentLocation, ui);
                player.increaseHungerLevel();
                currentLocation.getItems().remove(item);
                System.out.println("You take the " + item + " with you.");
                System.out.println("....................................................");
            }
            else {
                checkHungerlevel(sc, player, currentLocation, ui);
                player.increaseHungerLevel();
                System.out.println("You can't carry more than "  + player.getMaxInventorySize() + " items.");
                System.out.println("====================================================");
            }

    }

    private void checkHungerlevel(Scanner sc, Player player, Location currentLocation, UserInterface ui) {

        if (player.tooHungry()) {
            System.out.println("You're too hungry to do anything. Maybe you should eat something?");
            System.out.println("....................................................");
            ui.startTheUserInterface(sc, player, currentLocation, ui);
        }
        if (player.getHungerLevel()==11) {
            System.out.println("You're starting to feel light headed... You feel your stomach growling.");
            System.out.println("....................................................");
        }
        if (player.getHungerLevel()==13) {
            System.out.println("You're starting to feel light headed... You feel your stomach growling.");
            System.out.println("....................................................");
        }
    }

    public Location moveToLocation(Player player, Location currentLocation, Scanner sc, int command, UserInterface ui) {
        Location nextLocation = currentLocation.getExits().get(command);

        if (nextLocation.isLocked()) {
            System.out.println(nextLocation + " is locked.");
            return currentLocation;
        }

        else if (nextLocation.isLockedWithPasscode()) {
            System.out.println("This room is locked with a passcode.");
            while (true) {
                player.increaseHungerLevel();
                player.increaseHungerLevel();
                checkHungerlevel(sc, player, currentLocation, ui);
                System.out.println("....................................................");
                System.out.print("Passcode: ");
                int passcode = sc.nextInt();

                if (passcode == nextLocation.getPasscode()) {
                    player.increaseHungerLevel();
                    System.out.println("....................................................");
                    System.out.println("Correct! The door is now unlocked.");

                    nextLocation.openWithPasscode();
                    break;
                }
                else {
                    player.increaseHungerLevel();
                    System.out.println("....................................................");
                    System.out.println("Wrong passcode! Try again?");
                    System.out.println("\t>1 - Yes");
                    System.out.println("\t>2 - No");
                    int choice = sc.nextInt();

                    if (choice == 1) continue;
                    if (choice == 2) return currentLocation;
                }
            }
        }

        System.out.println("You left the " + currentLocation + " and moved to the " + nextLocation + ".");
        System.out.println("....................................................");
        return nextLocation;
    }

    public void winGame(Player player) {
        System.out.println();
        String congratulations = "Pop the champagne "+ player + "!!! You got succesfully out of the building and won the game!";
        CowSay.callTheCow(congratulations);
        // System.out.println("Congratulations " + player + "! You made it succesfully out of the building and won the game!" );
        System.exit(0);
    }

    public void checkInventory(Scanner sc, Player player, Location currentLocation, UserInterface ui) {
            checkHungerlevel(sc, player, currentLocation, ui);
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

            int command = sc.nextInt();
            int index = command-1;

            if (command <= player.getInventory().size()) {
                System.out.println(player.getInventory().get(index).getDescription());
                System.out.println("....................................................");
                checkInventory(sc,player,currentLocation,ui);
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

    public void startTheUserInterface(Scanner sc, Player player, Location currentLocation, UserInterface ui){
        while (true) {
            try {
                if (currentLocation.getName().substring(0, 4).equals("exit")) {
                    winGame(player);
                }

                //print description of current location
                System.out.println("-" + currentLocation.getName().toUpperCase() + "-");
                System.out.println();
                System.out.println("You are currently in the " + currentLocation + ".");

                System.out.println("....................................................");

                //print options for the player
                System.out.println("<COMMANDS>");
                printOptions(currentLocation, player);
                System.out.println("====================================================");

                int command = Integer.parseInt(sc.nextLine());

                if (command == 999) {
                    System.out.println("....................................................");
                    System.out.println("====================================================");
                    System.out.println("Thanks for playing!");
                    break;
                }
                if (command == 11) {
                    System.out.println("....................................................");
                    examineRoom(currentLocation, sc, player, ui);
                }

                if (command == 22) {
                    System.out.println("....................................................");
                    checkInventory(sc, player, currentLocation, ui);
                }

                if (command > 0 && command < 10) {

                    currentLocation = moveToLocation(player, currentLocation, sc, command, ui);
                }

            } catch (Exception e) {
                System.out.println("Only numbers, please!");
                System.out.println("====================================================");
            }
        }
    }
}
