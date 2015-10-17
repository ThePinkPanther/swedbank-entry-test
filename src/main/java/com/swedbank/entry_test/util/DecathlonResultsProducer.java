package com.swedbank.entry_test.util;

import com.swedbank.entry_test.util.data.DecathlonResultEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author ben
 * @version 1.0
 */
public class DecathlonResultsProducer {

    private final DecathlonEntryDecoder decoder;

    public DecathlonResultsProducer(DecathlonEntryDecoder decoder) {
        this.decoder = decoder;
    }

    public Collection<DecathlonResultEntry> produce(InputStream source) throws IOException {
        Collection<DecathlonResultEntry> entries = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    entries.add(decoder.decode(line));
                } catch (DecodingException e) {
                    //TODO set up logger
                }
            }
        }
        return entries;
    }

}
