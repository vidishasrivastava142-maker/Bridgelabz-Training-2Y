import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Create an array to store multiplication results
        int[] multiplicationTable = new int[10];

        // Calculate and store multiplication results from 1 to 10
        for (int i = 1; i <= multiplicationTable.length; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the multiplication table
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }

        // Close Scanner object
        input.close();
    }
}