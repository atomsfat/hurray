package hurray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IceCreamSolution {

  // Complete the icecreamParlor function below.
  static int[] icecreamParlor(int m, int[] arr) {
    Map<Integer, ArrayList<Integer>> cost = new TreeMap<Integer, ArrayList<Integer>>();

    for (int i = 0; i < arr.length; i++) {
      ArrayList<Integer> indexes = cost.get(arr[i]) == null ? new ArrayList<Integer>() : cost.get(arr[i]);

      indexes.add(i + 1);
      cost.put(arr[i], indexes);
    }
    int result[] = new int[2];

    for (Map.Entry<Integer, ArrayList<Integer>> entry : cost.entrySet()) {
      Integer costA = entry.getKey();
      Integer costB = m - costA;

      if (entry.getValue().size() > 1) {

      }

      ArrayList<Integer> listCostB = cost.get(costB);

      if (listCostB != null) {
        result[0] = entry.getValue().get(0);
        if (listCostB.size() > 1) {
          result[1] = listCostB.get(1);
        } else {
          result[1] = listCostB.get(0);
        }

        break;
      }
    }
    Arrays.sort(result);
    return result;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int m = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] arr = new int[n];

      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
      }

      int[] result = icecreamParlor(m, arr);
      System.out.println(Arrays.toString(result));

      // for (int i = 0; i < result.length; i++) {
      //  bufferedWriter.write(String.valueOf(result[i]));

      //   if (i != result.length - 1) {
      //       bufferedWriter.write(" ");
      //   }
      //  }

      //   bufferedWriter.newLine();
    }

    //   bufferedWriter.close();

    scanner.close();
  }
}
