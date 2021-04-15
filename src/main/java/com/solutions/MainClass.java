package com.solutions;

import java.util.Arrays;

class StaticComponents
{
    static int staticVariable;

    // static block
    static
    {
        System.out.println("StaticComponents SIB");
        staticVariable = 10;
    }

    static void staticMethod()
    {
        System.out.println("From StaticMethod");
        System.out.println(staticVariable);
    }
}

public class MainClass
{
    static
    {
        System.out.println("MainClass SIB");
        System.out.println("nnnnn"+StaticComponents.staticVariable);
    }

    public static void main(String[] args)
    {
        //Static Members directly accessed with Class Name
        StaticComponents.staticVariable = 20; // first calls Main class static block
        StaticComponents.staticMethod();

        System.out.println("val="+repeatedString("aaba",10));
    }

    static long repeatedString(String s, long n) {
      /*  int len = s.length();
        int count = 0;
        long r = n;
        long count = 0;
        if(len==1 && s.equals("a")){
            return n;
        }
        while(r!=0){
            if(s.charAt(count)=='a'){
                count++;

            }
            count=(count==len-1)?0:count+1;

            if(r>0){
                r--;
            }

        }*/

        // is efficient
        int len = s.length();
        long count = 0;
        long rpt = n/len;
        long c = n%len;
        if(len==1 && s.equals("a")){
            return n;
        }
        for(int i =0;i<len;i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }
        count*=rpt;
        for (int i = 0; i < c; i++) {
            if(s.charAt(i)=='a'){
                count++;
            }
        }



       /* for(int i = 0; i<len && n-- > 0; i++){
            if(s.charAt(i) == 'a'){
                count += count + (r>0? 1:0);
            }
            if(r > 0){
                r--;
            }
        }*/
        return count;
    }


}