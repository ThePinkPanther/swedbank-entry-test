package com.swedbank.entry_test.util;

import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

/**
 * @author ben
 * @version 1.0
 */
public class XslAttacher {

    static final String XSL_HEADER_PROPERTY_NAME = "com.sun.xml.internal.bind.xmlHeaders";
    static final String XSL_HEADER = "\n<?xml-stylesheet type='text/xsl' href=\"%s\" ?>";

    /**
     * Looks for specified file in resources folder, copies it to working directory and attaches
     * it to marshaller file.
     *
     * @param marshaller      marshaller to attach XSL to
     * @param xslResourceName a file name to look in src/main/resources folder
     * @throws PropertyException
     * @throws IOException
     * @throws URISyntaxException
     */
    public void attachXsl(Marshaller marshaller, String xslResourceName, String newFileName)
            throws Exception {

        final URL url = this.getClass().getResource("/" + xslResourceName);
        if (url == null) {
            throw new FileNotFoundException("A resource named " + xslResourceName + " was not found.");
        }
        final File file = new File(url.toURI());

        final File newFile = new File(newFileName);
        newFile.createNewFile();

        try {
            try (final OutputStream outStream = new FileOutputStream(newFile)) {
                Files.copy(file.toPath(), outStream);
                outStream.flush();
            }

            marshaller.setProperty(XSL_HEADER_PROPERTY_NAME, String.format(XSL_HEADER, newFileName));

        } catch (Exception e) {
            // Delete the new XSL file if operation fails
            newFile.delete();
            throw e;
        }
    }

}
