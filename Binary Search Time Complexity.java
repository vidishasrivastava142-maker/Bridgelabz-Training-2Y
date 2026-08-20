public class BinarySearchTimeComplexity {

    public static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /*
    Array: {0, 2, 3, 4, 8, 61}
    Target = 4

    Step 1:
    low = 0, high = 5
    mid = 2
    arr[mid] = 3

    3 < 4, so search the right half.

    Step 2:
    low = 3, high = 5
    mid = 4
    arr[mid] = 8

    8 > 4, so search the left half.

    Step 3:
    low = 3, high = 3
    mid = 3
    arr[mid] = 4

    Target found.


    After each comparison, the search space becomes half.

    N / 2^k = 1

    N = 2^k

    k = log2(N)

    Worst Case Time Complexity = O(log N)
    */
}