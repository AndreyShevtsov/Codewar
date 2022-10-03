import org.jetbrains.annotations.NotNull;

/**
 * @author Andrey Shevtsov on 07.08.2022
 **/

public class Kata {
    public static void main(String[] args) {

        String str = "sumo";
        String ending = "umo";
        for (int i = 1; i < (str.length() + 1); i++) {
            System.out.print(str.charAt(str.length() - i));
        }
        System.out.println();
        for (int i = 1; i < (ending.length() + 1); i++) {
            System.out.print(ending.charAt(ending.length() - i));
        }
        System.out.println();
        System.out.println(solution(str, ending));
        System.out.println();

    }

    public static boolean solution(String str, @NotNull String ending) {
        for (int i = 1; i <= ending.length(); i++) {
            if ((str.charAt(str.length() - i) == ending.charAt(ending.length() - i)) & (ending.length() <= str.length()))
                ;
            else return false;

        }
        return true;

    }


}