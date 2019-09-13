public class ValueConverterTest {

        //ValueConverter vc = new ValueConverter();

        public static void TestDouble(double output) {

                int i = 0;

                //Testvalues

            //Airpressure
                double a = 0;
            //Temperature
                double b = 0;
            //Humidity
                double c = 0;
            //windSpeed
                double d = 0;
            //windDirection
                double e = 0;
            //rainMeter
                double f = 0;
            //uvIndex
                double g = 0;
            //batteryLevel
                double h = 0;

                double[] testValue = {a, b, c, d, e, f, g, h};

                int run = testValue.length;

            while (i < run) {

                if (output == testValue[i]) {
                    System.out.println("Output komt overeen met testwaarde");
                    System.out.println("Output = " + output);
                    System.out.println("Testwaarde = " + testValue[i]);
                } else {
                    System.out.println("Output komt NIET overeen met testwaarde");
                    System.out.println("Output:" + output);
                    System.out.println("Testwaarde:" + testValue[i]);
                }
                i++;

            }
        }

        public static void TestString(String output){
            String a = "";
            String b = "";
            String c = "";

            String[] testValue = {a, b, c};
            int i = 0;
            int run = testValue.length;

            while (i < run) {

                if (output == testValue[i]) {
                    System.out.println("Output komt overeen met testwaarde");
                    System.out.println("Output = " + output);
                    System.out.println("Testwaarde = " + testValue[i]);
                } else {
                    System.out.println("Output komt NIET overeen met testwaarde");
                    System.out.println("Output:" + output);
                    System.out.println("Testwaarde:" + testValue[i]);
                }
                i++;

            }

        }

    }

