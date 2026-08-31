package com.exercise.helper;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class TestResourceHelper {

    public static String getFullPath(String filename) {
        Path path = FileSystems.getDefault().getPath("src", "test", "resources", filename);
        return path.toAbsolutePath().toString();
    }
}
