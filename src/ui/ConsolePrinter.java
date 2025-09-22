package ui;

import log.ConsoleLog;
import config.AppConfig;

/* ========================================
 *        CONSOLE PRINTER CLASS
 ==========================================*/

/**
 * Handles console output for the application.
 * <p>
 * Provides methods to display program information, introductions,
 * conclusions, prompts, menu options, and log messages with
 * appropriate formatting and optional ANSI styling.
 * </p>
 */
public class ConsolePrinter {

    /* ==========================
     * CONSTRUCTOR
     ==========================*/

    /**
     * Constructs a new {@code ConsolePrinter}.
     */
    public ConsolePrinter() {}

    /* ==========================
     * USER-INTERFACE METHODS
     ==========================*/

    /**
     * Prints the program name banner to the console.
     * <p>
     * If ANSI is supported (based on {@link AppConfig#isANSISupported()}),
     * the name is displayed with inverse video highlighting.
     * Otherwise, plain text is used.
     * </p>
     */
    public void printProgramName() {
        System.out.print("\n\n");
        String intro = String.format("======== %s ========", AppConfig.getProgramName());

        if (AppConfig.isANSISupported())
            System.out.print("\u001B[7m" + intro + "\u001B[0m");
        else
            System.out.print(intro);
    }

    /**
     * Prints a brief introduction of the program to the console.
     * <p>
     * Includes program name, creation date, and author details.
     * </p>
     */
    public void printIntroduction() {
        System.out.print("\n" + AppConfig.getProgramName()
                + " \nDate Created: YYYY / MM / DD \nCreated by: Dekxisosta");
    }

    /**
     * Prints a brief conclusion message upon program termination.
     * <p>
     * Includes program name and a thank-you note.
     * </p>
     */
    public void printConclusion() {
        System.out.print("\n" + AppConfig.getProgramName()
                + " \nThank you for using the program!! \n- Dekxi");
    }

    /**
     * Prints an input prompt to the console.
     *
     * @param inputType a description of the expected input (e.g., "number", "name")
     */
    public void ask(String inputType) {
        System.out.printf("%nEnter %s: ", inputType);
    }

    /**
     * Prints a log message with its corresponding log label.
     *
     * @param message  the message to display
     * @param logType  the log level/type (determines the label via {@link ConsoleLog#label()})
     */
    public void log(String message, ConsoleLog logType) {
        System.out.printf("%n%s %s", logType.label(), message);
    }

    /**
     * Prints a list of menu options to the console.
     * <p>
     * Options are displayed in the order provided, with indices shown
     * in square brackets. By convention, index 0 is reserved for
     * exit or back options, and is displayed last.
     * </p>
     *
     * @param options an array of option strings, where index 0 is the "Exit/Back" option
     */
    public void printMenuOptions(String[] options) {
        for (int i = 1; i < options.length; i++)
            System.out.printf("%n[%d] %s", i, options[i]);

        System.out.printf("%n[%d] %s", 0, options[0]);
    }
}
