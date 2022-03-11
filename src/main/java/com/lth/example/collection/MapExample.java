package com.lth.example.collection;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(100, "A");
        map.put(101, "B");
        map.put(101, "C");
        System.out.println("Số phần tử của Map: " + map.size());
        System.out.println("Tập hợp key bao gồm: " + map.keySet());
        System.out.println("Tập hợp value bao gồm: " + map.values());
        System.out.println("Map có chứa value B hay không? " + (map.containsValue("B")? "Có":"Không"));
        System.out.println("Map có chứa value C hay không? " + (map.containsValue("C")? "Có":"Không"));
        System.out.println("Map có chứa key 100 hay không? " + (map.containsKey(100)? "Có":"Không"));

        System.out.println("Phần tử trong map bao gồm: ");
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        map.remove(10);
        System.out.println("Tập hợp key bao gồm: " + map.keySet());
        System.out.println("Tập hợp value bao gồm: " + map.values());
    }
}
