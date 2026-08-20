public class LinearSearchTimeComplexity {

    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    /*
    Array: {8, 61, 2, 3, 4, 0}

    Best Case:
    Target = 8

    The target is at the first position, so only one comparison
    is needed.

    Best Case Time Complexity = O(1)


    Worst Case:
    Target = 0 or a value not present in the array.

    All elements may need to be checked.

    Worst Case Time Complexity = O(N)


    Average Case:
    The target can be at any random position. Approximately N/2
    elements are checked on average.

    Average Case Time Complexity = O(N)
    */
}