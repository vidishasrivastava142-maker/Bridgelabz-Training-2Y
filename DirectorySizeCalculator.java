import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DirectorySizeCalculator {

    static Set<String> visited = new HashSet<>();

    static long calculateSize(File file) throws IOException {

        if (!file.exists()) {
            return 0;
        }

        if (java.nio.file.Files.isSymbolicLink(file.toPath())) {
            return 0;
        }

        if (file.isFile()) {
            return file.length();
        }

        String path = file.getCanonicalPath();

        if (!visited.add(path)) {
            return 0;
        }

        long total = 0;
        File[] files = file.listFiles();

        if (files != null) {
            for (File item : files) {
                total += calculateSize(item);
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String path = sc.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            long size = calculateSize(directory);

            System.out.println("Total size: " + size + " bytes");
            System.out.println("Total size: " + (size / 1024.0) + " KB");
        } else {
            System.out.println("Invalid directory path.");
        }

        sc.close();
    }
}