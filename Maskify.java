import org.jetbrains.annotations.Contract;

/**
 * @author Andrey Shevtsov on 08.08.2022
 **/

public class Maskify {
    public static String maskify(String str) {
//        throw new UnsupportedOperationException("Unimplemented");
        if (str.length() < 4) {
            return str;
        } else {
            String result = "";
            for (int i = 0; i < str.length() - 4; i++) {
                result = result + "#";
            }
            result = result + str.substring(str.length() - 4);
            return result;
        }
    }


    public static void main(String[] args) {
        String str = "64607935616";
        System.out.println(maskify(str));
    }
}

/* public class Maskify {
    public static String maskify(String str) {
        return str.replaceAll(".(?=.{4})", "#");
    }
}

"4556364607935616" --> "############5616"
        "64607935616" -->      "#######5616"
        "1" -->                "1"
        "" -->                 ""

// "What was the name of your first pet?"

        "Skippy" --> "##ippy"

        "Nananananananananananananananana Batman!"
        -->
        "####################################man!"
*/