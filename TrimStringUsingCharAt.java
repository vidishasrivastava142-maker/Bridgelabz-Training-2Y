import java.util.Scanner;

class TrimStringUsingCharAt {

    // Method to find the start and end indexes after trimming spaces
    public static int[] findTrimIndexes(String text) {

        // Find the length of the string
        int length = text.length();

        // Start from the beginning
        int start = 0;

        // Find the first non-space character
        while (start < length && text.charAt(start) == ' ') {
            start++;
        }

        // Start from the end
        int end = length - 1;

        // Find the last non-space character
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        // Return start and end indexes
        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {

        // Create an empty string
        String result = "";

        // Add characters from start to end
        for (int i = start; i <= end; i++) {
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

        // Compare every character
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
        System.out.print("Enter a string with spaces: ");
        String text = input.nextLine();

        // Find indexes after trimming
        int[] indexes = findTrimIndexes(text);

        String userDefinedTrimmed;

        // Handle a string containing only spaces
        if (indexes[0] > indexes[1]) {
            userDefinedTrimmed = "";
        } else {
            // Create trimmed string using charAt()
            userDefinedTrimmed =
                    createSubstring(text, indexes[0], indexes[1]);
        }

        // Trim using built-in trim() method
        String builtInTrimmed = text.trim();

        // Compare both strings
        boolean result =
                compareStrings(userDefinedTrimmed, builtInTrimmed);

        // Display results
        System.out.println("Trimmed using charAt(): "
                + userDefinedTrimmed);

        System.out.println("Trimmed using trim(): "
                + builtInTrimmed);

        System.out.println("Both results are same: " + result);

        // Close Scanner object
        input.close();
    }}