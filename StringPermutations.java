import java.util.Scanner;

public class StringPermutations {

    static void permute(String str, String result) {
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            String remaining =
                str.substring(0, i) + str.substring(i + 1);

            permute(remaining, result + ch);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        permute(str, "");

        sc.close();
    }
}