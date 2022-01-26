package cl.velasquezabel.eyjava.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidator {
	/**
	 * as suggested by OWASP standards, owasp.org
	 * */
    private static final String MAIL_PATTERN =
            "^[a-zA-Z0-9_+&*-] + (?:\\.[a-zA-Z0-9_+&*-] + )*@(?:[a-zA-Z0-9-]+\\.) + [a-zA-Z]{2, 7}";
    
    private static final Pattern mailPattern = Pattern.compile(MAIL_PATTERN);

    public static boolean isValidEmail(final String email) {
        Matcher matcher = mailPattern.matcher(email);
        return matcher.matches();
    }

}
