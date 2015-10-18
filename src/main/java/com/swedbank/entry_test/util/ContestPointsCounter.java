package com.swedbank.entry_test.util;

/**
 * @author ben
 * @version 1.0
 */
public class ContestPointsCounter {

    /**
     * Counts points using standard formula: Points = INT(A(|B — P|)^C)
     * @param result known as parameter P
     * @param resultMultiplier known as parameter A
     * @param resultComponent known as parameter B
     * @param resultDegree known as parameter C
     * @return decathlon points
     */
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
