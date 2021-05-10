package com.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Java8MthdRefandLambda {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("node", "java", "python", "ruby");
        // to use a class to print the list
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //using lamba expression
        list.forEach(s-> System.out.println(s));
        //using method reference
        // Both lambda expression or method reference
        // does nothing but just another way call to an existing method.
        // With method reference, it gains better readability.
        list.forEach(System.out::println);

        //1) Calling a static method
        //a. Regular mthd call
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                MthdRef.display(s);
            }
        });
        //b. using lambda expr
        list.forEach(s-> MthdRef.display(s));
        //c. using method ref
        list.forEach(MthdRef::display);

        //2) Reference to instance method of an obj
        //a. Regular mthd call
        MthdRef obj = new MthdRef();
        addBiCon(5, 9, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return obj.add(integer,integer2);
            }
        });
        //b. using lambda expr
        addBiCon(3,4,(a,b)-> obj.add(a,b));
        //c. using method ref
        addBiCon(3,7,obj::add);

        //3) Reference to an instance method of any object of particular type
        //a. using lambda expr
        Integer res = addBiCon(3,4,(a,b)-> Math.max(a,b));
        System.out.println(res);
        //b. using method ref
        res = addBiCon(3,7,Math::max);
        System.out.println(res);

        //4) Reference to constructor

        Consumer<MthdRefConst> dis = MthdRefConst::dis;
        dis.accept(new MthdRefConst());
    }

    public static Integer addBiCon(Integer n, Integer n1, BiFunction<Integer,Integer,Integer> biCon){
        return biCon.apply(n,n1);
    }
}

interface MthdRefConstInf {

    void dis();
}
class MthdRefConst implements MthdRefConstInf{

    @Override
    public void dis(){
        System.out.println("In overridden mthd");
    }

}

    class MthdRef{
    public static void display(String s){
        System.out.println("In static Mthd "+ s);
    }

    public Integer add(Integer n, Integer n1){
        System.out.println("In Method Instance "+ (n+n1));
        return (n+n1);
    }


}