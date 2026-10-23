```java
import java.util.Scanner;

public class NQueensProblem {

    static int N;
    static int[] board;
    static boolean[] columns;
    static boolean[] diagonal1;
    static boolean[] diagonal2;

    static boolean solve(int row) {
        if (row == N) {
            return true;
        }

        for (int col = 0; col < N; col++) {
            int d1 = row - col + N - 1;
            int d2 = row + col;

            if (!columns[col] && !diagonal1[d1] && !diagonal2[d2]) {

                board[row] = col;
                columns[col] = true;
                diagonal1[d1] = true;
                diagonal2[d2] = true;

                if (solve(row + 1)) {
                    return true;
                }

                board[row] = -1;
                columns[col] = false;
                diagonal1[d1] = false;
                diagonal2[d2] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        N = sc.nextInt();

        if (N <= 0) {
            System.out.println("N must be positive.");
            sc.close();
            return;
        }

        board = new int[N];
        columns = new boolean[N];
        diagonal1 = new boolean[2 * N - 1];
        diagonal2 = new boolean[2 * N - 1];

        for (int i = 0; i < N; i++) {
            board[i] = -1;
        }

        if (solve(0)) {
            System.out.println("Solution:");
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (board[row] == col) {
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists for N = " + N);
        }

        sc.close();
    }
}
```
