package fi.academy;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Game {
    Scanner sc = new Scanner(System.in);
    boolean avain;
    // Jouni kommentoi ja kokeilee

    public static void main( String[] args ) {
        Game game = new Game();
        game.elevator();
    }

    public void elevator(){
        if (!avain) {
            System.out.println("You are in an elevator. What do you want to do?");
            System.out.println("1: Go right");
            System.out.println("2: Go left");
            int choice = sc.nextInt();

            if (choice==1) {
                hallway6();
            }

            if (choice==2) {
                office();
            }
        }




    }

    private void office() {
        System.out.println("You arrived in the office. What would you like to do now?");
    }

    private void hallway6() {
        System.out.println("Joonaksen editti");
    }

    private void toilet24() { //Johanna
        System.out.println("You can't enter the loo, you fool!");
    }

    private void toilet25() { //Johanna
        System.out.println("You enter the toilet. As usual, there's no paper there. What do you do?");
        System.out.println("1. Leave the toilet. Try to find Maisa to help you. ");
        System.out.println("2. Leave the toilet. I didn't need to go anyway.");
        System.out.println("3. Use the toilet.");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            office();
        }
        if (choice.equals("2.")) {
            office();
        }
        if (choice.equals("3.")) {
            System.out.println("You flush the toilet. You hear a strange crackling sound coming from the wash basin.");
            System.out.println("1. Leave the toilet.");
            System.out.println("2. Check the wash basin.");
            System.out.println("3. Check under the wash basin.");

            if (choice.equals("1")) {
              office();
            }  if (choice.equals("2")) {
                office();
            } if (choice.equals("3")) {
                office();
            } else {
                System.out.println("A troll eats you and you die. mwahaha.");
            }
        } else {
            System.out.println("A troll eats you and you die. mwahaha.");
        }
    }


}
