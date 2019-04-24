package hurray;

import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {

  public static void main(String args[]){
//   j

//    for(int i=0; i < 100; i++){
//      System.out.print(fibonacci(i) + " ");
//    }
    for(int i=0; i < 1000; i++){
      System.out.print(fibonacciNoRecursive(i) + " ");
    }


  }

 static long fibonacci(int number){
    if( number == 0){
      return 0;
    }
    if( number < 3){
      return 1;
    }

    return fibonacci(number-1) + fibonacci(number-2);
  }

  static BigInteger fibonacciNoRecursive(int number){
    int size = number +1;

    BigInteger result[] = new BigInteger[size];

    int index = 0;
    while(index < size){

      if(index == 0){
        result[index] = BigInteger.ZERO;
        index++;
        continue;
      }
      if(index < 3){
        result[index] = BigInteger.ONE;
        index++;
        continue;
      }
      result[index] =  result[index - 1].add(result[index - 2]);

      index++;
    }

    return  result[size - 1];
  }
}

