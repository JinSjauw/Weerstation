import java.util.ArrayList;

public class User {
    public static void main(String[] args) {
        Measurement ND = new Measurement();
        RawMeasurement RD = DatabaseConnection.getMostRecentMeasurement();
        ND.setData(RD);

        ND.ReturnAll();
//        ND.setStationId(RD.getStationId());
//        ND.setDateStamp(RD.getDateStamp());
//        ND.setAirpressure(ValueConverter.temperature(RD.getBarometer()));
//        ND.setInsideTemp(ValueConverter.temperature(RD.getInsideTemp()));
//        ND.setInsideHum(ValueConverter.humidity(RD.getInsideHum()));
//        ND.setOutsideTemp(ValueConverter.temperature(RD.getOutsideTemp()));
//        ND.setWindSpeed(ValueConverter.windSpeed(RD.getWindSpeed()));
//        ND.setAvgWindSpeed(ValueConverter.windSpeed(RD.getAvgWindSpeed()));
//        ND.setWindDir(ValueConverter.windDirection(RD.getWindDir()));
//        ND.setOutsideHum(ValueConverter.humidity(RD.getOutsideHum()));
//        ND.setRainRate(ValueConverter.rainMeter(RD.getRainRate()));
//        ND.setUVLevel(ValueConverter.uvIndex(RD.getUVLevel()));
//        ND.setSolarRad(RD.getSolarRad());
//        ND.setXmitBatt(RD.getXmitBatt());
//        ND.setBattLevel(ValueConverter.batteryLevel(RD.getBattLevel()));
//        ND.setForeIcon(RD.getForeIcon());
//        ND.setSunrise(ValueConverter.sunRise(RD.getSunrise()));
//        ND.setSunset(ValueConverter.sunSet(RD.getSunset()));

        System.out.println(RD);
        System.out.println("");
        System.out.println(ND);

    }
}
