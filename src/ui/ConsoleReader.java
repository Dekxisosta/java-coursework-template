package ui;

import java.io.BufferedReader;
import java.io.IOException;

/* ========================================
 *   CONSOLE READER CLASS
 ==========================================*/

/**
 * A utility class for handling console-based user input.
 * <p>
 * Provides methods to read and validate integers, strings, booleans,
 * and option selections from a {@link BufferedReader}.
 * Designed for simple coursework or console applications.
 * </p>
 */
public class ConsoleReader {

    /** The buffered reader used for console input. */
    private final BufferedReader reader;

    /**
     * Constructs a new {@code ConsoleReader}.
     *
     * @param reader the {@link BufferedReader} to wrap for input
     */
    public ConsoleReader(BufferedReader reader) {
        this.reader = reader;
    }

    /* ==========================
     * INPUT VALIDATOR METHODS
     ==========================*/

    /**
     * Reads an integer value from the console.
     *
     * @return the integer entered by the user
     * @throws NumberFormatException if the input cannot be parsed as an integer
     * @throws IOException if an I/O error occurs while reading
     */
    public int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }

    /**
     * Reads an integer value within a specified inclusive range.
     *
     * @param min the minimum allowed value (inclusive)
     * @param max the maximum allowed value (inclusive)
     * @return the validated integer entered by the user
     * @throws NumberFormatException if the input cannot be parsed as an integer
     * @throws IOException if an I/O error occurs while reading
     * @throws IllegalArgumentException if the number is outside the given range
     */
    public int readIntWithinRange(int min, int max)
            throws NumberFormatException, IOException, IllegalArgumentException {
        int num = readInt();
        if (num >= min && num <= max) {
            return num;
        }
        throw new IllegalArgumentException("Invalid number. Must be within [" + min + ".." + max + "].");
    }

    /**
     * Reads a raw string input from the console.
     *
     * @return the string entered by the user
     * @throws IOException if an I/O error occurs while reading
     */
    public String readString() throws IOException {
        return reader.readLine();
    }

    /**
     * Reads a boolean value from the console.
     * <p>
     * Accepts case-insensitive values such as:
     * {@code "true", "yes", "y", "1"} for {@code true}, and
     * {@code "false", "no", "n", "0"} for {@code false}.
     * </p>
     *
     * @return the parsed boolean value
     * @throws IOException if an I/O error occurs while reading
     * @throws IllegalArgumentException if the input does not match any expected values
     */
    public boolean readBoolean() throws IOException, IllegalArgumentException {
        String bool = readString();

        if (bool.equalsIgnoreCase("true")
                || bool.equalsIgnoreCase("yes")
                || bool.equalsIgnoreCase("y")
                || bool.equalsIgnoreCase("1")) {
            return true;
        }
        if (bool.equalsIgnoreCase("false")
                || bool.equalsIgnoreCase("no")
                || bool.equalsIgnoreCase("n")
                || bool.equalsIgnoreCase("0")) {
            return false;
        }
        throw new IllegalArgumentException("Invalid choice for boolean. Please try again.");
    }

    /**
     * Reads an option from a list of choices.
     * <p>
     * The user may select an option either by typing the option string
     * (case-insensitive) or its index (zero-based).
     * </p>
     *
     * @param options an array of valid option strings
     * @return the index of the selected option
     * @throws IOException if an I/O error occurs while reading
     * @throws IllegalArgumentException if the input does not match any option or index
     */
    public int readOption(String[] options) throws IOException, IllegalArgumentException {
        String choice = readString();

        for (int i = 0; i < options.length; i++) {
            if (choice.equalsIgnoreCase(options[i]) || choice.equals(String.valueOf(i)))
                return i;
        }
        throw new IllegalArgumentException("Invalid choice. Please try again.");
    }

    /**
     * Closes the underlying {@link BufferedReader}.
     * <p>
     * Suppresses any {@link IOException} that occurs to prevent
     * unnecessary interruptions during program shutdown.
     * </p>
     */
    public void close() {
        try {
            reader.close();
        } catch (IOException ignored) {}
    }
}
