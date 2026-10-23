import java.util.Scanner;

public class PowerCalculator {

    static long power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base: ");
        int x = sc.nextInt();

        System.out.print("Enter non-negative exponent: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Exponent must be non-negative.");
        } else {
            System.out.println("Result = " + power(x, n));
        }

        sc.close();
    }
}