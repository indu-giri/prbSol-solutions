package com.solutions;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class Key {
    String keyVal;

    public Key(String keyVal) {
        this.keyVal = keyVal;
    }
}

public class HashMapScenario {

    public static void main(String[] args) {
        HashMap<String, Integer> strKeyMap = new HashMap<>();
        strKeyMap.put("A", Integer.valueOf(1));
        // will replace "A"
        strKeyMap.put("A", Integer.valueOf(2));
        HashMap<Key, Integer> custKeyMap = new HashMap<>();
        Key k1 = new Key("A");
        Key k2 = new Key("A");
        //both are different keys
        custKeyMap.put(k1, Integer.valueOf(1));
        custKeyMap.put(k2, Integer.valueOf(2));
        //value will be str:2;cust: 1
        System.out.println(String.format("str:%s;cust: %s", strKeyMap.get("A"), custKeyMap.get(k1)));

        int a1[] = {1, 2, 3};
        int a2[] = {1, 2, 3};
        //checks ref and not the values
        if (a1.equals(a2))
            System.out.println("same");
        // will be not same
        else System.out.println("not same");

        // without terminal op - toArray() it will not print values
        a1 = Arrays.stream(a1).map(i -> {
            System.out.println("do " + i);
            return i * 2;
        }).toArray();
        Arrays.stream(a1).forEach(i -> System.out.println(i));


    }
}
