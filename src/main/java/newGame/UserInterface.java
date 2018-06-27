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

            if (!vowels.contains(currentLocation.getName().charAt(0))) {
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

    public void welcome() {
        System.out.println("Welcome");
    }

    public void examineRoom(Location currentLocation, Scanner sc) {
        if (currentLocation.getItems().isEmpty()) {
            System.out.println("There is nothing interesting in this " + currentLocation + ".");
        }

        else {
            System.out.println("You see these items: ");
            int commandIndex = 1;
            List<Item> movableItems = new ArrayList<>();

            for (Item item: currentLocation.getItems()) {
                System.out.println(item.toString());
                if (item.isMovable()) {
                    movableItems.add(item);
                }
            }

            System.out.println("What would you like to do?");
            for (Item movableItem: movableItems) {
                System.out.println("\t>" + commandIndex + " - take the " + movableItem + " with you.");
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

            passcode:
            while (true) {
                System.out.println("What's the passcode?");
                int passcode = sc.nextInt();

                if (passcode == nextLocation.getPasscode()) {
                    nextLocation.openWithPasscode();
                }
                else {
                    System.out.println("Wrong passcode! Try again?");
                    System.out.println("\t>1 - Yes");
                    System.out.println("\t>2 - No");
                    int choice = sc.nextInt();

                    if (choice == 1) continue passcode;
                    if (choice == 2) break passcode;
                }
            }

        }

        return nextLocation;
    }
}
