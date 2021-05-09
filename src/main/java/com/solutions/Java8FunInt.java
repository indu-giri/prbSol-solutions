package com.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8FunInt {

    public static void main(String[] args) {
        //Function
        Function<Double, Double> fun = (a) -> Double.valueOf(a * 2);
        Double res = fun.apply(5.0);
        System.out.println("Function usage result: " + res);

        //BiFunction
        BiFunction<Double, Integer, Double> biFun = (a, b) -> a + Double.valueOf(b * 2);
        Double res1 = biFun.apply(res, 5);
        System.out.println("BiFunction usage result: " + res1);

        // Use both Function and BiFunction
        Double combRes = biFun.andThen(fun).apply(10.0, 30);
        System.out.println("Function + BiFunction usage result: " + combRes);

        //method that accepts BiFunction and Function as arguments and chains it together.
        Double addFunRes = addFunc(2.0, 7, biFun, fun);
        System.out.println("Function + BiFunction(method call) usage result: " + addFunRes);

        //above method can be made generic
        String addgenFunRes = change(2, 4,
                (a1, a2) -> a1 * a1,
                (r) -> "Multiply : " + String.valueOf(r));
        System.out.println("Function + BiFunction(Generic) usage result: " + addgenFunRes);
        String result3 = change("a", "b",
                (a1, a2) -> a1 + a2,
                (r) -> r + "cde");
        System.out.println("Function + BiFunction(Generic) usage result: " + result3);

        //Factory pattern:uses BiFunction to create an object
        Add obj = change(5.0, 4.0,
                (a1, a2) -> a1 + a2,
                //The Add::new calls the following constructor,
                // which accepts two arguments and return an object (Add), so it matches with the BiFunction signature.
                Add::new);
        System.out.println(obj.add());
    }


    public static <R> R addFunc(Double n, Integer n1, BiFunction<Double, Integer, Double> biFun, Function<Double, R> fun) {
        return biFun.andThen(fun).apply(n, n1);
    }

    public static <D, I, R1, R2> R2 change(D n, I n1, BiFunction<D, I, R1> biFun1, Function<R1, R2> fun1) {
        return biFun1.andThen(fun1).apply(n, n1);
    }
}

class Add {
    Double n;


    public Add(Double n) {
        this.n = n;

    }

    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }


    public String add() {
        return "Factory Result " + (this.n);
    }
}

