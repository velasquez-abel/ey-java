package cl.velasquezabel.eyjava.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    // digit + lowercase char + uppercase char symbol
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9]{1})(?=.*[0-9]{1})(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private static final String AT_LEAST_2_DIGS =
            "^(?=.*?\\d.*\\d)$";
    		//"^(?=.*?\\d.*\\d)[a-zA-Z0-9]{8,}$";

    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
    private static final Pattern twoDigitsPattern = Pattern.compile(AT_LEAST_2_DIGS);

    public static boolean validPassword(final String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public static boolean atLeastTwoDigits(final String s) {
        Matcher matcher = twoDigitsPattern.matcher(s);
        return matcher.matches();
    }

    public static boolean isValid(final String s) {
    	return validPassword(s) && atLeastTwoDigits(s);
    }
}