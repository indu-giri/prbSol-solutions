package com.solutions;

public class longestSubPali {
    static int begin;
    static int length;
    public static void main(String[] args) {
        String str = "babca";
        if (str.length()<2)
        {
            System.out.println(str);
        }

          for (int i = 0; i < str.length()-1; i++) {
              //for odd string
              checkPali(str,i,i);
              //for even string
              checkPali(str,i,i+1);
          }
        System.out.println(str.substring(begin,begin+length));


    }
    public static void checkPali(String s, int start, int end){

        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if (length< end-start-1) {
            length = end-start-1;
            begin= start+ 1;
        }
    }


}
