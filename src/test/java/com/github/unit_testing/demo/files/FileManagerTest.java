package com.github.unit_testing.demo.files;

import jdk.Exported;
import org.junit.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileManagerTest {
    private static String fileName = "file.txt";
    private static Path destinationDir;
    private static Path sourceDir;
    private Path sourcePath;
    private Path destinationPath;

    @BeforeClass
    public static void setupDirectories() throws Exception{
        Path basePath = getBasePath();
        //setup source dir
        sourceDir = FileManager.getSubPath(basePath, "srcDir");
        Files.createDirectories(sourceDir);
        //setup destinationDir
        destinationDir = FileManager.getSubPath(basePath,"destDir");
        Files.createDirectories(destinationDir);
    }

    private static Path getBasePath() throws URISyntaxException {
        URI uri = FileManagerTest.class.getClassLoader().getResource(".").toURI();
        return Paths.get(uri);
    }

    @Before
    public void setup() throws IOException {
        sourcePath = sourceDir.resolve(fileName);
        Files.createFile(sourcePath);
        destinationPath = FileManager.getSubPath(destinationDir, "0000_" + fileName);
    }

    @Test
    public void shouldCopyFile() throws IOException {
        //execute
        FileManager.copy(sourcePath, destinationDir);

        //verify
        assertTrue(FileManager.pathExists(sourcePath));
        assertEquals(Boolean.TRUE, FileManager.pathExists(destinationPath));

    }

    @Test
    public void shouldMoveFile() throws IOException {
        //execute
        FileManager.move(sourcePath, destinationDir);

        //verify
        assertFalse(FileManager.pathExists(sourcePath));
        assertTrue(FileManager.pathExists(destinationPath));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenCopyingFile() throws IOException {
        //execute
        FileManager.copy(sourcePath, destinationPath);

        //verify
        assertTrue(FileManager.pathExists(sourcePath));
        assertEquals(Boolean.TRUE, FileManager.pathExists(destinationPath));

    }

    @After
    public void cleanUp() throws IOException {
        FileManager.delete(sourcePath);
        FileManager.delete(destinationPath);
    }

    @AfterClass
    public static void cleanupDirectories() throws IOException {
        FileManager.delete(sourceDir);
        FileManager.delete(destinationDir);
    }
}