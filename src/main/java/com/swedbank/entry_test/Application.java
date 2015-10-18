package com.swedbank.entry_test;

import com.swedbank.entry_test.util.*;
import com.swedbank.entry_test.util.data.DecathlonResultEntry;
import com.swedbank.entry_test.util.data.DecathlonResultEntryCollectionWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

/**
 * @author ben
 * @version 1.0
 */
public class Application {

    /**
     * A fast solution
     */
    public static final Logger LOGGER = new Logger();

    public static void main(String[] args) throws Exception {

        // Parse arguments
        ArgumentParser parser = new ArgumentParser();
        parser.parse(args);

        // Set output streams when debug mode activated
        if (parser.isDebugModeActive()) {
            LOGGER.setErrorStream(System.err);
            LOGGER.setPrintStream(System.out);
        }

        try (InputStream applicationInput = parser.getApplicationInput();
             OutputStream applicationOutput = parser.getApplicationOutput()) {

            // Parse entries from given input files
            Collection<DecathlonResultEntry> entries = new DecathlonResultsProducer(
                    new CustomDecathlonCsvEntryDecoder())
                    .produce(applicationInput);

            // Count points and positions, order collection by points earned
            Collection<DecathlonResultEntry> organisedEntries =
                    new DecathlonEntryOrganiser(
                            new StandardDecathlonPointsCounter()).organise(entries);

            // Create XML writer
            JAXBContext context = JAXBContext.newInstance(DecathlonResultEntryCollectionWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            // Set readable format
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            if (parser.isXslRequired()) {
                // If client asks for XSL, add existing XSL model from resources and attach it to
                // marshaller
                String xslFileName = "decathlon.xsl";
                new XslAttacher().attachXsl(marshaller, xslFileName, xslFileName);
            }

            // Format and write XML to output
            marshaller.marshal(new DecathlonResultEntryCollectionWrapper(organisedEntries),
                    applicationOutput);

        } catch (Exception e) {
            LOGGER.err(e);
        }

    }

}
