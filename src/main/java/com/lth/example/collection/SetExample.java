package com.lth.example.collection;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> setA = new HashSet<String>();
        Set<String> setB = new HashSet<String>();
        setB.add("Java");
        setB.add("Python");
        setB.add("Java");
        setB.add("PHP");
        // Thêm các phần tử setB khác vào setA trong Java
        setA.addAll(setB);

        System.out.println("Số phần tử của setA: " + setA.size());
        System.out.println("Các phần tử của setA: " + setA);
        System.out.println("setA có chứa Java không? " + setA.contains("Java"));
        System.out.println("setA có chứa C++ không? " + setA.contains("C++"));
    }
}
