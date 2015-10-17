package com.swedbank.entry_test;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ben
 * @version 1.0
 */
public class EntryTest {

    public static void main(String[] args) throws Exception {
        ArgumentParser parser = new ArgumentParser(args);

        try (OutputStream applicationOutput = parser.getApplicationOutput();
             InputStream applicationInput = parser.getApplicationInput()) {

        }
    }

}
