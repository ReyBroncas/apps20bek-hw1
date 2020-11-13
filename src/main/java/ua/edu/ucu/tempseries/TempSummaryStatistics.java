package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics(double averageTemp,
                                 double deviationTemp,
                                 double minTemp,
                                 double maxTemp) {
        this.avgTemp = averageTemp;
        this.devTemp = deviationTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDeviationTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
