import java.util.Scanner;

class MeanHeightFootballTeam {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array to store the heights of 11 players
        double[] heights = new double[11];

        // Take input for the heights of 11 players
        System.out.println("Enter the heights of 11 players in cm:");

        for (int i = 0; i < heights.length; i++) {
            heights[i] = input.nextDouble();
        }

        // Calculate the sum of all heights
        double sum = 0.0;

        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Calculate the mean height
        double mean = sum / heights.length;

        // Display the mean height
        System.out.println("Mean height of the football team: " + mean + " cm");

        // Close Scanner object
        input.close();
    }
}