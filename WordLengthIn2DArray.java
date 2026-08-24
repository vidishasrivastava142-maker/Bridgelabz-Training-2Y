import java.util.Scanner;

class WordLengthIn2DArray {

    // Method to find string length without using length()
    public static int findStringLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            // End of string reached
        }

        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitIntoWords(String text) {

        int textLength = findStringLength(text);
        int wordCount = 0;
        boolean insideWord = false;

        // Count the number of words
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);

            if (ch != ' ' && !insideWord) {
                wordCount++;
                insideWord = true;
            } else if (ch == ' ') {
                insideWord = false;
            }
        }

        // Create an array to store words
        String[] words = new String[wordCount];

        int wordIndex = 0;
        String currentWord = "";

        // Extract words
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

    // Method to create a 2D array containing words and their lengths
    public static String[][] createWordLengthArray(String[] words) {

        String[][] wordData = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            wordData[i][0] = words[i];

            int wordLength = findStringLength(words[i]);
            wordData[i][1] = String.valueOf(wordLength);
        }

        return wordData;
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter a text: ");
        String text = input.nextLine();

        // Split text into words
        String[] words = splitIntoWords(text);

        // Create 2D array containing words and lengths
        String[][] wordData = createWordLengthArray(words);

        // Display the result in tabular format
        System.out.println("\nWord\t\tLength");
        System.out.println("--------------------");

        for (int i = 0; i < wordData.length; i++) {

            // Convert length from String to Integer
            int wordLength = Integer.parseInt(wordData[i][1]);

            System.out.println(wordData[i][0] + "\t\t" + wordLength);
        }

        // Close Scanner object
        input.close();
    }
}