package com.swedbank.entry_test.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ben
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class DecathlonResultEntry {

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
    private Position position;

    public DecathlonResultEntry() {
    }

    public DecathlonResultEntry(
            String name,
            double oneHundredMetresSprintTime,
            double longJumpDistance,
            double shotPutDistance,
            double highJumpDistance,
            double fourHundredMetresSprintTime,
            double oneHundredTenMetresHurdleTime,
            double discusThrowDistance,
            double poleVaultDistance,
            double javelinThrowDistance,
            double oneThousandFiveHoundedMetresRunTime, Position position) {
        this.position = position;
        this.name = name;
        this.oneHundredMetresSprintTime = oneHundredMetresSprintTime;
        this.longJumpDistance = longJumpDistance;
        this.shotPutDistance = shotPutDistance;
        this.highJumpDistance = highJumpDistance;
        this.fourHundredMetresSprintTime = fourHundredMetresSprintTime;
        this.oneHundredTenMetresHurdleTime = oneHundredTenMetresHurdleTime;
        this.discusThrowDistance = discusThrowDistance;
        this.poleVaultDistance = poleVaultDistance;
        this.javelinThrowDistance = javelinThrowDistance;
        this.oneThousandFiveHoundedMetresRunTime = oneThousandFiveHoundedMetresRunTime;
    }

    public String getName() {
        return name;
    }

    public double getOneHundredMetresSprintTime() {
        return oneHundredMetresSprintTime;
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

    public double getFourHundredMetresSprintTime() {
        return fourHundredMetresSprintTime;
    }

    public double getOneHundredTenMetresHurdleTime() {
        return oneHundredTenMetresHurdleTime;
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

    public double getOneThousandFiveHoundedMetresRunTime() {
        return oneThousandFiveHoundedMetresRunTime;
    }

    public Position getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOneHundredMetresSprintTime(double oneHundredMetresSprintTime) {
        this.oneHundredMetresSprintTime = oneHundredMetresSprintTime;
    }

    public void setLongJumpDistance(double longJumpDistance) {
        this.longJumpDistance = longJumpDistance;
    }

    public void setShotPutDistance(double shotPutDistance) {
        this.shotPutDistance = shotPutDistance;
    }

    public void setHighJumpDistance(double highJumpDistance) {
        this.highJumpDistance = highJumpDistance;
    }

    public void setFourHundredMetresSprintTime(double fourHundredMetresSprintTime) {
        this.fourHundredMetresSprintTime = fourHundredMetresSprintTime;
    }

    public void setOneHundredTenMetresHurdleTime(double oneHundredTenMetresHurdleTime) {
        this.oneHundredTenMetresHurdleTime = oneHundredTenMetresHurdleTime;
    }

    public void setDiscusThrowDistance(double discusThrowDistance) {
        this.discusThrowDistance = discusThrowDistance;
    }

    public void setPoleVaultDistance(double poleVaultDistance) {
        this.poleVaultDistance = poleVaultDistance;
    }

    public void setJavelinThrowDistance(double javelinThrowDistance) {
        this.javelinThrowDistance = javelinThrowDistance;
    }

    public void setOneThousandFiveHoundedMetresRunTime(double oneThousandFiveHoundedMetresRunTime) {
        this.oneThousandFiveHoundedMetresRunTime = oneThousandFiveHoundedMetresRunTime;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
