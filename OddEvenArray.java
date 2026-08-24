import java.util.Scanner;

class OddEvenArray {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for a natural number
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Validate the input
        if (number <= 0) {
            System.err.println("Invalid Number. Please enter a natural number.");
            System.exit(0);
        }

        // Create arrays to store odd and even numbers
        int[] oddNumbers = new int[number / 2 + 1];
        int[] evenNumbers = new int[number / 2 + 1];

        // Initialize indexes for odd and even arrays
        int oddIndex = 0;
        int evenIndex = 0;

        // Find and store odd and even numbers
        for (int i = 1; i <= number; i++) {

            // Store even numbers
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            }

            // Store odd numbers
            else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Display odd numbers
        System.out.println("Odd numbers:");

        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Move to the next line
        System.out.println();

        // Display even numbers
        System.out.println("Even numbers:");

        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        // Close Scanner object
        input.close();
    }
}