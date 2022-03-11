package com.lth.example.collection;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");
        arr.set(0, "3");
        for(String s: arr){
            System.out.println(s);
        }
    }
}
