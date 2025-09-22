package dispatcher;

import ui.ConsolePrinter;
import ui.ConsoleReader;
import ui.MenuOptions;
import log.ConsoleLog;

import java.awt.*;

/**
 * Dispatcher class that coordinates console input and output operations.
 * <p>
 * Acts as a middle layer between the user interface (console)
 * and the underlying business logic. It delegates printing,
 * logging, and menu handling to the {@link ConsolePrinter}
 * and validates user input via the {@link ConsoleReader}.
 * </p>
 */
public class ConsoleDispatcher {
    /** Reads and validates user input from console */
    ConsoleReader input;
    /** Handles console output such as prompts and logs */
    ConsolePrinter printer;

    /**
     * Dispatches actions based on the chosen menu index.
     *
     * @param choice the index of the action to be dispatched
     */
    public void menu(int choice){
        switch(choice){
            case 0:
                break;
            default:
                printer.log("No set action for index " + choice, ConsoleLog.DEBUG);
        }
    }

    /**
     * Constructs a dispatcher with the given reader and printer.
     *
     * @param input   the {@link ConsoleReader} used for input
     * @param printer the {@link ConsolePrinter} used for output
     */
    public ConsoleDispatcher(ConsoleReader input, ConsolePrinter printer){
        this.input = input;
        this.printer = printer;
    }

    /** Prints the program introduction. */
    public void printIntroduction(){
        printer.printIntroduction();
    }

    /** Prints the program conclusion. */
    public void printConclusion(){
        printer.printConclusion();
    }

    /**
     * Prints the program's menu of options.
     */
    public void printMenuOptions(){
        printer.printMenuOptions(MenuOptions.getMenuOptions());
    }

    /**
     * Prints the program's menu of options.
     */
    public void printYNOptions(){
        printer.printMenuOptions(new String[]{"NO", "YES"});
    }

    /** Prints the program name as a header. */
    public void printProgramName(){
        printer.printProgramName();
    }

    /**
     * Prompts the user to enter a specific input type.
     *
     * @param inputType description of the expected input
     */
    public void ask(String inputType){
        printer.ask(inputType);
    }

    /**
     * Logs a message with a given type.
     *
     * @param message the message to log
     * @param log     the {@link ConsoleLog} type (INFO, ERROR, DEBUG, etc.)
     */
    public void log(String message, ConsoleLog log){
        printer.log(message, log);
    }

    /**
     * Reads a boolean input from the console with validation.
     *
     * @return a valid boolean value
     */
    public boolean getBoolean(){
        while(true){
            try{
                return input.readBoolean();
            }catch(Exception e){
                printer.log(e.getMessage(), ConsoleLog.ERROR);
                printer.ask("(y/n)");
            }
        }
    }

    /**
     * Reads a string input from the console with validation.
     *
     * @return a valid string
     */
    public String getString(){
        while(true){
            try{
                return input.readString();
            }catch(Exception e){
                printer.log(e.getMessage(), ConsoleLog.ERROR);
                printer.ask("valid text");
            }
        }
    }

    /**
     * Reads an integer input from the console with validation.
     *
     * @return a valid integer
     */
    public int getInt(){
        while(true){
            try{
                return input.readInt();
            }catch(Exception e){
                printer.log(e.getMessage(), ConsoleLog.ERROR);
                printer.ask("valid integer");
            }
        }
    }

    /**
     * Reads an integer input within a specific range.
     *
     * @param min the minimum acceptable value (inclusive)
     * @param max the maximum acceptable value (inclusive)
     * @return a valid integer within the range
     */
    public int getIntWithRange(int min, int max){
        while(true){
            try{
                return input.readIntWithinRange(min, max);
            }catch(Exception e){
                printer.log(e.getMessage(), ConsoleLog.ERROR);
                printer.ask("valid integer");
            }
        }
    }

    /**
     * Reads an option choice from a given list of options.
     *
     * @return the index of the selected option
     */
    public int getOptionChoice(){
        while(true){
            try{
                return input.readOption(MenuOptions.getMenuOptions());
            }catch(Exception e){
                printer.log(e.getMessage(), ConsoleLog.ERROR);
                printer.ask("valid option");
            }
        }
    }

    /** Closes the underlying {@link ConsoleReader} to free resources. */
    public void close() {
        input.close();
    }
}
