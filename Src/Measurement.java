import java.io.Serializable;
import java.time.LocalDateTime;

public class Measurement implements Serializable
{
    RawMeasurement RawData = DatabaseConnection.getMostRecentMeasurement();

    //Maak een class (object?) aan
    private RawMeasurement raw;
    //--------------------------------
    private String stationId;
    private LocalDateTime dateStamp;
    private double airpressure;
    private double insideTempC;
    private double insideHum;
    private double outsideTempC;
    private double windSpeedkmh;
    private double avgWindSpeedkmh;
    private double windDir;
    private double outsideHum;
    private double rainRatemm;
    private double UVLevel;
    private double solarRad;
    private double xmitBatt;
    private double battLevel;
    private double foreIcon;
    private String sunrise;
    private String sunset;

    public Measurement(RawMeasurement rawMeasurement)
    {
    this.raw = rawMeasurement;
    }

    //Methode om alle setters te roepen
    public void ReturnAll()
    {
        getStationId();
        getDateStamp();
        getAirpressure();
        getInsideTemp();
        getInsideHum();
        getOutsideTemp();
        getOutsideHum();
        getWindSpeed();
        getAvgWindSpeed();
        getWindDir();
        getRainRate();
        getUVLevel();
        getSolarRad();
        getXmitBatt();
        getBattLevel();
        getForeIcon();
        getSunset();
        getSunrise();
        getAirpressure();
    }

    //Maak een setter en getter aan om een object te ontvangen

    public void setData(RawMeasurement RD){

        this.raw = RD;
    }

    public Object getData ()
    {
        return raw;
    }
    // -------------------------------------------------------------

    //Vanaf hier bij alle setters de ValueConverter class implementeren.

    // stationId

    public String getStationId()
    {
        this.stationId = raw.getStationId();
        return stationId;
    }

    // dateStamp

    public LocalDateTime getDateStamp ()
    {
        this.dateStamp = raw.getDateStamp();
        return dateStamp;
    }

    // barometer

    public double getAirpressure ()
    {
        this.airpressure = ValueConverter.airPressure(raw.getBarometer());
        return airpressure;
    }

    // insideTemp

    public double getInsideTemp ()
    {
        this.insideTempC = ValueConverter.temperature(raw.getInsideTemp());
        return insideTempC;
    }

    // insideHum

    public double getInsideHum ()
    {
        this.insideHum = ValueConverter.humidity(raw.getInsideHum());
        return insideHum;
    }

    // outsideTemp

    public double getOutsideTemp ()
    {
        this.outsideTempC = ValueConverter.temperature(this.raw.getOutsideTemp());
        return outsideTempC;
    }

    // windSpeed

    public double getWindSpeed ()
    {
        this.windSpeedkmh = ValueConverter.windSpeed(raw.getWindSpeed());
        return windSpeedkmh;
    }

    // avgWindSpeed

    public double getAvgWindSpeed ()
    {
        this.avgWindSpeedkmh = ValueConverter.windSpeed(raw.getAvgWindSpeed());
        return avgWindSpeedkmh;
    }

    // windDir

    public double getWindDir ()
    {
        this.windDir = ValueConverter.windDirection(raw.getWindDir());
        return windDir;
    }

    // outsideHum

    public double getOutsideHum ()
    {
        this.outsideHum = ValueConverter.humidity(raw.getOutsideHum());
        return outsideHum;
    }

    // rainRate

    public double getRainRate ()
    {
        this.rainRatemm = ValueConverter.rainMeter(raw.getRainRate());
        return rainRatemm;
    }

    // UVlevel

    public double getUVLevel ()
    {
        this.UVLevel = ValueConverter.uvIndex(raw.getUVLevel());
        return UVLevel;
    }

    // solarRad

    public double getSolarRad ()
    {
        this.solarRad = raw.getSolarRad();
        return solarRad;
    }

    // xmitBatt

    public double getXmitBatt ()
    {
        this.xmitBatt = raw.getXmitBatt();
        return xmitBatt;
    }

    // battLevel

    public double getBattLevel ()
    {
        this.battLevel = ValueConverter.batteryLevel(raw.getBattLevel());
        return battLevel;
    }

    // foreIcon

    public double getForeIcon ()
    {
        this.foreIcon = raw.getForeIcon();
        return foreIcon;
    }

    // sunrise
    public String getSunrise ()
    {
        this.sunrise = ValueConverter.sunRise(raw.getSunrise());
        return sunrise;
    }

    // sunset

    public String getSunset ()
    {
        this.sunset = ValueConverter.sunSet(raw.getSunset());
        return sunset;
    }

    public Boolean isValid(){
        Boolean valid = true;
        return valid;
    }

    public String toString()
    {
        //afronding Luchtdruk
        long decimal = Math.round(airpressure*10);
        airpressure = decimal/10.0;

        //afronding Temperatuur
        long dtemp = Math.round(insideTempC*10);
        insideTempC = dtemp/10.0;
        long dtemp2 = Math.round(outsideTempC*10);
        outsideTempC = dtemp2/10.0;

        //afronding wind
        long dwind = Math.round(windSpeedkmh*10);
        windSpeedkmh = dwind/10.0;
        long dwindavg = Math.round(avgWindSpeedkmh*10);
        avgWindSpeedkmh = dwindavg/10.0;
        //affronding battlvl
        long dbattlvl = Math.round(battLevel*10);
        battLevel = dbattlvl/10.0;


        String s = "Measurement:"
                + "\nstationId = \t" + stationId
                + "\ndateStamp = \t" + dateStamp
                + "\nbarometer = \t" + airpressure
                + "\ninsideTemp = \t" + insideTempC + " C"
                + "\ninsideHum = \t" + insideHum + "%"
                + "\noutsideTemp = \t" + outsideTempC + " C"
                + "\nwindSpeed = \t" + windSpeedkmh + "Km/h"
                + "\navgWindSpeed = \t" + avgWindSpeedkmh + "Km/h"
                + "\nwindDir = \t" + windDir
                + "\noutsideHum = \t" + outsideHum + "%"
                + "\nrainRate = \t" + rainRatemm + "mm"
                + "\nUVLevel = \t" + UVLevel
                + "\nsolarRad = \t" + solarRad
                + "\nxmitBatt = \t" + xmitBatt
                + "\nbattLevel = \t" + battLevel + " Volt"
                + "\nforeIcon = \t" + foreIcon
                + "\nsunrise = \t" + sunrise
                + "\nsunset = \t" + sunset;
        //afronding hier plaatsen
        return s;
    }


}