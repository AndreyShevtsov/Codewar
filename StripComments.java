import java.util.Arrays;

/**
 * @author Andrey Shevtsov on 04.09.2022
 **/

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {

        String textAfter = "";
        String[] splitText = text.split("\\\\n");

        for (String st :
                splitText) {
            for (int i = 0; i < commentSymbols.length; i++) {
                if (st.contains(commentSymbols[i]))
                    st = st.replaceAll("\\" + commentSymbols[i] + ".*", "");
//                System.out.println(st);
           }

            textAfter = textAfter + st.trim() + "\n";
        }
        System.out.println(textAfter);
        return textAfter;
    }

    public static void main(String[] args) {
        String text = "apples, pears # and bananas\\ngrapes\\nbananas !apples";
//        String text = "a #b\\nc\\nd $e f g";
        String[] commentSymbols = {"#", "!"};
//        String[] commentSymbols = {"#", "$"};
        System.out.println(text);
        System.out.println(Arrays.toString(commentSymbols));
        stripComments(text, commentSymbols);


//        System.out.println(textAfter.toString().trim());


    }

}
