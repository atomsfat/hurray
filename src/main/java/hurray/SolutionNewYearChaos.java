package hurray;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SolutionNewYearChaos {

  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {

    int bribes = 0;


    for (int j = q.length - 1; j >= 0; j--) {
      int searchValue = j + 1;
      int bribesByPerson = 0;


      if (q[j] != searchValue) {

        if (j - 1 >= 0 && q[j - 1] == searchValue) {

          bribesByPerson += 1;
          q[j - 1] = q[j];
          q[j] = searchValue;
        } else if (j - 2 >= 0 && q[j - 2] == searchValue) {

          bribesByPerson += 2;

          q[j - 2] = q[j - 1];
          q[j - 1] = q[j];
          q[j] =searchValue;
        } else {

          System.out.println("Too chaotic");
          return;
//          break;
        }

      }
      bribes += bribesByPerson;
    }


      System.out.println(bribes);


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];

      String[] qItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int qItem = Integer.parseInt(qItems[i]);
        q[i] = qItem;
      }

      minimumBribes(q);
    }

    scanner.close();
  }
}
