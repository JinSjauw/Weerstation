//import sun.security.ec.ECDSASignature;

import javax.xml.crypto.Data;
import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;

/**
 * A class to contain a period of time
 *
 * @author Johan Talboom
 * @version 2.0
 */
public class Period {
	private LocalDate beginPeriod;
	private LocalDate endPeriod;

	/**
	 * default constructor, sets the period to today
	 */
	public Period() {
		beginPeriod = LocalDate.now();
		endPeriod = LocalDate.now();
	}

	public Period(LocalDate beginPeriod, LocalDate endPeriod) {
		this.beginPeriod = beginPeriod;
		this.endPeriod = endPeriod;
	}

	public Period(LocalDate beginPeriod) {
		this.beginPeriod = beginPeriod;
		this.endPeriod = LocalDate.now();
	}

	public Period(int days) {
		this.beginPeriod = LocalDate.now().minus(java.time.Period.ofDays(days));
		this.endPeriod = LocalDate.now();
	}

	/**
	 * Simple setter for start of period
	 */
	public void setStart(int year, int month, int day) {
		beginPeriod = LocalDate.of(year, month, day);
	}

	/**
	 * simple setter for end of period
	 */
	public void setEnd(int year, int month, int day) {
		endPeriod = LocalDate.of(year, month, day);
	}

	/**
	 * alternative setter for start of period
	 *
	 * @param beginPeriod
	 */
	public void setStart(LocalDate beginPeriod) {
		this.beginPeriod = beginPeriod;
	}

	/**
	 * alternative setter for end of period
	 *
	 * @param endPeriod
	 */
	public void setEnd(LocalDate endPeriod) {
		this.endPeriod = endPeriod;
	}

	/**
	 * calculates the number of days in the period
	 */
	public long numberOfDays() {
		return ChronoUnit.DAYS.between(beginPeriod, endPeriod);
	}


	/**
	 * gets all raw measurements of this period from the database
	 * @return a list of raw measurements
	 */
	public ArrayList<RawMeasurement> getRawMeasurements() {
		return DatabaseConnection.getMeasurementsBetween(LocalDateTime.of(beginPeriod, LocalTime.of(0, 1)), LocalDateTime.of(endPeriod, LocalTime.of(23, 59)));
	}

	/**
	 * Builds an ArrayList of measurements. This method also filters out any 'bad' measurements
	 * @return a filtered list of measurements
	 */
	//-------------------------------------------------------------------------
	public ArrayList<Measurement> getMeasurements() {
		ArrayList<Measurement> measurements = new ArrayList<>();
		ArrayList<RawMeasurement> rawMeasurements = getRawMeasurements();
		for (RawMeasurement rawMeasurement : rawMeasurements) {
			Measurement measurement = new Measurement(rawMeasurement);
			if(measurement.isValid()) {
				measurements.add(measurement);
			}
		}
		return measurements;
	}
	//-----------------------------------------------------------------------------

	//------------------Array List---------------------------------------------------
//	LocalDateTime Begin;
//	LocalDateTime End;
//	ArrayList<RawMeasurement> RD = DatabaseConnection.getMeasurementsBetween(Begin, End);


	//-------------------------------------------------------------------------------


	/**
	 * todo
	 * @return
	 */
	public double getAverageOutsideTemperature()
	{
		ArrayList<Double> outsidetemplist = outsidetemp();
		//ArrayList<Measurement> measurements = getMeasurements();
		//calculate average outside temperature and return it
		return average(outsidetemplist);
	}

	public double getModusOutsideTemperature(){
		ArrayList<Double> outsideTempList = outsidetemp();


		return getMedian(outsideTempList);
	}

	/**
	 * Todo
	 */
	public ArrayList<Period> hasHeatWave() {
		return null;
	}

	/**
	 * Todo
	 */
	public Period longestDraught() {
		return new Period();
	}

	/**
	 * Todo more methods
	 */
	 public double getMedian(ArrayList<Double> list)
	 {
	 	double middle;
		int total = list.size();
		if(total % 2 == 0 ){
			middle = (list.get(list.size()/2) + list.get(list.size() / 2 - 1));
		}
		else
		{
			middle = list.get(list.size() / 2);
		}

	 	return middle;
	 }


	public ArrayList<Double> outsidetemp(){
		ArrayList<Measurement> measurements = getMeasurements();
		ArrayList getallen = new ArrayList();
		for (Measurement numbers: measurements){
			getallen.add(numbers.getOutsideTemp());
		}

		return getallen;
	}


	public double sum(ArrayList<Double> list) {

		double plus = 0;
		for (double thing:list){
			plus = plus + thing;
		}
		return(plus);
	}

	public double average (ArrayList<Double> list){
		//ArrayList list =outsidetemp();
		double amount = list.size();
		double average = (sum(list)/amount);
		return average;
	}

	public double  variance(){

		ArrayList<Double>getallen = outsidetemp();
		//avg
		double avg = average(getallen);
		double var = 0;
		int amount = 0;
		for (double thing : getallen) {
			amount++;
		}
		int tamount = amount;
		while (amount != 0) {
			amount--;
			var = var + Math.pow((getallen.get(amount)-avg),2);
		}
		var = var/(tamount-1);

		return var;
	}

	public double largest(ArrayList<Double> measurements) {
		double largest = measurements.get(0);

		for (double number : measurements) {
			if (number < largest) {
				largest = number;
			}
		}
		return largest;
	}

	public double smallest(ArrayList<Double> measurement) {

		double smallest = measurement.get(0);

		for (double number : measurement) {
			if (number > smallest) {
				smallest = number;
			}
		}
		return smallest;
	}


    public ArrayList<Double> modus(ArrayList<Double> measurements){
        //ArrayList<Measurement> measurements = getMeasurements();

        int maxCount = 0;
        ArrayList<Double> modae = new ArrayList<>();

        for (double forEachMeas : measurements) {
			int count = 0;

			for (double countingEachMeas : measurements) {
				if (forEachMeas == countingEachMeas) {
					++count;
				}
				if (count > maxCount) {
					maxCount = count;

                    modae.clear();
                    modae.add(countingEachMeas);

                } else if (count == maxCount){
                    if (!modae.contains(countingEachMeas)){
                        modae.add(countingEachMeas);
                    }
                }
            }
        }
        return modae;
    }
				}
