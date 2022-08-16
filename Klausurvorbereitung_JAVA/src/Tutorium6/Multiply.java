package Tutorium6;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Multiply implements BinaryOperator<Integer> {


    @Override
    public Integer apply(Integer integer, Integer integer2) {
        return integer*integer2;
    }
}
