public class ValueConverter {
    ValueConverterTest test = new ValueConverterTest();

    public void main(String[] args) {

        //luchtdruk
        short rawValue = 0;
        System.out.println("de luchtdruk is: "+airPressure(rawValue)+" HPa");

        test.TestDouble(airPressure(rawValue));

        //binnentemp
        short tempfbi = 0;
        System.out.println("de binnentemperatuur is: "+temperature(tempfbi)+" C");
        //binnen luchtvochtigheid
        short humbin = 0;
        System.out.println("de binnen luchtvochtigheid is: "+humidity(humbin)+" %");
        //buiten temperatuur
        short tempfbu = 0;
        double tempbuiten = temperature(tempfbu);
        System.out.println("de buiten temperatuur is: "+tempbuiten+" C");
        //windspeed
        short windsnel = 0;
        System.out.println("de windsnelheid is: "+windSpeed(windsnel)+" km/h");
        //avg windspeed
        rawValue = 0;
        System.out.println("de gemiddelde windsnelheid is: "+windSpeed(rawValue)+" km/h");
        //windrichting
        rawValue = 0;
        System.out.println("de windrichting is: "+windDirection(rawValue)+" graden");
        //buiten luchtvochtigheid
        short humbui = 0;
        System.out.println("de buiten luchtvochtigheid is: "+humidity(humbui)+" %");
        //rainrate
        rawValue = 0;
        System.out.println("de regenrate is: "+rainMeter(rawValue)+" mm");
        //uvlevel
        rawValue = 0;
        System.out.println("de uv level is: "+uvIndex(rawValue));
        //batt level
        rawValue = 0;
        System.out.println("de batterij niveau is: "+batteryLevel(rawValue)+" Volt");
        //sunrise
        rawValue = 0;
        System.out.println("de zonsopgang is om: "+sunRise(rawValue));
        //Sunset
        rawValue = 0;
        System.out.println("de zonsondergang is om: "+sunSet(rawValue));
        //windchill
        System.out.println("de windchill is: "+windChill(windsnel,tempfbu));
        //dewpoint
        System.out.println("de dewpoint is: "+dewpoint(humbui,tempbuiten));


    }
    /** airPressure
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De luchtdruk in hPa
     */
    public static double airPressure(short rawValue){
        double HPa = 33.86389 * rawValue / 1000;
        return HPa;
    }
    /** temperature
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De temperatuur in graden Celcius
     */
    public static double temperature(short rawValue){
        double temp = ((rawValue/10) - 32)/ 1.8;
        return temp;
    }
    /** humidity
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De relatieve luchtvochtigheid in procenten
     */
    public static double humidity(short rawValue){
        double hum = 0;
        //WIP
        return hum;
    }
    /** windSpeed
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De windsnelheid in km/h
     */
    public static double windSpeed(short rawValue){
        double wspeed = rawValue*1.609;
        return wspeed;
    }
    /** windDirection
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De windrichting in graden
     */
    public static double windDirection(short rawValue){
        double wdir = 0;
        //WIP






        return wdir;
    }
    /** rainMeter
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De hoeveelheid regen in mm
     */
    public static double rainMeter(short rawValue){
        double rain = rawValue*25.4;

        return rain;
    }
    /** uvIndex
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De uv index (dimensieloos)
     */
    public static double uvIndex(short rawValue){
        //1*10^-1
        double uv = rawValue * 0.1;
        return uv;
    }
    /** batteryLevel
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De batterijspanning in Volt
     */
    public static double batteryLevel(short rawValue){
        double bat = ((rawValue * 300)/512)/100.0;
        return bat;
    }
    /** sunRise
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return Zonsopkomst in hh:mm notatie
     */
    public static String sunRise(short rawValue){
        String sunset  = "";
        int hour = rawValue/100;
        if (hour<10){
            sunset = sunset +"0";
        }
        sunset = sunset+hour;
        sunset=sunset+":";
        int minute = rawValue%100;
        sunset = sunset+minute;
        return sunset;

    }
    /** sunSet
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return Zonsondergang in hh:mm notatie
     */
    public static String sunSet(short rawValue){
        String sunset  = "";
        int hour = rawValue/100;
        //nodig?
        if (hour<10){
            sunset = sunset +"0";
        }
        sunset = sunset+hour;
        sunset=sunset+":";
        int minute = rawValue%100;
        sunset = sunset+minute;
        return sunset;

    }
    /**
     * Windchill
     * @return Wind chill
     */
    public static double windChill(short windsnel,short tempfbu){
        double windchill = 0.0817*(3.71 * windsnel *0.5 +5.81-0.25* windsnel) * (tempfbu -9.14)+91.4;
        //V in mph en T in fahrenheid
        return windchill;
    }
    //dewpoint

    public static double dewpoint(short humbui,double tempbuiten){

        double dewpoint  = Math.pow(humbui *0.01*6.112,((17.62*tempbuiten)/(tempbuiten+243.12)));
        //RH relatieve luchtvochtigheid en T in celsius
        return dewpoint;
    }




}
