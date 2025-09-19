/**
 * Java Simple Coursework Template
 * This program is created to reduce the need of writing boilerplate code
 * Created by: Dekxisosta
 * Date: 2025 / 09 / 19
 */
public class Main{
    /* ==========================
     * ENTRY-POINT METHOD
     ==========================*/
    /** @param args (not-used) */
    public static void main(String[] args){
        try{
            new ProgramController().run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}