import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author Andrey Shevtsov on 09.09.2022
 **/

public class Justify {

    public static @NotNull String justify(@NotNull String text, int width) {
        int countLine = 0;
        int countResult = 0;
        StringBuilder result = new StringBuilder();
        ArrayList<String> line = new ArrayList<>();

        String replacedText = text.replaceAll("\\s+", " ")
                .replaceAll("\n", "");
        String[] words = replacedText.split(" ");
        int countWords = Arrays.stream(words).mapToInt(String::length).sum() + words.length-1;

        for (int i = 0; i < words.length; i++) {

            if ((countLine + words[i].length() - 1) < width) {
                if (countWords - countResult <= width && countLine  == 0) {
                    System.out.println(countWords + "CountWords");
                    System.out.println(countResult + "CountResult");
                    result.append(words[i]).append(" ");
                    continue;
                }
                line.add(words[i]);
                countResult += words[i].length() + 1;
                countLine += words[i].length() + 1;


            } else if ((countLine + words[i].length() - 1) >= width) {
                StringBuilder lineResult = new StringBuilder();
                if (line.size() != 1) {
                    int diff = width - countLine + line.size();
                    for (int j = 0; j < line.size() - 1; j++) {
                        String str = line.get(j).toString() + " ";
                        line.set(j, str);
                        diff--;
                        if ((diff > 0) && (j == line.size() - 2)) j = -1;
                        if (diff == 0) break;
                    }
                }
                for (String y : line) {
                    lineResult.append(y);
                }
                result.append(lineResult).append("\n");
                line.clear();
                countLine = 0;
                i--;
            }

        }
        return result.toString().trim();
    }


    public static void main(String[] args) {
        String text =

                        "Lorem  ipsum  dolor  sit amet,\n" +
                        "consectetur  adipiscing  elit.\n" +
                        "Vestibulum    sagittis   dolor\n" +
                        "mauris,  at  elementum  ligula\n" +
                        "tempor  eget.  In quis rhoncus\n" +
                        "nunc,  at  aliquet orci. Fusce\n" +
                        "at   dolor   sit   amet  felis\n" +
                        "suscipit   tristique.   Nam  a\n" +
                        "imperdiet   tellus.  Nulla  eu\n" +
                        "vestibulum    urna.    Vivamus\n" +
                        "tincidunt  suscipit  enim, nec\n" +
                        "ultrices   nisi  volutpat  ac.\n" +
                        "Maecenas   sit   amet  lacinia\n" +
                        "arcu,  non dictum justo. Donec\n" +
                        "sed  quam  vel  risus faucibus\n" +
                        "euismod.  Suspendisse  rhoncus\n" +
                        "rhoncus  felis  at  fermentum.\n" +
                        "Donec lorem magna, ultricies a\n" +
                        "nunc    sit    amet,   blandit\n" +
                        "fringilla  nunc. In vestibulum\n" +
                        "velit    ac    felis   rhoncus\n" +
                        "pellentesque. Mauris at tellus\n" +
                        "enim.  Aliquam eleifend tempus\n" +
                        "dapibus. Pellentesque commodo,\n" +
                        "nisi    sit   amet   hendrerit\n" +
                        "fringilla,   ante  odio  porta\n" +
                        "lacus,   ut   elementum  justo\n" +
                        "nulla et dolor.";
        justify(text, 15);
        System.out.println(justify(text, 15));

    }
}
/*
  import java.util.*;
import java.util.stream.Collectors;

public class Kata {

  private static String formatLine(Stack<String> line, int width) {
    if (line.size() == 1) return line.pop() + "\n";
    int spaces = width - line.stream().mapToInt(s -> s.length()).sum();
    int spacesPerWord = spaces / (line.size() - 1);
    int largerSpaces = spaces % (line.size() - 1);
    List<String> base = line.stream().map(s -> s + " ".repeat(spacesPerWord)).collect(Collectors.toList());
    for (int i = 0; i < largerSpaces; i++)
      base.set(i, base.get(i) + " ");
    base.set(base.size() - 1, base.get(base.size() - 1).trim());
    return base.stream().collect(Collectors.joining()) + "\n";
  }

  public static String justify(String text, int width) {
    String lines = "";
    String[] words = text.split(" ");
    Stack<String> line = new Stack<>();
    for (int i = 0; i < words.length; i++) {
      line.push(words[i]);
      if (line.stream().mapToInt(s -> s.length() + 1).sum() - 1 > width) {
        line.pop();
        lines += formatLine(line, width);
        line = new Stack<>();
        i--;
      }
    }
    lines += line.stream().collect(Collectors.joining(" "));

    return lines;
  }
}

 */