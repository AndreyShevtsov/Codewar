/**
 * @author Andrey Shevtsov on 07.08.2022
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        String str = (binary.toString());
        str = (str.substring(1, str.length()-1)).replaceAll(", ", "");
        int number = Integer.parseInt(str, 2);
        return number;
    }

    public static void main(String[] args) {
        List<Integer> binary = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 1, 1));
        System.out.println(binary);
        System.out.println(ConvertBinaryArrayToInt(binary));


    }
}
/*import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
      return Integer.parseInt(binary.toString().replaceAll("\\D", ""), 2);
    }
}
*/