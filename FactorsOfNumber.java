import java.util.Scanner;

class FactorsOfNumber {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a positive number: ");
        int number = input.nextInt();

        // Validate the user input
        if (number <= 0) {
            System.err.println("Invalid Number. Please enter a positive number.");
            System.exit(0);
        }

        // Initialize the maximum size of the factors array
        int maxFactor = 10;

        // Create an array to store the factors
        int[] factors = new int[maxFactor];

        // Initialize the index
        int index = 0;

        // Find the factors of the number
        for (int i = 1; i <= number; i++) {

            // Check if i is a factor
            if (number % i == 0) {

                // Increase array size if it is full
                if (index == factors.length) {

                    // Create a temporary array with double the size
                    int[] temp = new int[factors.length * 2];

                    // Copy the existing factors into the temporary array
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    // Assign the temporary array to factors
                    factors = temp;

                    // Update the maximum factor size
                    maxFactor = factors.length;
                }

                // Store the factor in the array
                factors[index] = i;

                // Increment the index
                index++;
            }
        }

        // Display the factors
        System.out.println("Factors of " + number + ":");

        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        // Close Scanner object
        input.close();
    }
}