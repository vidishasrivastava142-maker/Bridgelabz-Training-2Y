import java.util.Scanner;

class ConvertToUppercase {

    // Method to convert text to uppercase using charAt()
    public static String convertToUppercase(String text) {

        // Create an empty string to store the result
        String result = "";

        // Convert each lowercase character to uppercase
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result += ch;
        }

        return result;
    }

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

        // Take complete text input
        System.out.print("Enter a text: ");
        String text = input.nextLine();

        // Convert text using user-defined method
        String userDefinedResult = convertToUppercase(text);

        // Convert text using built-in method
        String builtInResult = text.toUpperCase();

        // Compare both results
        boolean result = compareStrings(userDefinedResult, builtInResult);

        // Display the results
        System.out.println("Uppercase using charAt(): " + userDefinedResult);
        System.out.println("Uppercase using toUpperCase(): " + builtInResult);
        System.out.println("Both results are same: " + result);

        // Close Scanner object
        input.close();
    }
}