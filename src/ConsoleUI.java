import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ConsoleUI {
    /** Instance field for the service where business logic lies */
    Service service = new Service();

    /** Efficient reader for console inputs */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /** Constructor for the Console UI class */
    ConsoleUI(){}

    /**
     * Dispatches actions from the business layer
     * @param choice
     */
    void menu(int choice){
        switch(choice){
            case 0:
                break;
            default:
                showMessage(ConsoleTag.DEBUG, "No set action for index" + choice);
        }
    }
    /**
     * Prompts program termination
     * @return y/n value, y will proceed with termination, n will not
     */
    boolean promptTermination(){
        showMessage(ConsoleTag.SYSTEM, "Exit the program?");
        showOptions(new String[] {"NO", "YES"});
        showEnterPrompt("choice");

        // 'Yes' will set continueProgram to false, vice versa
        return !getBoolean();
    }
    /* ==========================
     * USER-INTERFACE METHODS
     ==========================*/
    void showProgramName(){
        printf("%n%n======== %s ========", "Java Coursework Menu Options");
    }

    /** Shows a brief introduction of the program on console */
    void showIntroduction(){
        print("\nJava Coursework Introduction!! \nDate Created: YYYY / MM / DD \nCreated by: Dekxisosta");
    }

    /** Shows a brief conclusion upon program termination */
    void showConclusion(){
        print("\nJava Coursework Conclusion!! \nThank you for using the program!! \n- Dekxi");
    }

    /**
     * Shows an enter prompt with expected input type
     * @param prompt expected input type
     */
    void showEnterPrompt(String prompt){
        printf("%nEnter %s: ", prompt);
    }

    /**
     * Shows a message with its appropriate logging tag
     * @param tag used for getting its corresponding label
     * @param message the message to be conveyed
     */
    void showMessage(ConsoleTag tag, String message){
        printf("%n%s %s", tag.label(), message);
    }

    /**
     * Shows a set of options
     * @param options the set of options to be displayed
     */
    void showOptions(String[] options){
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
    int getInt(){
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
    int getIntWithinRange(int min, int max){
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
    String getString(){
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
    boolean getBoolean(){
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
    enum ConsoleTag{
        DEBUG("[DEBUG]"),
        ERROR("[ERROR]"),
        SYSTEM("[SYSTEM]"),
        INFO("[INFO]");

        private String label;
        ConsoleTag(String label){ this.label = label;}

        String label(){return this.label;}
    }

    /** Shorthand print method */
    void print(String message){
        System.out.print(message);
    }

    /** Shorthand printf method */
    void printf(String format, Object... args){
        System.out.printf(format, args);
    }

    /** Shorthand println method for explicit line spacing */
    void println(){
        System.out.println();
    }

    /** Closes the BufferedReader obj to assure resource-saving if JVM garbage collection fails */
    void close(){
        try{
            reader.close();
        }catch(IOException ignored){}
    }
}
