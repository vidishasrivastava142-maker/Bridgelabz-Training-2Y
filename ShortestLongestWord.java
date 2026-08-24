import java.util.Scanner;

class ShortestLongestWord {

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

    // Method to find shortest and longest word indexes
    public static int[] findShortestLongest(String[][] wordData) {

        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordData.length; i++) {

            int currentLength = Integer.parseInt(wordData[i][1]);
            int shortestLength = Integer.parseInt(wordData[shortestIndex][1]);
            int longestLength = Integer.parseInt(wordData[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }

            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter a text: ");
        String text = input.nextLine();

        // Split text into words
        String[] words = splitIntoWords(text);

        // Validate that at least one word exists
        if (words.length == 0) {
            System.err.println("Invalid input. No words found.");
            input.close();
            return;
        }

        // Create 2D array containing words and their lengths
        String[][] wordData = createWordLengthArray(words);

        // Find shortest and longest word
        int[] result = findShortestLongest(wordData);

        // Display the result
        int shortestIndex = result[0];
        int longestIndex = result[1];

        System.out.println("\nShortest Word: " + wordData[shortestIndex][0]);
        System.out.println("Length: " + wordData[shortestIndex][1]);

        System.out.println("\nLongest Word: " + wordData[longestIndex][0]);
        System.out.println("Length: " + wordData[longestIndex][1]);

        // Close Scanner object
        input.close();
    }
}