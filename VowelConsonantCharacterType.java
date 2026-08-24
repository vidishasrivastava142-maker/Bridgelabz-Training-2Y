import java.util.Scanner;

class VowelConsonantCharacterType {

    // Method to check whether a character is a vowel, consonant, or not a letter
    public static String checkCharacterType(char ch) {

        // Convert uppercase character to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if the character is a letter
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }

        // Check if the character is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        // Otherwise, it is a consonant
        return "Consonant";
    }

    // Method to find the character type for every character
    public static String[][] findCharacterTypes(String text) {

        // Create a 2D array to store character and its type
        String[][] characterData = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {

            // Store the character
            characterData[i][0] = String.valueOf(text.charAt(i));

            // Store the character type
            characterData[i][1] = checkCharacterType(text.charAt(i));
        }

        return characterData;
    }

    // Method to display the 2D array in tabular format
    public static void displayCharacterTypes(String[][] characterData) {

        System.out.println("\nCharacter\tType");
        System.out.println("-------------------------");

        for (int i = 0; i < characterData.length; i++) {
            System.out.println(
                    characterData[i][0] + "\t\t" + characterData[i][1]
            );
        }
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter a text: ");
        String text = input.nextLine();

        // Find character types
        String[][] characterData = findCharacterTypes(text);

        // Display the character types
        displayCharacterTypes(characterData);

        // Close Scanner object
        input.close();
    }
}