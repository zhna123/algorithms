package test;

/**
 * Created by nz026920 on 7/29/16.
 */

// don't forget the return statement

public class ArrayRotate {

    static boolean isRotated(int[] array1, int[] array2) {
        int length = array2.length;
        for (int i =0; i<length; i++) {
            int tmp = array2[i];
            array2[i] = array2[i+1];
            array2[length-1] = tmp;
            if (isSame(array1, array2)) {
                return true;
            }
            length--;
        }
        return false;
    }

    static boolean isSame(int[] array1, int[] array2) {
        for (int i=0; i<array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] test1 = new int[] {1,2,3,5,6,7,8};
        int[] test2 = new int[] {5,6,7,8,1,2,3};
        System.out.println(isRotated(test1, test2));
    }

}
