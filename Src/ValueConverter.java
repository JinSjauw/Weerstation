public class ValueConverter {
    ValueConverterTest test = new ValueConverterTest();
    //excel regel 748

    //public static void main(String[] args) {

        //luchtdruk
        //short rawValue = 30189;
        //System.out.println("de luchtdruk is: "+airPressure(rawValue)+" HPa");

        //ValueConverterTest.Testpressure(airPressure(rawValue));

        //binnentemp
        //short tempfbi = 797;
        //System.out.println("de binnentemperatuur is: "+temperature(tempfbi)+" C");


        //ValueConverterTest.Testtempbinnen(temperature(tempfbi));

        //binnen luchtvochtigheid
        //short humbin = 44;
        //System.out.println("de binnen luchtvochtigheid is: "+humidity(humbin)+" %");

        //ValueConverterTest.Testhumiditybinnen(humidity(humbin));

        //buiten temperatuur
        //short tempfbu = 608;
        //double tempbuiten = temperature(tempfbu);
        //System.out.println("de buiten temperatuur is: "+tempbuiten+" C");

        //ValueConverterTest.Testtempbuiten(temperature(tempfbu));

        //windspeed
        //short windsnel = 9;
        //System.out.println("de windsnelheid is: "+windSpeed(windsnel)+" km/h");

        //ValueConverterTest.Testwindspeed(windSpeed(windsnel));

        //avg windspeed
        //rawValue = 6;
        //System.out.println("de gemiddelde windsnelheid is: "+windSpeed(rawValue)+" km/h");

        //ValueConverterTest.Testavgwindspeed(windSpeed(rawValue));

        //windrichting
        //rawValue = 195;
        //System.out.println("de windrichting is: "+windDirection(rawValue)+" graden");

        //ValueConverterTest.Testwindrichting(windDirection(rawValue));

        //buiten luchtvochtigheid
        //short humbui = 90;
        //System.out.println("de buiten luchtvochtigheid is: "+humidity(humbui)+" %");

        //ValueConverterTest.Testhumiditybuiten(humidity(humbui));

        //rainrate
        //rawValue = 0;
        //System.out.println("de regenrate is: "+rainMeter(rawValue)+" mm");

        //ValueConverterTest.Testrainrate(rainMeter(rawValue));

        //uvlevel
        //rawValue = 9;
        //System.out.println("de uv level is: "+uvIndex(rawValue));

        //ValueConverterTest.Testuvlevel(uvIndex(rawValue));

        //batt level
        //rawValue = 660;
        //System.out.println("de batterij niveau is: "+batteryLevel(rawValue)+" Volt");

        //ValueConverterTest.Testbattlevel(batteryLevel(rawValue));

        //sunrise
        //rawValue = 710;
        //System.out.println("de zonsopgang is om: "+sunRise(rawValue));

        //ValueConverterTest.Testsunrise(sunRise(rawValue));

        //Sunset
        //rawValue = 2007;
        //System.out.println("de zonsondergang is om: "+sunSet(rawValue));

        //ValueConverterTest.Testsunset(sunSet(rawValue));

        //windchill
        //System.out.println("de windchill is: "+windChill(windsnel,tempfbu));

        //ValueConverterTest.Testwindchill(windChill(windsnel,tempfbu));

        //dewpoint
        //System.out.println("de dewpoint is: "+dewpoint(humbui,tempbuiten));

        //ValueConverterTest.Testdewpoint(dewpoint(humbui,tempbuiten));



    //}
    /** airPressure
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De luchtdruk in hPa
     */
    public static double airPressure(short rawValue){

        double HPa = 33.86389 * rawValue / 1000;

//        long decimal = Math.round(HPa*10);
//        HPa = decimal/10.0;

        return HPa;
    }
    /** temperature
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De temperatuur in graden Celcius
     */
    public static double temperature(short rawValue){
        double temp = (((rawValue/10.0) - 32.0)/1.8);

//        long decimal = Math.round(temp*10);
//        temp = decimal/10.0;

        return temp;
    }
    /** humidity
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De relatieve luchtvochtigheid in procenten
     */
    public static double humidity(short rawValue){

        //WIP
        return rawValue;
    }
    /** windSpeed
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De windsnelheid in km/h
     */
    public static double windSpeed(short rawValue){
        double wspeed = rawValue*1.609;
//        long decimal = Math.round(wspeed*10);
//        wspeed = decimal/10.0;
        return wspeed;
    }
    /** windDirection
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return De windrichting in graden
     */
    public static double windDirection(short rawValue){

        return rawValue;
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

//        long decimal = Math.round(bat*10);
//        bat = decimal/10.0;

        return bat;
    }
    /** sunRise
     *
     * @param rawValue Ruwe meetwaarde van het vp2pro weerstation
     * @return Zonsopkomst in hh:mm notatie
     */
    public static String sunRise(short rawValue){
        String sunrise  = "";
        int hour = rawValue/100;
        if (hour<10){
            sunrise = sunrise +"0";
        }
        sunrise = sunrise+hour;
        sunrise=sunrise+":";
        int minute = rawValue%100;
        if (minute<10){
            sunrise= sunrise +"0";
        }
        sunrise = sunrise+minute;
        return sunrise;

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
        if (minute<10){
            sunset = sunset +"0";
        }
        sunset = sunset+minute;
        return sunset;

    }
    /**
     * Windchill
     * @return Wind chill
     */
    public static double windChill(short windsnel,short tempfbu){
        double windchill = 0.0817*(3.71 * windsnel *0.5 +5.81-0.25* windsnel) * (tempfbu/10.0 -9.14)+91.4;
        //V in mph en T in fahrenheid

//        long decimal = Math.round(windchill*10);
//        windchill = decimal/10.0;

        return windchill;
    }
    //dewpoint

    public static double dewpoint(short humbui,double tempbuiten){

        double dewpoint  = Math.pow((humbui *0.01*6.112),((17.62*tempbuiten)/(tempbuiten+243.12)));
        //RH relatieve luchtvochtigheid en T in celsius

//        long decimal = Math.round(dewpoint*10);
//        dewpoint = decimal/10.0;

        return dewpoint;
    }




}
