import java.util.Scanner;

class NullPointerExceptionDemo {

    // Method to generate NullPointerException
    public static void generateException() {

        // Create a null String
        String text = null;

        // Access a String method using null reference
        System.out.println(text.length());
    }

    // Method to handle NullPointerException
    public static void handleException() {

        // Create a null String
        String text = null;

        try {
            // Access a String method using null reference
            System.out.println(text.length());
        } catch (NullPointerException exception) {

            // Handle NullPointerException
            System.err.println("NullPointerException handled.");
            System.err.println("Message: " + exception.getMessage());
        } catch (RuntimeException exception) {

            // Handle any other RuntimeException
            System.err.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {

        // Call the method that generates the exception
        // Uncomment this line to see the exception occur
        // generateException();

        // Call the method that handles the exception
        handleException();
    }
}