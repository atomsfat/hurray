package hurray;

public class Palindrome {

  public static void main(String... args) {

  //  System.out.println(isPalindrome("A car, a man, a maraca."));
    System.out.println(7/2);
  }

  public static boolean isPalindrome(String str) {
    boolean isValid = true;

    String replaced = str.replace(" ", "");
    replaced = replaced.replace(",", "");
    replaced = replaced.replace(".", "");
    replaced = replaced.toLowerCase();

    System.out.println(replaced + " " + replaced.length());

    for (int i = 0, j = replaced.length() - 1; i < replaced.length() - 1; i++, j--) {

      if (replaced.charAt(i) != replaced.charAt(j)) {
        isValid = false;
        break;
      }

    }

    return isValid;
  }
}
