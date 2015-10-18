package com.swedbank.entry_test.util.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * @author ben
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "decathlonResult")
public class DecathlonResultEntry {

    private String name;
    private Double oneHundredMetresSprintTime;
    private Double longJumpDistance;
    private Double shotPutDistance;
    private Double highJumpDistance;
    private Double fourHundredMetresSprintTime;
    private Double oneHundredTenMetresHurdleTime;
    private Double discusThrowDistance;
    private Double poleVaultDistance;
    private Double javelinThrowDistance;
    private Double oneThousandFiveHoundedMetresRunTime;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    private Integer points;
    private Position position;

    public DecathlonResultEntry() {
    }

    public DecathlonResultEntry(
            String name,
            Double oneHundredMetresSprintTime,
            Double longJumpDistance,
            Double shotPutDistance,
            Double highJumpDistance,
            Double fourHundredMetresSprintTime,
            Double oneHundredTenMetresHurdleTime,
            Double discusThrowDistance,
            Double poleVaultDistance,
            Double javelinThrowDistance,
            Double oneThousandFiveHoundedMetresRunTime,
            Integer points,
            Position position) {
        this.points = points;
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

    public Double getOneHundredMetresSprintTime() {
        return oneHundredMetresSprintTime;
    }

    public Double getLongJumpDistance() {
        return longJumpDistance;
    }

    public Double getShotPutDistance() {
        return shotPutDistance;
    }

    public Double getHighJumpDistance() {
        return highJumpDistance;
    }

    public Double getFourHundredMetresSprintTime() {
        return fourHundredMetresSprintTime;
    }

    public Double getOneHundredTenMetresHurdleTime() {
        return oneHundredTenMetresHurdleTime;
    }

    public Double getDiscusThrowDistance() {
        return discusThrowDistance;
    }

    public Double getPoleVaultDistance() {
        return poleVaultDistance;
    }

    public Double getJavelinThrowDistance() {
        return javelinThrowDistance;
    }

    public Double getOneThousandFiveHoundedMetresRunTime() {
        return oneThousandFiveHoundedMetresRunTime;
    }

    public Position getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOneHundredMetresSprintTime(Double oneHundredMetresSprintTime) {
        this.oneHundredMetresSprintTime = oneHundredMetresSprintTime;
    }

    public void setLongJumpDistance(Double longJumpDistance) {
        this.longJumpDistance = longJumpDistance;
    }

    public void setShotPutDistance(Double shotPutDistance) {
        this.shotPutDistance = shotPutDistance;
    }

    public void setHighJumpDistance(Double highJumpDistance) {
        this.highJumpDistance = highJumpDistance;
    }

    public void setFourHundredMetresSprintTime(Double fourHundredMetresSprintTime) {
        this.fourHundredMetresSprintTime = fourHundredMetresSprintTime;
    }

    public void setOneHundredTenMetresHurdleTime(Double oneHundredTenMetresHurdleTime) {
        this.oneHundredTenMetresHurdleTime = oneHundredTenMetresHurdleTime;
    }

    public void setDiscusThrowDistance(Double discusThrowDistance) {
        this.discusThrowDistance = discusThrowDistance;
    }

    public void setPoleVaultDistance(Double poleVaultDistance) {
        this.poleVaultDistance = poleVaultDistance;
    }

    public void setJavelinThrowDistance(Double javelinThrowDistance) {
        this.javelinThrowDistance = javelinThrowDistance;
    }

    public void setOneThousandFiveHoundedMetresRunTime(Double oneThousandFiveHoundedMetresRunTime) {
        this.oneThousandFiveHoundedMetresRunTime = oneThousandFiveHoundedMetresRunTime;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DecathlonResultEntry) {
            DecathlonResultEntry entry = (DecathlonResultEntry) obj;
            if (Objects.equals(entry.name, name) &&
                Objects.equals(entry.oneHundredMetresSprintTime, oneHundredMetresSprintTime) &&
                Objects.equals(entry.longJumpDistance, longJumpDistance) &&
                Objects.equals(entry.shotPutDistance, shotPutDistance) &&
                Objects.equals(entry.highJumpDistance, highJumpDistance) &&
                Objects.equals(entry.fourHundredMetresSprintTime, fourHundredMetresSprintTime) &&
                Objects.equals(entry.oneHundredTenMetresHurdleTime, oneHundredTenMetresHurdleTime) &&
                Objects.equals(entry.discusThrowDistance, discusThrowDistance) &&
                Objects.equals(entry.poleVaultDistance, poleVaultDistance) &&
                Objects.equals(entry.javelinThrowDistance, javelinThrowDistance) &&
                Objects.equals(entry.oneThousandFiveHoundedMetresRunTime, oneThousandFiveHoundedMetresRunTime) &&
                Objects.equals(entry.position, position) &&
                Objects.equals(entry.points, points)
                    ) {
                return true;
            }
        }
        return false;
    }

}
