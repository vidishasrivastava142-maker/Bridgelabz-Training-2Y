import java.util.Scanner;

class CalculateBMIUsing2DArray {
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

        // Create a 2D array to store height, weight and BMI
        // Column 0 = Height, Column 1 = Weight, Column 2 = BMI
        double[][] personData = new double[numberOfPersons][3];

        // Create an array to store weight status
        String[] weightStatus = new String[numberOfPersons];

        // Take input for height and weight
        for (int i = 0; i < numberOfPersons; i++) {

            // Take valid height input
            while (true) {
                System.out.print("Enter height of person " + (i + 1) + " in meters: ");
                double height = input.nextDouble();

                // Validate height
                if (height > 0) {
                    personData[i][0] = height;
                    break;
                }

                System.err.println("Invalid height. Please enter a positive value.");
            }

            // Take valid weight input
            while (true) {
                System.out.print("Enter weight of person " + (i + 1) + " in kg: ");
                double weight = input.nextDouble();

                // Validate weight
                if (weight > 0) {
                    personData[i][1] = weight;
                    break;
                }

                System.err.println("Invalid weight. Please enter a positive value.");
            }
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < personData.length; i++) {

            // Calculate BMI
            personData[i][2] =
                    personData[i][1] / (personData[i][0] * personData[i][0]);

            // Determine weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display height, weight, BMI and status
        System.out.println("\nPerson Details:");

        for (int i = 0; i < personData.length; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height: " + personData[i][0] + " m");
            System.out.println("Weight: " + personData[i][1] + " kg");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }

        // Close Scanner object
        input.close();
    }
}