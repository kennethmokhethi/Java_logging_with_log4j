import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class PasswordChecker
{

    private static final Logger logger = LogManager.getLogger(PasswordChecker.class.getName());
    //function that check if the password is valid
    public static String passwordIsValid(String password) throws Exception {
        boolean password_null = password.isEmpty();
        boolean pass_length_above_8 = (password.toCharArray().length >= 8);
        boolean contain_upper_case_letters = password.matches(".*[A-Z].*");
        boolean contain_lower_case_letter = password.matches(".*[a-z].*");
        boolean contain_numbers = password.matches(".*\\d.*");
        boolean contain_special_characters = password.matches(".*[$&+,:;=?@#|'<>.^*()%!-].*");

        //Calling the function for error handling
      return  error_handling(password_null ,pass_length_above_8 ,contain_upper_case_letters ,contain_lower_case_letter,
                        contain_special_characters ,contain_numbers);

    }

    //Function for error handling:Utility method for passwordIsValid(password) function
    public static String error_handling(boolean password_null  ,boolean pass_length_above_8 ,boolean contain_upper_case_letters ,
                                       boolean contain_lower_case_letter ,boolean contains_special_char ,boolean contain_numbers) throws Exception
    {

            if (!password_null) {
                if (pass_length_above_8) {
                    if (contain_upper_case_letters) {

                        if (contain_lower_case_letter) {

                            if (contain_numbers) {

                                if (contains_special_char) {
                                    return ("All requirements met");
                                } else {
                                    logger.error("No special character found");
                                    throw new NoSpecialChar("password should have at least one special character");
                                }
                            } else {
                                throw new NoNumber("password should at least have one digit");
                            }

                        } else {
                            throw new NoLowerCaseLetter("password should have at least one lowercase letter");
                        }

                    } else {
                        throw new NoUpperCaseLetter("password should have at least one uppercase letter");
                    }

                } else {
                    throw new LessCharacters("password should be longer than than 8 characters");
                }

            } else {
                throw new NullPointerException("password should exist");
            }

  // return "";
    }

    //function that check if the password meets at least 3 requirements
    public static boolean passwordIsOk(String password)
    {
        int condition_met = 0;
        boolean password_null = password.isEmpty();
        boolean pass_length_above_8 = (password.toCharArray().length >= 8);
        boolean contain_upper_case_letters = password.matches(".*[A-Z].*");
        boolean contain_lower_case_letter = password.matches(".*[a-z].*");
        boolean contain_numbers = password.matches(".*\\d.*");
        boolean contain_special_characters = password.matches(".*[$&+,:;=?@#|'<>.^*()%!-].*");

        if(password_null) return false;
        if(!pass_length_above_8) return false;
        if(contain_lower_case_letter) ++condition_met;
        if(contain_numbers) ++condition_met;
        if(contain_upper_case_letters) ++condition_met;
        if(contain_special_characters) ++condition_met;
        
        return condition_met >= 1;
    }
    
    public static void main(String[] args) throws Exception {
        //Testing if the password meets the minimum requirement set:passwordIsValid(password)
        Scanner scan = new Scanner(System.in);
        logger.info("----------------------------------------------------------");
        logger.info("1. Enter password");
        String password = scan.nextLine();
        logger.debug(passwordIsValid(password));
        System.out.println("------------------------------------------------------------");

        //Testing if the password meet at least 3 requirements;passwordIsOk(password)
        logger.info("------------------------------------------------------------");
        logger.info("2. Enter password to check if it meets at least 3 requirements");
        String password2 = scan.nextLine();

        logger.debug(passwordIsOk(password2));
        logger.info("------------------------------------------------------------");
    }
}
