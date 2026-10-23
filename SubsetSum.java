import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSum {

    static boolean findSubset(
            int[] arr, int index, int target,
            ArrayList<Integer> result) {

        if (target == 0) {
            System.out.println("Subset = " + result);
            return true;
        }

        if (index == arr.length) {
            return false;
        }

        // Choice 1: Include the current element
        if (arr[index] <= target) {
            result.add(arr[index]);

            if (findSubset(
                    arr, index + 1, target - arr[index], result)) {
                return true;
            }

            // Backtrack
            result.remove(result.size() - 1);
        }

        // Choice 2: Exclude the current element
        return findSubset(arr, index + 1, target, result);
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

        System.out.println("Enter non-negative array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] < 0) {
                System.out.println("Negative numbers are not supported.");
                sc.close();
                return;
            }
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        if (target < 0) {
            System.out.println("Target must be non-negative.");
        } else if (!findSubset(
                arr, 0, target, new ArrayList<Integer>())) {
            System.out.println("No subset found.");
        }

        sc.close();
    }
}