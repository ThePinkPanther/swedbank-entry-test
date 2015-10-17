package com.swedbank.entry_test.util;

import java.io.IOException;

/**
 * @author ben
 * @version 1.0
 */
public class DecodingException extends IOException {

    public DecodingException() {
    }

    public DecodingException(String message) {
        super(message);
    }

    public DecodingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecodingException(Throwable cause) {
        super(cause);
    }
}
