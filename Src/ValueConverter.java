public class ValueConverter {
    public static void main(String[] args) {
        //luchtdruk
        short rawValue = 0;
        System.out.println("de luchtdruk is: "+airPressure(rawValue)+" HPa");
        //binnentemp
        rawValue = 0;
        System.out.println("de binnentemperatuur is: "+temperature(rawValue)+" C");
        //binnen luchtvochtigheid
        rawValue = 0;
        System.out.println("de binnen luchtvochtigheid is: "+humidity(rawValue)+" %");
        //buiten temperatuur
        rawValue = 0;
        System.out.println("de buiten temperatuur is: "+airPressure(rawValue)+" C");
        //windspeed
        rawValue = 0;
        System.out.println("de windsnelheid is: "+windSpeed(rawValue)+" km/h");
        //avg windspeed
        rawValue = 0;
        System.out.println("de gemiddelde windsnelheid is: "+windSpeed(rawValue)+" km/h");
        //windrichting
        rawValue = 0;
        System.out.println("de windrichting is: "+windDirection(rawValue)+" graden");
        //buiten luchtvochtigheid
        rawValue = 0;
        System.out.println("de buiten luchtvochtigheid is: "+humidity(rawValue)+" %");
        //rainrate
        rawValue = 0;
        System.out.println("de regenrate is: "+rainMeter(rawValue)+" mm");
        //windspeed
        rawValue = 0;
        System.out.println("de luchtdruk is: "+windSpeed(rawValue)+" km/h");
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
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return Wind chill
     */
    public static String windChill(short rawValue){
        //WIP
        //0.0817*(3.71 * V *0.5 +5.81-0.25* V) * (T -9.14)+91.4
        //V in mph en T in fahrenheid
        return "0";
    }
    //dewpoint
    //v = RH *0.01*6.112*exp[(17.62*T)/(T+243.12)]
    //RH relatieve luchtvochtigheid en T in celsius
    public static String dewpoint(short rawValue){
        //WIP
        //0.0817*(3.71 * V *0.5 +5.81-0.25* V) * (T -9.14)+91.4
        //V in mph en T in fahrenheid
        return "0";
    }




}
