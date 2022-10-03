/**
 * @author Andrey Shevtsov on 07.08.2022
 **/

public class XO {

        public static boolean getXO(String str) {
        int iter1 = 0;
        int iter2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.toLowerCase().charAt(i) == 'x') {
                iter1 = iter1 + 1;
             }
        }
        for (int j = 0; j < str.length(); j++) {
            if (str.toLowerCase().charAt(j) == 'o') {
                iter2 = iter2 + 1;
            }
        }
        return  (iter1 == iter2);

        }

    public static void main(String[] args) {
        String str = "ffxflolilxll";
        System.out.println();
        System.out.println(getXO(str));
    }
}