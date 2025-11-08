import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Translator logic = new Translator();

        System.out.println("Morse Converter");
        System.out.println("1 = English - Morse");
        System.out.println("2 = Morse - English");
        System.out.print("Choose option: ");


        Scanner scanner = new Scanner(System.in);
        Integer intValue = null;
        do {
            String text = scanner.nextLine();
            try {
                intValue = Integer.parseInt(text);
            } catch (NumberFormatException exp) {
                if (text.isEmpty()) {
                    System.out.println("You must provide an input");
                } else {
                    System.out.println(text + " is not a valid int value");
                }
            }
        } while (intValue == null);

        try {
            if (intValue == 1) {
                System.out.print("Enter English text: ");
                String text = scanner.nextLine();
                String result = logic.englishToMorse(text);
                System.out.println("Morse: " + result);

            } else if (intValue == 2) {
                System.out.print("Enter Morse code: ");
                String text = scanner.nextLine();
                String result = logic.morseToEnglish(text);
                System.out.println("English: " + result);

            } else {
                System.out.println("Invalid menu option.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
