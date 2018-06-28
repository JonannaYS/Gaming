package newGame;

import java.sql.SQLOutput;
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
        System.out.print("Please enter your name: ");
        player.setName(sc.nextLine());
        System.out.println("Hello " + player + "!");
        System.out.println("====================================================");
    }



    public void examineRoom(Location currentLocation, Scanner sc, Player player, UserInterface ui) {
        player.increaseHungerLevel();

        if (player.tooHungry()) {
            System.out.println("too hungery");
            ui.startTheUserInterface(sc, player, currentLocation, ui);
        }

        if (currentLocation.getItems().isEmpty()) {
            System.out.println("There is nothing interesting in this " + currentLocation + ".");
            System.out.println("....................................................");
        }

        else {

            System.out.println("The " + currentLocation + " seems to contain these items: ");
            for (Item item: currentLocation.getItems()) {
                System.out.println(item);
            }
            int commandIndex = 1;
            List<Item> movableItems = new ArrayList<>();

            for (Item item: currentLocation.getItems()) {
                if (item.isMovable()) {
                    movableItems.add(item);
                }
            }
            System.out.println("....................................................");
            System.out.println("What would you like to do?");

            for (Item movableItem: movableItems) {
                System.out.println("\t>" + commandIndex + " - take the " + movableItem + " with you.");
                commandIndex++;
            }
            System.out.println("\t>" + commandIndex + " - do nothing.");
            System.out.println("====================================================");

            int command = sc.nextInt();

            if (command <= movableItems.size()) {
                int index = command-1;
                Item item = movableItems.get(index);
                if (player.addItemToInventory(item)) {
                    player.increaseHungerLevel();
                    currentLocation.getItems().remove(item);
                    System.out.println("You take the " + item + " with you.");
                    System.out.println("....................................................");
                }
                else {
                    player.increaseHungerLevel();
                    System.out.println("You can't carry more than "  + player.getMaxInventorySize() + " items.");
                    System.out.println("====================================================");
                }
            }
        }
    }

    public Location moveToLocation(Location currentLocation, Scanner sc, int command) {
        Location nextLocation = currentLocation.getExits().get(command);

        if (nextLocation.isLocked()) {
            System.out.println(nextLocation + " is locked.");
            return currentLocation;
        }

        else if (nextLocation.isLockedWithPasscode()) {

            while (true) {
                System.out.println("....................................................");
                System.out.println("What's the passcode?");
                int passcode = sc.nextInt();

                if (passcode == nextLocation.getPasscode()) {
                    System.out.println("Correct! The door is now unlocked.");
                    nextLocation.openWithPasscode();
                    break;
                }
                else {
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
        System.out.println("Congratulations " + player + "! You made it succesfully out of the building and won the game!" );
        System.exit(0);
    }

    public void checkInventory(Scanner sc, Player player, Location currentLocation) {

//        player.addItemToInventory(new Item("vasara","vasara",1,true));
//        player.addItemToInventory(new Item("kengät","nämä ovat kengät",1,true));
//        player.addItemToInventory(new Item("sukat","nämä ovat sukat",1,true));

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
                checkInventory(sc,player,currentLocation);
            }


            else if (command <= player.getInventory().size()*2) {
                index -= player.getInventory().size();
                Item item = player.getInventory().get(index);
                currentLocation.addItem(item);
                player.getInventory().remove(index);
                System.out.println("You left the " + item + " in the " + currentLocation);
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
                System.out.println();
                System.out.println(currentLocation.getDescription());

                System.out.println("....................................................");
                System.out.println("What would you like to do?");

                //print options for the player
                printOptions(currentLocation, player);
                System.out.println("====================================================");

                int command = sc.nextInt();

                if (command == 999) {
                    System.out.println("====================================================");
                    System.out.println("Thanks for playing!");
                    break;
                }
                if (command == 11) {
                    System.out.println("....................................................");
                    examineRoom(currentLocation, sc, player,ui);
                }

                if (command == 22) {
                    System.out.println("....................................................");
                    checkInventory(sc, player, currentLocation);
                }

                if (command > 0 && command < 10) {

                    currentLocation = moveToLocation(currentLocation, sc, command);
                }
            } catch (NullPointerException n) {
                continue;
            }
        }

    }

}
