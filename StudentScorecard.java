import java.util.Scanner;

class StudentScorecard {

    // Method to generate random 2-digit marks for Physics, Chemistry and Maths
    public static int[][] generateMarks(int numberOfStudents) {

        int[][] marks = new int[numberOfStudents][3];

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                marks[i][j] = (int) (Math.random() * 91) + 10;
            }
        }

        return marks;
    }

    // Method to calculate total, average and percentage
    public static double[][] calculateResults(int[][] marks) {

        double[][] results = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {

            int total = marks[i][0] + marks[i][1] + marks[i][2];

            double average = (double) total / marks[i].length;
            double percentage = (double) total / 300 * 100;

            // Round values to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }

        return results;
    }

    // Method to calculate grade based on percentage
    public static String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    // Method to create grade array
    public static String[][] createGradeArray(double[][] results) {

        String[][] grades = new String[results.length][1];

        for (int i = 0; i < results.length; i++) {
            grades[i][0] = calculateGrade(results[i][2]);
        }

        return grades;
    }

    // Method to display the scorecard
    public static void displayScorecard(int[][] marks,
                                        double[][] results,
                                        String[][] grades) {

        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {

            System.out.println(
                    (i + 1) + "\t"
                    + marks[i][0] + "\t"
                    + marks[i][1] + "\t\t"
                    + marks[i][2] + "\t"
                    + (int) results[i][0] + "\t"
                    + results[i][1] + "\t"
                    + results[i][2] + "%\t\t"
                    + grades[i][0]
            );
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

        // Generate marks
        int[][] marks = generateMarks(numberOfStudents);

        // Calculate total, average and percentage
        double[][] results = calculateResults(marks);

        // Calculate grades
        String[][] grades = createGradeArray(results);

        // Display scorecard
        displayScorecard(marks, results, grades);

        // Close Scanner object
        input.close();
    }
}