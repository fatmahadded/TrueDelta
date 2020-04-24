package utils;

import java.util.Collection;

public class FloatUtils {
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static double standardDeviation(Collection<Double> collection)
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = collection.size();

        for(double num : collection) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: collection) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
}
