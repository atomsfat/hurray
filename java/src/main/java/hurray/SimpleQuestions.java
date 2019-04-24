package hurray;



import java.util.Map;
import java.util.TreeMap;

public class SimpleQuestions {


  public static void main(String...args){


    //convertIntToStr(99);
    printSubstrings("ABCDE");

  }

  static boolean startCapitalized(String str){

    int A = 'A';
    int Z = 'Z';
    int  a = str.charAt(0);

    return a >= A && a <= Z;
  }

  static void convertIntToStr(int number){



    int units = number % 10;
    int tens = number / 10;

    Map<Integer, String> dic = new TreeMap<>();

    dic.put(1, "uno");
    dic.put(2, "dos");
    dic.put(3, "tres");
    dic.put(4, "cuatro");
    dic.put(5, "cinco");
    dic.put(6, "seis");
    dic.put(7, "siete");
    dic.put(8, "ocho");
    dic.put(9, "nueve");
    dic.put(10, "diez");
    dic.put(20, "veite");
    dic.put(30, "treinta");
    dic.put(40, "cuarenta");
    dic.put(50, "cincuenta");
    dic.put(60, "sesenta");
    dic.put(70, "setenta");
    dic.put(80, "ochenta");
    dic.put(90, "noventa");
    dic.put(100, "cien");


    if(tens >= 1){
      System.out.print(dic.get(tens * 10) + " y ");
    }

    if(units >= 1){
      System.out.print(dic.get(units));
    }


  };

  static void printSubstrings(String abc){


    int size = 1;
    int currentIndex = 1;

    while(size < abc.length() ){

      while(currentIndex < abc.length()    ){

        if(currentIndex + size > abc.length()){
          break;
        }

        System.out.print(abc.charAt(0));
        System.out.print(abc.substring(currentIndex, currentIndex + size));
        currentIndex++;
        System.out.println("");

      }
      currentIndex=1;
      size++;

    }


  }

}
