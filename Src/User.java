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

    }
}
