/**
 * @author Andrey Shevtsov on 05.08.2022
 **/


import java.lang.String;

public class StringSplit {
    public static String[] solution(String s) {
        if (s.length() % 2 != 0) {
            s = s + "_";
        }

        return s.split("(?<=\\G.{2})");
    }
}



//* 'abc' =>  ['ab', 'c_']
//* 'abcdef' => ['ab', 'cd', 'ef']