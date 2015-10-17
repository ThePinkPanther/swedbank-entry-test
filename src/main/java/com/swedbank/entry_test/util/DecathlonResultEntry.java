package com.swedbank.entry_test.util;

/**
 * @author ben
 * @version 1.0
 */
public class DecathlonResultEntry {

    private final String name;

    private final double oneHundreadMetresSprintTime;

    private final double longJumpDistance;

    private final double shotPutDistance;

    private final double highJumpDistance;

    private final double fourHundreadMetresSprintTime;

    private final double oneHundreadTenMetresHurdleTime;

    private final double discusThrowDistance;

    private final double poleVaultDistance;

    private final double javelinThrowDistance;

    private final double oneThousandFiveHoundreadMetresRunTime;

    public DecathlonResultEntry(
            String name,
            double oneHundreadMetresSprintTime,
            double longJumpDistance,
            double shotPutDistance,
            double highJumpDistance,
            double fourHundreadMetresSprintTime,
            double oneHundreadTenMetresHurdleTime,
            double discusThrowDistance,
            double poleVaultDistance,
            double javelinThrowDistance,
            double oneThousandFiveHoundreadMetresRunTime) {
        if (name == null)
            throw new NullPointerException("Name can't be null");
        this.name = name;
        this.oneHundreadMetresSprintTime = oneHundreadMetresSprintTime;
        this.longJumpDistance = longJumpDistance;
        this.shotPutDistance = shotPutDistance;
        this.highJumpDistance = highJumpDistance;
        this.fourHundreadMetresSprintTime = fourHundreadMetresSprintTime;
        this.oneHundreadTenMetresHurdleTime = oneHundreadTenMetresHurdleTime;
        this.discusThrowDistance = discusThrowDistance;
        this.poleVaultDistance = poleVaultDistance;
        this.javelinThrowDistance = javelinThrowDistance;
        this.oneThousandFiveHoundreadMetresRunTime = oneThousandFiveHoundreadMetresRunTime;
    }

    public String getName() {
        return name;
    }

    public double getOneHundreadMetresSprintTime() {
        return oneHundreadMetresSprintTime;
    }

    public double getLongJumpDistance() {
        return longJumpDistance;
    }

    public double getShotPutDistance() {
        return shotPutDistance;
    }

    public double getHighJumpDistance() {
        return highJumpDistance;
    }

    public double getFourHundreadMetresSprintTime() {
        return fourHundreadMetresSprintTime;
    }

    public double getOneHundreadTenMetresHurdleTime() {
        return oneHundreadTenMetresHurdleTime;
    }

    public double getDiscusThrowDistance() {
        return discusThrowDistance;
    }

    public double getPoleVaultDistance() {
        return poleVaultDistance;
    }

    public double getJavelinThrowDistance() {
        return javelinThrowDistance;
    }

    public double getOneThousandFiveHoundreadMetresRunTime() {
        return oneThousandFiveHoundreadMetresRunTime;
    }

}
