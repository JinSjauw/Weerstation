import java.util.ArrayList;

public class User {
    public static void main(String[] args) {

        RawMeasurement RD = DatabaseConnection.getMostRecentMeasurement();
        Measurement ND = new Measurement(RD.getStationId(),RD.getDateStamp(),ValueConverter.airPressure(RD.getBarometer()),ValueConverter.temperature(RD.getInsideTemp()),ValueConverter.humidity(RD.getInsideHum()),ValueConverter.temperature(RD.getOutsideTemp()),ValueConverter.windSpeed(RD.getWindSpeed()),ValueConverter.windSpeed(RD.getAvgWindSpeed()),RD.getWindDir(),RD.getOutsideHum(),ValueConverter.rainMeter(RD.getRainRate()),ValueConverter.uvIndex(RD.getUVLevel()),RD.getSolarRad(),RD.getXmitBatt(),ValueConverter.batteryLevel(RD.getBattLevel()),RD.getForeIcon(),ValueConverter.sunRise(RD.getSunrise()),ValueConverter.sunSet(RD.getSunset()));
        //Stuur het RawMeasurement object door naar Measurement
//        ND.setData(RD);
//        //Roep alle setters aan
//        ND.ReturnAll();

        System.out.println(RD);
        System.out.println("");
        System.out.println(ND);

    }
}
