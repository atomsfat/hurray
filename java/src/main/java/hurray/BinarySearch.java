package hurray;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class BinarySearch {

  public static void main(String...args){

    int arr[] = {0, 1, 1, 2, 4, 5, 6, 7, 8};
    System.out.println(findBinary(arr, 0));
    int arr2[] = {1, 1, 1, 2, 4, 5, 6, 8, 8};
    System.out.println(frecuency(arr2, 1));

    System.out.println(Arrays.toString(arr2));
  }

  static int  findBinary(int arr[], int n){

    int start = 0;
    int end = arr.length -1;


    while( start <= end){
      int middle = (start + end) / 2 ;

      if(arr[middle] < n){
        start = middle + 1;

      }else if(arr[middle] > n) {
        end = middle - 1;
      }else{
//        System.out.println("S " + start + " e " + end + " m " + middle );
        return middle;
      }

    }

    return -1;
  }



  /**
   * Array: [1, 1, 1, 2, 4, 5, 6, 8, 8]
   *     N: 1
   * Count: 3 (1 appears 3 times in the array)
   *
   *
   */

  static int frecuency(int arr[], int n){ //3  //2

    int currentIndex = findBinary(arr, n); // //3


    if(currentIndex == -1){
      return -1;
    }

    Map<Integer, Integer> revert = new TreeMap<>();

    System.out.println(" c " +currentIndex);
    int count = 0;

    while(currentIndex >= 0){

      revert.put(currentIndex, n);
      arr[currentIndex] = Integer.MIN_VALUE;
      Arrays.sort(arr);
      currentIndex = findBinary(arr, n);
        System.out.println(" c2 " + currentIndex);

      count++;
    }

    for(Map.Entry<Integer, Integer> data : revert.entrySet()){
      arr[data.getKey()] = data.getValue();
    }

    return count;
  }
}
