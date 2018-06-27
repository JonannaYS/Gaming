package newGame;

import java.util.*;

public class Game {

    public void start(Scanner sc, Random random) {
        Player player = new Player();
        UserInterface ui = new UserInterface();
        GameData gameData = new GameData(random);
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

            if (command == 999) {
                break;
            }
            if (command == 22) {
                ui.examineRoom(currentLocation,sc);
            }
            if (command > 0 && command < 10) {
                currentLocation = ui.moveToLocation(currentLocation,sc,command);
            }


        }





    }

}
