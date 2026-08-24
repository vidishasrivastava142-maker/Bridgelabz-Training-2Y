import java.util.Scanner;

class NumberFormatExceptionDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {

        // Convert text into an integer
        int number = Integer.parseInt(text);

        // Display the number
        System.out.println("Number: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {

        try {
            // Convert text into an integer
            int number = Integer.parseInt(text);

            // Display the number
            System.out.println("Number: " + number);

        } catch (NumberFormatException exception) {

            // Handle NumberFormatException
            System.err.println("NumberFormatException handled.");
            System.err.println("Message: " + exception.getMessage());

        } catch (RuntimeException exception) {

            // Handle any other RuntimeException
            System.err.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input as String
        System.out.print("Enter a number: ");
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