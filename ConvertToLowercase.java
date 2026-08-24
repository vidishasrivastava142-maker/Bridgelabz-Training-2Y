import java.util.Scanner;

class ConvertToLowercase {

    // Method to convert text to lowercase using charAt()
    public static String convertToLowercase(String text) {

        // Create an empty string to store the result
        String result = "";

        // Convert each uppercase character to lowercase
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // ASCII difference between uppercase and lowercase is 32
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
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
        String userDefinedResult = convertToLowercase(text);

        // Convert text using built-in method
        String builtInResult = text.toLowerCase();

        // Compare both results
        boolean result = compareStrings(userDefinedResult, builtInResult);

        // Display the results
        System.out.println("Lowercase using charAt(): " + userDefinedResult);
        System.out.println("Lowercase using toLowerCase(): " + builtInResult);
        System.out.println("Both results are same: " + result);

        // Close Scanner object
        input.close();
    }
}