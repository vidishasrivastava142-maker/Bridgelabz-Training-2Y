import java.util.Scanner;

class PalindromeChecker {

    public static boolean checkPalindromeUsingLoop(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean checkPalindromeUsingRecursion(
            String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return checkPalindromeUsingRecursion(text, start + 1, end - 1);
    }

    public static char[] reverseString(String text) {

        char[] reverse = new char[text.length()];
        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }

    public static boolean checkPalindromeUsingArrays(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        boolean result1 = checkPalindromeUsingLoop(text);

        boolean result2 = checkPalindromeUsingRecursion(
                text, 0, text.length() - 1);

        boolean result3 = checkPalindromeUsingArrays(text);

        System.out.println("\nUsing Loop: " + result1);
        System.out.println("Using Recursion: " + result2);
        System.out.println("Using Character Arrays: " + result3);

        scanner.close();
    }
}