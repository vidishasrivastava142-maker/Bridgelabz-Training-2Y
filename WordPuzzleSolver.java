import java.util.Scanner;

public class WordPuzzleSolver {

    static int n = 4;
    static int m = 4;

    static char[][] grid = new char[n][m];
    static boolean[][] visited = new boolean[n][m];

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean search(int r, int c, String word, int index) {

        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= n || c < 0 || c >= m) {
            return false;
        }

        if (visited[r][c] || grid[r][c] != word.charAt(index)) {
            return false;
        }

        visited[r][c] = true;

        for (int k = 0; k < 8; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (search(nr, nc, word, index + 1)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the 4x4 grid:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.print("Enter target word: ");
        String word = sc.next().toUpperCase();

        boolean found = false;

        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m && !found; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    found = search(i, j, word, 0);
                }
            }
        }

        if (found) {
            System.out.println("Word found!");
        } else {
            System.out.println("Word not found.");
        }

        sc.close();
    }
}