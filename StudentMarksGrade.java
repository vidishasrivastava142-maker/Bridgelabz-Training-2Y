import java.util.Scanner;

class StudentMarksGrade {
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

        // Create arrays to store marks, percentage and grade
        double[] physicsMarks = new double[numberOfStudents];
        double[] chemistryMarks = new double[numberOfStudents];
        double[] mathsMarks = new double[numberOfStudents];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];

        // Define the maximum marks for each subject
        double maximumMarksPerSubject = 100.0;
        double totalMaximumMarks = maximumMarksPerSubject * 3;

        // Take input for marks of each student
        for (int i = 0; i < numberOfStudents; i++) {

            // Take valid Physics marks
            while (true) {
                System.out.print("Enter Physics marks for student " + (i + 1) + ": ");
                double marks = input.nextDouble();

                if (marks >= 0 && marks <= maximumMarksPerSubject) {
                    physicsMarks[i] = marks;
                    break;
                }

                System.err.println("Invalid marks. Enter marks between 0 and 100.");
            }

            // Take valid Chemistry marks
            while (true) {
                System.out.print("Enter Chemistry marks for student " + (i + 1) + ": ");
                double marks = input.nextDouble();

                if (marks >= 0 && marks <= maximumMarksPerSubject) {
                    chemistryMarks[i] = marks;
                    break;
                }

                System.err.println("Invalid marks. Enter marks between 0 and 100.");
            }

            // Take valid Maths marks
            while (true) {
                System.out.print("Enter Maths marks for student " + (i + 1) + ": ");
                double marks = input.nextDouble();

                if (marks >= 0 && marks <= maximumMarksPerSubject) {
                    mathsMarks[i] = marks;
                    break;
                }

                System.err.println("Invalid marks. Enter marks between 0 and 100.");
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < numberOfStudents; i++) {

            // Calculate total marks and percentage
            double totalMarks =
                    physicsMarks[i] + chemistryMarks[i] + mathsMarks[i];

            percentages[i] = (totalMarks / totalMaximumMarks) * 100;

            // Calculate grade based on percentage
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

        // Display student marks, percentage and grade
        System.out.println("\nStudent Results:");

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + physicsMarks[i]);
            System.out.println("Chemistry: " + chemistryMarks[i]);
            System.out.println("Maths: " + mathsMarks[i]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }

        // Close Scanner object
        input.close();
    }
}