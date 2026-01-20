package org.slicedPotatoes.adventOfCode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ReadFile {
    private static String root = "src/main/java/org/slicedPotatoes/adventOfCode/";

    public static String getFullFile(String path) throws IOException {
        return Files.readString(Path.of(root + path));
    }

    public static List<String> getLines(String path) throws IOException {
        return getStream(path).toList();
    }

    public static Stream<String> getStream(String path) throws IOException {
        return Files.lines(Path.of(root + path));
    }
}
