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
class ArgumentParser {

    final static String OUTPUT_FILE_FLAG = "--output";
    final static String INCLUDE_XSL_FLAG = "--include-xsl";
    final static String DEBUG_FLAG = "--debug";

    private boolean xslRequired = false;

    private boolean debugModeActive;

    public Collection<File> getInputFiles() {
        return inputFiles;
    }

    public OutputStream getApplicationOutput() {
        return applicationOutput;
    }

    public boolean isXslRequired() {
        return xslRequired;
    }

    public boolean isDebugModeActive() {
        return debugModeActive;
    }

    public InputStream getApplicationInput() {
        return applicationInput;
    }

    private OutputStream applicationOutput = System.out;

    private InputStream applicationInput;

    private final Collection<File> inputFiles = new LinkedList<>();

    /**
     * Reads provided arguments and sets it's parameters based on them
     *
     * @param arguments input arguments (supposedly from command line)
     * @throws Exception
     */
    public void parse(String[] arguments) throws Exception {
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

                case INCLUDE_XSL_FLAG:
                    xslRequired = true;
                    break;

                case DEBUG_FLAG:
                    debugModeActive = true;
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
            throw new IOException("Cant write to specified output file");
        }
        applicationOutput = new FileOutputStream(file);
    }

    private void setApplicationInput(File file) throws FileNotFoundException {
        final InputStream fileInputStream = new SequenceInputStream(
                new FileInputStream(file),
                new ByteArrayInputStream("\n".getBytes())); //Provide endline between files

        if (applicationInput == null) {
            applicationInput = fileInputStream;
        } else {
            applicationInput = new SequenceInputStream(applicationInput, fileInputStream);
        }
    }

}
