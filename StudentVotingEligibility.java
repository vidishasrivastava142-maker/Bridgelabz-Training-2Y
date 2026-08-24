import java.util.Scanner;

class StudentVotingEligibility {

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int numberOfStudents) {

        int[] ages = new int[numberOfStudents];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = (int) (Math.random() * 90) + 10;
        }

        return ages;
    }

    // Method to determine voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    // Method to display the result in tabular format
    public static void displayResult(String[][] result) {

        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + result[i][1]);
        }
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take number of students
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        // Validate number of students
        if (numberOfStudents <= 0) {
            System.err.println("Invalid number of students.");
            input.close();
            return;
        }

        // Generate ages
        int[] ages = generateAges(numberOfStudents);

        // Check voting eligibility
        String[][] result = checkVotingEligibility(ages);

        // Display result
        displayResult(result);

        // Close Scanner object
        input.close();
    }
}