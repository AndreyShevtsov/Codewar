/**
 * @author Andrey Shevtsov on 09.09.2022
 **/

public class FindMissingLetters {
    public static char findMissingLetter(char[] letters)
    {
        char result = 0;
        for (int i = 0; i < letters.length - 1; i++) {
        if (letters[i+1] != letters[i]+1)
            result = (char) (letters[i]+1);
        }
        return result;
    }


    public static void main(String[] args) {
        char[] letters =  {'a','b','c','d','f'};
        System.out.println(letters);

        findMissingLetter(letters);
        System.out.println(findMissingLetter(letters));

    }
}
/*

["a","b","c","d","f"] -> "e"
["O","Q","R","S"] -> "P"
 */