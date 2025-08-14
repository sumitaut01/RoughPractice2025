package basicsold.exceptiohandling;


//Step 1: Extend from Exception(Checked)
// or RuntimeException(unchecked)


public class R_01ExceptionCustom {

    public static void main(String[] args)  {

            try {
                registerUser(15);
            } catch (InvalidAgeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        //Error: User must be 18 or older.

        static void registerUser(int age)  {
            if (age < 18) {
                throw new InvalidAgeException("User must be 18 or older.");
            }
            System.out.println("User registered successfully.");
        }

    }

    // or extends Exception
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}
