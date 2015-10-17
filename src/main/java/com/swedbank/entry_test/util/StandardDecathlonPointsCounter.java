package com.swedbank.entry_test.util;

import com.swedbank.entry_test.util.data.DecathlonResultEntry;

/**
 * @author ben
 * @version 1.0
 */
public class StandardDecathlonPointsCounter implements DecathlonPointsCounter {

    private final ContestPointsCounter contestPointsCounter = new ContestPointsCounter();

    private final double[][] contestTable = {
            {25.4347, 18, 1.81},
            {0.14354, 220, 1.4},
            {51.39, 1.5, 1.05},
            {0.8465, 75, 1.42},
            {1.53775, 82, 1.81},
            {5.74352, 28.5, 1.92},
            {12.91, 4, 1.1},
            {0.2797, 100, 1.35},
            {10.14, 7, 1.08},
            {0.03768, 480, 1.85},
    };

    private double[] getEntryFields(DecathlonResultEntry entry) {
        return new double[]{
                entry.getOneHundredMetresSprintTime(),
                entry.getLongJumpDistance(),
                entry.getShotPutDistance(),
                entry.getHighJumpDistance(),
                entry.getFourHundredMetresSprintTime(),
                entry.getOneHundredTenMetresHurdleTime(),
                entry.getDiscusThrowDistance(),
                entry.getPoleVaultDistance(),
                entry.getJavelinThrowDistance(),
                entry.getOneThousandFiveHoundedMetresRunTime()
        };
    }

    @Override
    public int countPoints(DecathlonResultEntry entry) {
        int points = 0;
        double[] entryFields = getEntryFields(entry);
        for (int i = 0; i < entryFields.length && i < contestTable.length; i++ ){
            points+= contestPointsCounter.countPoints(
                    entryFields[i],
                    contestTable[i][0],
                    contestTable[i][1],
                    contestTable[i][2]);
        }
        return points;
    }
}
