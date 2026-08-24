import java.util.Scanner;

class StringCompare {

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String firstText, String secondText) {

        // Check if lengths are different
        if (firstText.length() != secondText.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < firstText.length(); i++) {
            if (firstText.charAt(i) != secondText.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for the first string
        System.out.print("Enter first string: ");
        String firstText = input.next();

        // Take input for the second string
        System.out.print("Enter second string: ");
        String secondText = input.next();

        // Compare strings using user-defined method
        boolean userDefinedResult = compareStrings(firstText, secondText);

        // Compare strings using built-in equals() method
        boolean builtInResult = firstText.equals(secondText);

        // Display the results
        System.out.println("Comparison using charAt(): " + userDefinedResult);
        System.out.println("Comparison using equals(): " + builtInResult);

        // Check whether both results are the same
        System.out.println("Both results are same: "
                + (userDefinedResult == builtInResult));

        // Close Scanner object
        input.close();
    }
}