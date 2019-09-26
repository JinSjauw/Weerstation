import com.sun.jdi.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Measurement implements Serializable
{
    RawMeasurement RawData = DatabaseConnection.getMostRecentMeasurement();

    //Maak een class (object?) aan
    RawMeasurement raw;
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

    public Measurement(String statiodId, LocalDateTime dateStamp, double airPressure)
    {
        this.stationId = stationId;
        this.dateStamp = dateStamp;
        this.airpressure = airPressure;

    }

    //Methode om alle setters te roepen
    public void ReturnAll()
    {
        setStationId();
        setDateStamp();
        setAirpressure();
        setInsideTemp();
        setInsideHum();
        setOutsideTemp();
        setOutsideHum();
        setWindSpeed();
        setAvgWindSpeed();
        setWindDir();
        setRainRate();
        setUVLevel();
        setSolarRad();
        setXmitBatt();
        setBattLevel();
        setForeIcon();
        setSunset();
        setSunrise();
        setAirpressure();
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
    public void setStationId ()
    {
        this.stationId = raw.getStationId();
    }

    public String getStationId()
    {
        return stationId;
    }

    // dateStamp
    public void setDateStamp ()
    {
        this.dateStamp = raw.getDateStamp() ;
    }

    public LocalDateTime getDateStamp ()
    {
        return dateStamp;
    }

    // barometer
    public void setAirpressure ()
    {
        this.airpressure = ValueConverter.airPressure(raw.getBarometer());
    }

    public double getAirpressure ()
    {
        return airpressure;
    }

    // insideTemp
    public void setInsideTemp ()
    {
        this.insideTempC = ValueConverter.temperature(raw.getInsideTemp());
    }

    public double getInsideTemp ()
    {
        return insideTempC;
    }

    // insideHum
    public void setInsideHum ()
    {
        this.insideHum = ValueConverter.humidity(raw.getInsideHum());
    }

    public double getInsideHum ()
    {
        return insideHum;
    }

    // outsideTemp
    public void setOutsideTemp ()
    {
        this.outsideTempC = ValueConverter.temperature(raw.getOutsideTemp());
    }

    public double getOutsideTemp ()
    {
        return outsideTempC;
    }

    // windSpeed
    public void setWindSpeed ()
    {
        this.windSpeedkmh = ValueConverter.windSpeed(raw.getWindSpeed());
    }

    public double getWindSpeed ()
    {
        return windSpeedkmh;
    }

    // avgWindSpeed
    public void setAvgWindSpeed ()
    {
        this.avgWindSpeedkmh = ValueConverter.windSpeed(raw.getAvgWindSpeed());
    }

    public double getAvgWindSpeed ()
    {
        return avgWindSpeedkmh;
    }

    // windDir
    public void setWindDir ()
    {
        this.windDir = ValueConverter.windDirection(raw.getWindDir());
    }

    public double getWindDir ()
    {
        return windDir;
    }

    // outsideHum
    public void setOutsideHum ()
    {
        this.outsideHum = ValueConverter.humidity(raw.getOutsideHum());
    }

    public double getOutsideHum ()
    {
        return outsideHum;
    }

    // rainRate
    public void setRainRate ()
    {
        this.rainRatemm = ValueConverter.rainMeter(raw.getRainRate());
    }

    public double getRainRate ()
    {
        return rainRatemm;
    }

    // UVLevel
    public void setUVLevel ()
    {
        this.UVLevel = ValueConverter.uvIndex(raw.getUVLevel());
    }

    public double getUVLevel ()
    {
        return UVLevel;
    }

    // solarRad
    public void setSolarRad ()
    {
        this.solarRad = raw.getSolarRad();
    }
    public double getSolarRad ()
    {
        return solarRad;
    }

    // xmitBatt
    public void setXmitBatt ()
    {
        this.xmitBatt = raw.getXmitBatt();
    }

    public double getXmitBatt ()
    {
        return xmitBatt;
    }

    // battLevel
    public void setBattLevel ()
    {
        this.battLevel = ValueConverter.batteryLevel(raw.getBattLevel());
    }

    public double getBattLevel ()
    {
        return battLevel;
    }

    // foreIcon
    public void setForeIcon ()
    {
        this.foreIcon = raw.getForeIcon();
    }

    public double getForeIcon ()
    {
        return foreIcon;
    }

    // sunrise
    public void setSunrise ()
    {
        this.sunrise = ValueConverter.sunRise(raw.getSunrise());
    }
    public String getSunrise ()
    {
        return sunrise;
    }

    // sunset
    public void setSunset ()
    {
        this.sunset = ValueConverter.sunSet(raw.getSunset());
    }

    public String getSunset ()
    {
        return sunset;
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