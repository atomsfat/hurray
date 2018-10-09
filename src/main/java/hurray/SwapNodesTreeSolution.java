package hurray;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SwapNodesTreeSolution {


  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }

    public void swapchild() {
      Node tmp = this.left;
      this.left = this.right;
      this.right = tmp;
    }

    public void addLeft(int value) {
      if (value != -1) {
        this.left = new Node(value);
      }

    }

    public void addRight(int value) {
      if (value != -1) {
        this.right = new Node(value);
      }
    }

    @Override
    public String toString() {
      return "" + data;
    }
  }

  private static Node createTree(int[][] indexes) {

    Node root = new Node(1);
    LinkedList<Node> stack = new LinkedList();
    stack.addLast(root);

    for (int i = 0; i < indexes.length; i++) {
      Node current = stack.removeFirst();

      for (int j = 0; j < 2; j++) {
        //   System.out.print(indexes[i][j] + " j " + j + " ");
        if (j == 0) {
          current.addLeft(indexes[i][j]);
          if (current.left != null) {
            stack.addLast(current.left);
          }
        } else {
          current.addRight(indexes[i][j]);
          if (current.right != null) {
            stack.addLast(current.right);
          }
        }
      }
      //System.out.println("");
    }
    return root;
  }

  private static void swapChildNodes(Node root, int level){

    int clevel = 1;
    LinkedList<Node> currentLevel = new LinkedList<>();
    LinkedList<Node> nextLevel = new LinkedList<>();
    currentLevel.addLast(root);

    List<LinkedList<Node>> process = new ArrayList<>();

    while(currentLevel.isEmpty() == false ){


      Node current = currentLevel.removeFirst();


      if(clevel % level==0) {

        current.swapchild();
      }

    //  System.out.println("level: " + clevel + " data: " + current + " size " + currentLevel.size());

      if(current.left != null){
        nextLevel.addLast(current.left);
      }
      if(current.right != null){
        nextLevel.addLast(current.right);
      }
      if(currentLevel.isEmpty()){
        clevel++;
        currentLevel = nextLevel;
        nextLevel = new LinkedList<>();
      }
    }




  }
  /*
   * Complete the swapNodes function below.
   */
  static int[][] swapNodes(int[][] indexes, int[] queries) {
    /*
     * Write your code here.
     */

    Node root = createTree(indexes);


    for(int level: queries){

      swapChildNodes(root, level);

      StringBuilder result = new StringBuilder();
      inOrderTransversal(root, result);
      System.out.println(result.toString());
    }

    return new int[0][0];
  }

  private static void printBFS(Node root) {
    LinkedList<Node> stack = new LinkedList();

    stack.addLast(root);
    while (stack.isEmpty() == false) {
      Node current = stack.removeFirst();
      if (current.left != null) {
        stack.addLast(current.left);
      }
      if (current.right != null) {
        stack.addLast(current.right);
      }

      System.out.print(current.data + " ");
    }
  }

  static void inOrderTransversal(Node root, StringBuilder sb){
    if(root != null){
      inOrderTransversal(root.left, sb);
      sb.append(root.data + " ");
      inOrderTransversal(root.right, sb);
    }
  }

  static void inOrderTransversal(Node root){
    if(root != null){
      inOrderTransversal(root.left);
      System.out.print(root.data + " ");
      inOrderTransversal(root.right);
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(scanner.nextLine().trim());

    int[][] indexes = new int[n][2];

    for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
      String[] indexesRowItems = scanner.nextLine().split(" ");

      for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
        int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
        indexes[indexesRowItr][indexesColumnItr] = indexesItem;
      }
    }

    int queriesCount = Integer.parseInt(scanner.nextLine().trim());

    int[] queries = new int[queriesCount];

    for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
      int queriesItem = Integer.parseInt(scanner.nextLine().trim());
      queries[queriesItr] = queriesItem;
    }

    int[][] result = swapNodes(indexes, queries);

    for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
      for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
        System.out.print(String.valueOf(result[resultRowItr][resultColumnItr]));

        if (resultColumnItr != result[resultRowItr].length - 1) {
          System.out.print(" ");
        }
      }

      if (resultRowItr != result.length - 1) {
        System.out.print("\n");
      }
    }

//    bufferedWriter.newLine();

//    bufferedWriter.close();
    // bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
  }
}
