package ua.edu.ucu.tempseries;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;

public class TemperatureSeriesAnalysisTest {

    // average() testing

    @Test
    public void testAverage_BasicSeries() {
        double[] tempSeries = {4, 5, 1, 2, 9, 7, 10, 8};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double expectedRes = 5.75;
        double actualRes = sa.average();
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testAverage_BasicSeries2() {
        double[] tempSeries = {15, 9, 55, 41, 35, 20, 62, 49};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double expectedRes = 35.75;
        double actualRes = sa.average();
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverage_EmptySeries() {
        double[] tempSeries = {};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.average();
    }

    @Test
    public void testAverage_OneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(temperatureSeries);
        double expRes = -1.0;
        double actualRes = sa.average();
        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAverage_BasicSeries3() {
        double[] tempSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double expRes = 1.0;
        double actualRes = sa.average();
        assertEquals(expRes, actualRes, 0.00001);
    }


    // deviation() testing

    @Test
    public void testDeviation_SameTempsSeries() {
        double[] tempSeries = {3, 3, 3, 3, 3, 3};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.deviation();
        double expectedRes = 0;
        assertEquals(expectedRes, actualRes, 0.00001);
    }


    @Test
    public void testDeviation_DifferentTempsSeries() {
        double[] tempSeries = {6.0, 2.0, 5.0, 1.0, 3.0, 4.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.deviation();
        double expectedRes = 2.91667;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviation_EmptySeries() {
        double[] tempSeries = {};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.deviation();
    }

    // min() testing

    @Test
    public void testMin_DifferentSeries() {
        double[] tempSeries = {0.0, -7.0, 5.0, 3.0, -1.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double expectedRes = -7.0;
        double actualRes = sa.min();
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testMin_OneElementArray() {
        double[] tempSeries = {0.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double expectedRes = 0.0;
        double actualRes = sa.min();
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMin_EmptySeries() {
        double[] tempSeries = {};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.min();
    }

    // max() testing

    @Test
    public void testMax_DifferentSeries() {
        double[] tempSeries = {0.0, -7.0, -4.0, 0.0, 1.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double expectedRes = 1.0;
        double actualRes = sa.max();
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testMax_SameValueSeries() {
        double[] tempSeries = {0.0, 0.0, 0.0, 0.0, 0.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double expectedRes = 0.0;
        double actualRes = sa.max();
        assertEquals(expectedRes, actualRes, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMax_EmptySeries() {
        double[] tempSeries = {};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.max();
    }

    // FindClosestToZero() testing

    @Test
    public void testFindTempClosestToZero_DifferentSeries() {
        double[] tempSeries = {-12.0, -5.0, -7.5, 2.5, 3.8, -2.5, 1.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToZero();
        double expectedRes = 1.0;
        assertEquals(actualRes, expectedRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero_SameValueSeries() {
        double[] tempSeries = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToZero();
        double expectedRes = 1.0;
        assertEquals(actualRes, expectedRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero_OneValueSeries() {
        double[] tempSeries = {1.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToZero();
        double expectedRes = 1.0;
        assertEquals(actualRes, expectedRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZero_EmptySeries() {
        double[] tempSeries = {};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.findTempClosestToZero();
    }

    // ClosestToValue() testing

    @Test
    public void testFindTempClosestToValue_DifferentSeries() {
        double[] tempSeries = {-1.0, -2.0, 6.0, 3.0, 5.0};
        double value = 6.0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToValue(value);
        double expectedRes = 6.0;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValue_EmptySeries() {
        double[] tempSeries = {};
        double value = 6.0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToValue(value);
        double expectedRes = 6.0;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue_DifferentSeriesGreaterThanValue() {
        double[] tempSeries = {1.5, 2.0, 4.0, 12.2, 5.9, 4.1, 5.4, 3.4, 5.2};
        double value = 5.0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToValue(value);
        double expectedRes = 5.2;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue_DifferentSeriesLessThanValue() {
        double[] tempSeries = {-1.2, -1.0, -4.0, -5.3, -3.9, -6.1, -5.4, -1.4, -5.1, -3.2};
        double value = -5.0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToValue(value);
        double expectedRes = -5.1;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue_DifferentSeries2() {
        double[] tempSeries = {-2.0, 2.1, 3.2, -4.3, 6.5, -6.5, -7.3, 4.0, 0.0};
        double value = 1.0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToValue(value);
        double expectedRes = 0.0;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue_TwoPossibleValidSolution() {
        double[] tempSeries = {7.0, -4.0, 0.1, 2.0, -1.9, 2.2, -1.4, 1.7, 6, -0.1, -2.1};
        double value = -2.0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double actualRes = sa.findTempClosestToValue(value);
        double expectedRes = -1.9;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    // findTempsLessThan() testing

    @Test
    public void testFindTempsLessThen_NoSuitableValues() {
        double[] tempSeries = {7.0, -4.1, 1.0, -9.0, 0.0, -7};
        double value = -10.0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double[] actualRes = sa.findTempsLessThen(value);
        assertEquals(actualRes.length, 0, 0.00001);
    }

    @Test
    public void testFindTempsLessThen_DifferentSeries() {
        double[] tempSeries = {-50, 10, -7, -15.0, 0, 3, -12, -1.4, 9, 12, 0.0, 21.1, 36.6, 0.1, -1, -1.0};
        double value = 1;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double[] actualRes = sa.findTempsLessThen(value);
        double[] expectedRes = {-50, -7.0, -15.0, 0.0, -12, -1.4, 0.0, 0.1, -1, -1.0};
        for (int i = 0; i < expectedRes.length; i++)
            assertEquals(expectedRes[i], actualRes[i], 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThen_EmptySeries() {
        double[] tempSeries = {};
        double value = 7;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.findTempsLessThen(value);
    }

    // findTempsGreaterThan() testing

    @Test
    public void testFindTempsGreaterThen_NoSuitableValues() {
        double[] tempSeries = {-7.0, -5.0, 0.0, 1.0, 0.0, 4.9};
        double value = 5.0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double[] actualRes = sa.findTempsGreaterThen(value);
        assertEquals(actualRes.length, 0, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThen_EmptySeries() {
        double[] tempSeries = {};
        double value = 7;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.findTempsGreaterThen(value);
    }

    @Test
    public void testFindTempsGreaterThen_DifferentSeries() {
        double[] tempSeries = {-23, 13, -7.8, -7.0, 0.0, 2, 12, -3, 1.8, 2.3, 7.7, 9};
        double value = 0;
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        double[] actualRes = sa.findTempsGreaterThen(value);
        double[] expectedRes = {13, 2, 12, 1.8, 2.3, 7.7, 9};
        for (int i = 0; i < expectedRes.length; i++)
            assertEquals(expectedRes[i], actualRes[i], 0.00001);
    }

    // SummaryStatistics() testing

    @Test
    public void testSummaryStatistics() {
        double[] tempSeries = {-3.3, -2, -1.0, 0.0, 1.0, 2, 6.0};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        TempSummaryStatistics as = sa.summaryStatistics();
        double expAvg = sa.average();
        double expDev = sa.deviation();
        double expMin = sa.min();
        double expMax = sa.max();
        assertEquals(expAvg, as.getAvgTemp(), 0.00001);
        assertEquals(expDev, as.getDeviationTemp(), 0.00001);
        assertEquals(expMin, as.getMinTemp(), 0.00001);
        assertEquals(expMax, as.getMaxTemp(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatistics_EmptySeries() {
        double[] tempSeries = {};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.summaryStatistics();
    }

    // addTemps() testing

    @Test
    public void testAddTemps_DifferentSeries() {
        double[] tempSeries = {0.0, 1.2, -4.5};
        double[] newSeries = {-5.0, 3.2};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        int actualRes = sa.addTemps(newSeries);
        int expectedRes = 5;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testAddTemps_DifferentSeries2() {
        double[] tempSeries = {1, -2, 3};
        double[] newSeries = {5, 4, -6};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        int actualRes = sa.addTemps(newSeries);
        int expectedRes = 6;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test
    public void testAddTemps_DifferentSeries3() {
        double[] tempSeries = {1, 2, 5, 7, 8};
        double[] newSeries = {0, 1, 2, 11, 10, 0, 3, 1};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        int actualRes = sa.addTemps(newSeries);
        int expectedRes = 13;
        assertEquals(expectedRes, actualRes, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTemps_InvalidValue() {
        double[] newSeries = {-2.1, 1.2, 3.1, 0, -273.9};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis();
        sa.addTemps(newSeries);
        int expectedRes = 0;
        assertEquals(expectedRes, sa.length(), 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTemps_InvalidValue2() {
        double[] newSeries = {0.0, -3.0, 4.5, 120, -273.1};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis();
        sa.addTemps(newSeries);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTemps_InvalidValue3() {
        double[] tempSeries = {-2.1, 1.2, 3.1, 0, -273.9};
        double[] newSeries = {0.0, -3.0, 4.5, 120, -2};
        TemperatureSeriesAnalysis sa = new TemperatureSeriesAnalysis(tempSeries);
        sa.addTemps(newSeries);
        int expectedRes = 0;
        assertEquals(expectedRes, sa.length(), 0.00001);
    }
}
