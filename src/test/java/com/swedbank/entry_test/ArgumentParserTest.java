package com.swedbank.entry_test;

import com.swedbank.entry_test.ArgumentParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;

public class ArgumentParserTest {

    private ArgumentParser argumentParser;
    private static final String TEST_FILE_1_NAME = "test1.xml";
    private static final String TEST_FILE_2_NAME = "test2";
    private static final String OUTPUT_FILE_NAME = "test3";
    private static final String[] ARGS = {
            TEST_FILE_1_NAME,
            TEST_FILE_2_NAME,
            ArgumentParser.OUTPUT_FILE_FLAG,
            OUTPUT_FILE_NAME,
            ArgumentParser.INCLUDE_XSL_FLAG};
    private File test1orig;
    private File test2orig;
    private File test2new;
    private File test1new;
    private File output;

    @Before
    public void setUp() throws Exception {
        argumentParser = new ArgumentParser();
        final URL url1 = this.getClass().getResource("/" + TEST_FILE_1_NAME);
        final URL url2 = this.getClass().getResource("/" + TEST_FILE_2_NAME);
        test1orig = new File(url1.toURI());
        test2orig = new File(url2.toURI());
        test1new = new File(TEST_FILE_1_NAME);
        test2new = new File(TEST_FILE_2_NAME);
        output = new File(OUTPUT_FILE_NAME);
        try (final OutputStream os1 = new FileOutputStream(test1new);
             final OutputStream os2 = new FileOutputStream(test2new);
        ) {
            Files.copy(test1orig.toPath(), os1);
            Files.copy(test2orig.toPath(), os2);
            os1.flush();
            os2.flush();
        }
    }

    @After
    public void tearDown() throws Exception {
        test1new.delete();
        test2new.delete();
        output.delete();
    }

    @Test
    public void testParse() throws Exception {
        argumentParser.parse(ARGS);
        assertTrue(argumentParser.isXslRequired());
        assertTrue(argumentParser.getApplicationOutput() instanceof FileOutputStream);
        HashSet<String> names = new HashSet<>();
        for (File file : argumentParser.getInputFiles()) {
            names.add(file.getName());
        }
        assertTrue(names.contains(TEST_FILE_1_NAME));
        assertTrue(names.contains(TEST_FILE_2_NAME));
    }
}