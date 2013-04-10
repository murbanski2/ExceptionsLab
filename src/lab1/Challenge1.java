package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    private static final String NAME_NULL_OR_BLANK_ERROR
            = "Name must not be null or blank.  Please enter a name.";

    public static void main(String[] args) {
        boolean keepGoing = true;
        while (keepGoing) {
            try {
                Challenge1 app = new Challenge1();

                String fullName = JOptionPane.showInputDialog("Enter full name:");
                if (isStringNullOrVoid(fullName)) {
                    throw new IllegalArgumentException(NAME_NULL_OR_BLANK_ERROR);
                }
                String lastName = app.extractLastName(fullName);
                String msg = "Your last name is: " + lastName;
                JOptionPane.showMessageDialog(null, msg);
                keepGoing = false;
            }
            catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, iae.getMessage() );
            }
            finally {
                //I don't think anything needs to be done here.
            } 
        }
    }
    
    public String extractLastName(String fullName) throws IllegalArgumentException{
        String[] nameParts = fullName.split(" ");
        
        if (nameParts.length < 2) {
            throw new IllegalArgumentException(
                    "Name must have at least two parts separated by a space." + 
                    "  Please enter a name with at least two parts.");
        }
        return nameParts[LAST_NAME_IDX];
        }
    
    private static boolean isStringNullOrVoid(String fName){
        boolean result = false;
        if (fName == null || fName.length() == 0) {
           result = true;
        }
        return result;
    }
}
    
 


    

