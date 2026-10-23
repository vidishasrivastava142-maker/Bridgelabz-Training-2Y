import java.util.Arrays;
import java.util.Scanner;

public class NQueensSolver {

    static int N;
    static int[] board;
    static boolean[] cols;
    static boolean[] diag1;
    static boolean[] diag2;

    static boolean solve(int row) {

        if (row == N) {
            return true;
        }

        for (int col = 0; col < N; col++) {

            int d1 = row - col + N - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            board[row] = col;

            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            if (solve(row + 1)) {
                return true;
            }

            board[row] = -1;

            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        N = sc.nextInt();

        if (N <= 0) {
            System.out.println("N must be positive.");
            sc.close();
            return;
        }

        board = new int[N];
        Arrays.fill(board, -1);

        cols = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];

        if (solve(0)) {

            System.out.println("One valid solution:");

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
            System.out.println("No solution exists.");
        }

        sc.close();
    }
}