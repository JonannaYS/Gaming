package newGame;

import java.util.Random;
import java.util.Scanner;


// Tämä kopio miniprojektista on tehty GIT local repo forkkauksen ja kloonauksen kokeiluun.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.start(scanner, random);
    }
}
