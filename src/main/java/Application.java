import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translator logic = new Translator();

        System.out.println("Morse Converter");
        System.out.println("1 = English - Morse");
        System.out.println("2 = Morse - English");
        System.out.print("Choose option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            if (choice == 1) {
                System.out.print("Enter English text: ");
                String text = scanner.nextLine();
                String result = logic.englishToMorse(text);
                System.out.println("Morse: " + result);

            } else if (choice == 2) {
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
