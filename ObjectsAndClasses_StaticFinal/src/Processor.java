public class Processor {

    private final Frequency frequency;
    private final NumberOfCores numberOfCores;
    private final Performance performance;
    private final int weightProcessor;


    public Processor(Frequency frequency,
                     NumberOfCores numberOfCores,
                     Performance performance,
                     int weightProcessor) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.performance = performance;
        this.weightProcessor = weightProcessor;
    }

    public Frequency getFrequency() {
        return frequency;
    }
    public NumberOfCores getNumberOfCores() {
        return numberOfCores;
    }
    public Performance getPerformance() {
        return performance;
    }
    public int getWeightProcessor() {
        return weightProcessor;
    }


}
