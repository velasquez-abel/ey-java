package cl.velasquezabel.eyjava.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {

    @ParameterizedTest(name = "#{index} - Run test with valid password for  = {0}")
    @MethodSource("validPasswordProvider")
    void test_password_regex_valid(String password) {
        assertTrue(PasswordValidator.validPassword(password));
    }

    @ParameterizedTest(name = "#{index} - Run test with invalid password = {0}")
    @MethodSource("invalidPasswordProvider")
    void test_password_regex_invalid(String password) {
        assertFalse(PasswordValidator.validPassword(password));
    }

    @ParameterizedTest(name = "#{index} - Run invalid test for at lest 2 digits = {0}")
    @MethodSource("invalidTwoDigits")
    void test_two_digits_regex_invalid(String password) {
        assertFalse(PasswordValidator.atLeastTwoDigits(password));
    }

    @ParameterizedTest(name = "#{index} - Run valid test for at lest 2 digits = {0}")
    @MethodSource("validTwoDigits")
    void test_two_digits_regex_valid(String password) {
        assertFalse(PasswordValidator.atLeastTwoDigits(password));
    }
    
    //1ABCDabcd
    @Test
    void testPasswordForAtLeatTwoDigits(){
    	String password = "1ABCDabcd";
    	assertTrue( PasswordValidator.validPassword(password));
    	assertTrue( PasswordValidator.atLeastTwoDigits(password));
    	assertTrue( PasswordValidator.isValid(password));
    }
    
    static Stream<String> validTwoDigits() {
        return Stream.of(
                "AAAbbbccc123", //valid
                "123AAAbbbccc", //valid
                "123bbbcccAAA", //valid
                "1A2b3aa4", //valid
                "Haa123456", // valid 
                "0123456789abcdefgAB"     // valid, 
        );
    }
    
    static Stream<String> invalidTwoDigits() {
        return Stream.of(
                "AAAbbbccc3", //invalid
                "1AAAbbbccc", //invalid
                "3bbbcccAAA", //invalid
                "A2baaadadd", //invalid
                "AAA1BBBB", // invalid 
                "xxx2yyyy"     // invalid, 
        );
    }
    
    static Stream<String> validPasswordProvider() {
        return Stream.of(
                "AAAbbbccc123", //valid
                "123AAAbbbccc", //valid
                "123bbbcccAAA", //valid
                "1A2b3aa4", //valid
                "Haa123456", // valid 
                "1ABCDabcd2",                // valid, must have at least 2 digits
                "0123456789abcdefgAB"     // valid, 
        );
    }

    // At least
    // one lowercase character,
    // one uppercase character,
    // one digit,
    // one special character
    // and length between 8 to 20.
    static Stream<String> invalidPasswordProvider() {
        return Stream.of(
                "12345678",                 // invalid, only digit
                "abcdefgh",                 // invalid, only lowercase
                "ABCDEFGH",                 // invalid, only uppercase
                "abc123xxxx",                // invalid, at least one uppercase
                "ABC123YYYY",                // invalid, at least one lowercase
                "ABCDabcd",                // invalid, at least one digit
                "1ABCDabcd",                // invalid, must have at least 2 digits
                "",                        // empty
                "");                        // empty
    }
}