package hurray;

import java.util.Map;
import java.util.TreeMap;

public class ColorFulSolution {

  public static void main(String... args) {

    System.out.println(colorfull(23));
//        System.out.println(colorfull(123123));
  }

  public static int colorfull(int A) {
    //char [] chars = ("" + a).toCharArray();

    Map<Integer, Integer> map = new TreeMap<>();
    String str = "" + A;
    for (int i = 0; i < str.length(); i++) {

      for (int j = str.length(); j > i; j--) {
        String subString = "" + str.subSequence(i, j);
        System.out.println("subString ---- " + subString);

        char[] digits = subString.toCharArray();
        int product = Integer.parseInt("" + digits[0]);
        for (int p = 1; p < digits.length; p++) {
          System.out.println("* digits " + digits[p]);

          product = product * Integer.parseInt("" + digits[p]);
        }
        System.out.println("product:: " + product);

        int freq = map.get(product) != null ? map.get(product) : 0;
        freq++;
        if (freq > 1) {
          return 0;
        }
        map.put(product, freq);

      }
    }

    return 1;
  }

}
