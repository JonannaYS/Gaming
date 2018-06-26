package fi.academy;

import java.sql.SQLOutput;
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
        game.elevator1();
    }

    public void elevator1() { //JOONAS
        if (!avain) {
            System.out.println("You are in an elevator. What do you want to do?");
            System.out.println("1: Go right");
            System.out.println("2: Go left");
            String choice = sc.nextLine();


            if (choice.equalsIgnoreCase("1")) {
                hallway6();
            }

            if (choice.equalsIgnoreCase("2")) {
                office3();
            } else {
                System.out.println("lol");
                elevator1();
            }
        }
    }

    public void hallway2() { //Jouni
        System.out.println("You are in a hallway in front of elevators. " +
                "There is an open office to the west and " +
                "the hallway continues to the east." +
                "What would you like to do now?");
        System.out.println("1: Go west to the office space.");
        System.out.println("2: Go go east continuing the hallway.");
        System.out.println("3: Press the elevator button to enter the elevator in the south.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            office3();
        }
        if (choice.equals("2")) {
            hallway6();
        }
        if (choice.equals("3")) {
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
        System.out.println("3: Go to northeast, there are doors to two toilets.");
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

    public void conference4() { //Jouni
        System.out.println("You are in a mid-size negotiating room. " +
                "There is a table with six chairs around it and a large monitor on the " +
                "north wall above the table. There is a window to the east, " +
                "the orange window shades are pulled open and some office buildings " +
                "can be seen from the window." +
                "You see a door to the east. What do you want to do?");
        System.out.println("1: Go east to the office space.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            office3();
        }
    }

    public void leasegreen5() { //Jouni
        System.out.println("You are in a semi large classroom. There is a U-shaped table in the middle" +
                "and some tables also by the east side of the wall. " +
                "The windows open to the west and you can see some office buildings with white walls" +
                "from the window across the street. " +
                "The room may be leased; it has a greenish feeling..." +
                "What do you want to do?");
        System.out.println("1: Go south to the open office space.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            office3();
        }

    }

    public void hallway6() { //Jouni
        System.out.println("You are in a hallway. There are elevators to the west." +
                "To the east is a large open space surrounded by very cozy couches." +
                "There is a large whitescreen to the south. The space is airy and " +
                "surrounded by windows to the south and east." +
                "What do you want to do?");
        System.out.println("1: Go west to the hallway in front of the elevators.");
        System.out.println("2: Go east to the open space where the sofas are.");
        System.out.println("3: Go southwest to the exit door.");
        System.out.println("4: Go north to the hallway in front of toilets with a grey " +
                "hanging wall made of woollen material to the east of the hallway.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            hallway2();
        }
        if (choice.equals("2")) {
            couch7();
        }
        if (choice.equals("3")) {
            exit23();
        }
        if (choice.equals("4")) {
            hallway9();
        }
    }

    public void hallway9() { //Jouni
        System.out.println("You are in a hallway to the south there is a " +
                "hallway leading to west around the wall to the east you see a thick grey woollen felt" +
                "wall hanging from the roof. It looks sturdy. To the northwest there is a door to a toilet and " +
                "to west there is a door to a maintenance room.  To southwest there is door to another toilet." +
                "To north there is a large open kitchen, you can smell a nice aroma of coffee from the kitchen." +
                "What do you want to do?");
        System.out.println("1: Go northwest to the toilet.");
        System.out.println("2: Go west to the maintenance room.");
        System.out.println("3: Go southwest to the other toilet.");
        System.out.println("4: Go north to the kitchen where the aroma of coffee appears to be coming from.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            toilet12();
        }
        if (choice.equals("2")) {
            maintenance11();
        }
        if (choice.equals("3")) {
            toilet10();
        }
        if (choice.equals("4")) {
            kitchen13();
        }
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
        System.out.println("You are in a hallway of some sort.");
    }

    public void conference19() { //JOONAS
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway18();
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
