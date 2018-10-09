package hurray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class MissingNumbersSolution {

  // Complete the missingNumbers function below.
  static int[] missingNumbers(int[] arr, int[] brr) {
    Map<Integer, Integer> freqA = populateMap(arr);
    Map<Integer, Integer> freqB = populateMap(brr);


    if (freqA.size() >= freqB.size()) {
      return check(freqA, freqB);
    } else {
      return check(freqB, freqA);
    }
  }

  static int[] check(Map<Integer, Integer> a, Map<Integer, Integer> b) {

    System.out.println(a + " " + a.size());
    System.out.println("====");
    System.out.println(b + " " + b.size());
    ArrayList<Integer> result = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
      if (b.get(entry.getKey()) == null || b.get(entry.getKey()).equals(entry.getValue()) == false) {
        System.out.println("--> " + b.get(entry.getKey()) + " " + entry.getValue() + " " + (b.get(entry.getKey()).equals(entry.getValue())));
        result.add(entry.getKey());
      }
    }
    Collections.sort(result);

    int result2[] = new int[result.size()];

    for (int i = 0; i < result.size(); i++) {
      result2[i] = result.get(i);
    }

    return result2;
  }

  static Map<Integer, Integer> populateMap(int[] arr) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (Integer n : arr) {
      Integer freq = map.get(n) == null ? 0 : map.get(n);
      freq++;
      map.put(n, freq);
    }
    return map;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int m = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] brr = new int[m];

    String[] brrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      int brrItem = Integer.parseInt(brrItems[i]);
      brr[i] = brrItem;
    }

    int[] result = missingNumbers(arr, brr);

    System.out.println(Arrays.toString(result));

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }

//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

    scanner.close();
  }
}
