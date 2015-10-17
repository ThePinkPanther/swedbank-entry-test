package com.swedbank.entry_test.util;

/**
 * @author ben
 * @version 1.0
 */
public class ContestPointsCounter {

    public int countPoints(
            double result,
            double resultMultiplier,
            double resultComponent,
            double resultDegree) {

        return (int) Math.floor(
                Math.abs(
                        resultMultiplier * Math.pow(
                                (result - resultComponent),
                                resultDegree
                        )));

    }

}
