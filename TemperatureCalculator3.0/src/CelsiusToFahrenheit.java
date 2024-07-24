public class CelsiusToFahrenheit extends TemperatureConversion {
    public CelsiusToFahrenheit(double temperature) {
        super(temperature);
    }

    @Override
    public double convert() {
        return (temperature * 9 / 5) + 32;
    }
}
