import java.util.Arrays;

/**
 * @author Andrey Shevtsov on 08.09.2022
 **/

public class UniqueNumber {
    public static double findUniq(double[] arr) {
        Arrays.sort(arr);
        double result;
            if (Math.abs(arr[0]-arr[1]) < 0.0000000000001)
                result = arr[arr.length-1];
            else result = arr[0];
            System.out.println(arr);

        return result;
    }


    public static void main(String[] args) {
        double[] arr = {1,2,1,1,1,1,1,1};
        System.out.println(findUniq(arr));


    }
}
/*
import java.util.Arrays;
 public class Kata {
    public static double findUniq(double[] arr) {
      Arrays.sort(arr);
      return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }
}

 */