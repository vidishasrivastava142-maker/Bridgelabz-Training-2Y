import java.util.Scanner;

class YoungestTallestFriends {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Define the number of friends
        int friendCount = 3;

        // Create arrays to store names, ages and heights
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[friendCount];
        double[] heights = new double[friendCount];

        // Take input for age and height of each friend
        for (int i = 0; i < friendCount; i++) {

            // Take valid age input
            while (true) {
                System.out.print("Enter age of " + names[i] + ": ");
                int age = input.nextInt();

                // Validate age
                if (age > 0) {
                    ages[i] = age;
                    break;
                }

                System.err.println("Invalid age. Please enter a positive value.");
            }

            // Take valid height input
            while (true) {
                System.out.print("Enter height of " + names[i] + " in cm: ");
                double height = input.nextDouble();

                // Validate height
                if (height > 0) {
                    heights[i] = height;
                    break;
                }

                System.err.println("Invalid height. Please enter a positive value.");
            }
        }

        // Assume the first friend is the youngest and tallest
        int youngestIndex = 0;
        int tallestIndex = 0;

        // Find the youngest and tallest friend
        for (int i = 1; i < friendCount; i++) {

            // Check for youngest friend
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }

            // Check for tallest friend
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display the youngest friend
        System.out.println("\nYoungest Friend: " + names[youngestIndex]);
        System.out.println("Age: " + ages[youngestIndex]);

        // Display the tallest friend
        System.out.println("Tallest Friend: " + names[tallestIndex]);
        System.out.println("Height: " + heights[tallestIndex] + " cm");

        // Close Scanner object
        input.close();
    }
}