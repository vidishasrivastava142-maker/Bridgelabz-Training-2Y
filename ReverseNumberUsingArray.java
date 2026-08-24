import java.util.Scanner;

class ReverseNumberUsingArray {
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
            System.out.println("Reversed number: 0");
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

        // Create an array to store the reversed digits
        int[] reversedDigits = new int[digits.length];

        // Copy digits into the reversed array
        for (int i = 0; i < digits.length; i++) {
            reversedDigits[i] = digits[digits.length - 1 - i];
        }

        // Display the original digits
        System.out.println("Digits of the number:");

        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i] + " ");
        }

        System.out.println();

        // Display the reversed array
        System.out.println("Reversed number:");

        for (int i = reversedDigits.length - 1; i >= 0; i--) {
            System.out.print(reversedDigits[i]);
        }

        System.out.println();

        // Close Scanner object
        input.close();
    }
}