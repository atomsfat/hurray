package hurray;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.logging.SocketHandler;

public class TreeSolution {

  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    sc.close();

    System.out.println("nodes " + input);
    Node root = null;
    for (String str : input.split(" ")) {
      root = insert(root, Integer.parseInt(str));
    }
//    System.out.println("preOrder:");
//    printPreOrder(root);
//    System.out.println("");
//    System.out.println("postOrder:");
//    printPostOrder(root);
//    System.out.println("");
    System.out.print("BFS: ");
    printBFS(root);

//    System.out.println("");
//    System.out.print("BFS2: ");
//    printBFS2(root);
//
//
//    System.out.println("-");
//    System.out.println("Top view");
//    topView(root);
//
//    System.out.println("-");
//    System.out.println("Top view2");
//    topView2(root);
//
//    System.out.println("transversal");
//    transversal(root);

    System.out.println("inOrderTransversal");
    inOrderTransversal(root);


  }

  static void inOrderTransversal(Node root){
    if(root != null){
      inOrderTransversal(root.left);
      System.out.print(root.data + " ");
      inOrderTransversal(root.right);
    }
  }

  static void printPreOrder(Node root) {
    if (root != null) {
      System.out.print(root.data + " ");
      printPreOrder(root.left);
      printPreOrder(root.right);
    }
  }

  static void printPostOrder(Node root) {
    if (root != null) {
      printPostOrder(root.left);
      printPostOrder(root.right);
      System.out.print(root.data + " ");
    }

  }


  static void printBFS2(Node root){
    Queue<Node> process = new LinkedList<>();

    process.add(root);
    while(process.isEmpty() == false){

      Node current = process.poll();

      System.out.print(current.data + " ");

      if(current.left != null){
        process.add(current.left);
      }

      if(current.right != null){
        process.add(current.right);
      }


    }

  }


  static void printBFS(Node root) {
    LinkedList<Node> currentLevel = new LinkedList<>();

    if (root != null) {
      currentLevel.push(root);
    }

    int level = handleLevelsBFS(currentLevel, -1);
    System.out.println("");
    System.out.println("levels: " + level);

  }


  static int handleLevelsBFS(LinkedList<Node> currentLevel, int level) {

    level++;
    LinkedList<Node> nextLevelNodes = new LinkedList<>();

    System.out.println("");

    while (currentLevel.isEmpty() == false) {
      Node current = currentLevel.removeFirst();
      System.out.print(current.data + " ");
      if (current.left != null) {
        nextLevelNodes.addLast(current.left);
      }
      if (current.right != null) {
        nextLevelNodes.addLast(current.right);
      }
    }

    if (nextLevelNodes.isEmpty() == false) {
      level = handleLevelsBFS(nextLevelNodes, level);
    }

    return level;

  }

  static void transversal(Node root){
    Queue<HDWrapper>  level0 = new LinkedList<>();
    if (root != null) {
      level0.add(new HDWrapper(root, 0, true));
    }

    TreeMap<Integer, StringBuilder> sides = new TreeMap<>();

    while(level0.isEmpty() == false){
      HDWrapper current = level0.poll();

      StringBuilder side = sides.get(current.hd) == null ? new StringBuilder() : sides.get(current.hd);

      if(current.right){
        side.append(current.node.data + " ");
      }else{
        side.insert(0,current.node.data + " " );
      }

      sides.put(current.hd, side);

      if(current.node.left != null){
        level0.add(new HDWrapper(current.node.left, current.hd -1, false));
      }

      if(current.node.right != null){
        level0.add(new HDWrapper(current.node.right, current.hd +1, true));
      }
    }

    for(Map.Entry<Integer, StringBuilder> entry : sides.entrySet()){
      System.out.println("[" + entry.getKey() + "] "+ entry.getValue().toString());
    }

  }
  static void topView2(Node root) {
    Queue<HDWrapper> level0 = new LinkedList<>();

    if (root != null) {
      level0.add(new HDWrapper(root, 0, true));
    }
    HashSet<Integer> hds = new HashSet<>();

    StringBuilder sb = new StringBuilder();

    while(level0.isEmpty() == false){

      HDWrapper current = level0.poll();
      if(!hds.contains(current.hd)){
        hds.add(current.hd);
        if(current.right){
          sb.append(current.node.data + " ");
        }else{
          sb.insert(0,current.node.data + " " );
        }
      }


      if(current.node.left != null){
        level0.add(new HDWrapper(current.node.left, current.hd -1 , false));
      }
      if(current.node.right != null){
        level0.add(new HDWrapper(current.node.right, current.hd +1, true));
      }

    }


    System.out.println(sb.toString());
  }



  static void topView(Node root) {
    LinkedList<HDWrapper> level0 = new LinkedList<>();

    if (root != null) {
      level0.push(new HDWrapper(root, 0, true));
    }
    HashSet<Integer> hds = new HashSet<>();


    StringBuilder sb = new StringBuilder();
    handleLevelTopView(level0, hds, sb);

    System.out.println(sb.toString());
  }


  static void handleLevelTopView(LinkedList<HDWrapper> currentLevel, HashSet<Integer> hds, StringBuilder sb) {

    LinkedList<HDWrapper> nextLevel = new LinkedList<>();

    while (currentLevel.isEmpty() == false) {

      HDWrapper currentHdWrapper = currentLevel.pop();



      if (!hds.contains(currentHdWrapper.hd)) {
        hds.add(currentHdWrapper.hd);
//        System.out.println("here" + currentHdWrapper.node.data + " hd[" + currentHdWrapper.hd+  "]" + " ");
        if(currentHdWrapper.right){
          sb.append(currentHdWrapper.node.data + " ");

        }else{
          sb.insert(0,currentHdWrapper.node.data + " " );
        }


      }

      if(currentHdWrapper.node.left != null){
        nextLevel.addLast(new HDWrapper(currentHdWrapper.node.left, currentHdWrapper.hd-1, false));
      }

      if(currentHdWrapper.node.right != null){
        nextLevel.addLast(new HDWrapper(currentHdWrapper.node.right, currentHdWrapper.hd+1, true));
      }

    }

  //  System.out.println("nextLevel " + nextLevel.size());
    if(nextLevel.isEmpty() == false){
      handleLevelTopView(nextLevel, hds, sb);
    }


  }


  static Node insert(Node root, int data) {

    if (root == null) {
      return new Node(data);
    }


    if (data < root.data) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }

    return root;

  }

  static class HDWrapper{
    int hd;
    Node node;
    boolean right;
    public HDWrapper(Node node, int hd, boolean right){
      this.node = node;
      this.hd = hd;
      this.right = right;
    }
  }

  static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "" + data;
    }
  }
}
