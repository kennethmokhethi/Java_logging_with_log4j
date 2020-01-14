import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker
{

    static int condition_met = 0;

    private static void passwordIsValid(String password)
    {
        boolean password_null = true;
        boolean pass_length_above_8 = (password.toCharArray().length >= 8);
        boolean contain_upper_case_letters = password.matches(".*[A-Z].*");;
        boolean contain_lower_case_letter = password.matches(".*[a-z].*");
        boolean contain_numbers = password.matches(".*\\d.*");;
        boolean contain_special_characters =password.matches(".*[$&+,:;=?@#|'<>.^*()%!-].*");

        if(password != null)
        {
            password_null = false;
        }

        error_handling(password_null,pass_length_above_8,contain_upper_case_letters,contain_lower_case_letter,
                        contain_special_characters,contain_numbers);

    }

    private static boolean passwordIsOk(String password)
    {
        return condition_met >= 3;
    }

    private static void error_handling(boolean password_null  ,boolean pass_length_above_8 ,boolean contain_upper_case_letters ,
                                       boolean contain_lower_case_letter ,boolean contains_special_char ,boolean contain_numbers)
    {
            try
            {
                if(!password_null)
                {
                    if(pass_length_above_8)
                    {
                        if(contain_upper_case_letters)
                        {
                            ++condition_met;
                            if(contain_lower_case_letter)
                            {
                                ++condition_met;
                                if(contain_numbers)
                                {
                                    ++condition_met;
                                    if(contains_special_char)
                                    {
                                        ++condition_met;
                                    }else{
                                        throw  new ArithmeticException("Password has no specail characters");
                                    }
                                }else{
                                    throw new ArithmeticException("Passowrd has no number/s");
                                }

                            }else{
                                throw new ArithmeticException("Password has no lower case letter/s");
                            }

                        }else{
                            throw new ArithmeticException("Password has no upper case letter/s");
                        }

                    }else{
                        throw new ArithmeticException("Password less than 8 characters");
                    }

                }else{
                    throw new ArithmeticException("Password is null");
                }

            }catch (Exception e)
            {
                System.out.println("Error :" + e);
            }
    }


    public static void main(String[] args)
    {
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Enter password");
        String password = scan.nextLine();*/
        passwordIsValid("Hel24d");


    }
}
