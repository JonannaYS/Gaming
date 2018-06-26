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

            if (choice.equals("1")) {
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
                "You see some desks and chairs, one laptop on the nearest desk.\n " +
                "There are some papers with coffee cup stains on the papers scattered on the floor." +
                "\nThere is a printer in the corner.\n" +
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
            System.out.println("Which toilet would you like to enter?");
            System.out.println("1: The toilet near to you.");
            System.out.println("2: the toilet further to northeast from you.");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                toilet24();
            }
            if (choice.equalsIgnoreCase("2")) {
                toilet25();
            }
            if (choice.equals("4")) {
                hallway2();
            }
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

    public void couch7() { //Johanna
        System.out.println("You are in the livingroom. There are large couches and chairs around you.");
        System.out.println("1: Go back to the hallway.");
        System.out.println("2: Go to the dining room.");
        System.out.println("3: Examine room. You might die.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            hallway6();
        }
        if (choice.equals("2")) {
            diningRoom8();
        }
        if (choice.equals("3")) {
            System.out.println("You find nothing here.");
            couch7();
        }
    }

    public void diningRoom8(){ //Joonas
        System.out.println("You are in a hall. In the north there appears to be a kitchen. In the south there are some couches.");
        System.out.println("1: Go north.");
        System.out.println("2: Go south.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                kitchen13();
                break;
            case "2":
                couch7();
                break;
            default:
                System.out.println("That is not an option.");
                diningRoom8();
                break;
        }
    }

    public void hallway9() { //Jouni
        System.out.println("You are in a hallway to the south there is a " +
                "hallway leading to west around the wall to the east you see a \n " +
                "thick grey woollen felt wall hanging from the roof. It looks \n " +
                "sturdy. To the northwest there is a door to a toilet and  \n " +
                "to west there is a door to a maintenance room.  To southwest \n " +
                "there is door to another toilet. To north there is a large open \n" +
                " kitchen, you can smell a nice aroma of coffee from the kitchen. \n" +
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

    public void toilet10 () { //Johanna
        System.out.println("You can't enter the loo, you fool!");
        hallway9();
    }

    public void maintenance11 () {
        System.out.println("The door is locked. You hear hushed sounds coming from the maintenance room!");
        hallway9();
    }

    public void toilet12 () { //Johanna
        System.out.println("You can't enter the loo, you fool!");
        hallway9();
    }

    public void kitchen13 () { //Johanna
        System.out.println("You enter the kitchen. What do you do?");
        System.out.println("1: Make yourself some coffee. ");
        System.out.println("2: Have a sandwich.");
        System.out.println("3: Leave the room.");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            System.out.println("You drink your coffee and feel refreshed.");
            kitchen13();
        }
        if (choice.equals("2")) {
            System.out.println("You devour someones sandwich from the fridge... Seriously?!");
            kitchen13();
        }
        if (choice.equals("3")) {
            System.out.println("You decide to leave the kitchen. Where do you want to go?");
            System.out.println("1: Go north to the hallway to other rooms.");
            System.out.println("2: Go southwest to the hallway with exits to toilets.");
            System.out.println("3: Go south to the dining room with large white tables surrounded by nice chairs.");

            choice = sc.nextLine();

            if (choice.equals("1")) {
                hallway14a();
            }
            if (choice.equals("2")) {
                hallway9();
            }
            if (choice.equals("3")) {
                diningRoom8();
            } else {
                System.out.println("A troll eats you and you die. mwahaha.");
            }
        } else {
            kitchen13();
        }
    }

    public void hallway14a(){
        System.out.println("You are in a hallway. Hallway continues to the west. There are two doors: one to the north and another to the east. In the south there is a kitchen.");
        System.out.println("1: Go west.");
        System.out.println("2: Go north.");
        System.out.println("3: Go east.");
        System.out.println("4: Go south.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                hallway14b();
                break;
            case "2":
                accenture16();
                break;
            case "3":
                conference15();
                break;
            case "4":
                kitchen13();
                break;
            default:
                System.out.println("Not possible.");
                hallway14a();

        }
    }

    public void hallway14b() {
        System.out.println("You are in a hallway. Hallway continues to the north and to the east. There is a door to the west. In the south there is a corner with a TV.");
        System.out.println("1: Go west.");
        System.out.println("2: Go north.");
        System.out.println("3: Go east.");
        System.out.println("4: Go south.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                cSharp20();
                break;
            case "2":
                hallway18();
                break;
            case "3":
                hallway14a();
                break;
            case "4":
                beanbags21();
                break;
            default:
                System.out.println("Not possible.");
                hallway14b();
        }
    }

    public void conference15 () { //Johanna
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway14a();
        }
    }

    public void accenture16 () { //Johanna
        System.out.println("It's a classroom. You notice that the air in the room is thick and stale.");
        System.out.println("1: Go back to the hallway.");
        System.out.println("2: You go to the thermostat.");
        System.out.println("3: You want to look around.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            hallway14a();
        }
        if (choice.equals("2")) {
            System.out.println("The air conditioning is broken.");
            accenture16();
        }
        if (choice.equals("3.")) {
            System.out.println("There is currently nothing interesting in this room.");
            accenture16();
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
        System.out.println("You are in a hallway of some sort. There is an exit in the west. There is also two rooms north and north-east. The hallway continues southwards.");
        System.out.println("1: Try the exit door.");
        System.out.println("2: Go into the room in the north");
        System.out.println("3: Go into the room in the north-east");
        System.out.println("4: Go south through the hallway.");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            exit22();
        }

        if (choice.equals("2")) {
            conference19();
        }

        if (choice.equals("3")) {
            conference17();
        }

        if (choice.equals("4")) {
            hallway14b();
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

    public void cSharp20() { //Johanna
        System.out.println("You are in a classroom. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway14b();
        }
    }

    public void beanbags21() { //Jouni
        System.out.println("There are a few large and colourful beanbag chairs omn the floors." +
                "They look very inviting. On the south wall there is a large monitor where you see fortnite" +
                "on a Playstation. It appears even more inviting." +
                "What do you want to do?");
        System.out.println("1: Go to the north to a large open hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway14b();
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
        office3();
    }

    public void toilet25() { //Johanna
        System.out.println("You enter the toilet. As usual, there's no paper there. What do you do?");
        System.out.println("1: Leave the toilet. Try to find Maisa to help you. ");
        System.out.println("2: Leave the toilet. I didn't need to go anyway.");
        System.out.println("3: Use the toilet.");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            office3();
        }
        if (choice.equals("2")) {
            office3();
        }
        if (choice.equals("3")) {
            System.out.println("You flush the toilet. You hear a strange crackling sound coming from the wash basin.");
            System.out.println("1: Leave the toilet.");
            System.out.println("2: Check the wash basin.");
            System.out.println("3: Check under the wash basin.");

            choice = sc.nextLine();

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
            office3();
        }
    }
}
