package com.swedbank.entry_test.util;

import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author ben
 * @version 1.0
 */
public class FileComparator {

    private final String digest;

    public FileComparator(String digest) {
        this.digest = digest;
    }

    /**
     * Compares hashes of provided files
     * @param f1
     * @param f2
     * @return true if both files are the same, false otherwise;
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public boolean compare(File f1, File f2)
            throws NoSuchAlgorithmException, IOException {
        MessageDigest md1 = MessageDigest.getInstance(digest);
        MessageDigest md2 = MessageDigest.getInstance(digest);

        try (InputStream str1 = new FileInputStream(f1);
             InputStream str2 = new FileInputStream(f2)) {
            DigestInputStream dis1 = new DigestInputStream(str1, md1);
            DigestInputStream dis2 = new DigestInputStream(str2, md2);

            return Arrays.equals(
                    dis1.getMessageDigest().digest(),
                    dis2.getMessageDigest().digest()
            );
        }
    }

}
