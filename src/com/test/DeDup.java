package com.test;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * @author Jithesh Manhappallil Chacko
 * 
 */
public class DeDup {

public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11}; 

	public static void main(String[] args) {

		DeDup deDup = new DeDup();
		int[] uniqueNumbers;

		uniqueNumbers = removeDuplicatesOne(deDup.randomIntegers);
		System.out.print("Random Integers:");
		printRandomIntegers(uniqueNumbers);

		System.out.println("\n");

		uniqueNumbers = removeDuplicatesTwo(deDup.randomIntegers);
		System.out.print("Random Integers Ordered:");
		printRandomIntegers(uniqueNumbers);

		System.out.println("\n");

		uniqueNumbers = removeDuplicatesThree(deDup.randomIntegers);
		System.out.print("Random Integers Sorted:");
		printRandomIntegers(uniqueNumbers);
	}

	/**
	 * <b>Advantages</b>
	 * </br>Simple approach using HashSet.
	 * </br>Most efficient in terms of performance.
	 * </p>
	 * <b>Disadvantages</b>
	 * <br>Does not provide any ordering.
	 * </p>
	 * <b>Improvement</b>
	 * <br>LinkedHashSet can be used to provide ordering with a minor compromise to the performance.
	 * </p>
	 * 
	 * @param randomIntegers array of random integers with duplicates
	 * @return random integers with no duplicates
	 */
	
	private static int[] removeDuplicatesOne(int[] randomIntegers) {
		Set<Integer> uniqueNos = new HashSet<Integer>();
		for (int randomInteger : randomIntegers) {
			uniqueNos.add(randomInteger);
		}
		int i = 0;
		int[] uniqueInts = new int[uniqueNos.size()];
		for (int uniqueInt : uniqueNos) {
			uniqueInts[i++] = uniqueInt;
		}
		return uniqueInts;
	}
	
	/**
	 * <b>Advantages</b>
	 * </br>Using LinkedHashSet retains order of insertion of integers into the set.
	 * </p>
	 * <b>Disadvantages</b>
	 * <br>Adds little performance overhead when compared to HashSet.
	 * </p>
	 * <b>Improvement</b>
	 * <br>This approach using LinkedHashSet is ideal to retain the original order.
	 * </p>
	 * @param randomIntegers array of random integers with duplicates
	 * @return random integers with no duplicates
	 */

	private static int[] removeDuplicatesTwo(int[] randomIntegers) {
		Set<Integer> uniqueNos = new LinkedHashSet<Integer>();
		for (int randomInteger : randomIntegers) {
			uniqueNos.add(randomInteger);
		}
		int i = 0;
		int[] uniqueInts = new int[uniqueNos.size()];
		for (int uniqueInt : uniqueNos) {
			uniqueInts[i++] = uniqueInt;
		}
		return uniqueInts;
	}
	
	/**
	 * <b>Advantages</b>
	 * </br>Prints the integer array in the sorted order.
	 * </br>Efficient than using TreeSet in terms of performance.
	 * </p>
	 * <b>Disadvantages</b>
	 * <br>Programming overhead of copying the unique elements from the sorted array.
	 * </p>
	 * <b>Improvement</b>
	 * <br>Java collection data structures can be used to avoid programming overhead.
	 * </p>
	 * 
	 * @param randomIntegers array of random integers with duplicates
	 * @return random integers with no duplicates
	 */
	private static int[] removeDuplicatesThree(int[] randomIntegers) {
		Arrays.sort(randomIntegers);

		int i = 1;// head of original array
		int j = 0;// head of new array

		while (i < randomIntegers.length) {
			if (randomIntegers[i] == randomIntegers[j]) {
				i++;
			} else {// Copy the new unique element to the head of new array
					// and advance the count
				j++;
				randomIntegers[j] = randomIntegers[i];
				i++;
			}
		}
		// Return the array, only counting till the head of new array
		return Arrays.copyOf(randomIntegers, j + 1);
	}
	
	/**
	 * Print the array of random integers with no duplicates.
	 * 
	 * @param uniqueNumbers
	 */
	private static void printRandomIntegers(int[] uniqueNumbers) {
		for (int uniqueNumber : uniqueNumbers) {
			System.out.print(uniqueNumber + ",");
		}
	}

}


