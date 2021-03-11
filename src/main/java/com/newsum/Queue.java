package com.newsum;

public interface Queue<T>{
  void add(T t);

  T remove();

  T peek();
}
