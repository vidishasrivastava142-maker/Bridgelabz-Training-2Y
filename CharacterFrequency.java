import java.util.Scanner;

class CharacterFrequency {

    public static String[][] findCharacterFrequency(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] > 0) {
                uniqueCount++;
                frequency[text.charAt(i)] = -frequency[text.charAt(i)];
            }
        }

        String[][] result = new String[uniqueCount][2];

        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency[ch] < 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(-frequency[ch]);

                frequency[ch] = 0;
                index++;
            }
        }

        return result;
    }

    public static void displayFrequency(String[][] result) {

        System.out.println("Character\tFrequency");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        String[][] result = findCharacterFrequency(text);

        displayFrequency(result);

        scanner.close();
    }
}