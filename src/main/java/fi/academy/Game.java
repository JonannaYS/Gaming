package fi.academy;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Game {
    Scanner sc = new Scanner(System.in);
    boolean avain;

    public static void main( String[] args ) {
        Game game = new Game();
        game.elevator1();
    }

    public void elevator1(){ //JOONAS
        if (!avain) {
            System.out.println("You are in an elevator. What do you want to do?");
            System.out.println("1: Go right");
            System.out.println("2: Go left");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("1")) {
                hallway6();
            }

            if (choice.equalsIgnoreCase("2")) {
                office();
            }

            else {
                System.out.println("lol");
                elevator1();
            }
        }
    }

    public void conference17(){ //JOONAS
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway18();
        }
    }

    public void hallway18(){ //JOONAS
        System.out.println("You are in a hallway of some sort.");
    }

    public void conference19(){ //JOONAS
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway18();
        }
    }

    public void office() { //JOONAS
        System.out.println("You arrived in the office. What would you like to do now?");
    }

    public void hallway6() { //JOONAS
        System.out.println("Joonaksen editti");
    }

    public void toilet24() {
        System.out.println("You can't enter the loo, you fool!");
    }
}
