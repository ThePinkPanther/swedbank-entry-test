package com.swedbank.entry_test;

import com.swedbank.entry_test.util.DecodingException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ben
 * @version 1.0
 */
public class Logger {

    public Logger() {
    }

    public Logger(OutputStream errorStream, OutputStream printStream) {
        this.errorStream = errorStream;
        this.printStream = printStream;
    }

    public OutputStream getErrorStream() {
        return errorStream;
    }

    public void setErrorStream(OutputStream errorStream) {
        this.errorStream = errorStream;
    }

    public OutputStream getPrintStream() {
        return printStream;
    }

    public void setPrintStream(OutputStream printStream) {
        this.printStream = printStream;
    }

    private OutputStream errorStream;
    private OutputStream printStream;

    public void err(String err) {
        try {
            printToStream(errorStream, err);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(String print) {
        try {
            printToStream(printStream, print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printToStream(OutputStream os, String message) throws IOException {
        if (os != null) {
            os.write(message.getBytes());
        }
    }

    public void err(Exception e) {
        err(e.getMessage());
    }
}
