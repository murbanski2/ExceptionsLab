package lab4;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private NameService nameService;
    private static final String ERR_MSG =
            "Sorry, you must provide both a first name and a last name. "
            + "Please try again.";

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {
        try {
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        String lastName = nameService.extractLastName(fullName);
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        }
        catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, ERR_MSG );
            
        }
        finally {
            System.out.println("The method used gui input of a name");
            System.out.println("and the name was split at the spaces.");
            System.out.println("The word following the first space");
            System.out.println("is considered the last name.");
            System.out.println("The name was validated.");
        }
        
        
        
    }
     
}
