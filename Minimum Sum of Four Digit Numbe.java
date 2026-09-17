import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] digit = new int[4];

        for (int i = 0; i < 4; i++) {
            digit[i] = num % 10;
            num /= 10;
        }

        Arrays.sort(digit);

        int nums1 = digit[0] * 10 + digit[2];
        int nums2 = digit[1] * 10 + digit[3];

        System.out.println(nums1 + nums2);
    }
}