public class FahrenheitToCelsius extends TemperatureConversion{
    public FahrenheitToCelsius(double temperature) {
        super(temperature);
    }

    @Override
    public double convert() {
        return (temperature - 32) * 5 / 9;
    }
}
