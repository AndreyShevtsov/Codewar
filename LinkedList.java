import java.util.ArrayList;
import java.util.Random;

/**
 * @author Andrey Shevtsov on 10.09.2022
 **/

public class LinkedList {


    public static void linked() {
        ArrayList<Integer> randNumbers = new ArrayList<>();
        Random rand = new Random();
        while (randNumbers.size() < 10) {
            randNumbers.add(Math.abs(rand.nextInt()) / 100000);

        }
        System.out.println(randNumbers.toString());
        int iteration = 12;
            for (int i = 0; i < randNumbers.size(); i++) {
//            System.out.println(randNumbers.get(i));
            int r = randNumbers.get(i) * 10;
//            System.out.println(r);
            randNumbers.set(i, r);
            iteration--;
            if ((iteration>0) && (i == randNumbers.size()-1)) i=-1;
            if (iteration == 0) break;

//            System.out.println(randNumbers.toString());

        }
        System.out.println(randNumbers.toString());
    }

    public static void main(String[] args) {
        linked();
        System.out.println();
    }

}

