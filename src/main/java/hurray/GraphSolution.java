package hurray;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GraphSolution {


  static class Node implements Comparable<Node>{
    int data;
    TreeSet<Node> adjacent = new TreeSet<>();
    public Node(int data){
      this.data = data;
    }

    public String toString(){
      return "" + data  ;
    }


    @Override
    public int compareTo(Node o) {
      if(this.data == o.data ){
        return 0;
      }else if(this.data > o.data){
        return 1;
      }else{
        return -1;
      }
    }
  }



  // Complete the bfs function below.
  static int[] bfs(int n, int m, int[][] edges, int s) {

    Node nodes[] = new Node[n];

    for(int i=0 ; i < n ; i++){
      nodes[i] = new Node(i+1);  //node[0] = 1
    }

    // System.out.println(Arrays.toString(nodes));

    for(int j=0 ; j < m ; j++){
      int u = edges[j][0];
      int v = edges[j][1];


      Node nodeU = nodes[u-1];
      Node nodeV = nodes[v-1];

      nodeU.adjacent.add(nodeV);
      nodeV.adjacent.add(nodeU);


    }

//    for(int i=0 ; i < n ; i++){
//      Node no = nodes[i];
//      System.out.println(no.data + " " + Arrays.toString(no.adjacent.toArray()) );
//    }


    Node startNode = nodes[s-1];

    return calculateDistances(startNode, nodes);


  }

  private static int []  calculateDistances(Node start, Node[] nodes ){

    int result[] = new int[nodes.length -1];

    int index =0;
    for(Node node: nodes){
      if(start.data != node.data){
        result[index] = calculateDistance(start, node);
        index++;
      }

    }

    return result;
  }


  private static int calculateDistance(Node start, Node dest){

//    System.out.println("s d " + start + " " + dest);
    LinkedList<Node> currentLevel = new LinkedList<>();
    LinkedList<Node> nextLevel = new LinkedList<>();
    TreeSet<Integer> visited = new TreeSet<>();

    int level = 0;
    int distace = -1;
    boolean found = false;

    currentLevel.push(start);

    while(currentLevel.isEmpty() == false){
      Node current =  currentLevel.removeFirst();

      if(visited.contains(current.data) == false){


//        System.out.println(current.data + " " + Arrays.toString(current.adjacent.toArray())  + " level " + level +  " visited "+ Arrays.toString(visited.toArray()));
//        System.out.println(Arrays.toString(currentLevel.toArray()) );
//        System.out.println("currentLevel " + currentLevel.size() + " nextLevel " + nextLevel.size());

        visited.add(current.data);

        if(current.data == dest.data){
          found = true;
          break;
        }

        if(current.adjacent.contains(dest)){
          found = true;
          level++;
          break;
        }
        for(Node node: current.adjacent){
          nextLevel.addLast(node);
        }
      }
//      System.out.println("currentLevel22 " + currentLevel.size() + " nextLevel " + nextLevel.size() + " " + currentLevel.isEmpty() + " " + currentLevel.peekFirst());
      if(currentLevel.isEmpty()){
        currentLevel = nextLevel;
        nextLevel = new LinkedList<>();
        level++;
      }

    }

    if(found){
      distace = level * 6;
    }


    return distace;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
  //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String[] nm = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nm[0]);

      int m = Integer.parseInt(nm[1]);

      int[][] edges = new int[m][2];

      for (int i = 0; i < m; i++) {
        String[] edgesRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int edgesItem = Integer.parseInt(edgesRowItems[j]);
          edges[i][j] = edgesItem;
        }
      }

      int s = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] result = bfs(n, m, edges, s);

      for (int i = 0; i < result.length; i++) {
       // bufferedWriter.write(String.valueOf(result[i]));
        System.out.print(String.valueOf(result[i]) + " ");

//        if (i != result.length - 1) {
//         // bufferedWriter.write(" ");
//          System.out.println(" ");
//        }
      }

      System.out.println("");
    //  bufferedWriter.newLine();
    }

   // bufferedWriter.close();

    scanner.close();
  }
}
