package com.solutions;

import java.util.*;

public class FirstUniChar {

    public static void main(String[] args) {
        String n = "greengarden";

        firstUnq(n);

    }
    public static void firstUnq(String s){
        Map<String,Integer> ma= new LinkedHashMap<String,Integer>();
        for (char i:s.toCharArray()) {
            if(ma.containsKey(i+"")) {
                ma.put(i + "", ma.get(i+"") + 1);
            }else{
                ma.put(i+"",0);
            }
        }
        for (Map.Entry<String, Integer> e: ma.entrySet())
              {
            if(e.getValue().compareTo(0)==0){
                System.out.println(e.getKey());
                break;
            }
        }

    }
}
