package com.solutions;

import java.util.*;

//1) check covariant return type
//2) reverse integer without using string operations
// 3) check if 2 strings are anagram

class A {

}

class B extends A {

}

interface C1 {
    CharSequence get();
}

interface C2 {
    String get();
}

public class ReverseIntandAnagram implements C1, C2 {
    public static void main(String[] args) {
        int val = 1;
        int rev = 0;

        while (val != 0) {
            int temp = val % 10;
            val = val / 10;

            rev = rev * 10 + temp;

        }

        System.out.println("REVERESE: " + rev);
        anagram("TRIENGLA", "INTEGREL");
        anagram("TRIENGLE", "INTEGREL");
    }

    public static void anagram(String s1, String s2) {
        //  Set<String> temp= new HashSet<String>(s1.);
        char[] s1c = s1.toLowerCase(Locale.ROOT).toCharArray();
        char[] s2c = s2.toLowerCase(Locale.ROOT).toCharArray();
        if (s1.length() != s2.length()) {
            System.out.println("Not anagram");
            return;
        }
        Arrays.sort(s1c);
        Arrays.sort(s2c);
        for (int i = 0; i < s1.length(); i++) {
            if (s1c[i] != s2c[i]) {
                System.out.println("Not Anagram");
                return;
            }
        }
        System.out.println("Anagram");

    }

    @Override
    public String get() {
        return null;
    }


}
