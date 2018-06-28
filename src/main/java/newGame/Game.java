package newGame;

import java.util.*;

public class Game {

    public void start(Scanner sc, Random random) {
        Player player = new Player("stranger");
        UserInterface ui = new UserInterface();
        GameData gameData = new GameData(random);
        Location currentLocation = gameData.initializeGame();
        Map<String, Location> allLocations = gameData.getLocations();


        // welcome player
        ui.welcome(player, sc);

        game:
        while (true) {
            if (currentLocation.getName().substring(0,4).equals("exit")) {
                ui.winGame();
            }

            //print description of current location
            System.out.println("====================================================");
            System.out.println(currentLocation.getDescription());
            System.out.println("What would you like to do?");

            //print options for the player
            ui.printOptions(currentLocation,player);
            System.out.println("====================================================");

            int command = sc.nextInt();

            if (command == 999) {
                System.out.println("====================================================");
                System.out.println("Thanks for playing!");
                break;
            }
            if (command == 11) {
                System.out.println("====================================================");
                ui.examineRoom(currentLocation,sc,player);
            }

            if (command == 22) {
                System.out.println("====================================================");
                ui.checkInventory(sc, player, currentLocation);
            }

            if (command > 0 && command < 10) {
                currentLocation = ui.moveToLocation(currentLocation,sc,command);
            }




        }





    }

}
