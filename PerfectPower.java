import java.util.Arrays;

/**
 * @author Andrey Shevtsov on 03.09.2022
 **/

public class PerfectPower {

    public static int[] isPerfectPower(int n) {

        int m = 0;
        int k = 0;
        int result = 0;
        for (int i = 2; i <= n/i; i++) {
            for (int j = 2; j < 30; j++) {
                result = (int) Math.pow(i, j);
                if (result == n) {
                    m = i;
                    k = j;
                    int[] isPP = new int[]{m, k};
                    return isPP;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int n = 18496;

        isPerfectPower(n);
        System.out.println(Arrays.toString(isPerfectPower(n)));

    }
}
/*
public class PerfectPower {
  public static int[] isPerfectPower(int n) {
    for (var m = 2; m * m <= n; ++ m)
    for (var k = 2; Math.pow(m, k) <= n; ++ k)
      if (Math.pow(m, k) == n) return new int[]{m, k};
    return null;
  }
}
 */
