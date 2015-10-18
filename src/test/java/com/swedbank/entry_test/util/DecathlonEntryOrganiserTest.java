package com.swedbank.entry_test.util;

import com.swedbank.entry_test.util.data.DecathlonResultEntry;
import com.swedbank.entry_test.util.data.DecathlonResultEntryCollectionWrapper;
import com.swedbank.entry_test.util.data.Position;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class DecathlonEntryOrganiserTest {

    private static final String TEST_FILE_1_NAME = "test1.xml";
    private Collection<DecathlonResultEntry> entries;

    @Before
    public void setUp() throws Exception {
        final URL url1 = this.getClass().getResource("/" + TEST_FILE_1_NAME);
        File test1orig = new File(url1.toURI());
        JAXBContext context = JAXBContext.newInstance(DecathlonResultEntryCollectionWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        DecathlonResultEntryCollectionWrapper entryWrapper =
                (DecathlonResultEntryCollectionWrapper) unmarshaller.unmarshal(test1orig);
        entries = entryWrapper.getEntries();
    }

    @Test
    public void testOrganise() throws Exception {
        Collection<DecathlonResultEntry> organisedEntries =
                new DecathlonEntryOrganiser(new StandardDecathlonPointsCounter()).organise(entries);

        int points = 0;
        Position position = null;
        for (DecathlonResultEntry entry : organisedEntries) {
            if (position != null) {
                assertTrue(points >= entry.getPoints());
                assertTrue(position.getFrom() <= entry.getPosition().getFrom());
                assertTrue(position.getTo() <= entry.getPosition().getTo());
            }
            points = entry.getPoints();
            position = entry.getPosition();
        }

    }

}