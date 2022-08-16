package Tutorium6;

import java.util.function.Predicate;

public class TestOdd implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer%2 ==1;
    }
}
