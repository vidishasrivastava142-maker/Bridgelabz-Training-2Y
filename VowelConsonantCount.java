import java.util.Scanner;

class VowelConsonantCount {

    // Method to check whether a character is a vowel, consonant, or not a letter
    public static String checkCharacterType(char ch) {

        // Convert uppercase character to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check whether the character is a letter
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }

        // Check whether the character is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        // Otherwise, the character is a consonant
        return "Consonant";
    }

    // Method to find the count of vowels and consonants
    public static int[] countVowelsAndConsonants(String text) {

        // Index 0 = vowels, Index 1 = consonants
        int[] count = new int[2];

        // Check every character
        for (int i = 0; i < text.length(); i++) {

            String characterType = checkCharacterType(text.charAt(i));

            if (characterType.equals("Vowel")) {
                count[0]++;
            } else if (characterType.equals("Consonant")) {
                count[1]++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter a text: ");
        String text = input.nextLine();

        // Find vowel and consonant counts
        int[] result = countVowelsAndConsonants(text);

        // Display the results
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);

        // Close Scanner object
        input.close();
    }
}