package newGame;

import java.util.Random;
import java.util.Scanner;

//Joonas
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.start(scanner, random);
    }
}
