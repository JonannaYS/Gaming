package newGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public void start(Scanner sc) {
        GameData gameData = new GameData();
        Player player = new Player();
        UserInterface ui = new UserInterface();
        Location currentLocation = gameData.initialize();
        List<Location> allLocations = gameData.getLocations();


        // welcome player
        System.out.println("Welcome to the game.");

        while (true) {

            //print description of current locations
            System.out.println("What would you like to do?");

            //print options for the player
            ui.printOptions(currentLocation,player);


        }





    }

}
