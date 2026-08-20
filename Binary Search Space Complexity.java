public class BinarySearchSpaceComplexity {

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
    Binary Search uses only a few variables:

    low
    high
    mid

    No extra array or recursive call stack is used.

    Auxiliary Space Complexity = O(1)
    */
}