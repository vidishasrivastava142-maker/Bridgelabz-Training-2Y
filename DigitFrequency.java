import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Validate the number
        if (number < 0) {
            System.err.println("Invalid Number. Please enter a non-negative number.");
            System.exit(0);
        }

        // Handle the case when the number is 0
        if (number == 0) {
            System.out.println("Digit 0: 1 time");
            input.close();
            return;
        }

        // Find the count of digits
        int count = 0;
        int temp = number;

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        // Create an array to store the digits
        int[] digits = new int[count];

        // Store the digits in the array
        for (int i = 0; i < digits.length; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Create a frequency array for digits 0 to 9
        int[] frequency = new int[10];

        // Calculate the frequency of each digit
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        // Display the frequency of each digit
        System.out.println("\nDigit Frequency:");

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }

        // Close Scanner object
        input.close();
    }
}