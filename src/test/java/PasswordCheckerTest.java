
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {
    //Instantiating the class PasswordChecker
    PasswordChecker pass_obj = new PasswordChecker();


   @Test
    void passwordIsValid() throws myException
    {

        assertEquals("All requirements met",pass_obj.passwordIsValid("fsrd1@Ghdtgfs"));
    }

    @Test
    void passwordIsOk()
    {
        assertTrue(pass_obj.passwordIsOk("asds!ad2da"));
    }


}