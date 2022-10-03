import java.util.Arrays;

/**
 * @author Andrey Shevtsov on 23.09.2022
 **/

public class Quest {

    public static void main(String[] args) {
        char [] array = {'a','b','c'};
        for (char element: array) {
            element += element;
        }
        System.out.println(Arrays.toString(array));

    }
}
