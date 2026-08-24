import java.util.Scanner;

class SplitStringIntoWords {

    // Method to find string length without using length()
    public static int findStringLength(String text) {

        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            // Exception occurs when the end of the string is reached
        }

        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitIntoWords(String text) {

        int textLength = findStringLength(text);
        int wordCount = 0;

        // Count the number of words
        boolean insideWord = false;

        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);

            if (ch != ' ' && !insideWord) {
                wordCount++;
                insideWord = true;
            } else if (ch == ' ') {
                insideWord = false;
            }
        }

        // Create array to store words
        String[] words = new String[wordCount];

        int wordIndex = 0;
        String currentWord = "";

        // Extract each word
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                currentWord += ch;
            } else if (!currentWord.equals("")) {
                words[wordIndex] = currentWord;
                wordIndex++;
                currentWord = "";
            }
        }

        // Store the last word
        if (!currentWord.equals("")) {
            words[wordIndex] = currentWord;
        }

        return words;
    }

    // Method to compare two String arrays
    public static boolean compareArrays(String[] firstArray,
                                        String[] secondArray) {

        if (firstArray.length != secondArray.length) {
            return false;
        }

        for (int i = 0; i < firstArray.length; i++) {
            if (!firstArray[i].equals(secondArray[i])) {
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

        // Split text using user-defined method
        String[] userDefinedWords = splitIntoWords(text);

        // Split text using built-in split() method
        String[] builtInWords = text.trim().split("\\s+");

        // Compare both arrays
        boolean result = compareArrays(userDefinedWords, builtInWords);

        // Display user-defined words
        System.out.println("\nWords using charAt():");

        for (int i = 0; i < userDefinedWords.length; i++) {
            System.out.println(userDefinedWords[i]);
        }

        // Display built-in words
        System.out.println("\nWords using split():");

        for (int i = 0; i < builtInWords.length; i++) {
            System.out.println(builtInWords[i]);
        }

        // Display comparison result
        System.out.println("\nBoth results are same: " + result);

        // Close Scanner object
        input.close();
    }
}