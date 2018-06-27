package newGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {

    public void start(Scanner sc) {
        GameData gameData = new GameData();
        Player player = new Player();
        UserInterface ui = new UserInterface();
        Location currentLocation = gameData.initialize();
        Map<String, Location> allLocations = gameData.getLocations();


        // welcome player
        ui.welcome();

        game:
        while (true) {

            //print description of current locations
            System.out.println(currentLocation.getDescription());
            System.out.println("What would you like to do?");

            //print options for the player
            ui.printOptions(currentLocation,player);

            int command = sc.nextInt();
            if (command == 999) break;
            if (command == 22) break;

            //go to the next room
            if (command > 0 && command < 10) {
                Location nextLocation = currentLocation.getExits().get(command);

                if (nextLocation.isLocked()) {
                    System.out.println(nextLocation + " is locked.");
                    continue;
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

                currentLocation = nextLocation;
            }


        }





    }

}
