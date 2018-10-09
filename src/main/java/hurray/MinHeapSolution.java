package hurray;

import java.util.Arrays;

public class MinHeapSolution {

  int size = 0;
  int capacity = 10;
  int [] holder = new int[capacity];

  int getLeftChildIndex(int parentIndex){ return (parentIndex * 2 ) + 1;}
  int getRightChildIndex(int parentIndex){ return (parentIndex * 2 ) + 2;}
  int getParentIndex(int childIndex){return (childIndex -1)/2;}

  boolean hasLeftChild(int index){return getLeftChildIndex(index) > 0 && getLeftChildIndex(index) < size;}
  boolean hasRightChild(int index){return getRightChildIndex(index) < size;}
  boolean hasParent(int index){return index > 0;}

  int leftChild(int parentIndex){return holder[getLeftChildIndex(parentIndex)];}
  int rightChild(int parentIndex){return holder[getRightChildIndex(parentIndex)];}
  int parent(int childIndex){return holder[getParentIndex(childIndex)];}

  private void swap(int indexA, int indexB) {
    int temp = holder[indexA];
    holder[indexA] = holder[indexB];
    holder[indexB] = temp;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      capacity = capacity * 2;
      holder = Arrays.copyOf(holder, capacity);
    }
  }

  int peek() {
    if (size == 0) {
      throw new IllegalStateException();
    }
    return holder[0];
  }

  void delete(int number){


  }

  int indexFound(){
    return 0;
  }

  int poll() {
    if (size == 0) {
      throw new IllegalStateException();
    }
    int item = holder[0];

    holder[0] = holder[size - 1]; // put the latest element
    holder[size - 1] = 0;
    size--;
    System.out.println(this.toString());
    heapifydown();

    return item;
  }

  void add(int element) {
    ensureCapacity();
    holder[size] = element;
    size++;
    heapifyup();
  }

  private void heapifydown() {

    int index = 0;
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
        smallerChildIndex = getRightChildIndex(index);
      }

      if (holder[index] < holder[smallerChildIndex]) { //everything is in order
        break;
      }
      swap(index, smallerChildIndex);

      index = smallerChildIndex;

    }
    System.out.println("==up" + this);
  }

  private void heapifyup() {
    int index = size - 1;

    while (hasParent(index) && parent(index) > holder[index]) {

      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
    System.out.println("==up" + this);
  }

  @Override
  public String toString() {
    return Arrays.toString(holder);
  }

  public static void main(String args[]) {
    MinHeapSolution heap = new MinHeapSolution();

    heap.add(10);
    heap.add(15);
    heap.add(20);
//    heap.add(17);
    heap.add(8);
    heap.add(1);
    heap.add(3);
    heap.add(2);
    heap.add(4);

    System.out.println(heap);


    heap.poll();
    System.out.println(heap);

    heap.poll();
    System.out.println("size " + heap.size);
  }
}
