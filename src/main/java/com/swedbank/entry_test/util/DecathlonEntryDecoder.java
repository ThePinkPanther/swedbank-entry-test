package com.swedbank.entry_test.util;


/**
 * @author ben
 * @version 1.0
 */
public interface DecathlonEntryDecoder {

    public DecathlonResultEntry decode(String str) throws DecodingException;

}
