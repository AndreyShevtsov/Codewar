import java.util.*;

/**
 * @author Andrey Shevtsov on 01.09.2022
 **/

public class Greed {
    public static int greedy(int[] dice) {
        int score = 0;
        int count = 0;

        int[] distDice = Arrays.stream(dice).distinct().toArray();

        System.out.println();

        for (int i = 0; i < distDice.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (dice[j] == distDice[i])
                    count++;
            }
            if (distDice[i] == 1) {
                if (count == 3)
                    score += 1000;
                else if (count > 3)
                    score += 100 * (count - 3) + 1000;
                else score += 100 * count;

            } else if (distDice[i] == 2) {
                if (count >= 3)
                    score += 200;
            } else if (distDice[i] == 3) {
                if (count >= 3)
                    score += 300;
            } else if (distDice[i] == 4) {
                if (count >= 3)
                    score += 400;
            } else if (distDice[i] == 5) {
                if (count == 3)
                    score += 500;
                else if (count > 3)
                    score += 50 * (count - 3) + 500;
                else score += 50 * count;
            } else if (distDice[i] == 6) {
                if (count >= 3)
                    score += 600;
            }
            count = 0;

        }

        return score;
    }

    public static void main(String[] args) {
//        int[] dice = {6, 6, 1, 6, 3};
        int[] dice = new int[5];
        for (int i = 0; i < 5; i++) {
            dice[i] = new Random().nextInt(7 - 1) + 1;
            System.out.print(dice[i] + " ");
        }
        System.out.println();
        System.out.println(greedy(dice));


    }

    /**
     * @author Andrey Shevtsov on 09.08.2022
     **/

    public static class DescendingOrder {
        public static int sortDesc(final int num) {
            int n = num;
            List<Integer> arr = new ArrayList<>();
            while (n != 0) {
                arr.add(n % 10);
                n /= 10;
            }
                arr.sort(Collections.reverseOrder());

            int number = 0;
            int offset = 1;
            for (int i = arr.size() - 1; i >= 0; i--) {
                number += arr.get(i) * offset;
                offset *= 10;
            }
            return number;
        }


        public static void main(String[] args) {

            int num = 145263;
            System.out.println(sortDesc(num));

        }
    }
}
/*
Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point
 */