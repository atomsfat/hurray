package hurray;

import java.util.Arrays;
import java.util.Scanner;

public class SpecialPalindromeAgain {

  static int substrCount( int n, String str) {

    int count = 0;
    for(int i=0 ; i<str.length() ; i++){
      String ns = str.substring(i);
      count += descompose(ns);

    }
    return count;
  }

  static int descompose(String str) {

    int count = 0;
    if (str == null || str.length() == 0) {
      return 0;
    }

    if(isPalindrome(str)){
      count++;
    }
    System.out.println(str + " " + isPalindrome(str));
    String newStr = str.substring(0, str.length() - 1);

    return count + descompose(newStr);
  }

  public static boolean isPalindrome(String str){
    if(str.length() == 0 || str.length() == 1){
      return true;
    }
    char arr[] = str.toCharArray();

    if(str.length() % 2 != 0){
      int middle = arr.length/2;
      arr[middle] = arr[0];
    }

    Arrays.sort(arr);

    if(arr[0] != arr[arr.length-1]){
      return false;
    }else{
      return true;
    }


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String... args) {
    long result = substrCount(0, "aasaa");
    System.out.println(result);
  }

  public static void main2(String... args) {

 //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String s = scanner.nextLine();

    long result = substrCount(n, s);

   // bufferedWriter.write(String.valueOf(result));

    System.out.println(String.valueOf(result));
  //  bufferedWriter.newLine();

  //  bufferedWriter.close();

    scanner.close();
  }
}
