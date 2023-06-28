package test.java;

import main.java.ua.lviv.iot.algo.part1.FossilStone;
import main.java.ua.lviv.iot.algo.part1.PreciousStone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FossilStoneTest {

    private FossilStone fossilStone;
    @BeforeEach
    public void setUp() {
        String name = "Stone";
        String color = "Red";
        double weightInGrams = 50.0;
        double pricePerGram = 10.0;
        double energyPerBurnedGram = 0.9;
        fossilStone = new FossilStone(name, color, weightInGrams, pricePerGram, energyPerBurnedGram);
    }


    @Test
    void testGetFullPrice() {
        double pricePerGram = 10.0;
        double energyPerBurnedGram = 0.9;
        double expectedFullPrice = pricePerGram * energyPerBurnedGram;
        double actualFullPrice = fossilStone.getFullPrice();
        assertEquals(expectedFullPrice, actualFullPrice);
    }

}