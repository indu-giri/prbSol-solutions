package com.solutions;

import java.util.*;

public class ClosestNumbers {
    public static void main(String[] args) {
        List<Integer> arr =Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761,
                30, 6246457, -6461594, 266854, -520, -470 );
        List<Integer> val = closestNumbers(arr);
        val.stream().forEach(System.out::println);
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        List<Integer> val= new ArrayList<Integer>();
        if(arr.size()<2)
            return arr;
        arr.sort((x1,x2)->x1.compareTo(x2));
        int diff = arr.get(2)-arr.get(1);
        Map<List<Integer>,Integer> arrMap = new LinkedHashMap<List<Integer>,Integer>();
        for (int i = 0; i < arr.size()-1; i++) {
            int temp=arr.get(i+1)-arr.get(i);
            arrMap.put(Arrays.asList(arr.get(i), arr.get(i + 1)),temp);

        }
        Integer minVal = arrMap.entrySet().stream().min((x, y)-> x.getValue().compareTo(y.getValue())).get().getValue();
        if(minVal!=0){
            Iterator itr = arrMap.entrySet().iterator();

            int i=0;
            while(itr.hasNext()){
                Map.Entry mapElement = (Map.Entry)itr.next();
                if(minVal==mapElement.getValue()){
                    val.addAll((Collection<? extends Integer>) mapElement.getKey());
                }
                i++;
            }
        }
    return val;
    }
}
