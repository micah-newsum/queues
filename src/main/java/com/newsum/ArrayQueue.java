package com.newsum;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T>{
  private Object[] queue;
  private int front;
  private int back;

  public ArrayQueue(int capacity){
    queue = new Object[capacity];
  }

  @Override
  public void add(T t) {
    // logic to make circular queue. This prevents unnecessary resizing of the backing array.
    if (size() == queue.length - 1){
      int numItems = size();
      Object[] tempArray = new Object[2 * queue.length];

      // unwraps queue
      System.arraycopy(queue, front, tempArray, 0, queue.length - front);
      System.arraycopy(queue, 0, tempArray, queue.length - front, back);

      queue = tempArray;

      front = 0;
      back = numItems;
      tempArray = null;
    }

    queue[back] = t;
    if (back < queue.length - 1 ){
      back++;
    } else {
      back = 0;
    }
  }

  @Override
  public T remove() {
    if (size() == 0){
      throw new NoSuchElementException();
    }

    T t = (T)queue[front];
    queue[front] = null;
    front++;
    if (size() == 0){
      front = 0;
      back = 0;
    } else if (front == queue.length){
      front = 0;
    }

    return t;
  }

  @Override
  public T peek() {
    if (size() == 0){
      throw new NoSuchElementException();
    }

    return (T)queue[front];
  }

  public int size(){
    // test whether queue has wrapped
    if (front <= back){
      return back - front;
    } else {
      return back - front + queue.length;
    }
  }

  @Override
  public String toString() {
    String s = "ArrayQueue{";

    // test whether queue has wrapped
    if (front <= back){
      for (int i = front; i < back; i++) {
        s += queue[i].toString() + ", ";
      }
    } else {
      for (int i = front; i < queue.length; i++) {
        s += queue[i].toString() + ", ";
      }
      for (int i = 0; i < back; i++){
        s += queue[i].toString() + ", ";
      }
    }

    s += " front=" + front +
        ", back=" + back +
        '}';

    return s;
  }
}
