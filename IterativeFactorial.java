import java.util.Scanner;

public class IterativeFactorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n < 0 || n > 12) {
            System.out.println("Enter a number between 0 and 12.");
        } else {
            long result = 1;

            for (int i = 2; i <= n; i++) {
                result *= i;
            }

            System.out.println("Factorial = " + result);
        }

        sc.close();
    }
}