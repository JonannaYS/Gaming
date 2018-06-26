package fi.academy;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Game {
    Scanner sc = new Scanner(System.in);
    boolean passKey;

    public static void main(String[] args) {
        Game game = new Game();
        game.elevator1();

    }

    public void elevator1() { //JOONAS
        System.out.println("You are in an elevator and the doors are shut.");
        System.out.println("1: Open the doors");
        System.out.println("2: Do nothing");
        String choice = sc.nextLine();


        if (choice.equalsIgnoreCase("1")) {
            System.out.println("Behind the doorway is a dark hallway.");
            System.out.println("1: Go to the hallway.");
            System.out.println("2: Go back inside the elevator");
            choice = sc.nextLine();

            if (choice.equals("1:")) {
                hallway2();
            }

            if (choice.equals("2")) {
                elevator1();
            }
        }

        if (choice.equalsIgnoreCase("2")) {
            elevator1();
        } else {
            System.out.println("Not an option at this time.");
            elevator1();
        }
    }

    public void office3() { //Jouni
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

    public void hallway6() { //JOONAS
        System.out.println("Joonaksen editti");
    }

    public void conference17() { //JOONAS
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway18();
        }
    }

    public void hallway18() { //JOONAS
        System.out.println("You are in a hallway of some sort. There is an exit in the west. There is also two rooms north and north-east. The hallway continues southwards.");
        System.out.println("1: Try the exit door.");
        System.out.println("2: Go into the room in the north");
        System.out.println("3: Go into the room in the north-east");
        System.out.println("4: Go south through the hallway.");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            exit();
        }

        if (choice.equals("2")) {
            conference19();
        }

        if (choice.equals("3")) {
            conference17();
        }

        if (choice.equals("4")) {
            hallway14();
        }

        else {
            System.out.println("That's not possible.");
            hallway18();
        }

    }

    public void conference19() { //JOONAS
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway18();
        }
    }

    public void exit22(){
        if (passKey) {
            System.out.println("Gongratulations! You have succesfully exited the building.");
        }

        else {
            System.out.println("The door is locked.");
            hallway18();
        }
    }

    public void exit23(){
        if (passKey) {
            System.out.println("Gongratulations! You have succesfully exited the building.");
        }

        else {
            System.out.println("The door is locked.");
            hallway6();
        }
    }

    public void toilet24() { //Johanna
        System.out.println("You can't enter the loo, you fool!");
    }

    public void toilet25() { //Johanna
        System.out.println("You enter the toilet. As usual, there's no paper there. What do you do?");
        System.out.println("1. Leave the toilet. Try to find Maisa to help you. ");
        System.out.println("2. Leave the toilet. I didn't need to go anyway.");
        System.out.println("3. Use the toilet.");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            office3();
        }
        if (choice.equals("2.")) {
            office3();
        }
        if (choice.equals("3.")) {
            System.out.println("You flush the toilet. You hear a strange crackling sound coming from the wash basin.");
            System.out.println("1. Leave the toilet.");
            System.out.println("2. Check the wash basin.");
            System.out.println("3. Check under the wash basin.");

            if (choice.equals("1")) {
                office3();
            }
            if (choice.equals("2")) {
                office3();
            }
            if (choice.equals("3")) {
                office3();
            } else {
                System.out.println("A troll eats you and you die. mwahaha.");
            }
        } else {
            System.out.println("A troll eats you and you die. mwahaha.");
        }
    }
}
