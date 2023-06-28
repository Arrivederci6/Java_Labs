package test.java;

import main.java.ua.lviv.iot.algo.part1.ArtificialPreciousStone;
import main.java.ua.lviv.iot.algo.part1.PreciousStone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtificialPreciousStoneTest {

    private PreciousStone preciousStone;

    private ArtificialPreciousStone artificialPreciousStone;

    @BeforeEach
    public void setUp() {
        String name = "Stone";
        String color = "Red";
        double weightInGrams = 50.0;
        double pricePerGram = 10.0;
        String stoneLaboratoryName = "Lab";
        artificialPreciousStone = new ArtificialPreciousStone(name, color, weightInGrams, pricePerGram, stoneLaboratoryName);
    }

    @Test
    void testGetFullPrice() {
        double expectedFullPrice = 50.0 * 10.0;
        double actualFullPrice = artificialPreciousStone.getFullPrice();
        assertEquals(expectedFullPrice, actualFullPrice);
    }

}