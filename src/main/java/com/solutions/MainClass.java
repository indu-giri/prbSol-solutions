package com.solutions;

class StaticComponents
{
    static int staticVariable;

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
        StaticComponents.staticVariable = 20;
        StaticComponents.staticMethod();

        System.out.println(repeatedString("aba",10));
    }

    //not efficient
    static long repeatedString(String s, long n) {
        int len = s.length();
        int d = 0;
        long r = n;
        long count = 0;
        if(len==1 && s.equals("a")){
            return n;
        }
        while(r!=0){
            if(s.charAt(d)=='a'){
                count++;

            }
            d=(d==len-1)?0:d+1;

            if(r>0){
                r--;
            }

        }
       /* for(int i = 0; i<len && n-- > 0; i++){
            if(s.charAt(i) == 'a'){
                count += d + (r>0? 1:0);
            }
            if(r > 0){
                r--;
            }
        }*/
        return count;
    }


}