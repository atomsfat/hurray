package hurray;
import java.io.*;
import java.util.*;

import java.util.Arrays;

import java.io.*;
import java.util.*;

public class Heap2Solution {

  int holder[];
  int size = 0;
  int capacity = 10;

  public Heap2Solution(){
    holder = new int[10];
  }

  private int getLeftChildIndex(int parentIndex){
    return (parentIndex * 2) + 1;
  }

  private int getRightChildIndex(int parentIndex){
    return (parentIndex * 2) + 2;
  }

  private int getParentIndex(int childIndex){
    return (childIndex - 1)/2;
  }

  private boolean hasParent(int childIndex){
    return childIndex > 0 && getParentIndex(childIndex) >= 0;
  }

  private boolean hasLeftChild(int parentIndex){
    return getLeftChildIndex(parentIndex) > 0 && getLeftChildIndex(parentIndex) < size;
  }

  private boolean hasRighChild(int parentIndex){
    return getRightChildIndex(parentIndex) < size;
  }

  private int left(int parentIndex){
    return holder[getLeftChildIndex(parentIndex)];
  }

  private int right(int parentIndex){
    return holder[getRightChildIndex(parentIndex)];
  }

  private int parent(int childIndex){
    return holder[getParentIndex(childIndex)];
  }

  public int peak(){
    return holder[0];
  }

  public void add(int value){
    //  System.out.println("adding " + value);
    size++;
    ensureCapacity();
    if(size == 0){
      holder[size-1] = value;
      size++;
      return;
    }
    holder[size-1] = value;
    heapifyup();

  }

  private void ensureCapacity(){
    if(capacity == size){
      holder = Arrays.copyOf(holder, capacity * 2);
      capacity *=2;
    }

  }

  private void heapifyup(){
    int currentIndex = size - 1;

    //  System.out.println("currentIndex " + currentIndex + " hasParent " + hasParent(currentIndex)  );
    while(hasParent(currentIndex) &&  holder[currentIndex] < parent(currentIndex)){
      if(holder[currentIndex] < parent(currentIndex)){
        swap(getParentIndex(currentIndex), currentIndex);
      }
      currentIndex = getParentIndex(currentIndex);
    }

    // System.out.println("heapifyup " + Arrays.toString(holder));
  }

  private void swap(int indexA, int indexB){
    int tmp = holder[indexA];
    holder[indexA] = holder[indexB];
    holder[indexB] = tmp;
  }

  private int findIndexOfValue(int value){
    int index = 0;
    while(index < size){
      if(value == holder[index]){
        break;
      }
      index ++;
    }
    return index;
  }


  private void removeElementByValue(int value){
    int index = findIndexOfValue(value);
    holder[index] = holder[size - 1];
    holder[size - 1] = 0;
    size--;
    heapifydown(index);
  }

  private void heapifydown(int index){

    while(hasLeftChild(index)){
      int childSmallerIndex = getLeftChildIndex(index);
      if(hasRighChild(index) && right(index) < left(index)){
        childSmallerIndex = getRightChildIndex(index);
      }
      if(holder[index] < holder[childSmallerIndex]){ //everything is in order;
        break;
      }
      swap(index, childSmallerIndex);
      index = childSmallerIndex;
    }
    //  System.out.println("heapifydown " + Arrays.toString(holder));
  }

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner sc = new Scanner(System.in);

    Heap2Solution heap = new Heap2Solution();

    int queries = Integer.parseInt(sc.nextLine());
    while(queries > 0){
      String query[] = sc.nextLine().split(" ");
      switch(query[0]){
        case "1":
          heap.add(Integer.parseInt(query[1]));
          break;
        case "2":
          heap.removeElementByValue(Integer.parseInt(query[1]));
          break;
        case "3":
          System.out.println(heap.peak());
          break;
      }
      queries--;
    }

    sc.close();
    // System.out.println(Arrays.toString(heap.holder));
  }
}
