package test.java.writer;

import static org.junit.jupiter.api.Assertions.*;

import main.java.ua.lviv.iot.algo.part1.manager.StoneManager;
import main.java.ua.lviv.iot.algo.part1.model.ArtificialPreciousStone;
import main.java.ua.lviv.iot.algo.part1.model.DestroyedStone;
import main.java.ua.lviv.iot.algo.part1.model.FossilStone;
import main.java.ua.lviv.iot.algo.part1.model.PreciousStone;
import main.java.ua.lviv.iot.algo.part1.writer.StoneWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


class StoneWriterTest {
    private static final String EXPECTED_FILENAME = "expected.csv";
    private static final String RESULT_FILENAME = "result.csv";
    private StoneWriter writer;
    private StoneManager manager;

    @BeforeEach
    public void setUp() {
        this.writer = new StoneWriter();
        this.manager = new StoneManager();

        manager.addStone(new PreciousStone("Diamondo", "Aqua-Blue", 99.9, 59.9, 1));
        manager.addStone(new ArtificialPreciousStone("Emeraldo", "Light-Green", 99.9, 19.9, "LPNU"));
        manager.addStone(new FossilStone("Coal", "Dark", 99.9, 9.9, 100));
        manager.addStone(new DestroyedStone("Destroyed Amethyst", "Purple", 99.9, 39.9, 8.5));

        File resultFile = writer.writeToFile(manager.getStones(), new File(RESULT_FILENAME));
        assertNotNull(resultFile);

        assertTrue(resultFile.exists());
    }

    @Test
    public void testWriteIfListIsEmpty() throws IOException {
        File resultFile = new File(RESULT_FILENAME);
        assertTrue(resultFile.exists());
        assertNull(writer.writeToFile(List.of(), resultFile));
    }

    @Test
    public void testWriteListOfStones() throws IOException {
        File expectedFile = new File(EXPECTED_FILENAME);
        File resultFile = new File(RESULT_FILENAME);

        writer.writeToFile(manager.getStones(), resultFile);

        assertEquals(-1L, Files.mismatch(expectedFile.toPath(), resultFile.toPath()));
    }

    @Test
    public void testWriterOverride() throws IOException {
        File resultFile = new File(RESULT_FILENAME);
        resultFile.createNewFile();
        FileWriter fileWriter = new FileWriter(resultFile);
        fileWriter.write("text for test");
        fileWriter.close();

        testWriteListOfStones();

        File expectedFile = new File(EXPECTED_FILENAME);
        String expectedContent = new String(Files.readAllBytes(expectedFile.toPath()));
        String resultContent = new String(Files.readAllBytes(resultFile.toPath()));
        assertEquals(expectedContent, resultContent);
    }

}