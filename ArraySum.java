import java.util.Scanner;

public class ArraySum {

    static int sum(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        return arr[n - 1] + sum(arr, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid array size.");
            sc.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Sum = " + sum(arr, n));

        sc.close();
    }
}