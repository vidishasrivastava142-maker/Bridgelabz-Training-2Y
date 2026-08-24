import java.util.Scanner;

class CharacterFrequencyUsingNestedLoops {

    public static String[] findCharacterFrequency(String text) {

        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];

        for (int i = 0; i < characters.length; i++) {

            if (characters[i] == '0') {
                continue;
            }

            frequency[i] = 1;

            for (int j = i + 1; j < characters.length; j++) {

                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '0';
                }
            }
        }

        int uniqueCount = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0') {
                uniqueCount++;
            }
        }

        String[] result = new String[uniqueCount];

        int index = 0;

        for (int i = 0; i < characters.length; i++) {

            if (characters[i] != '0') {
                result[index] = characters[i] + " : " + frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void displayFrequency(String[] result) {

        System.out.println("Character\tFrequency");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        String[] result = findCharacterFrequency(text);

        displayFrequency(result);

        scanner.close();
    }
}