package Tutorium5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Comp {


    private static List <Integer> numbers1 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) ;

    private static List<Integer> numbers2 = new ArrayList (Arrays.asList(1, 0, 3, 4, 1, 1, 2, 8, 8, 1)) ;

    public static List<Boolean> compare(List<Integer> list1,
                                        List<Integer> list2,
                                        BiPredicate<Integer, Integer> p){
        List<Boolean> compared = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
        compared.add(p.test(list1.get(i), list2.get(i)));
      }
        return compared;
    }

    //List<Boolean> res2 = compare(numbers1, numbers2, bf);

    public static void main(String[] args) {
        BiPredicate<Integer, Integer> bp = (x,y) -> x == y;

        BiFunction<Integer, Integer, Boolean> bf = (x, y) -> x == y;
        List<Boolean> res1 = compare(numbers1, numbers2, bp);
        System.out.println(res1);


        Function<Integer, Integer> f1 = (x) -> x + 1;
        Predicate<Integer> f2 = (x) -> x % 2 == 1;
        BinaryOperator<Integer> f3 = (x, y) -> x + y;

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        numbers1.stream().map(f1).filter(f2).reduce(f3);
    }
}
