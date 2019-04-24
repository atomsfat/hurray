package hurray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BirdsSolution {

  // Complete the migratoryBirds function below.
  static int migratoryBirds(List<Integer> arr) {

    Map<Integer, Integer> freq = new TreeMap<>();

    for (Integer n : arr) {
      Integer previous = freq.get(n) != null ? freq.get(n) : 0;
      previous++;
      freq.put(n, previous);
    }
    System.out.println(freq);
    Integer minKey = Integer.MAX_VALUE;
    Integer maxCount = 0;
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        minKey = entry.getKey();

      }
    }

    return minKey;

  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int result = migratoryBirds(arr);
    System.out.println("" + result);

    //  bufferedWriter.write(String.valueOf(result));
    //   bufferedWriter.newLine();

    bufferedReader.close();
    //  bufferedWriter.close();
  }
}
