package hurray;

import java.io.*;
import java.util.*;

public class QueueSolution {


  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in);
    int q = Integer.parseInt(sc.nextLine());
    Queue queue = new Queue();
    while (sc.hasNextLine()) {
      String query[] = sc.nextLine().split(" ");
      switch (query[0]) {
        case "1":
          int data = Integer.parseInt(query[1]);
          queue.queue(data);
          break;
        case "2":
          queue.dequeue();
          break;
        case "3":
          System.out.println("print data ---:>" + queue.peek());
          break;

      }
    }
    sc.close();
  }

  static class Queue {

    Stack stack = new Stack();
    Stack reverse = new Stack();

    public void queue(int data) {
      stack.push(data);
    }

    public Integer peek() {
      fillReverse();
      return reverse.peek();
    }

    private void fillReverse() {
      if (reverse.top == null) {
        while (stack.top != null) {
          int data = stack.pop();
          reverse.push(data);
        }
      }
    }

    public Integer dequeue() {

      fillReverse();
      return reverse.pop();

    }

  }


  static class Stack {

    Node top = null;

    public Integer peek() {
      return top.data;
    }

    public Integer pop() {
      if (top != null) {
        Integer data = top.data;
        top = top.next;
        return data;
      }
      return null;
    }

    public void push(int i) {
      if (top == null) {
        top = new Node(i);
      } else {
        Node newTop = new Node(i);
        newTop.next = top;
        top = newTop;
      }
    }
  }

  static class Node {
    Integer data;
    Node next;

    public Node(Integer data) {
      this.data = data;
    }
  }
}
