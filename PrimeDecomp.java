import java.util.*;

/**
 * @author Andrey Shevtsov on 17.08.2022
 **/

public class PrimeDecomp {

    public static String factors(int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int b = 2;
        while (n != 1) {
            if (n % b == 0) {
                n /= b;
                al.add(b);
            } else if (b == 2) {
                b++;
            } else {
                b += 2;
            }
        }
        StringBuilder resStr = new StringBuilder();
        System.out.println(al);
        int count = 0;
        for (int i = 0; i < al.size(); i++) {
              for (int j = 0; j < al.size(); j++) {
                 if (al.get(i) == al.get(j)) count++;
             }

            if (count == 1) resStr.append("(" + al.get(i) + ")");

            else if (count != 1 & (al.get(i) != al.get(i+1))) resStr.append("(" + al.get(i) + "**" + count + ")");

            count = 0;

        }
        String str = resStr.toString();
        return str;

    }


    public static void main(String[] args) {
//        int n = 4;
       int n = 86240;
//        int n = 7775460;
//
//       int n = 7779890;
        System.out.println(factors(n));


//    2 2 3 3 3 5 7 11 11 17    (2**2)(3**3)(5)(7)(11**2)(17)",

    }

}

/*


public class PrimeDecomp {

    public static String factors(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) {
            int count;
            for (count = 0; lst % fac == 0; ++count) {
                lst /= fac;
            }
            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }
        return result;
    }
}
 */