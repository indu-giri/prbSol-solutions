package com.solutions;



import java.util.*;
/*There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.

Example
String[] strings = {"aba",
                "baba", "aba", "xzxb"};
        String[] queries = {"aba", "xzxb", "ab", "ab", "xzxb"};


Result:[2,1,0,0,1]

Function Description

Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.

matchingStrings has the following parameters:

string strings[n] - an array of strings to search
string queries[q] - an array of query strings
Returns

int[q]: an array of results for each query


 */

public class SparseArrays {


    public static void main(String[] args) {

        String[] strings = {"aba",
                "baba", "aba", "xzxb"};
        String[] queries = {"aba", "xzxb", "ab", "ab", "xzxb"};
        int[] res = matchingStrings(strings, queries);
        Arrays.stream(res).forEach(x -> System.out.println(x));
    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] res = new int[queries.length];
        Map<String, Integer> queryMap = new LinkedHashMap<String, Integer>();
        for (String s : queries) {
            queryMap.put(s, 0);
        }
        for (int i = 0; i < strings.length; i++) {
            if (queryMap.containsKey(strings[i])) {

                queryMap.replace(strings[i], queryMap.get(strings[i]) + 1);
            }
        }

        for (int j = 0; j < queries.length; j++) {

            res[j] = queryMap.get(queries[j]);
        }

       /* Iterator itr = queryMap.entrySet().iterator();
        int i=0;
        while(itr.hasNext()){
            Map.Entry mapElement = (Map.Entry)itr.next();
            res[i]=(int) mapElement.getValue();
            i++;
        }*/
        return res;

    }

}
