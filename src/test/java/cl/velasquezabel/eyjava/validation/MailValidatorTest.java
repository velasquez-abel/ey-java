package cl.velasquezabel.eyjava.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MailValidatorTest {

    @ParameterizedTest(name = "#{index} - Run test with valid email for  = {0}")
    @MethodSource("validEmailProvider")
    void test_email_regex_valid(String email) {
        assertTrue(MailValidator.isValidEmail(email));
    }

    @ParameterizedTest(name = "#{index} - Run test with invalid email = {0}")
    @MethodSource("invalidEmailProvider")
    void test_email_regex_invalid(String email) {
        assertFalse(MailValidator.isValidEmail(email));
    }

    static Stream<String> validEmailProvider() {
        return Stream.of(
                "AAA@bbbccc123.o", //valid
                "123@AAAbbb.ccc", //valid
                "123.bbbccc@AAA.BBB.CCC", //valid
                "juan@rodriguez.org" , //valid
                "1A2@b3aa4.xyz", //valid
                "Haa_123456@x.z", // valid 
                "1ABCD@abcd2.x",                // valid
                "0123456789abcdefgAB@asdasdasfg34543545345.x"     // valid 
        );
    }

    static Stream<String> invalidEmailProvider() {
        return Stream.of(
                "12345678",                 // invalid, missing @
                "abcdefgh@BBB",                 // invalid, missing domain Q
                "ABCDEFGH@",                 // invalid, missing server domain Q
                "@xxxx.z",                // invalid, missing user
                "aaa.bbb@",                // invalid, incomplete
                "",                        // empty
                "");                        // empty
    }    
}
