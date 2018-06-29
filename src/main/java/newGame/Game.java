package newGame;

import java.util.*;

public class Game {

    public void start(Scanner sc, Random random) {
        Player player = new Player("stranger");
        UserInterface ui = new UserInterface();
        GameData gameData = new GameData(random);
        Location currentLocation = gameData.initializeGame();

        //Start the UI
        ui.startTheUserInterface(sc, player, currentLocation, gameData);
    }
}
