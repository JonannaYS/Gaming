package fi.academy;

import java.util.Scanner;

/**
 * Hello world!
 */
public class Game {
    Scanner sc = new Scanner(System.in);
    boolean avain;
    // Jouni kommentoi ja kokeilee

    public static void main(String[] args) {
        Game game = new Game();
        game.elevator();
    }

    public void elevator() {
        if (!avain) {
            System.out.println("You are in an elevator. What do you want to do?");
            System.out.println("1: Go right");
            System.out.println("2: Go left");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                hallway6();
            }

            if (choice.equals("2")) {
                office();
            } else {
                System.out.println("lol");
                elevator();
            }

        }


    }

    public void office() { //Jouni
        System.out.println("You arrived in the office. " +
                "You see some desks and chairs, one laptop on the nearest desk. " +
                "There are some papers with coffee cup stains on the papers scattered on the floor." +
                "There is a printer in the corner." +
                "What would you like to do now?");
        System.out.println("1: Go west, there is a door opening to a smaller room by a glass wall.");
        System.out.println("2: Go to north, there is a door between two glass walls opening to a large room.");
        System.out.println("3: Go to north east, there are two toilets.");
        System.out.println("4: Go to east to a hallway in front of the elevators.");

        String choice = sc.nextLine();
        if (choice.equals("1")) {
            conference4();
        }
        if (choice.equals("2")) {
            leasegreen5();
        }
        if (choice.equals("3")) {
            toilet24();
        }
        if (choice.equals("4")) {
            hallway2();
        }

    }




    public void hallway6() {
        System.out.println("Joonaksen editti");
    }

    public void toilet24() {
        System.out.println("You can't enter the loo, you fool!");
    }
}
