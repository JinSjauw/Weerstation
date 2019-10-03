import java.sql.SQLOutput;
import java.util.ArrayList;


public class User {
    public static void main(String[] args) {

        RawMeasurement RD = DatabaseConnection.getMostRecentMeasurement();
        Measurement ND = new Measurement(RD.getStationId(),
                RD.getDateStamp(),
                ValueConverter.airPressure(RD.getBarometer()),
                ValueConverter.temperature(RD.getInsideTemp()),
                ValueConverter.humidity(RD.getInsideHum()),
                ValueConverter.temperature(RD.getOutsideTemp()),
                ValueConverter.windSpeed(RD.getWindSpeed()),
                ValueConverter.windSpeed(RD.getAvgWindSpeed()),
                RD.getWindDir(),
                RD.getOutsideHum(),
                ValueConverter.rainMeter(RD.getRainRate()),
                ValueConverter.uvIndex(RD.getUVLevel()),
                RD.getSolarRad(),
                RD.getXmitBatt(),
                ValueConverter.batteryLevel(RD.getBattLevel()),
                RD.getForeIcon(),
                ValueConverter.sunRise(RD.getSunrise()),
                ValueConverter.sunSet(RD.getSunset()));

        //Stuur het RawMeasurement object door naar Measurement
//        ND.setData(RD);
//        //Roep alle setters aan
//        ND.ReturnAll();

        System.out.println(RD);
        System.out.println("");
        System.out.println(ND);
        String outsidetempgui = Double.toString(ND.getOutsideTemp());

        IO.init();
        IO.writeShort(0x18, outsidetempgui.charAt(0));
        IO.writeShort(0x16, outsidetempgui.charAt(1));
        IO.writeShort(0x14, 0x180);
        IO.writeShort(0x12,outsidetempgui.charAt(3));
        IO.writeShort(0x10,12);
        IO.delay(1000);
        System.out.println(outsidetempgui);

    }
}
