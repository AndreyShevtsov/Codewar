/**
 * @author Andrey Shevtsov on 07.08.2022
 **/

public class SpinWords {

    public String spinWords(String sentence) {
        String[] ar = sentence.split(" ");
        String sentence1 = "";
        for (String x: ar) {if (x.length() >= 5) x = new StringBuilder(x).reverse().toString();
            if (ar.length == 1) sentence1 = x;
            else sentence1 += " " + x;
        } return sentence1.trim();

    }


    public static void main(String[] args) {
        SpinWords sent1 = new SpinWords();
        System.out.println(sent1.spinWords("Hey fellow warriors"));

    }

}


/*      spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
        spinWords( "This is a test") => returns "This is a test"
        spinWords( "This is another test" )=> returns "This is rehtona test"

        public class SpinWords {

  public String spinWords(String sentence) {


       for (String a : sentence.split(" "))
       {
           if (a.length()> 4)
           {
              sentence = sentence.replace(a, new  StringBuffer(a).reverse());
           }


       }
       return sentence;
*/