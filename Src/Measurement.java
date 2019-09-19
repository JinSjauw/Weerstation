import java.util.ArrayList;

public class Measurement {
    public static void main(String[] args) {
       RawMeasurement measurement = DatabaseConnection.getMostRecentMeasurement();
        System.out.println(measurement);
        System.out.println(ValueConverter.sunSet(measurement.getSunset()));
        System.out.println(ValueConverter.airPressure(measurement.getBarometer()));
        System.out.println(ValueConverter.temperature(measurement.getInsideTemp()));


    }
}
