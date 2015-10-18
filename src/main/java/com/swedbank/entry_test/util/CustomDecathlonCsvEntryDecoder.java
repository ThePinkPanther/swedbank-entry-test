package com.swedbank.entry_test.util;


import com.swedbank.entry_test.util.data.DecathlonResultEntry;

/**
 * @author ben
 * @version 1.0
 */
public class CustomDecathlonCsvEntryDecoder implements DecathlonEntryDecoder {

    private final static int CSV_COL_NUM = 11;
    private final String separator;

    public CustomDecathlonCsvEntryDecoder() {
        this(";");
    }

    public CustomDecathlonCsvEntryDecoder(String separator) {
        this.separator = separator;
    }

    /**
     * Produces decathlon entry from a CSV file line
     *
     * @param str CSV file line
     * @return DecathlonResultEntry
     * @throws DecodingException
     */
    @Override
    public DecathlonResultEntry decode(String str) throws DecodingException {
        String[] columns = str.trim().split(separator);
        if (columns.length != CSV_COL_NUM) {
            throw new DecodingException(
                    "Given line has wrong number of fields (" + CSV_COL_NUM + " " + "expected)");
        }
        try {

            // Parse the last fields that holds minutes
            String[] marathonTime = columns[10].split("\\.", 2);
            if (marathonTime.length != 2) {
                throw new DecodingException(
                        "oneThousandFiveHoundedMetresRunTime format is expected to be mm:ss:SS");
            }

            return new DecathlonResultEntry(
                    columns[0],
                    Double.parseDouble(columns[1]),
                    Double.parseDouble(columns[2]),
                    Double.parseDouble(columns[3]),
                    Double.parseDouble(columns[4]),
                    Double.parseDouble(columns[5]),
                    Double.parseDouble(columns[6]),
                    Double.parseDouble(columns[7]),
                    Double.parseDouble(columns[8]),
                    Double.parseDouble(columns[9]),
                    Double.parseDouble(marathonTime[1]) + Integer.parseInt(marathonTime[0]) * 60,
                    null, null);
        } catch (NumberFormatException e) {
            throw new DecodingException(e.getMessage());
        }
    }
}
