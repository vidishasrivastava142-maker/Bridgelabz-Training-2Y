public class LinearSearchSpaceComplexity {

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

    Linear Search only uses a few extra variables such as
    i and target.

    It does not create any extra array or data structure.

    Auxiliary Space Complexity = O(1)
    */
}