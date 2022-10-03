import static java.lang.Math.abs;

/**
 * @author Andrey Shevtsov on 16.08.2022
 **/

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if ((a == null) || (b == null)) return false;

        if (a.length != b.length)
            return false;

        int sum1 = 0;
        int sum2 = 0;

        for (int x : b) {
            double result = Math.sqrt(abs(x));
            sum1 += result;
        }
        for (int y : a) {
            sum2 += Math.abs(y);
        }
        if (sum1 != sum2) return false;
        return true;
    }


    public static void main(String[] args) {

          int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
          int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(a, b));
    }
}
//       public class AreSame {
//
//  public static boolean comp(int[] a, int[] b) {
//    if ((a == null) || (b == null)){
//          return false;
//    }
//    int[] aa = Arrays.stream(a).map(n -> n * n).toArray();
//    Arrays.sort(aa);
//    Arrays.sort(b);
//    return (Arrays.equals(aa, b));
//
//  }
//}
