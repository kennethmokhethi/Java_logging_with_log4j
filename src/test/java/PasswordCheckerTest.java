
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {
    //Instantiating the class PasswordChecker
    PasswordChecker pass_obj = new PasswordChecker();

    //1.Tests if an exception is throw when password is null
    @Test
    void password_is_Null() throws NullPointerException
    {
        assertThrows(NullPointerException.class,()->{pass_obj.passwordIsValid("");});
    }

    //2.Tests if an exception is thrown when password is less than 8 characters
    @Test
    void password_less_than_8_chars()
    {
        assertThrows(LessCharacters.class,()->{pass_obj.passwordIsValid("d@dsA");});
    }

    //3.Tests if an exception is thrown when password does not contain an upper case letter
    @Test
    void password_no_capital_letter()
    {
       assertThrows(NoUpperCaseLetter.class,()->{pass_obj.passwordIsValid("fsdas1@fsd");});
    }

    //4.Tests if an exception is thrown when password does not contain a lower case letter
    @Test
    void password_no_small_letter()
    {
        assertThrows(NoLowerCaseLetter.class,()->{pass_obj.passwordIsValid("DSFA!FS2DSJH");});
    }

    //5.Tests if an exception is thrown when password does not contain a number
    @Test
    void password_no_number()
    {
        assertThrows(NoNumber.class,()->{pass_obj.passwordIsValid("adsFSD@VGf!");});
    }

    //6.Tests if an exception is thrown when password does not contain a special character
    @Test
    void password_no_special_char()
    {
        assertThrows(NoSpecialChar.class,()->{pass_obj.passwordIsValid("Afsd1fdvFSsd");});
    }

    //Test if "All requirements met" is returned when the password meets all requested
   @Test
    void passwordIsValid()  throws Exception
    {

        assertEquals("All requirements met",pass_obj.passwordIsValid("fsrd1@Ghdtgfs"));
    }

    @Test
    void passwordIsOk()
    {
        assertTrue(pass_obj.passwordIsOk("asds!ad2da"));
    }


}