import java.util.Scanner;

class NumberCheck {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array to store 5 numbers
        int[] numbers = new int[5];

        // Take input for 5 numbers
        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        // Check each number
        for (int i = 0; i < numbers.length; i++) {

            // Check if the number is positive
            if (numbers[i] > 0) {

                // Check if the positive number is even or odd
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive and even.");
                } else {
                    System.out.println(numbers[i] + " is positive and odd.");
                }
            }

            // Check if the number is negative
            else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative.");
            }

            // Number is zero
            else {
                System.out.println(numbers[i] + " is zero.");
            }
        }

        // Compare the first and last elements
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("First and last elements are equal.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element is greater than the last element.");
        } else {
            System.out.println("First element is less than the last element.");
        }

        // Close Scanner object
        input.close();
    }
}