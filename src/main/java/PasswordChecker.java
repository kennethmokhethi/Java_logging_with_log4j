public class PasswordChecker
{

    static int condition_met = 0;

    private static void passwordIsValid(String password)
    {
        boolean password_null = true;
        boolean pass_length_above_8 = false;
        boolean passUpperCase = false;
        boolean passLowerCase = false;
        boolean passNum = false;
        boolean passNul = true;
        boolean contain_upper_case_letters = false;
        boolean contain_lower_case_letter = false;
        boolean contain_numbers = false;
        boolean contain_special_characters =password.matches("[$&+,:;=?@#|'<>.^*()%!-]");
        String upper_case_letters = "/[A-Z]/g";
        String lowerCaseLetters = "/[a-z]/g";
        String numbers = "/[0-9]/g";
        boolean status;

        if(password != null)
        {
            password_null = false;
            if(password.toCharArray().length >= 8)
            {
                pass_length_above_8 = true;
            }

            if(password.matches(upper_case_letters))
            {
                contain_upper_case_letters = true;
            }
            if(password.matches(lowerCaseLetters))
            {
                contain_lower_case_letter = true;
            }

            if(password.matches(numbers))
            {
                contain_numbers = true;
            }
        }



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

    }
}
