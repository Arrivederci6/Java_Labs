package main.java.ua.lviv.iot.algo.part1;

import lombok.*;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StoneManager {

    @Getter
    public List<Stone> stones = new ArrayList();

    public void addStone(final Stone stone){
        stones.add(stone);
    }

    public List<Stone> findStonesWithPricePerGramHigherThan(double price){
        return stones
                .stream()
                .filter(stone -> stone.pricePerGram > price)
                .toList();
    }

    public List<Stone> findStonesByColor(String color){
        return stones
                .stream()
                .filter(stone -> stone.color.equals(color))
                .toList();
    }
}
