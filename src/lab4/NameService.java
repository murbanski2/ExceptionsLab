package lab4;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) {
        try {
            String[] nameParts = fullName.split(" ");
            return nameParts[LAST_NAME_IDX];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) {
        try {
            String[] nameParts = fullName.split(" ");
            return nameParts[FIRST_NAME_IDX];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        try {
            return name.length();
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    
}
