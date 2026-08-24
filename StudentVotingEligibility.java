import java.util.Scanner;

class StudentVotingEligibility {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array to store the ages of 10 students
        int[] ages = new int[10];

        // Take input for the age of each student
        System.out.println("Enter the ages of 10 students:");

        for (int i = 0; i < ages.length; i++) {
            ages[i] = input.nextInt();
        }

        // Check voting eligibility for each student
        for (int i = 0; i < ages.length; i++) {

            // Validate the age
            if (ages[i] < 0) {
                System.out.println("Invalid age: " + ages[i]);
            }
            // Check if the student can vote
            else if (ages[i] >= 18) {
                System.out.println("The student with the age " + ages[i] + " can vote.");
            }
            // Student cannot vote
            else {
                System.out.println("The student with the age " + ages[i] + " cannot vote.");
            }
        }

        // Close the Scanner object
        input.close();
    }
}