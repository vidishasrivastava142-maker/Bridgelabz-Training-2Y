import java.util.Scanner;

class StringIndexOutOfBoundsExceptionDemo {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {

        // Access an index beyond the length of the string
        System.out.println(text.charAt(text.length()));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {

        try {
            // Access an index beyond the length of the string
            System.out.println(text.charAt(text.length()));

        } catch (StringIndexOutOfBoundsException exception) {

            // Handle StringIndexOutOfBoundsException
            System.err.println("StringIndexOutOfBoundsException handled.");
            System.err.println("Message: " + exception.getMessage());

        } catch (RuntimeException exception) {

            // Handle any other RuntimeException
            System.err.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for the string
        System.out.print("Enter a string: ");
        String text = input.next();

        // Call the method that generates the exception
        // Uncomment this line to see the exception occur
        // generateException(text);

        // Call the method that handles the exception
        handleException(text);

        // Close Scanner object
        input.close();
    }
}