package main.java.ua.lviv.iot.algo.part1.writer;

import lombok.*;
import main.java.ua.lviv.iot.algo.part1.model.Stone;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@ToString
@Getter
public class StoneWriter {
    public File writeToFile(List<Stone> stones, File file) {
        if (stones == null || stones.isEmpty()) {
            return null;
        }

        try (PrintWriter stoneWriter = new PrintWriter(file)) {
            for (var stone : stones) {
                stoneWriter.println(stone.getHeaders());
                stoneWriter.println(stone.toCSV());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return file;
    }

}