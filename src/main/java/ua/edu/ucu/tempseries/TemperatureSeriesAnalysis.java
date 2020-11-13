package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    static final double ZERO = -273.0;
    static final int ARRAY_REALLOCATE_COEFFICIENT = 2;
    private double[] temperatureList;
    private int tempSeriesBuffer = 0;
    private int tempSeriesSize = 0;

    public TemperatureSeriesAnalysis() {
        temperatureList = new double[0];
        tempSeriesBuffer = 0;
        tempSeriesSize = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        checkSeries(temperatureSeries, true);
        tempSeriesBuffer = temperatureSeries.length;
        tempSeriesSize = tempSeriesBuffer;
        temperatureList = new double[tempSeriesBuffer];
        System.arraycopy(temperatureSeries, 0, temperatureList,
                0, tempSeriesBuffer);
    }

    public void checkSeries(double[] temperatureSeries, boolean eachTemp) {
        int seriesLen = temperatureSeries.length;
        if (seriesLen == 0) {
            throw new IllegalArgumentException();
        }
        if (eachTemp) {
            for (double temperature : temperatureSeries) {
                if (temperature < ZERO) {
                    throw new InputMismatchException();
                }
            }
        }
    }

    public int length() {
        return tempSeriesBuffer;
    }

    public double average() throws IllegalArgumentException {
        checkSeries(temperatureList, false);
        double sum = 0;
        for (double x : temperatureList) {
            sum += x;
        }
        return sum / tempSeriesBuffer;
    }

    public double deviation() {
        double avg = average();
        double sum = 0;
        for (double x : temperatureList) {
            sum += ((x - avg) * (x - avg));
        }
        return sum / tempSeriesBuffer;
    }

    public double max() throws IllegalArgumentException {
        return findMaxValue(true);
    }

    public double min() throws IllegalArgumentException {
        return findMaxValue(false);
    }

    public double findMaxValue(boolean isMax)
            throws IllegalArgumentException {
        checkSeries(temperatureList, false);
        int multiValue;
        if (isMax) {
            multiValue = 1;
        } else {
            multiValue = -1;
        }
        double outValue = temperatureList[0];
        for (int i = 1; i < tempSeriesBuffer; ++i) {
            if (temperatureList[i] * multiValue > outValue * multiValue) {
                outValue = temperatureList[i];
            }
        }
        return outValue;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    // Searches for the FIRST closest value in array
    public double findTempClosestToValue(double tempValue)
            throws IllegalArgumentException {
        checkSeries(temperatureList, false);
        int closestValueIndex = 0;
        double currentDiff;
        double closestDiff;
        for (int i = 0; i < tempSeriesBuffer; ++i) {

            currentDiff = Math.abs(tempValue - temperatureList[i]);
            closestDiff = Math.abs(tempValue
                    - temperatureList[closestValueIndex]);

            if (currentDiff < closestDiff) {
                closestValueIndex = i;
            } else if ((currentDiff == closestDiff)
                    && (temperatureList[i]
                    > temperatureList[closestValueIndex])) {
                closestValueIndex = i;
            }
        }
        return temperatureList[closestValueIndex];
    }

    public double[] findTempsGreaterThen(double tempValue)
            throws IllegalArgumentException {
        return findGreaterThanValue(tempValue, false);
    }

    public double[] findTempsLessThen(double tempValue)
            throws IllegalArgumentException {
        return findGreaterThanValue(tempValue, true);
    }


    public double[] findGreaterThanValue(double tempValue,
                                         boolean greater)
            throws IllegalArgumentException {
        checkSeries(temperatureList, false);
        int great;
        if (greater) {
            great = 1;
        } else {
            great = -1;
        }
        int cnt = 0;
        for (double x : temperatureList) {
            if (Double.compare(tempValue, x) * great > 0) {
                ++cnt;
            }
        }
        double[] outputArray = new double[cnt];
        cnt = 0;
        for (int i = 0; i < tempSeriesBuffer; ++i) {
            if (Double.compare(tempValue, temperatureList[i]) * great > 0) {
                outputArray[cnt] = temperatureList[i];
                ++cnt;
            }
        }
        return outputArray;
    }

    public TempSummaryStatistics summaryStatistics() {
        double avg = average();
        double dev = deviation();
        double min = min();
        double max = max();
        return new TempSummaryStatistics(avg, dev, min, max);
    }

    public int addTemps(double[] temps)
            throws IllegalArgumentException,
            InputMismatchException {
        checkSeries(temps, true);
        int inputSeriesSize = temps.length;
        int newSize = tempSeriesSize + inputSeriesSize;
        int tmp = tempSeriesBuffer;

        while (tmp < newSize) {
            tmp *= ARRAY_REALLOCATE_COEFFICIENT;
        }

        int newBuff = tmp;
        double[] newTempSeries = new double[newBuff];
        int j = 0;
        for (int i = 0; i < newSize; ++i) {
            if (i < tempSeriesBuffer) {
                newTempSeries[i] = temperatureList[i];
            } else {
                newTempSeries[i] = temps[j];
                ++j;
            }
        }
        temperatureList = newTempSeries;
        tempSeriesSize = newSize;
        tempSeriesBuffer = newBuff;
        return tempSeriesSize;
    }
}
