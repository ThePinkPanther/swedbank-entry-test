package com.swedbank.entry_test.util;

import com.swedbank.entry_test.Application;
import com.swedbank.entry_test.util.data.DecathlonResultEntry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author ben
 * @version 1.0
 */
public class DecathlonResultsProducer {

    private final DecathlonEntryDecoder decoder;

    public DecathlonResultsProducer(DecathlonEntryDecoder decoder) {
        this.decoder = decoder;
    }

    /**
     * Reads given input source line by line and produces entries (a CSV file reader)
     *
     * @param source InputStream
     * @return Collection<DecathlonResultEntry>
     * @throws IOException
     */
    public Collection<DecathlonResultEntry> produce(InputStream source) {
        Collection<DecathlonResultEntry> entries = new LinkedList<>();
        try (Scanner reader = new Scanner(source)) {
            while (reader.hasNext()) {
                try {
                    String line = reader.nextLine();
                    entries.add(decoder.decode(line));
                } catch (DecodingException e) {
                    Application.LOGGER.err(e);
                }
            }
        }
        return entries;
    }

}
