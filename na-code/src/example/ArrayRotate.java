package example;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class ArrayRotate {

    // this method used an extra O(n) space
    public void rotate(final int[] nums, final int k) {

        if (nums.length <= 1) {
            return;
        }

        final int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i + k < nums.length) {
                tmp[i + k] = nums[i];
            } else {
                tmp[(i + k) % nums.length] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }

    }

    // the other method which is using extra space is to store the n-k(left rotate will be k) element in an array; shift
    // rest of the array; store back (it seems clearer)
    // used O(n-k) extra space
    public void rotate4(final int[] nums, int k) {
        final int n = nums.length;
        if (n <= 1) {
            return;
        }
        if (n == k || k == 0) {
            return;
        }
        if (n < k) {
            k = k % n;
        }
        // create a new array length m
        final int m = n - k;
        final int[] tmp = new int[m];
        // store first m elements from nums to the new array
        for (int i = 0; i < m; i++) {
            tmp[i] = nums[i];
        }
        // shift the rest of nums to left
        for (int i = 0; i < k; i++) {
            nums[i] = nums[i + m];
        }
        // store tmp back to nums
        for (int i = 0; i < m; i++) {
            nums[i + k] = tmp[i];
        }
    }

    // rotate in place
    public void rotate2(final int[] nums, int k) {

        final int n = nums.length;

        if (n <= 1) {
            return;
        }

        while (n < k) {
            k = k % n;
        }

        if (n == k) {
            return;
        }

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }

    private void reverse(final int[] nums, int i, int j) {

        while (i < j) {
            final int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            i++;
            j--;
        }

    }

    // in place
    public void rotate3(final int[] nums, int k) {
        final int n = nums.length;

        if (n <= 1) {
            return;
        }

        while (n < k) {
            k = k % n;
        }

        if (n == k) {
            return;
        }

        // right rotate k == left rotate(n - k)
        k = n - k;

        // current location
        int j;
        // next location
        int d;
        // store the overwritten number
        int tmp;
        for (int i = 0; i < gcd(n, k); i++) {
            // initialize
            tmp = nums[i];
            j = i;

            while (true) {
                d = j + k;
                if (d >= n) {
                    d = d - n;
                }
                if (d == i) {
                    break;
                }
                nums[j] = nums[d];
                j = d;
            }
            // at this point, j moved to the last possible location
            nums[j] = tmp;
        }

    }

    int gcd(final int a, final int b)
    {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(final String[] args) {
        final int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        new ArrayRotate().rotate4(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
