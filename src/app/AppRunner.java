package app;

import dispatcher.ConsoleDispatcher;
import log.ConsoleLog;

/**
 * Controls the main program loop and coordinates interactions
 * between the dispatcher and the user.
 * <p>
 * The {@code AppRunner} manages the application lifecycle:
 * <ul>
 *   <li>Printing the introduction</li>
 *   <li>Running the main menu loop</li>
 *   <li>Delegating user actions to the dispatcher</li>
 *   <li>Handling graceful termination</li>
 * </ul>
 * </p>
 */
public class AppRunner {

    /** The dispatcher responsible for console input/output */
    private final ConsoleDispatcher dispatcher;

    /**
     * Constructs an application runner with the given dispatcher.
     *
     * @param dispatcher the dispatcher that manages I/O operations
     */
    public AppRunner(ConsoleDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    /**
     * Starts the main program loop.
     * <p>
     * This method runs until the user confirms program termination.
     * </p>
     */
    public void run() {
        boolean isContinueProgram = true;

        dispatcher.printIntroduction();

        while (isContinueProgram) {
            dispatcher.printProgramName();
            dispatcher.printMenuOptions();
            dispatcher.ask("option");

            int choice = dispatcher.getOptionChoice();

            if (choice != 0) {
                dispatcher.menu(choice);
            } else {
                isContinueProgram = promptTermination();
            }
        }

        dispatcher.printConclusion();
        dispatcher.close();
    }

    /**
     * Prompts the user to confirm termination of the program.
     *
     * @return {@code true} if the program should continue running,
     *         {@code false} if the program should terminate
     */
    private boolean promptTermination() {
        dispatcher.log("Exit the program?", ConsoleLog.SYSTEM);
        dispatcher.printYNOptions();
        dispatcher.ask("choice");

        // 'Yes' means terminate -> return false to stop the loop.
        // 'No' means continue -> return true to keep running.
        return !dispatcher.getBoolean();
    }
}
