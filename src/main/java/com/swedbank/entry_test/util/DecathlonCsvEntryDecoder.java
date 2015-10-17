package com.swedbank.entry_test.util;


/**
 * @author ben
 * @version 1.0
 */
public class DecathlonCsvEntryDecoder implements DecathlonEntryDecoder {

    private final static int CSV_COL_NUM = 11;
    private final String separator;

    public DecathlonCsvEntryDecoder() {
        this(";");
    }

    public DecathlonCsvEntryDecoder(String separator) {
        this.separator = separator;
    }

    @Override
    public DecathlonResultEntry decode(String str) throws DecodingException {
        String[] columns = str.trim().split(separator);
        if (columns.length != CSV_COL_NUM) {
            throw new DecodingException("Given line has wrong number of fields ("+CSV_COL_NUM+" " +
                    "expected)");
        }
        try {
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
                    Double.parseDouble(columns[10]),
                    null);
        } catch (NumberFormatException e) {
            throw new DecodingException(e.getMessage());
        }
    }
}
