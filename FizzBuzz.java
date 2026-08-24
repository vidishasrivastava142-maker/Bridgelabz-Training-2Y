import java.util.Scanner;

class FizzBuzz {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Validate the user input
        if (number <= 0) {
            System.err.println("Invalid Number. Please enter a positive integer.");
            System.exit(0);
        }

        // Create a String array to store the FizzBuzz results
        String[] results = new String[number + 1];

        // Generate FizzBuzz results from 0 to the given number
        for (int i = 0; i <= number; i++) {

            // Check if the number is divisible by both 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            }

            // Check if the number is divisible by 3
            else if (i % 3 == 0) {
                results[i] = "Fizz";
            }

            // Check if the number is divisible by 5
            else if (i % 5 == 0) {
                results[i] = "Buzz";
            }

            // Store the number as a String
            else {
                results[i] = String.valueOf(i);
            }
        }

        // Display the results
        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }

        // Close Scanner object
        input.close();
    }
}