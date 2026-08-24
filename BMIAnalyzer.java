// Question 1: Body Mass Index (BMI) of 10 Persons

import java.util.Scanner;

class BMIAnalyzer {

    public static String[] calculateBMI(double weight, double heightInCm) {
        double heightInMeter = heightInCm / 100;
        double bmi = weight / (heightInMeter * heightInMeter);

        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{
            String.valueOf(heightInCm),
            String.valueOf(weight),
            String.format("%.2f", bmi),
            status
        };
    }

    public static String[][] calculateAllBMI(double[][] persons) {
        String[][] result = new String[persons.length][4];

        for (int i = 0; i < persons.length; i++) {
            result[i] = calculateBMI(persons[i][0], persons[i][1]);
        }

        return result;
    }

    public static void displayBMI(String[][] result) {
        System.out.printf("%-12s %-12s %-10s %-15s%n",
                "Height(cm)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-12s %-12s %-10s %-15s%n",
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    result[i][3]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[][] persons = new double[10][2];

        for (int i = 0; i < persons.length; i++) {
            System.out.println("Enter details for Person " + (i + 1));

            System.out.print("Enter weight in kg: ");
            persons[i][0] = scanner.nextDouble();

            System.out.print("Enter height in cm: ");
            persons[i][1] = scanner.nextDouble();
        }

        String[][] result = calculateAllBMI(persons);

        System.out.println("\nBMI Details:");
        displayBMI(result);

        scanner.close();
    }
}