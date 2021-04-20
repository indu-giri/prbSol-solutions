package com.solutions;


import java.util.Arrays;

// 1) check if a string is palindrome
// 2) find different palindromes in a string
public class palindrome {

    public static void main(String[] args) {
        String str = "aba";
        int pali = checkPali(str);
        System.out.println((pali==1)?"palindrome":"not palindrome");
                 //to check if we can use streams to display distinct array values
                // Arrays.stream(new String[] {"1","2","3","1"}).distinct().forEach(System.out::println);
      // 2) find different palindromes in a string
        int[][] palin =new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() ; j++) {
                palin[i][j] = checkPali(str.substring(i,j+1));
               if(palin[i][j]==1)
                System.out.println(str.substring(i,j+1) +" ");
            }
           // System.out.println( "");
        }

        System.out.println(Arrays.deepToString(palin));

    }
    public static int checkPali(String s){

       int j ;
        int i = 0;
        int  res = 0;
       if(s!= null){
           j = s.length()-1;
       }
       else return res;

       while(i<=j){

            if(s.charAt(i)!=s.charAt(j)){
                res = 0;
                break;
            }
            res=1;
            i++;
            j--;
        }
        return res;
    }


}
