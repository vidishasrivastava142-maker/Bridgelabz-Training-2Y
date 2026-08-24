import java.util.Scanner;

class LargestSecondLargestDigit {
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
            System.out.println("Largest digit: 0");
            System.out.println("Second largest digit: Not available");
            input.close();
            return;
        }

        // Define the maximum number of digits
        int maxDigit = 10;

        // Create an array to store the digits
        int[] digits = new int[maxDigit];

        // Initialize the index
        int index = 0;

        // Store the digits in the array
        while (number != 0) {

            // Stop if the array reaches its maximum size
            if (index == maxDigit) {
                break;
            }

            // Store the last digit
            digits[index] = number % 10;

            // Remove the last digit
            number /= 10;

            // Increment the index
            index++;
        }

        // Initialize largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        // Find the largest and second largest digits
        for (int i = 0; i < index; i++) {

            // Check for the largest digit
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            }

            // Check for the second largest digit
            else if (digits[i] > secondLargest && digits[i] < largest) {
                secondLargest = digits[i];
            }
        }

        // Check whether a distinct second largest digit exists
        boolean secondLargestExists = false;

        for (int i = 0; i < index; i++) {
            if (digits[i] < largest) {
                secondLargestExists = true;
                break;
            }
        }

        // Display the largest digit
        System.out.println("Largest digit: " + largest);

        // Display the second largest digit
        if (secondLargestExists) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("Second largest digit: Not available");
        }

        // Close Scanner object
        input.close();
    }
}