import java.util.Scanner;

class StoreNumbersAndSum {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array to store maximum 10 numbers
        double[] numbers = new double[10];

        // Initialize variables
        double total = 0.0;
        int index = 0;

        // Take user input until 0, negative number, or array limit is reached
        while (true) {

            // Check if the array is full
            if (index == numbers.length) {
                break;
            }

            // Take input from the user
            System.out.print("Enter a number: ");
            double number = input.nextDouble();

            // Stop if the number is zero or negative
            if (number <= 0) {
                break;
            }

            // Store the number in the array
            numbers[index] = number;

            // Increment the index
            index++;
        }

        // Calculate the total of all stored numbers
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display all stored numbers
        System.out.println("Numbers entered:");

        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }

        // Display the total
        System.out.println("Total: " + total);

        // Close Scanner object
        input.close();
    }
}