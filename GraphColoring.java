import java.util.Scanner;

public class GraphColoring {

    static int V, C;
    static int[][] graph;
    static int[] color;

    static boolean isSafe(int vertex, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[vertex][i] == 1 && color[i] == c) {
                return false;
            }
        }

        return true;
    }

    static boolean solve(int vertex) {
        if (vertex == V) {
            return true;
        }

        for (int c = 1; c <= C; c++) {
            if (isSafe(vertex, c)) {
                color[vertex] = c;

                if (solve(vertex + 1)) {
                    return true;
                }

                // Backtrack
                color[vertex] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        V = sc.nextInt();

        System.out.print("Enter number of colors: ");
        C = sc.nextInt();

        if (V <= 0 || C <= 0) {
            System.out.println("Invalid input.");
            sc.close();
            return;
        }

        graph = new int[V][V];
        color = new int[V];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        if (solve(0)) {
            System.out.println("Vertex colors:");

            for (int i = 0; i < V; i++) {
                System.out.println(
                    "Vertex " + i + " -> Color " + color[i]
                );
            }
        } else {
            System.out.println("No valid coloring exists.");
        }

        sc.close();
    }
}