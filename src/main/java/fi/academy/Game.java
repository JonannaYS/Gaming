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
}
