import java.util.Scanner;

class TwoDArrayToOneD {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        // Validate rows and columns
        if (rows <= 0 || columns <= 0) {
            System.err.println("Invalid number of rows or columns.");
            System.exit(0);
        }

        // Create the 2D array
        int[][] matrix = new int[rows][columns];

        // Take input for the elements of the 2D array
        System.out.println("Enter the elements of the 2D array:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Create a 1D array with size rows * columns
        int[] array = new int[rows * columns];

        // Initialize index for the 1D array
        int index = 0;

        // Copy elements from the 2D array to the 1D array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display the 1D array
        System.out.println("The 1D array is:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Close Scanner object
        input.close();
    }
}