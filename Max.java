import java.util.Arrays;

/**
 * @author Andrey Shevtsov on 15.08.2022
 **/

public class Max {

    public static int sequence(int[] arr) {
        int sumMax = 0;
        if (arr.length == 0) return sumMax;
        for (int i = 0; i < arr.length - 1; i++) {
            int[] arr1 = Arrays.copyOfRange(arr, i, arr.length);
            int result = 0;
            for (int k : arr1) {
                result += k;
                if (sumMax < result) sumMax = result;
            }
        }
        return sumMax;
    }


    public static void main(String[] args) {
//      int a[] = new int[]{};
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sequence(a));


    }

}
/*
 Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 should be 6: {4, -1, 2, 1}


public class Max {
    public static int sequence(int[] arr) {

        int sum = 0;
        int max = 0;

        for(int a : arr) {
            sum += a;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }


*/