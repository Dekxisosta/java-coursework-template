package app;

import dispatcher.ConsoleDispatcher;
import ui.ConsolePrinter;
import ui.ConsoleReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Java Simple Coursework Template.
 * <p>
 * This program is created to reduce the need for writing boilerplate code.
 * It demonstrates a layered architecture where the main class is responsible
 * only for application startup and wiring dependencies.
 * </p>
 *
 * <p><b>Created by:</b> Dekxisosta<br>
 * <b>Date:</b> 2025-09-19</p>
 */
public class App {

    /* ==========================
     * ENTRY-POINT METHOD
     ==========================*/

    /**
     * Application entry point.
     *
     * @param args command-line arguments (not used in this template)
     */
    public static void main(String[] args) {
        ConsoleReader input = new ConsoleReader(
                new BufferedReader(new InputStreamReader(System.in))
        );
        ConsolePrinter printer = new ConsolePrinter();
        ConsoleDispatcher dispatcher = new ConsoleDispatcher(input, printer);
        AppRunner runner = new AppRunner(dispatcher);

        try {
            runner.run();
        } catch (Exception e) {
            System.err.println(
                    "Unexpected error occurred while running App: " + e.getMessage()
            );
            e.printStackTrace(System.err);
        }
    }
}
