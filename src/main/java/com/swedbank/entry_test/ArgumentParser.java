package com.swedbank.entry_test;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author ben
 * @version 1.0
 */
public class ArgumentParser {


    private final static String OUTPUT_FILE_FLAG = "-o";

    public Collection<File> getInputFiles() {
        return inputFiles;
    }

    public OutputStream getApplicationOutput() {
        return applicationOutput;
    }

    public InputStream getApplicationInput() {
        return applicationInput;
    }

    private OutputStream applicationOutput = System.out;

    private InputStream applicationInput;

    private final Collection<File> inputFiles = new LinkedList<>();

    public ArgumentParser(String[] arguments) throws Exception {
        Iterator<String> argumentIterator = Arrays.asList(arguments).iterator();
        while (argumentIterator.hasNext()) {
            String arg = argumentIterator.next();

            switch (arg) {
                case OUTPUT_FILE_FLAG:
                    if (argumentIterator.hasNext()) {
                        setOutputFile(argumentIterator.next());
                    } else {
                        throw new Exception("No output file specified");
                    }
                    break;

                default:
                    addInputFile(arg);
                    break;
            }
        }

        if (inputFiles.isEmpty()) {
            throw new Exception("No input file specified");
        }

    }

    private void addInputFile(String name) throws Exception {
        File inputFile = new File(name);
        if (!inputFile.isFile()) {
            throw new Exception("Specified input file '" + name + "' does not exist");
        }
        if (!inputFile.canRead()) {
            throw new Exception("Specified input file '" + name + "' is unreadable");
        }
        inputFiles.add(inputFile);
        setApplicationInput(inputFile);
    }

    private void setOutputFile(String name) throws IOException {
        File file = new File(name);
        file.createNewFile();
        if (!file.canWrite()) {
            throw new RuntimeException("Cant write to specified output file");
        }
        applicationOutput = new FileOutputStream(file);
    }

    private void setApplicationInput(File file) throws FileNotFoundException {
        InputStream fileInputStream = new FileInputStream(file);
        if (applicationInput == null) {
            applicationInput = fileInputStream;
        } else {
            applicationInput = new SequenceInputStream(applicationInput, fileInputStream);
        }
    }

}
