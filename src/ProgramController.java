/** This class controls the flow of the program */
class ProgramController {
    /* ==========================
     * PROGRAM RUNNER METHOD
     ==========================*/
    /** Runs the actual program flow */
    void run(){
        ConsoleUI ui = new ConsoleUI();

        boolean isContinueProgram = true;
        /*
         * IMPORTANT! If actionNames < menu cases, then
         * (menuCases - actionNames) menu cases cannot be performed
         */
        String[] actionNames = {
                "Terminate Program"
        };

        ui.showIntroduction();

        while(isContinueProgram){
            ui.showProgramName();
            ui.showOptions(actionNames);
            ui.showEnterPrompt("choice");

            int choice = ui.getIntWithinRange(0,actionNames.length-1);

            if(choice!=0)
                ui.menu(choice);
            else
                isContinueProgram = ui.promptTermination();
        }
        ui.showConclusion();
        ui.close();
    }
}
