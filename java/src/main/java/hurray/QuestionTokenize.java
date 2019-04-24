package hurray;
// Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut sagittis diam, vitae dictum tellus. Sed a urna mi. Nam porta a magna id accumsan. Donec fringilla tincidunt nibh, quis vehicula tortor ultrices id. Proin ut erat est. Donec tristique ultrices tortor, accumsan ultrices tellus dictum a. Maecenas ligula diam, convallis at interdum nec, tincidunt vitae sem. Etiam aliquam placerat auctor. Fusce vitae facilisis nisi, malesuada luctus felis. Sed at efficitur felis, vel feugiat cras amet.


import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class QuestionTokenize {


  public static void main(String... args) {


    String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut sagittis diam, vitae dictum tellus. Sed a urna mi. Nam porta a magna id accumsan. Donec fringilla tincidunt nibh, quis vehicula tortor ultrices id. Proin ut erat est. Donec tristique ultrices tortor, accumsan ultrices tellus dictum a. Maecenas ligula diam, convallis at interdum nec, tincidunt vitae sem. Etiam aliquam placerat auctor. Fusce vitae facilisis nisi, malesuada luctus felis. Sed at efficitur felis, vel feugiat cras amet.";

//    List<String> results = tokenize(input);
//    for (String str : results) {
//      System.out.println(str);
//    }
//
//    System.out.println("----");
    tokenize2(input);


  }

  //This is what I answers in the interview lol
  public static List<String> tokenize(String arg) {

    String[] breaking = arg.split(" ");

    List<String> result = new ArrayList<>();
    List<String> tmp = new ArrayList<>();

    int msgCounting = 1;


    String currentMessage = "";

    for (String str : breaking) {


      int clength = str.length() + 1;

      if (currentMessage.length() + clength < 136) {   //
        if (currentMessage.length() > 1) {
          currentMessage = currentMessage + " " + str;
        } else {
          currentMessage = currentMessage + str;
        }
      } else {
        tmp.add(currentMessage);
        currentMessage = str + " ";
        msgCounting++;

      }
    }
    tmp.add(currentMessage);

    int index = 1;
    for (String str : tmp) {
      result.add("[" + index + "/" + tmp.size() + "] " + str + "| " + str.length());
      index++;
    }

    return result;
  }


  public static void tokenize2(String input) {

    Double finalPage = (Math.ceil(Double.valueOf(input.length()) / 140));

    String words[] = input.split(" ");
    int page = 0;
    int finalLength = 0;
    String result = "";
    for (String word : words) {
      if (result.isEmpty()) {
        result = word;
        continue;
      }
      String temp = result + " " + word;
      if (temp.length() >= 140) {
        page++;
        finalLength = finalLength + result.length();
        System.out.println("[" + page + "/" + finalPage.intValue() + "] " + result + "| " + result.length());
        result = word;
      } else {
        result = temp;
      }

    }
    page++;

    System.out.println("[" + page + "/" + finalPage.intValue() + "] " + result + "| " + result.length());

  }


}
