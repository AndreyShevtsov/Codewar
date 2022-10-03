import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Andrey Shevtsov on 28.09.2022
 **/

public class RomanNumerals {

    public static String toRoman(int n) {
        StringBuilder romanNumber = new StringBuilder();
        String str = Integer.toString(n);
        char[] charArray = str.toCharArray();
        List<Integer> cia = new ArrayList<Integer>();
        Collections.reverse(cia);
        for (int i = 0; i < charArray.length; i++) {
            int c = Character.getNumericValue(charArray[i]);
            cia.add(c);
        }
        Collections.reverse(cia);
        String x, y, z;
        for (int i = 0; i < cia.size(); i++) {
            switch (i) {
                case 0: {
                    x = "I";
                    y = "V";
                    z = "X";
                }
                break;
                case 1: {
                    x = "X";
                    y = "L";
                    z = "C";
                }
                break;
                case 2: {
                    x = "C";
                    y = "D";
                    z = "M";
                }
                break;
                case 3: {
                    x = "M";
                    y = "";
                    z = "";
                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
            switch (cia.get(i)) {
                case 1:
                    romanNumber.append(x);
                    break;
                case 2:
                    romanNumber.append(x).append(x);
                    break;
                case 3:
                    romanNumber.append(x).append(x).append(x);
                    break;
                case 4:
                    romanNumber.append(y).append(x);
                    break;
                case 5:
                    romanNumber.append(y);
                    break;
                case 6:
                    romanNumber.append(x).append(y);
                    break;
                case 7:
                    romanNumber.append(x).append(x).append(y);
                    break;
                case 8:
                    romanNumber.append(x).append(x).append(x).append(y);
                    break;
                case 9:
                    romanNumber.append(z).append(x);
                    break;
                case 0:
                    break;
            }
        }
        return romanNumber.reverse().toString();
    }

    public static int fromRoman(String romanNumeral) {
        int result = 0;
        romanNumeral = new StringBuilder(romanNumeral).reverse().toString();
        String x = "", y = "", z = "";
        int k = 0;
        while (!romanNumeral.isEmpty()) {
            if (romanNumeral.contains("I") || romanNumeral.contains("V")) {
                x = "I";
                y = "V";
                z = "X";
                k = 1;
            } else if ((romanNumeral.contains("X") || romanNumeral.contains("L")) && !romanNumeral.contains("I")
                    && !romanNumeral.contains("V")) {
                x = "X";
                y = "L";
                z = "C";
                k = 10;
            } else if ((romanNumeral.contains("C") || romanNumeral.contains("D") && !romanNumeral.contains("I")
                    && !romanNumeral.contains("V") && !romanNumeral.contains("X") && !romanNumeral.contains("L"))) {
                x = "C";
                y = "D";
                z = "M";
                k = 100;
            } else {
                x = "M";
                y = "Z";
                z = "Z";
                k = 1000;
            }
           StringBuilder insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(x).append(x).append(x).append(y).toString())) {
                result += 8 * k;
                romanNumeral = romanNumeral.replaceAll(x, "").replace(y, "");
            } else
                insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(x).append(x).append(y).toString())) {
                result += 7 * k;
                romanNumeral = romanNumeral.replaceAll(x, "").replace(y, "");
            } else insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(x).append(y).toString())) {
                result += 6 * k;
                romanNumeral = romanNumeral.replace(x, "").replace(y, "");
            } else insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(y).append(x).toString())) {
                result += 4 * k;
                romanNumeral = romanNumeral.replace(y, "").replace(x, "");
            } else insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(y).toString())) {
                result += 5 * k;
                romanNumeral = romanNumeral.replace(y, "");
            } else insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(x).append(x).append(x).toString())) {
                result += 3 * k;
                romanNumeral = romanNumeral.replaceAll(x, "");
           } else insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(x).append(x).toString())) {
                result += 2 * k;
                romanNumeral = romanNumeral.replaceAll(x, "");
            } else insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(z).append(x).toString())) {
                result += 9 * k;
                romanNumeral = romanNumeral.replaceFirst(z, "").replaceFirst(x, "");
            } else insertion = new StringBuilder("");
            if (romanNumeral.contains(insertion.append(x).toString())) {
                result += k;
                romanNumeral = romanNumeral.replace(x, "");
            }
      }
        return result;
    }

    public static void main(String[] args) {
        int n = 1000;
        toRoman(n);
        System.out.println(toRoman(n));

        String romanNumeral = "M";
        fromRoman(romanNumeral);
        System.out.println( fromRoman(romanNumeral));

    }
}
/*
public class RomanNumerals1 {
    private static final String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARABIC_NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String toRoman(int n) {
        int remainingValue = n;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ARABIC_NUMBERS.length; i++) {
            while (remainingValue >= ARABIC_NUMBERS[i]) {
                remainingValue -= ARABIC_NUMBERS[i];
                result.append(ROMAN_NUMBERS[i]);
            }
        }

        return result.toString();
    }

    public static int fromRoman(String romanNumeral) {
        String remainingValue = romanNumeral;
        int result = 0;

        for(int i = 0; i<ROMAN_NUMBERS.length; i++) {
            while(remainingValue.startsWith(ROMAN_NUMBERS[i])) {
                remainingValue = remainingValue.substring(ROMAN_NUMBERS[i].length(), remainingValue.length());
                result += ARABIC_NUMBERS[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 992;
        toRoman(n);
        System.out.println(toRoman(n));

        String romanNumeral = "CMXCII";
        fromRoman(romanNumeral);
        System.out.println( fromRoman(romanNumeral));

    }
}


 */