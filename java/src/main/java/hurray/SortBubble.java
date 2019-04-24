package hurray;

import java.util.Arrays;

public class SortBubble {


  private static void sort(int arr[]) {
    boolean sorted = false;
    while (sorted == false) {
      sorted = true;
      for (int j = arr.length-1; j >= 0 && j-1 >=0; j--) {

        if (arr[j] < arr[j - 1]) {
          swap(arr, j, j - 1);
          sorted = false;
        }
      }
    }
  }

  private static void swap(int arr[], int u, int v) {
    int tmp = arr[u];
    arr[u] = arr[v];
    arr[v] = tmp;
  }

  public static void main(String... args) {

    int arr[] = {10, 4, 1, 5, 7};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
