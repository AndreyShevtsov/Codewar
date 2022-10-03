
/**
 * @author Andrey Shevtsov on 16.08.2022
 **/

public class PangramChecker {
    public boolean check(String sentence) {
        sentence = sentence.toLowerCase().replaceAll("\\W", "");
        String str = "abcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i < str.length(); i++) {
            int index = sentence.indexOf(str.charAt(i));
            while (index == -1) return false;
            System.out.println(index);
        }
        return true;

    }


    public static void main(String[] args) {
        PangramChecker param1 = new PangramChecker();
        PangramChecker param2 = new PangramChecker();

        System.out.println(param1.check("The quick brown fox jumps over the lazy dog."));
        System.out.println(param2.check("You shall not pass!"));
    }
}

/*
public class PangramChecker {
  public boolean check(String s){
    return s.toLowerCase().chars().filter(Character::isLetter).distinct().count() == 26;
  }
}
 */