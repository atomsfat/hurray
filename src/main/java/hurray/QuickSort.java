package hurray;

import java.util.Arrays;

public class QuickSort {


  public static void quickSort(int arr[]){

    quickSort(arr, 0, arr.length -1);

  }

  private static void quickSort(int arr[], int start, int end){

    if(start >= end){
      return;
    }

    int pivotIndex = (start + end)/2;
    int pivotValue = arr[pivotIndex];


    int partition = partition( arr, start, end, pivotValue);
    quickSort(arr, start, partition-1);
    quickSort(arr, partition, end);

  }

  private static int partition(int arr[], int start, int end, int pivot){


    while(start <= end){
      while(arr[start] < pivot){
        start++;
      }

      while(arr[end] > pivot){
        end--;
      }
      if(start <= end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        start++;
      }

    }

    return start;

  }



    public static void main(String ... args){
    int[] arr = { 9, 2, 31 , 4, 3, 5};
    quickSort(arr);



      System.out.println(">> " +Arrays.toString(arr).replaceAll("(\\[|\\]|,)", ""));
  }
}
