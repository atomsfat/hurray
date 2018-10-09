package hurray;

import java.util.Arrays;
import java.util.LinkedList;

public class Brackets {

  public static void main(String... args) {

    //       String bracket = "{[()]}";
    String bracket = "}][}}(}][))]";

    System.out.println(isBalanced(bracket));
  }

  public static String isBalanced(final String test) {

    LinkedList<Character> stack = new LinkedList<>();

    if (stack.size() % 2 != 0) {
      return "NO";
    }

    for (char a : test.toCharArray()) {
      if (isOpen(a)) {
        stack.push(a);
      } else {
        char x;
        try {
          x = stack.peek();
        } catch (NullPointerException e) {
          return "NO";
        }

        if (arePair(x, a)) {
          stack.pop();
        } else {
          stack.push(a);
        }

      }
    }

    if (stack.isEmpty()) {
      return "YES";
    } else {
      return "NO";
    }


  }

  public static boolean isOpen(char a) {
    if (a == ')' || a == '}' || a == ']') {
      return false;
    }
    return true;
  }

  public static boolean arePair(char a, char b) {

    if (a == '{' && b == '}')
      return true;

    if (a == '(' && b == ')')
      return true;

    if (a == '[' && b == ']')
      return true;

    return false;

  }
}
