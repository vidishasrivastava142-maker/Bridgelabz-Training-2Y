import java.util.Scanner;

class StringSubstring {

    // Method to create a substring using charAt()
    public static String createSubstring(String text, int startIndex, int endIndex) {

        // Create an empty string to store the substring
        String result = "";

        // Add characters from start index to end index
        for (int i = startIndex; i < endIndex; i++) {
            result += text.charAt(i);
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

        // Take input for the text
        System.out.print("Enter a string: ");
        String text = input.next();

        // Take input for start index
        System.out.print("Enter start index: ");
        int startIndex = input.nextInt();

        // Take input for end index
        System.out.print("Enter end index: ");
        int endIndex = input.nextInt();

        // Validate the indexes
        if (startIndex < 0 || endIndex > text.length()
                || startIndex > endIndex) {

            System.err.println("Invalid start or end index.");
            input.close();
            return;
        }

        // Create substring using user-defined method
        String userDefinedSubstring =
                createSubstring(text, startIndex, endIndex);

        // Create substring using built-in substring() method
        String builtInSubstring =
                text.substring(startIndex, endIndex);

        // Compare both substrings
        boolean result =
                compareStrings(userDefinedSubstring, builtInSubstring);

        // Display the results
        System.out.println("Substring using charAt(): "
                + userDefinedSubstring);

        System.out.println("Substring using substring(): "
                + builtInSubstring);

        System.out.println("Both substrings are same: " + result);

        // Close Scanner object
        input.close();
    }
}