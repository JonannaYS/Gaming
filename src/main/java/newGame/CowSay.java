package newGame;

import java.util.Scanner;

public class CowSay {

    public static void callTheCow(String sentence) {
        printTheBalloon(sentence);
        printTheCow(sentence);
    }

    private static void printTheCow(String sentence) {
        int lengthOfString = sentence.length();
        int up = 2227;
        String horn = "\u2227";
        System.out.println(horn + "__" + horn);
        for (int i = 0; i < (lengthOfString + 2); i++) {
            System.out.printf(" ");
        }
        System.out.println("(oo)\\________");
        for (int i = 0; i < (lengthOfString + 2); i++) {
            System.out.printf(" ");
        }
        System.out.println("(__)\\        )");
        for (int i = 0; i < (lengthOfString + 7); i++) {
            System.out.printf(" ");
        }
        System.out.println("||----W |");
        for (int i = 0; i < (lengthOfString + 7); i++) {
            System.out.printf(" ");
        }
        System.out.println("||     ||");
    }

    private static String requestInput() {
        Scanner reader = new Scanner(System.in);
        String lause = reader.nextLine();
        return lause;
    }

    private static void printTheBalloon(String sentence) {
        int lengthOfSentence = sentence.length();
        System.out.printf(" ");
        for (int i = 0; i < (lengthOfSentence + 2); i++) {
            System.out.printf("_");
        }
        System.out.println();
        System.out.println("< " + sentence + " >");
        System.out.printf(" ");
        for (int i = 0; i < (lengthOfSentence + 2); i++) {
            System.out.printf("-");
        }
        System.out.println();
        for (int i = 0; i < (lengthOfSentence); i++) {
            System.out.printf(" ");
        }
        System.out.printf("\\");
        System.out.println();
        for (int i = 0; i < (lengthOfSentence + 1); i++) {
            System.out.printf(" ");
        }
        System.out.printf("\\");
    }
}

