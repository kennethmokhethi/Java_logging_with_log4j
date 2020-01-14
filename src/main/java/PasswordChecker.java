import java.util.Scanner;

public class PasswordChecker
{
    //function that check if the password is valid
    private static void passwordIsValid(String password)
    {
        boolean password_null = password.isEmpty();
        boolean pass_length_above_8 = (password.toCharArray().length >= 8);
        boolean contain_upper_case_letters = password.matches(".*[A-Z].*");;
        boolean contain_lower_case_letter = password.matches(".*[a-z].*");
        boolean contain_numbers = password.matches(".*\\d.*");;
        boolean contain_special_characters = password.matches(".*[$&+,:;=?@#|'<>.^*()%!-].*");
        
        //Calling the function for error handling
        error_handling(password_null ,pass_length_above_8 ,contain_upper_case_letters ,contain_lower_case_letter,
                        contain_special_characters ,contain_numbers);

    }

    //Function for error handling:Utility method for passwordIsValid(password) function
    private static void error_handling(boolean password_null  ,boolean pass_length_above_8 ,boolean contain_upper_case_letters ,
                                       boolean contain_lower_case_letter ,boolean contains_special_char ,boolean contain_numbers)
    {
        try {
            if (!password_null) {
                if (pass_length_above_8) {
                    if (contain_upper_case_letters) {

                        if (contain_lower_case_letter) {

                            if (contain_numbers) {

                                if (contains_special_char) {
                                    System.out.println("All requirements met");
                                } else {
                                    throw new ArithmeticException("Password has no special character");
                                }
                            } else {
                                throw new ArithmeticException("Password has no number");
                            }

                        } else {
                            throw new ArithmeticException("Password has no lower case letter");
                        }

                    } else {
                        throw new ArithmeticException("Password has no upper case letter");
                    }

                } else {
                    throw new ArithmeticException("Password less than 8 characters");
                }

            } else {
                throw new ArithmeticException("Password is null");
            }

        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }

    //function that check if the password meets at least 3 requirements
    private static boolean passwordIsOk(String password)
    {
        int condition_met = 0;
        boolean password_null = true;
        boolean pass_length_above_8 = (password.toCharArray().length >= 8);
        boolean contain_upper_case_letters = password.matches(".*[A-Z].*");;
        boolean contain_lower_case_letter = password.matches(".*[a-z].*");
        boolean contain_numbers = password.matches(".*\\d.*");;
        boolean contain_special_characters = password.matches(".*[$&+,:;=?@#|'<>.^*()%!-].*");

        if(password != null)
        {
            password_null = false;
        }
        if(password_null) return false;
        if(!pass_length_above_8) return false;

        if(contain_lower_case_letter) ++condition_met;
        if(contain_numbers) ++condition_met;
        if(contain_upper_case_letters) ++condition_met;
        if(contain_special_characters) ++condition_met;
        return condition_met >= 1;
    }




    public static void main(String[] args)
    {
        //Testing if the password meets the minimum requirement set:passwordIsValid(password)
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter password");
        String password = scan.nextLine();
        passwordIsValid(password);
        System.out.println("------------------------------------------------------------");

        //Testing if the password meet at least 3 requirements;passwordIsOk(password)
        System.out.println("------------------------------------------------------------");
        System.out.println("Enter password to check if it meets at least 3 requirements");
        System.out.println(passwordIsOk(password));
        System.out.println("------------------------------------------------------------");
    }
}
