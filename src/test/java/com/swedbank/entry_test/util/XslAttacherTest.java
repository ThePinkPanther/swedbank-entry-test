package com.swedbank.entry_test.util;

import com.swedbank.entry_test.util.XslAttacher;
import com.swedbank.entry_test.util.data.DecathlonResultEntryCollectionWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class XslAttacherTest {


    private JAXBContext context;
    private Marshaller marshaller;
    private XslAttacher attacher;
    private static final String resourceName = "testdecathlon.xsl";

    @Before
    public void setUp() throws Exception {
        context = JAXBContext.newInstance(DecathlonResultEntryCollectionWrapper.class);
        marshaller = context.createMarshaller();
        attacher = new XslAttacher();
    }

    @Test
    public void testAttachXsl() throws Exception {
        attacher.attachXsl(marshaller, resourceName, resourceName);
        assertEquals(
                String.format(XslAttacher.XSL_HEADER, resourceName),
                marshaller.getProperty(XslAttacher.XSL_HEADER_PROPERTY_NAME));


        final File newXsl = new File(resourceName);
        assertTrue(newXsl.isFile());

        final URL url = this.getClass().getResource("/" + resourceName);
        final File originalXsl = new File(url.toURI());

        assertTrue ( new FileComparator("MD5").compare(originalXsl,newXsl));
    }

    @After
    public void tearDown() throws Exception {
        new File(resourceName).delete();
    }

}