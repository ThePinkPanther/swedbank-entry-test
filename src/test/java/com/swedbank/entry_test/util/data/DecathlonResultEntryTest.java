package com.swedbank.entry_test.util.data;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class DecathlonResultEntryTest {

    private static final File serialisationFile = new File("test.xml");
    private JAXBContext context;
    private static final Random random = new Random();

    @Before
    public void setUp() throws Exception {
        context = JAXBContext.newInstance(DecathlonResultEntry.class);
    }

    @Test
    public void testSerialisation() throws Exception {
        final Marshaller marshaller = context.createMarshaller();
        DecathlonResultEntry entry = new DecathlonResultEntry(
                "Aaa",
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextInt(),
                new Position(random.nextInt())
        );
        marshaller.marshal(entry, serialisationFile);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        assertTrue(entry.equals(unmarshaller.unmarshal(serialisationFile)));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        serialisationFile.delete();
    }

}