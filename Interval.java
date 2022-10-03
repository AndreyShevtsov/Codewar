import java.util.*;
import java.util.LinkedList;

/**
 * @author Andrey Shevtsov on 15.09.2022
 **/

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        System.out.println(Arrays.deepToString(intervals));
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        System.out.println(Arrays.deepToString(intervals));

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 0; j < intervals[0].length - 1; j++) {
                if (intervals[i + 1][j] >= intervals[i][j] && intervals[i + 1][j + 1] <= intervals[i][j + 1]) {
                    intervals[i + 1][j] = intervals[i][j];
                    intervals[i + 1][j + 1] = intervals[i][j + 1];
                }
            }
        }
        LinkedList<Integer> intervalsDuplicateEven = new LinkedList<>();
        LinkedList<Integer> intervalsDuplicateOdd = new LinkedList<>();

        int result;
        int minValue = 0;
        int maxValue = 0;
        for (int[] interval : intervals) {
            for (int j = 0; j < intervals[0].length; j++) {
                if (j % 2 == 0) {
                    intervalsDuplicateEven.add(interval[j]);
                    minValue = Collections.min(intervalsDuplicateEven);
                }
                if (j % 2 != 0) {
                    intervalsDuplicateOdd.add(interval[j]);
                    maxValue = Collections.max(intervalsDuplicateOdd);
                }
            }
        }
        System.out.println(intervalsDuplicateEven.toString());
        System.out.println(intervalsDuplicateOdd.toString());

        result = maxValue - minValue;
        System.out.println(result + "first");

        for (int i = 0; i < intervalsDuplicateEven.size()-1; i++) {
            if (intervalsDuplicateEven.get(i+1) > intervalsDuplicateOdd.get(i)) {
                result -= intervalsDuplicateEven.get(i+1) - intervalsDuplicateOdd.get(i);
                System.out.println(intervalsDuplicateEven.get(i+1) - intervalsDuplicateOdd.get(i) + "-----");
            }
        }
        System.out.println(result+ "finish");
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {-113, -108}, {-77, -69}, {-302, -298}, {158, 171}, {-141, -134}, {122, 123}, {171, 173}, {-429, -421}, {-10, 10}, {-322, -306}, {-141, -136}, {215, 220}, {32, 45}, {-301, -299}
        };
        sumIntervals(intervals);
//       System.out.println(sumIntervals(intervals));


    }
}


/*
{-113, -108}, {-77, -69}, {-302, -298}, {158, 171}, {-141, -134}, {122, 123}, {171, 173}, {-429, -421}, {-10, 10}, {-322, -306}, {-141, -136}, {215, 220}, {32, 45}, {-301, -299}


{-497, -482}, {305, 321}, {-395, -390}, {-151, -150}, {-491, -482}, {35, 52}, {127, 145}, {-496, -476}, {338, 357}, {-7, 11}, {-50, -36}, {-5, 11}, {82, 100}, {-77, -60}, {1, 5}, {159, 160}
 [1,5],
   [10, 20],
   [1, 6],
   [16, 19],
   [5, 11]
] ) => 19

 {1, 5},
                {10, 20},
                {1, 6},
                {16, 19},
                {5, 11}
 */