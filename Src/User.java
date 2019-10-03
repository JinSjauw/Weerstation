import java.sql.SQLOutput;
import java.util.ArrayList;

public class User {
    public static void main(String[] args) {

        Measurement ND = new Measurement();
        RawMeasurement RD = DatabaseConnection.getMostRecentMeasurement();

        //Stuur het RawMeasurement object door naar Measurement
        ND.setData(RD);
        //Roep alle setters aan
        ND.ReturnAll();

        System.out.println(RD);
        System.out.println("");
        System.out.println(ND);

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
