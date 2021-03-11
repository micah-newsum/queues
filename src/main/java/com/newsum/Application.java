package com.newsum;

import com.newsum.model.Employee;

public class Application {
  public static void main(String[] args) {
    Queue<Employee> queue = new ArrayQueue<>(3);
    queueClient(queue);
  }

  public static void queueClient(Queue<Employee> queue){
    queue.add(new Employee("John","Doe",1));
    queue.add(new Employee("Jane","Doe",2));
    System.out.println(queue);

    // print queue after peek
    System.out.println(queue.peek());
    System.out.println(queue);

    // print queue after remove
    System.out.println(queue.remove());
    System.out.println(queue);

    // print queue after add
    queue.add(new Employee("Bill","Smith",3));
    System.out.println(queue);

    // print after empty queue
    queue.remove();
    queue.remove();
    System.out.println(queue);
  }
}
