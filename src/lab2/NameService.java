package lab2;

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
    private static final String NAME_NULL_OR_BLANK_ERROR
            = "Name must not be null or blank.";
    private static final String NAME_NOT_TWO_PARTS
            = "Name must have at least two parts separated by a space.";
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) {
        if (isStringNullOrVoid(fullName) == true) {
            throw new IllegalArgumentException(NAME_NULL_OR_BLANK_ERROR);
        }
        String[] nameParts = fullName.split(" ");
        if (isNameTwoOrMoreParts(nameParts) == false) {
            throw new IllegalArgumentException(NAME_NOT_TWO_PARTS);
        }
        return nameParts[LAST_NAME_IDX];
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) {
        if (isStringNullOrVoid(fullName) == true) {
            throw new IllegalArgumentException(NAME_NULL_OR_BLANK_ERROR);
        }
        String[] nameParts = fullName.split(" ");
        if (isNameTwoOrMoreParts(nameParts) == false) {
            throw new IllegalArgumentException(NAME_NOT_TWO_PARTS);
        }
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        if (isStringNullOrVoid(name) == true) {
            throw new IllegalArgumentException(NAME_NULL_OR_BLANK_ERROR);
        }
        return name.length();
    }
    
       
    private static boolean isStringNullOrVoid(String name){
        boolean result = false;
        if (name == null || name.length() == 0) {
           result = true;
        }
        return result;
    }
    
    private boolean isNameTwoOrMoreParts(String[] parts) {
	boolean result = true;
	if (parts.length < 2) {
            result = false;
	}
	return result;
    }
}
