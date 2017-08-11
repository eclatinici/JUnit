package com.github.unit_testing.demo.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;

public class FileManager {

    public static void copy(Path source, Path destinationDir) throws IOException {
        if(pathExists(destinationDir) && destinationDir.toFile().isDirectory()) {
            Path destination = destinationDir.resolve("0000_" + source.getFileName());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public static void move(Path source, Path destinationDir) throws IOException {
        if(pathExists(destinationDir) && destinationDir.toFile().isDirectory()) {
            Path destination = destinationDir.resolve("0000_" + source.getFileName());
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean pathExists(Path destinationDir) {
        return destinationDir.toFile().exists();
    }

    public static Path getSubPath(Path dir, String file) {
        return dir.resolve(file);
    }

    public static void delete(Path dir) throws IOException {
        if(FileManager.pathExists(dir)) {
            Files.walk(dir, FileVisitOption.FOLLOW_LINKS)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }
}
