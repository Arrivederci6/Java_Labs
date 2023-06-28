package test.java.model;

import main.java.ua.lviv.iot.algo.part1.model.DestroyedStone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DestroyedStoneTest {

    private DestroyedStone destroyedStone;

    @BeforeEach
    public void setUp() {
        String name = "Stone";
        String color = "Red";
        double weightInGrams = 50.0;
        double pricePerGram = 10.0;
        double destructionIndex = 0.9;
        destroyedStone = new DestroyedStone(name, color, weightInGrams, pricePerGram, destructionIndex);
    }

    @Test
    void testGetFullPrice() {
        double expectedFullPrice = destroyedStone.getFullPrice();
        double actualFullPrice = destroyedStone.getFullPrice();
        assertEquals(expectedFullPrice, actualFullPrice);
    }


}