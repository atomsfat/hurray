package hurray;

import java.util.Arrays;

public class SortMerge {

  public static void mergeSort(int arr[]){

    if(arr.length <= 1){
      return;
    }

    int medium = arr.length/2;

    int left [] = Arrays.copyOfRange(arr, 0, medium);
//    System.out.println(Arrays.toString(left));
    int right [] = Arrays.copyOfRange(arr, medium , arr.length );
//    System.out.println(Arrays.toString(right));
    mergeSort(left);
    mergeSort(right);
    merge(left, right, arr);

    System.out.println("merged" + Arrays.toString(arr) );

  }

  private static void merge(int [] left, int right[], int dest[]){

    System.out.println("merge" + Arrays.toString(left) + " " +Arrays.toString(right));

    int current = 0;
    int leftI = 0;
    int rightI = 0;

    while(current < dest.length && rightI < right.length && leftI < left.length ){

      if(left[leftI] < right[rightI]){
        dest[current] = left[leftI];
        leftI++;
      }else{
        dest[current] = right[rightI];
        rightI++;
      }
      current++;
    }


    while( leftI < left.length){
      dest[current] = left[leftI];
      leftI++;
      current++;
    }

    while( rightI < right.length){
      dest[current] = right[rightI];
      rightI++;
      current++;
    }



  }



  private static void mergeHalves(int arr[], int low, int middle, int high){



 //   System.out.println("here -> " + Arrays.toString(temp));

//
  }


  public static void main(String...args){

    int a[] = {10, 3, 1, 2, 99};
    mergeSort(a);
    System.out.println(Arrays.toString(a));
  }
}
