import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Java Simple Coursework Template
 * This program is created to reduce the need of writing boilerplate code
 * Created by: Dekxisosta
 * Date: 2025 / 09 / 19
 */
public class Main{
    /* ==========================
     * INSTANCE FIELDS
     ==========================*/
    /** Console input reader */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /* ==========================
     * ENTRY-POINT METHOD
     ==========================*/
    /** @param args (not-used) */
    public static void main(String[] args){
        try{
            new Main().run();
        }catch(Exception ignored){}
    }

    /* ==========================
     * PROGRAM RUNNER METHOD
     ==========================*/
    /** Runs the actual program flow */
    private void run(){
        boolean isContinueProgram = true;
        String[] actionNames = {
                "Terminate Program"
        };

        showIntroduction();

        while(isContinueProgram){
            showProgramName();
            showOptions(actionNames);
            showEnterPrompt("choice");

            // !!! Modify max value by the number of actions
            int choice = getIntWithinRange(0,0);

            if(choice!=0)
                actionMenu(choice);
            else
                isContinueProgram = promptTermination();
        }
        showConclusion();
        close();
    }

    /* ==========================
     * ACTION METHODS
     ==========================*/
    /**
     * Serves as the menu for the action methods
     * @param choice chosen index of the action to be performed
     */
    private void actionMenu(int choice){
        switch(choice){
            //Enter actions here
        }
    }

    /**
     * Prompts program termination
     * @return y/n value, y will proceed with termination, n will not
     */
    private boolean promptTermination(){
        showMessage(ConsoleTag.SYSTEM, "Exit the program?");
        showOptions(new String[] {"NO", "YES"});
        showEnterPrompt("choice");

        // 'Yes' will set continueProgram to false, vice versa
        return !getBoolean();
    }
    /* ==========================
     * USER-INTERFACE METHODS
     ==========================*/
    private void showProgramName(){
        printf("======== %s ========", "Java Coursework Menu Options");
    }

    /** Shows a brief introduction of the program on console */
    private void showIntroduction(){
        print("\nJava Coursework Introduction!! \nDate Created: YYYY / MM / DD \nCreated by: Dekxisosta ");
        println();
        println();
    }

    /** Shows a brief conclusion upon program termination */
    private void showConclusion(){
        print("\nJava Coursework Conclusion!! \nThank you for using the program!! \n- Dekxi");
    }

    /**
     * Shows an enter prompt with expected input type
     * @param prompt expected input type
     */
    private void showEnterPrompt(String prompt){
        printf("%nEnter %s: ", prompt);
    }

    /**
     * Shows a message with its appropriate logging tag
     * @param tag used for getting its corresponding label
     * @param message the message to be conveyed
     */
    private void showMessage(ConsoleTag tag, String message){
        printf("%n%s %s", tag.label(), message);
    }

    /**
     * Shows a set of options
     * @param options the set of options to be displayed
     */
    private void showOptions(String[] options){
        for(int i=1; i<options.length; i++)
            printf("%n[%d] %s", i, options[i]);

        printf("%n[%d] %s", 0, options[0]);
    }


    /* ==========================
     * INPUT VALIDATOR METHODS
     ==========================*/
    /**
     * Gets an integer input from the console
     * @return valid integer input
     */
    private int getInt(){
        while(true){
            try{
                return Integer.parseInt(reader.readLine());
            }catch(NumberFormatException e){
                showMessage(ConsoleTag.ERROR, "Invalid number format. Please try again");
            }catch(IOException e){
                showMessage(ConsoleTag.ERROR, "Invalid input. Please try again");
            }
            showEnterPrompt("new integer");
        }
    }

    /**
     * Gets an integer input within an inclusive range of min-max
     * @param min minimum integer input (inclusive)
     * @param max maximum integer input (inclusive)
     * @return valid integer input within set range
     */
    private int getIntWithinRange(int min, int max){
        while(true){
            int num = getInt();
            if(num >= min && num <= max){
                return num;
            }
            showMessage(ConsoleTag.ERROR, "Invalid number. Must be within ["+min+".."+max+"].");
            showEnterPrompt("new integer");
        }
    }

    /**
     * Gets a string input
     * @return valid string
     */
    private String getString(){
        while(true){
            try{
                return reader.readLine();
            }catch(IOException e){
                showMessage(ConsoleTag.ERROR, "Invalid input, Please try again");
            }
            showEnterPrompt("new text");
        }
    }

    /**
     * Gets a boolean value
     * @return valid boolean
     */
    private boolean getBoolean(){
        while(true){
            String bool = getString();

            if(bool.equalsIgnoreCase("true")
                    || bool.equalsIgnoreCase("yes")
                    || bool.equalsIgnoreCase("y")
                    || bool.equalsIgnoreCase("1")){
                return true;
            }
            if(bool.equalsIgnoreCase("false")
                    || bool.equalsIgnoreCase("no")
                    || bool.equalsIgnoreCase("n")
                    || bool.equalsIgnoreCase("0")){
                return false;
            }
            showMessage(ConsoleTag.ERROR, "Invalid input. Please try again");
            showEnterPrompt("(y/n)");
        }
    }

    /* ==========================
     * UTILITIES
     ==========================*/
    /** Better logging for Console Outputs */
    private enum ConsoleTag{
        DEBUG("[DEBUG]"),
        ERROR("[ERROR]"),
        SYSTEM("[SYSTEM]"),
        INFO("[INFO]");

        private String label;
        ConsoleTag(String label){ this.label = label;}

        String label(){return this.label;}
    }

    /** Shorthand print method */
    private void print(String message){
        System.out.print(message);
    }

    /** Shorthand printf method */
    private void printf(String format, Object... args){
        System.out.printf(format, args);
    }

    /** Shorthand println method for explicit line spacing */
    private void println(){
        System.out.println();
    }

    /** Closes the BufferedReader obj to assure resource-saving if JVM garbage collection fails */
    private void close(){
        try{
            reader.close();
        }catch(IOException ignored){}
    }
}