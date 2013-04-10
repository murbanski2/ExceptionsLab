package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;
    public static final String VACATION_DAYS_OVER_MAXIMUM_ERROR 
            = "Vacation days can not be more than " + MAX_VACATION_DAYS;
    public static final String VACATION_DAYS_ARE_NEGATIVE_ERROR
            = "daysVacation must not be negative";
        public static final String HIREDATE_NULL_OR_BLANK_ERROR
            = "hireDate must not be null or blank";
    public static final String HIREDATE_IN_FUTURE_ERROR
            = "hireDate must not be in the future";
    public static final String LAST_NAME_NULL_OR_BLANK_ERROR
            = "lastName must not be null or blank";
    public static final String SSN_NULL_OR_BLANK_ERROR
            = "SSN must not be null or blank";
    public static final String SSN_FORMAT_ERROR
            = "SSN must be in the form 123-45-6677";
    

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn,
            Date hireDate, int daysVacation) throws IllegalArgumentException
    {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.ssn = ssn;
//        this.hireDate = hireDate;
//        this.daysVacation = daysVacation;
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setHireDate(hireDate);
        setDaysVacation(daysVacation);
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }

    public void setDaysVacation(int daysVacation) {
        if (this.isIntNegative(daysVacation) == true) {
            throw new IllegalArgumentException(VACATION_DAYS_ARE_NEGATIVE_ERROR);       
        }
        if (this.isVacationOverMaximum(daysVacation)) {
            throw new IllegalArgumentException(VACATION_DAYS_OVER_MAXIMUM_ERROR);
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (isStringNullOrBlank(ssn) == true) {
            throw new IllegalArgumentException(SSN_NULL_OR_BLANK_ERROR);
        }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        if(hireDate == null) {
            throw new IllegalArgumentException(HIREDATE_NULL_OR_BLANK_ERROR);
        }
        if (isDateInFuture(hireDate)) {
            throw new IllegalArgumentException(HIREDATE_IN_FUTURE_ERROR);
        }
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (isStringNullOrBlank(ssn) == true) {
            throw new IllegalArgumentException(LAST_NAME_NULL_OR_BLANK_ERROR);
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if (isStringNullOrBlank(ssn) == true) {
            throw new IllegalArgumentException(SSN_NULL_OR_BLANK_ERROR);
        }
        if (isSsnFormatValid(ssn) == false) {
            throw new IllegalArgumentException(SSN_FORMAT_ERROR);
        }
        this.ssn = ssn;
    }
    
    private boolean isStringNullOrBlank(String theString) {
        boolean result = false;
        if (theString == null || theString.length() == 0) {
            result = true;
        }
        return result;
    }
    
    private boolean isSsnFormatValid(String ssn) {
        boolean result = false;
        if (ssn.matches("[0-9]{3}\\-[0-9]{2}\\-[0-9]{4}")) {
            //ssn is correct format
            result = true;
        }
        return result;
    }
    
    private boolean isDateInFuture(Date d){
        boolean result = false;
        Date now = new Date();
        if(d.compareTo(now) > 0) {
            result = true;
        }
        return result;
    }
    
    private boolean isIntNegative(int i) {
        boolean result = false;
        if (i < 0) {
            result = true;
        }
        return result;
    }
    
    private boolean isVacationOverMaximum(int d) {
        boolean result = false;
        if (d > this.MAX_VACATION_DAYS) result = true;
        return result;
    }
}
