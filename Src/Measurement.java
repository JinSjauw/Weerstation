import java.io.Serializable;
import java.time.LocalDateTime;

public class Measurement implements Serializable
{

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

    // stationId
    public void setStationId (String str) { this.stationId = str;};
    public String getStationId () { return stationId; };

    // dateStamp
    public void setDateStamp (LocalDateTime ts) { this.dateStamp = ts;};
    public LocalDateTime getDateStamp () { return dateStamp; };

    // barometer
    public void setAirpressure (double val) { this.airpressure = val;};
    public double getAirpressure () { return airpressure; };

    // insideTemp
    public void setInsideTemp (double val) { this.insideTempC = val;};
    public double getInsideTemp () { return insideTempC; };

    // insideHum
    public void setInsideHum (double val) { this.insideHum = val;};
    public double getInsideHum () { return insideHum; };

    // outsideTemp
    public void setOutsideTemp (double val) { this.outsideTempC = val;};
    public double getOutsideTemp () { return outsideTempC; };

    // windSpeed
    public void setWindSpeed (double val) { this.windSpeedkmh = val;};
    public double getWindSpeed () { return windSpeedkmh; };

    // avgWindSpeed
    public void setAvgWindSpeed (double val) { this.avgWindSpeedkmh = val;};
    public double getAvgWindSpeed () { return avgWindSpeedkmh; };

    // windDir
    public void setWindDir (double val) { this.windDir = val;};
    public double getWindDir () { return windDir; };

    // outsideHum
    public void setOutsideHum (double val) { this.outsideHum = val;};
    public double getOutsideHum () { return outsideHum; };

    // rainRate
    public void setRainRate (double val) { this.rainRatemm = val;};
    public double getRainRate () { return rainRatemm; };

    // UVLevel
    public void setUVLevel (double val) { this.UVLevel = val;};
    public double getUVLevel () { return UVLevel; };

    // solarRad
    public void setSolarRad (double val) { this.solarRad = val;};
    public double getSolarRad () { return solarRad; };

    // xmitBatt
    public void setXmitBatt (double val) { this.xmitBatt = val;};
    public double getXmitBatt () { return xmitBatt; };

    // battLevel
    public void setBattLevel (double val) { this.battLevel = val;};
    public double getBattLevel () { return battLevel; };

    // foreIcon
    public void setForeIcon (double val) { this.foreIcon = val;};
    public double getForeIcon () { return foreIcon; };

    // sunrise
    public void setSunrise (String val) { this.sunrise = val;};
    public String getSunrise () { return sunrise; };

    // sunset
    public void setSunset (String val) { this.sunset = val;};
    public String getSunset () { return sunset; };

    public String toString()
    {
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