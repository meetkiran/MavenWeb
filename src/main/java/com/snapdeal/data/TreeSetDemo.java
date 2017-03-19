package com.snapdeal.data;
import java.util.*;
public class TreeSetDemo {

   public static void main(String args[]) {
      // Create a tree set
      TreeMap<Integer,String> ts = new TreeMap<Integer,String>();
     
      // Add elements to the tree set
      ts.put(1,"C");
      ts.put(2,"A");
      ts.put(3,"A");
      ts.put(4,"E");
      ts.put(5,"F");
      ts.put(6,"D");
      System.out.println(ts);
   }
}