public abstract class TemperatureConversion {
    protected double temperature;

    public TemperatureConversion(double temperature) {
        this.temperature = temperature;
    }

    public abstract double convert();
}
