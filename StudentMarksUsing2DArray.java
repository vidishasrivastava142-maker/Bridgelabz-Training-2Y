import java.util.Scanner;

class StudentMarksUsing2DArray {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Validate the number of students
        if (numberOfStudents <= 0) {
            System.err.println("Invalid number of students.");
            System.exit(0);
        }

        // Create a 2D array to store Physics, Chemistry and Maths marks
        // Column 0 = Physics, Column 1 = Chemistry, Column 2 = Maths
        double[][] marks = new double[numberOfStudents][3];

        // Create arrays to store percentages and grades
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];

        // Define maximum marks
        double maximumMarks = 100.0;
        double totalMaximumMarks = maximumMarks * 3;

        // Take input for marks of each student
        for (int i = 0; i < marks.length; i++) {

            // Take Physics marks
            while (true) {
                System.out.print("Enter Physics marks for student " + (i + 1) + ": ");
                double physicsMarks = input.nextDouble();

                if (physicsMarks >= 0 && physicsMarks <= maximumMarks) {
                    marks[i][0] = physicsMarks;
                    break;
                }

                System.err.println("Invalid marks. Enter marks between 0 and 100.");
            }

            // Take Chemistry marks
            while (true) {
                System.out.print("Enter Chemistry marks for student " + (i + 1) + ": ");
                double chemistryMarks = input.nextDouble();

                if (chemistryMarks >= 0 && chemistryMarks <= maximumMarks) {
                    marks[i][1] = chemistryMarks;
                    break;
                }

                System.err.println("Invalid marks. Enter marks between 0 and 100.");
            }

            // Take Maths marks
            while (true) {
                System.out.print("Enter Maths marks for student " + (i + 1) + ": ");
                double mathsMarks = input.nextDouble();

                if (mathsMarks >= 0 && mathsMarks <= maximumMarks) {
                    marks[i][2] = mathsMarks;
                    break;
                }

                System.err.println("Invalid marks. Enter marks between 0 and 100.");
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < marks.length; i++) {

            // Calculate total marks
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];

            // Calculate percentage
            percentages[i] = (totalMarks / totalMaximumMarks) * 100;

            // Calculate grade
            if (percentages[i] >= 90) {
                grades[i] = "A";
            } else if (percentages[i] >= 80) {
                grades[i] = "B";
            } else if (percentages[i] >= 70) {
                grades[i] = "C";
            } else if (percentages[i] >= 60) {
                grades[i] = "D";
            } else if (percentages[i] >= 50) {
                grades[i] = "E";
            } else {
                grades[i] = "F";
            }
        }

        // Display marks, percentage and grade
        System.out.println("\nStudent Results:");

        for (int i = 0; i < marks.length; i++) {

            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }

        // Close Scanner object
        input.close();
    }
}