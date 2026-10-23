import java.util.Scanner;

public class WordSearch {

    static int N, M;
    static char[][] grid;
    static boolean[][] visited;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean search(int r, int c, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= N || c < 0 || c >= M) {
            return false;
        }

        if (visited[r][c] || grid[r][c] != word.charAt(index)) {
            return false;
        }

        visited[r][c] = true;

        for (int k = 0; k < 8; k++) {
            if (search(
                    r + dr[k], c + dc[k], word, index + 1)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        N = sc.nextInt();
        M = sc.nextInt();

        if (N <= 0 || M <= 0) {
            System.out.println("Invalid grid size.");
            sc.close();
            return;
        }

        grid = new char[N][M];
        visited = new boolean[N][M];

        System.out.println("Enter grid characters:");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.print("Enter target word: ");
        String word = sc.next().toUpperCase();

        boolean found = false;

        for (int i = 0; i < N && !found; i++) {
            for (int j = 0; j < M && !found; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    found = search(i, j, word, 0);
                }
            }
        }

        System.out.println(found ? "Word found!" : "Word not found.");

        sc.close();
    }
}