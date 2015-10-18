package com.swedbank.entry_test.util;

import com.swedbank.entry_test.util.data.DecathlonResultEntry;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;

public class CustomDecathlonCsvEntryDecoderTest {

    private static final Random generator = new Random();
    private CustomDecathlonCsvEntryDecoder decoder;
    private final String separator = ";";
    private String name;
    private double oneHundredMetresSprintTime;
    private double longJumpDistance;
    private double shotPutDistance;
    private double highJumpDistance;
    private double fourHundredMetresSprintTime;
    private double oneHundredTenMetresHurdleTime;
    private double discusThrowDistance;
    private double poleVaultDistance;
    private double javelinThrowDistance;
    private double oneThousandFiveHoundedMetresRunTime;
    private String entry ;


    @Before
    public void setUp() throws Exception {
        name = "Lisa Simpson";
        oneHundredMetresSprintTime = generator.nextDouble();
        longJumpDistance = generator.nextDouble();
        shotPutDistance = generator.nextDouble();
        highJumpDistance = generator.nextDouble();
        fourHundredMetresSprintTime = generator.nextDouble();
        oneHundredTenMetresHurdleTime = generator.nextDouble();
        discusThrowDistance = generator.nextDouble();
        poleVaultDistance = generator.nextDouble();
        javelinThrowDistance = generator.nextDouble();
        oneThousandFiveHoundedMetresRunTime = generator.nextDouble();

        int minutes = (int) (oneThousandFiveHoundedMetresRunTime/60);
        double seconds = oneThousandFiveHoundedMetresRunTime%60;
        entry = String.format(
                "%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%d.%s",
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
                minutes,
                seconds);
        decoder = new CustomDecathlonCsvEntryDecoder(separator);
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