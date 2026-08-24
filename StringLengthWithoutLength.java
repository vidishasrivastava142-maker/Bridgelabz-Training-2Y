import java.util.Scanner;

class StringLengthWithoutLength {

    // Method to find the length of a string without using length()
    public static int findStringLength(String text) {

        // Initialize count to store the number of characters
        int count = 0;

        try {
            // Infinite loop to access each character
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException exception) {

            // Exception occurs when index reaches the string length
        }

        return count;
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for the string
        System.out.print("Enter a string: ");
        String text = input.next();

        // Find length using user-defined method
        int userDefinedLength = findStringLength(text);

        // Find length using built-in length() method
        int builtInLength = text.length();

        // Display both results
        System.out.println("Length using user-defined method: "
                + userDefinedLength);

        System.out.println("Length using length(): "
                + builtInLength);

        // Compare both results
        System.out.println("Both lengths are same: "
                + (userDefinedLength == builtInLength));

        // Close Scanner object
        input.close();
    }
}