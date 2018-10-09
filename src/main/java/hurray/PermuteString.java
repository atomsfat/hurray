package hurray;

public class PermuteString {


  public static void permuteHelper(String str, String choose) {
//    indent(choose.length());
//    System.out.println("permuteHelper(" + str + ", " + choose + ")");
    if (str.isEmpty()) {
      System.out.println(choose);
    } else {

      char chars[] = str.toCharArray();
      for (int i = 0; i < chars.length; i++) {

        String newStr = erase(str, i);

        //choose
        choose = choose + Character.valueOf(chars[i]).toString();

        //explore
        permuteHelper(newStr, choose);

        //unchoose

        choose = erase(choose, choose.length() - 1);


      }
    }

  }

  public static void indent(int times) {
    while (times > 0) {
      System.out.print("  ");
      times--;
    }
  }

  public static String erase(String str, int i) {

    if (str.length() < i + 1) {
      return str;
    }
    return str.substring(0, i) + str.substring(i + 1, str.length());


  }

  public static void permute(String arg) {

    permuteHelper(arg, "");
  }


  public static void main(String... args) {

    permute("ABCDE");
  }
}
