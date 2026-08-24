import java.util.Scanner;

class UniqueCharacters {

    // Method to find the length of the text without using length()
    public static int findLength(String text) {
        int count = 0;

        for (char ch : text.toCharArray()) {
            count++;
        }

        return count;
    }

    // Method to find unique characters
    public static char[] findUniqueCharacters(String text) {

        int textLength = findLength(text);
        char[] uniqueCharacters = new char[textLength];
        int uniqueCount = 0;

        for (int i = 0; i < textLength; i++) {

            boolean isUnique = true;

            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueCharacters[uniqueCount] = text.charAt(i);
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            result[i] = uniqueCharacters[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        char[] result = findUniqueCharacters(text);

        System.out.print("Unique characters: ");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        scanner.close();
    }
}