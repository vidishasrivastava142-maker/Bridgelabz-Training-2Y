import java.util.Scanner;

class CalculateBMI {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for the number of persons
        System.out.print("Enter the number of persons: ");
        int numberOfPersons = input.nextInt();

        // Validate the number of persons
        if (numberOfPersons <= 0) {
            System.err.println("Invalid number of persons.");
            System.exit(0);
        }

        // Create arrays to store weight, height, BMI and weight status
        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] bmi = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];

        // Take input for weight and height
        for (int i = 0; i < numberOfPersons; i++) {

            // Take valid weight input
            while (true) {
                System.out.print("Enter weight of person " + (i + 1) + " in kg: ");
                double weight = input.nextDouble();

                // Validate weight
                if (weight > 0) {
                    weights[i] = weight;
                    break;
                }

                System.err.println("Invalid weight. Please enter a positive value.");
            }

            // Take valid height input
            while (true) {
                System.out.print("Enter height of person " + (i + 1) + " in meters: ");
                double height = input.nextDouble();

                // Validate height
                if (height > 0) {
                    heights[i] = height;
                    break;
                }

                System.err.println("Invalid height. Please enter a positive value.");
            }
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < numberOfPersons; i++) {

            // Calculate BMI
            bmi[i] = weights[i] / (heights[i] * heights[i]);

            // Determine weight status
            if (bmi[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi[i] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display details of each person
        System.out.println("\nPerson Details:");

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height: " + heights[i] + " m");
            System.out.println("Weight: " + weights[i] + " kg");
            System.out.println("BMI: " + bmi[i]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }

        // Close Scanner object
        input.close();
    }
}