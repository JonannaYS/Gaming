//package newGame;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class LocationReader {
//
//    public static void main(String[] args) {
//        String fileName = "src/main/text/Locations.txt";
//        try (FileReader fr = new FileReader(fileName);
//             BufferedReader reader = new BufferedReader(fr)) {
//            String lineOfText;
//            while ((lineOfText = reader.readLine()) != null) {
//                System.out.println(lineOfText);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private boolean readWithReader(String nimi) {
//        try (FileReader fr = new FileReader(nimi);
//             BufferedReader in = new BufferedReader(fr)) {
//            StringBuilder text = new StringBuilder();
//            String lineOfText;
//            while ((lineOfText = in.readLine()) != null) {
//                text.append(lineOfText).append("\n");
//            }
//            String result = text.toString();
//            System.out.println(result);
//        } catch (FileNotFoundException e) {
//            return false;
//        } catch (IOException e) {
//            return false;
//        }
//        return true;
//    }
//}