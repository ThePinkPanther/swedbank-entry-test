package com.swedbank.entry_test.util;

import com.swedbank.entry_test.util.data.DecathlonResultEntry;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;

public class DecathlonCsvEntryDecoderTest {

    private static final Random generator = new Random();
    private DecathlonCsvEntryDecoder decoder;
    private final String separator = ";";
    private final String name = "Lisa Simpson";
    private final double oneHundredMetresSprintTime = generator.nextDouble();
    private final double longJumpDistance = generator.nextDouble();
    private final double shotPutDistance = generator.nextDouble();
    private final double highJumpDistance = generator.nextDouble();
    private final double fourHundredMetresSprintTime = generator.nextDouble();
    private final double oneHundredTenMetresHurdleTime = generator.nextDouble();
    private final double discusThrowDistance = generator.nextDouble();
    private final double poleVaultDistance = generator.nextDouble();
    private final double javelinThrowDistance = generator.nextDouble();
    private final double oneThousandFiveHoundedMetresRunTime = generator.nextDouble();
    private final String entry = String.format(
            "%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s",
            name,
            oneHundredMetresSprintTime,
            longJumpDistance,
            shotPutDistance,
            highJumpDistance,
            fourHundredMetresSprintTime,
            oneHundredTenMetresHurdleTime,
            discusThrowDistance,
            poleVaultDistance,
            javelinThrowDistance,
            oneThousandFiveHoundedMetresRunTime);

    @Before
    public void setUp() throws Exception {
        decoder = new DecathlonCsvEntryDecoder(separator);
    }

    @Test
    public void testDecode() throws Exception {
        DecathlonResultEntry result = decoder.decode(entry);
        assertEquals(name, result.getName());
        assertEquals(oneHundredMetresSprintTime, result.getOneHundredMetresSprintTime());
        assertEquals(longJumpDistance, result.getLongJumpDistance());
        assertEquals(shotPutDistance, result.getShotPutDistance());
        assertEquals(highJumpDistance, result.getHighJumpDistance());
        assertEquals(fourHundredMetresSprintTime, result.getFourHundredMetresSprintTime());
        assertEquals(oneHundredTenMetresHurdleTime, result.getOneHundredTenMetresHurdleTime());
        assertEquals(discusThrowDistance, result.getDiscusThrowDistance());
        assertEquals(poleVaultDistance, result.getPoleVaultDistance());
        assertEquals(javelinThrowDistance, result.getJavelinThrowDistance());
        assertEquals(oneThousandFiveHoundedMetresRunTime, result
                .getOneThousandFiveHoundedMetresRunTime());
    }
}