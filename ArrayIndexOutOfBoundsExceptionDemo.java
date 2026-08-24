import java.util.Scanner;

class ArrayIndexOutOfBoundsExceptionDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {

        // Access an index beyond the array length
        System.out.println(names[names.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {

        try {
            // Access an index beyond the array length
            System.out.println(names[names.length]);

        } catch (ArrayIndexOutOfBoundsException exception) {

            // Handle ArrayIndexOutOfBoundsException
            System.err.println("ArrayIndexOutOfBoundsException handled.");
            System.err.println("Message: " + exception.getMessage());

        } catch (RuntimeException exception) {

            // Handle any other RuntimeException
            System.err.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array of names
        String[] names = new String[3];

        // Take input for names
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = input.next();
        }

        // Call the method that generates the exception
        // Uncomment this line to see the exception occur
        // generateException(names);

        // Call the method that handles the exception
        handleException(names);

        // Close Scanner object
        input.close();
    }
}