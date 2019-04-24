package hurray;

import java.util.Arrays;

public class PermuteArrayHeap {


  public static void heap(int arr[], int n) {

    if (n == 1) {
      System.out.println(Arrays.toString(arr));
    }

    for (int i = 0; i < n; i++) {
      heap(arr, n - 1);  //2 // 1
      if (n % 2 == 0) {  //par even

        swap(arr, 0, n - 1);
      } else {

        swap(arr, i, n - 1);
      }
    }

  }


  public static void swap(int arr[], int v, int u) {
    int temp = arr[v];
    arr[v] = arr[u];
    arr[u] = temp;
  }

  public static void main(String... arg) {

    int arr[] = {1, 2, 3};

    heap(arr, arr.length);
  }
}
