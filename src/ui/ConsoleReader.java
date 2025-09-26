package ui;

import java.io.*;

/* ========================================
 *   CONSOLE READER CLASS
 ==========================================*/

/**
 * Utility for console-based user input.
 * <p>
 * Wraps a {@link BufferedReader} and provides methods
 * to read integers, strings, booleans, and menu options.
 * </p>
 */
public class ConsoleReader {
    private final BufferedReader reader;
    /* ==========================
     * CONSTRUCTOR
     ==========================*/
    /** Creates a new reader from the given {@link BufferedReader}. */
    public ConsoleReader(BufferedReader reader) {this.reader = reader;}

    /* ==========================
     * INPUT VALIDATOR METHODS
     ==========================*/
    /** Reads an integer value. */
    public int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }

    /** Reads an integer within an inclusive min-max range. */
    public int readIntWithinRange(int min, int max)
            throws NumberFormatException, IOException, IllegalArgumentException {
        int num = readInt();
        if (num >= min && num <= max) {
            return num;
        }
        throw new IllegalArgumentException("Invalid number. Must be within [" + min + ".." + max + "].");
    }

    /** Reads a raw string. */
    public String readString() throws IOException {
        return reader.readLine();
    }

    /** Reads a boolean value (supports true/false, yes/no, y/n, 1/0). */
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

    /** Reads an option by index or matching string. */
    public int readOption(String[] options) throws IOException, IllegalArgumentException {
        String choice = readString();

        for (int i = 0; i < options.length; i++) {
            if (choice.equalsIgnoreCase(options[i]) || choice.equals(String.valueOf(i)))
                return i;
        }
        throw new IllegalArgumentException("Invalid choice. Please try again.");
    }

    /** Closes the underlying reader (ignores errors). */
    public void close() {
        try {
            reader.close();
        } catch (IOException ignored) {}
    }
}
