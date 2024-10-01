public class Processor {
    private final int frequency;
    private final int numberOfCores;
    private final String performance;
    private final int weight;

    public Processor(int frequency, int numberOfCores, String performance, int weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.performance = performance;
        this.weight = weight;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getPerformance() {
        return performance;
    }

    public int getWeight() {
        return weight;
    }
}

