package Tutorium6;

import java.util.function.UnaryOperator;

public class MapPlusThree implements UnaryOperator<Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer+3;
    }
}
