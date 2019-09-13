public class ValueConverter {
    ValueConverterTest test = new ValueConverterTest();

    public static void main(String[] args) {
        //WIP
        airPressure()

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
        double temp = ((rawValue - 32)/ 1.8);

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
        return "0";
    }




}
