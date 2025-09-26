package ui;

import config.*;
import util.*;

/* ========================================
 *        CONSOLE PRINTER CLASS
 ==========================================*/
/**
 * Handles console output for the application.
 * <p></p>
 * Depends on {@link Ansi} for styling and {@link Logger} for log labels.
 */
public class ConsolePrinter {
    AppConfig config = AppConfig.getInstance();
    /* ==========================
     * CONSTRUCTOR
     ==========================*/
    /** Creates a new printer instance. */
    public ConsolePrinter() {}

    /* ==========================
     * USER-INTERFACE METHODS
     ==========================*/
    /** Prints the program name banner. */
    public void printProgramName() {
        int padding = 5;
        String programNameFormat = " ".repeat(padding)
                + config.getProgramName()
                + " ".repeat(padding);

        lineBreak();
        lineBreak();

        System.out.println("D|" + createBorder(programNameFormat.length()) + "|D");
        System.out.println("||" + wrapHeader(programNameFormat) + "||");
        System.out.println("D|" + createBorder(programNameFormat.length()) + "|D");
    }

    /** Prints a brief introduction with program details. */
    public void printIntroduction() {
        System.out.print(config.getAuthorBanner());
        System.out.print("\nPROGRAM: " + config.getProgramName()
                + "\nDate Created: " + config.getDateCreated()
                + "\nCreated by: " + config.getAuthorName());
    }

    /** Prints a conclusion message. */
    public void printConclusion() {
        System.out.print("\n" + config.getProgramName()
                + "\nThank you for using the program!! "
                + "\n- Dekxi");
    }

    /** Prints a message. */
    public void print(String message){
        System.out.printf("%n%s", message);
    }

    /** Prints a line break. */
    public void lineBreak(){
        System.out.println();
    }

    /** Prints an input prompt. */
    public void ask(String inputType) {
        System.out.printf("%nEnter %s: ", inputType);
    }

    /** Prints a log message with label. */
    public void log(String message, Logger logType) {
        System.out.printf("%n%s %s", logType.label(), message);
    }

    /** Prints a list of menu options. */
    public void printMenuOptions(String[] options) {
        for (int i = 1; i < options.length; i++)
            System.out.printf("%n[%d] %s", i, options[i]);

        System.out.printf("%n[%d] %s", 0, options[0]);
    }

    /** Prints menu options with a sub-heading. */
    public void printMenuOptions(String[] options, String title) {
        System.out.print("\n" + title);
        printMenuOptions(options);
    }

    /* ==========================
     * UTILITIES
     ==========================*/
    private String createBorder(int length){
        String style = "=";
        String border = style.repeat(length);
        return wrapHeader(border);
    }

    private String wrapHeader(String text){
        return "" + Ansi.BOLD + Ansi.REVERSE + config.getHeaderColor() + text + Ansi.RESET;
    }
}
