package com.swedbank.entry_test.util.data;

import com.swedbank.entry_test.util.FileComparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class DecathlonResultEntryCollectionWrapperTest {

    private JAXBContext context;
    private static final String TEST_FILE_1_NAME = "test1.xml";
    private static final String NEW_FILE_NAME = "test1.xml";
    private File test1orig;
    private File test1new;

    @Before
    public void setUp() throws Exception {
        context = JAXBContext.newInstance(DecathlonResultEntryCollectionWrapper.class);
        final URL url1 = this.getClass().getResource("/" + TEST_FILE_1_NAME);
        test1orig = new File(url1.toURI());
        test1new = new File(NEW_FILE_NAME);
        test1new.createNewFile();
    }

    @Test
    public void testSerialize() throws Exception {

        Unmarshaller unmarshaller = context.createUnmarshaller();
        DecathlonResultEntryCollectionWrapper entryWrapper =
                (DecathlonResultEntryCollectionWrapper) unmarshaller.unmarshal(test1orig);

        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(entryWrapper, test1new);

        assertTrue(new FileComparator("MD5").compare(test1new, test1orig));
    }

    @After
    public void tearDown() throws Exception {
        test1new.delete();
    }
}