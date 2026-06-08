
import com.learning.StringOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringOperationsTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    void testReverseUsingCharArray_regular() {
        assertEquals("elppa", StringOperations.reverseUsingCharArray("apple"));
    }

    @Test
    void testReverseUsingCharArray_emptyAndSingle() {
        assertEquals("", StringOperations.reverseUsingCharArray(""));
        assertEquals("x", StringOperations.reverseUsingCharArray("x"));
    }

    @Test
    void testReverseUsingCharArray_specialChars() {
        assertEquals("!@# $", StringOperations.reverseUsingCharArray("$ #@!"));
    }

    @Test
    void testReverseUsingStringBuilder_various() {
        assertEquals("elppa", StringOperations.reverseUsingStringBuilder("apple"));
        assertEquals("", StringOperations.reverseUsingStringBuilder(""));

    }

    @Test
    void testReverseUsingLoopDecrement_regular() {
        assertEquals("elppa", StringOperations.reverseUsingLoopDecrement("apple"));
        assertEquals("a", StringOperations.reverseUsingLoopDecrement("a"));
    }

    @Test
    void testNullInputs_throwNpe() {
        assertThrows(NullPointerException.class, () -> StringOperations.reverseUsingCharArray(null));
        assertThrows(NullPointerException.class, () -> StringOperations.reverseUsingStringBuilder(null));
        assertThrows(NullPointerException.class, () -> StringOperations.reverseUsingLoopDecrement(null));
    }

    @Test
    void testMainOutputsExpectedLines() {
        // run main and capture output
        StringOperations.main(new String[0]);

        String sep = System.lineSeparator();
        String expected = ""
                + "Reverse string of apple" + sep
                + " 1. Using Char Array  : elppa" + sep
                + " 2. Using String Builder  : elppa" + sep
                + " 3. Using Reverse Looping  : elppa" + sep;

        assertEquals(expected, outContent.toString());
    }
}
