package io.breitek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Write some code that gives the mean/median/mode
 * of a series of numbers.
 * 
 * This simple program will prompt the user to enter a series
 * 
 * @author John Breitzman
 *	(01/07/2020)
 *
 */
public class Main {

	private static Scanner s = new Scanner(System.in);
	private static final List<Double> numArr = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("This program will calculate the (Mean/Median/Mode) of the numbers you input into the program.\n");
		System.out.println("Please enter a number (e.g., 1, 15.3, -4) and press [Enter], when you are done adding numbers press any letter then press [Enter].");
		getInput();
		
		// Sort Array
		Collections.sort(numArr);

		// Validate Array has values and is not NULL;
		if (numArr != null && numArr.size() > 0) {
			getMean(numArr);
			getMedian(numArr);
			getMode(numArr);
		} else {
			System.out.println("Can not compute the Mean/Median/Mode. Object is null or has no values.");
		}
	}

	private static void getInput() {
		boolean quit = false;
		
		while(!quit) {
			
			try {
				double num = s.nextDouble();
				numArr.add(num);
			} catch (InputMismatchException e) {
				quit = true;
			}
		}
	}

	/**
	 * Method accepts an array of doubles
	 * and prints out to the console the 'Mode'
	 * of the numbers array
	 * 
	 * @param List<Double> numArr
	 */
	private static void getMode(List<Double> numArr) {
		Map<Double, Integer> numList = new HashMap<>();
		Set<Double> modes = new TreeSet<>();
		
		int maxNum = 0;
		int count = 0;
		// Add values to Map based off amount of times
		// they occured in the Numbers Array.
		for(double num : numArr) {
			if (numList.containsKey(num)) {
				Integer newNum = numList.get(num);
				numList.put(num, newNum+1);
				count = newNum+1;
			} else {
				numList.put(num, 1);
				count = 1;
			}
			
			if (count > maxNum) {
				maxNum = count;
			}
		}
		
		for (Map.Entry<Double, Integer> v : numList.entrySet()) {
			if (numList.get(v.getKey()) == maxNum) {
				modes.add(v.getKey());
			}
		}
		
		System.out.println("==========================================================");
		System.out.println("The Mode is: " + modes);	
		System.out.println("Number of occurrences: " + maxNum);	
		System.out.println("==========================================================");
	}

	/**
	 * Method accepts an array of doubles
	 * and prints out to the console the 'Median'
	 * of the numbers array
	 * 
	 * @param List<Double> numArr
	 */
	private static void getMedian(List<Double> numArr) {
		int arrCount = numArr.size();
		int midIndex = 0;
		double median = 0;
		
		// Check if sorted array if Even or Odd
		// and determine the Median accordingly.
		if (arrCount % 2 == 0) {
			midIndex = arrCount / 2;
			double mid1 = numArr.get(midIndex);
			double mid2 = numArr.get(midIndex-1);
			median = (mid1 + mid2) / 2;
		} else {
			midIndex = arrCount / 2;
			median = numArr.get(midIndex);
		}
		
		System.out.println("==========================================================");
		System.out.println("The Median is: " + String.format("%.2f", median));	
		System.out.println("==========================================================");
	}

	/**
	 * Method accepts an array of doubles
	 * and prints out to the console the 'Mean'
	 * or 'Average' of the numbers array.
	 * 
	 * @param List<Double> numArr
	 */
	private static void getMean(List<Double> numArr) {
		double total = 0.0;
		
		for(double num : numArr) {
			total = total + num;
		}

		System.out.println("==========================================================");
		System.out.println("The Mean is: " + String.format("%.2f", total/numArr.size()));	
		System.out.println("==========================================================");
	}
}
