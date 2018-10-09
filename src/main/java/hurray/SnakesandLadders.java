package hurray;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SnakesandLadders {

  static class Square implements Comparable<Square>{

    int data;
    TreeSet<Square> adjacent = new TreeSet<>();

    public Square(int data){
      this.data = data;
    }

    public int compareTo(Square o){
      int compare = 0;

      if(this.data > o.data){
        compare = 1;
      }
      if(this.data < o.data){
        compare = -1;
      }
      return compare;
    }

    public String toString(){
      return "" + data;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Square square = (Square) o;
      return data == square.data;
    }

    @Override
    public int hashCode() {
      return Objects.hash(data);
    }
  }

  // Complete the quickestWayUp function below.
  static int quickestWayUp(int[][] ladders, int[][] snakes) {


    Square[] squares = new Square[100];
    for(int i = 0 ; i < 100 ; i++){
      squares[i] = new Square(i+1);

//      if(i > 0 && i < 100){
//        squares[i-1].adjacent.add(squares[i]);
//      }
    }

    for(int l=0 ; l < ladders.length ; l++){
      int u = ladders[l][0];
      int v = ladders[l][1];
      Square su = squares[u-1];
      Square sv = squares[v-1];
      su.data = sv.data;
      su.adjacent.add(sv);
    }


    for(int l=0 ; l < snakes.length ; l++){
      int u = snakes[l][0];
      int v = snakes[l][1];
      Square su = squares[u-1];
      Square sv = squares[v-1];
      su.data = sv.data;
      su.adjacent.add(sv);
    }



    Square start = squares[0];
    Square end = squares[99];

    return printPaths(squares, end);
  }

  private static List<Square> take6(Square [] squares, int fromData){

    List<Square> six = new ArrayList<>();
    int indexStart = fromData - 1;

    for(int i=0; i<6 && indexStart<squares.length; i++, indexStart++){
      six.add(squares[indexStart]);
    }
    return six;
  }

  private static int printPaths(Square[] squares, Square end){

    LinkedList<List<Square>> stack = new LinkedList<>();
    LinkedList<List<Square>> nextStack = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();


    stack.addLast(take6(squares, 2));
    boolean found = false;

    int steps = 1;
    while(!stack.isEmpty()){

      List<Square> current = stack.removeFirst();

      System.out.println("current " + Arrays.toString(current.toArray()) + "  contains " + current.contains(end) + " step " + steps);


      if(current.contains(end)){
        found = true;
        break;
      }

      int i=0;
      for(Square sq : current){
        if(sq == null){
          break;
        }
        if(!visited.contains(sq.data)){
          visited.add(sq.data);

          for(Square aj: sq.adjacent){

            nextStack.addLast(take6(squares, aj.data + 1 ));
          }

          if(i == 5){
            nextStack.addLast(take6(squares, sq.data + 1));
          }
        }
        i++;
      }

      if(stack.isEmpty()){

        stack = nextStack;
        nextStack = new LinkedList<>();
        steps++;
      }

    }
    return found ? steps : -1;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
  //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[][] ladders = new int[n][2];

      for (int i = 0; i < n; i++) {
        String[] laddersRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int laddersItem = Integer.parseInt(laddersRowItems[j]);
          ladders[i][j] = laddersItem;
        }
      }

      int m = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[][] snakes = new int[m][2];

      for (int i = 0; i < m; i++) {
        String[] snakesRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int snakesItem = Integer.parseInt(snakesRowItems[j]);
          snakes[i][j] = snakesItem;
        }
      }

      int result = quickestWayUp(ladders, snakes);

    //  bufferedWriter.write(String.valueOf(result));
    //  bufferedWriter.newLine();
      System.out.println("--------?" + result);
    }

  //  bufferedWriter.close();

    scanner.close();
  }
}
