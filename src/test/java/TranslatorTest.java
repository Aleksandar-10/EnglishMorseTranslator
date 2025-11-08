import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TranslatorTest {

    Translator logic = new Translator();

    @Test
    public void testEnglishToMorse() {
        assertEquals(".... . .-.. .-.. ---", logic.englishToMorse("HELLO"));
    }

    @Test
    public void testMorseToEnglish() {
        assertEquals("HELLO", logic.morseToEnglish(".... . .-.. .-.. ---"));
    }

    @Test
    public void testEnglishWithSpace() {
        assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..",
                logic.englishToMorse("HELLO WORLD"));
    }

    @Test
    public void testInvalidEnglishCharacter() {
        assertThrows(IllegalArgumentException.class, () -> logic.englishToMorse("HELLO!"));
    }

    @Test
    public void testInvalidMorse() {
        assertThrows(IllegalArgumentException.class, () -> logic.morseToEnglish(".--.-"));
    }
}
