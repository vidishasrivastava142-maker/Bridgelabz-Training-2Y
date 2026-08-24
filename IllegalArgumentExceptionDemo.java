import java.util.Scanner;

class IllegalArgumentExceptionDemo {

    // Method to generate IllegalArgumentException
    public static void generateException(String text) {

        // Set start index greater than end index
        int startIndex = 5;
        int endIndex = 2;

        // Generate IllegalArgumentException
        System.out.println(text.substring(startIndex, endIndex));
    }

    // Method to handle IllegalArgumentException
    public static void handleException(String text) {

        // Define indexes
        int startIndex = 5;
        int endIndex = 2;

        try {
            // Generate IllegalArgumentException
            System.out.println(text.substring(startIndex, endIndex));

        } catch (IllegalArgumentException exception) {

            // Handle IllegalArgumentException
            System.err.println("IllegalArgumentException handled.");
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
        System.out.print("Enter a string with at least 6 characters: ");
        String text = input.next();

        // Validate the string length
        if (text.length() < 6) {
            System.err.println("Invalid input. String must contain at least 6 characters.");
            input.close();
            return;
        }

        // Call the method that generates the exception
        // Uncomment this line to see the exception occur
        // generateException(text);

        // Call the method that handles the exception
        handleException(text);

        // Close Scanner object
        input.close();
    }
}