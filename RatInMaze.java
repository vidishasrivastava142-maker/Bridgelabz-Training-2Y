import java.util.Scanner;

public class RatInMaze {

    static int N;

    static int[][] maze;
    static int[][] path;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean solve(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N
                || maze[r][c] == 0 || path[r][c] == 1) {
            return false;
        }

        if (r == N - 1 && c == N - 1) {
            path[r][c] = 1;
            return true;
        }

        path[r][c] = 1;

        for (int k = 0; k < 4; k++) {
            if (solve(r + dr[k], c + dc[k])) {
                return true;
            }
        }

        // Backtrack
        path[r][c] = 0;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maze size: ");
        N = sc.nextInt();

        if (N <= 0) {
            System.out.println("Invalid maze size.");
            sc.close();
            return;
        }

        maze = new int[N][N];
        path = new int[N][N];

        System.out.println("Enter maze (1 = open, 0 = blocked):");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        if (maze[0][0] == 1 && solve(0, 0)) {
            System.out.println("Path found:");

            for (int[] row : path) {
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No path exists.");
        }

        sc.close();
    }
}