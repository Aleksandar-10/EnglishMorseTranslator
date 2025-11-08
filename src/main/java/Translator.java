import java.util.HashMap;

public class Translator {
    private final HashMap<Character, String> englishToMorse = new HashMap<>();
    private final HashMap<String, Character> morseToEnglish = new HashMap<>();

    public Translator() {
        englishToMorse.put('A', ".-");   englishToMorse.put('B', "-...");
        englishToMorse.put('C', "-.-."); englishToMorse.put('D', "-..");
        englishToMorse.put('E', ".");    englishToMorse.put('F', "..-.");
        englishToMorse.put('G', "--.");  englishToMorse.put('H', "....");
        englishToMorse.put('I', "..");   englishToMorse.put('J', ".---");
        englishToMorse.put('K', "-.-");  englishToMorse.put('L', ".-..");
        englishToMorse.put('M', "--");   englishToMorse.put('N', "-.");
        englishToMorse.put('O', "---");  englishToMorse.put('P', ".--.");
        englishToMorse.put('Q', "--.-"); englishToMorse.put('R', ".-.");
        englishToMorse.put('S', "...");  englishToMorse.put('T', "-");
        englishToMorse.put('U', "..-");  englishToMorse.put('V', "...-");
        englishToMorse.put('W', ".--");  englishToMorse.put('X', "-..-");
        englishToMorse.put('Y', "-.--"); englishToMorse.put('Z', "--..");

        // Reverse mapping
        for (var entry : englishToMorse.entrySet()) {
            morseToEnglish.put(entry.getValue(), entry.getKey());
        }
    }

    // Convert English to Morse
    protected String englishToMorse(String text) throws IllegalArgumentException {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                result.append("/ ");
            } else {
                if (!englishToMorse.containsKey(c)) {
                    throw new IllegalArgumentException("Invalid character: " + c);
                }
                result.append(englishToMorse.get(c)).append(" ");
            }
        }

        return result.toString().trim();
    }

    // Convert Morse to English
    protected String morseToEnglish(String morse) throws IllegalArgumentException {
        StringBuilder result = new StringBuilder();

        String[] words = morse.split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");

            for (String letter : letters) {
                if (!morseToEnglish.containsKey(letter)) {
                    throw new IllegalArgumentException("Invalid Morse sequence: " + letter);
                }
                result.append(morseToEnglish.get(letter));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
