package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Driver class for testing the implementation of IntegerSet
 * @author mylesblock
 */
public class Driver {
	/**
	 * System output of different tests
	 * @param args passed in strings
	 */
	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		
		//Adding 
		set1.add(1);
		System.out.println("Result of add 1" + set1.toString());
		
		
		set1.add(1);
		System.out.println("Result of add 1" + set1.toString());
		
		
		set1.add(2);
		System.out.println("Result of add 2" + set1.toString());
		
		//Checking contains of a IntegerSet
		System.out.println("\nSet1 contains a 2: " + set1.contains(2));
		System.out.println("Set1 contains a 5: " + set1.contains(5));
		
		set1.add(0);
		set1.add(10);
		
		//Checking Largest & Smallest
		try {
			System.out.println("\nLargest in set1: " +  set1.largest());
			System.out.println("Smallest in set1: " + set1.smallest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Removal
		set1.remove(1);
		set1.remove(10);
		System.out.println("\nIntegerSet after removal of 1 & 10: " + set1.toString());
		
		//Length
		System.out.println("IntegerSet length: " + set1.length());
		
		//Creation of set2 via Casting
		ArrayList<Integer> toCastArrayList = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
		IntegerSet set2= new IntegerSet(toCastArrayList);
		System.out.println("\nCreation of set2: " + set2.toString());
		
		//Union
		set1.union(set2);
		System.out.println("Union of set1 & set2: " + set1.toString());
		ArrayList<Integer> toCastArrayList1 = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
		IntegerSet unionSet1 = new IntegerSet(toCastArrayList1);
		ArrayList<Integer> toCastArrayList2 = new ArrayList<>(Arrays.asList(1, 2, 6, 7));
		IntegerSet unionSet2 = new IntegerSet(toCastArrayList2);
		unionSet1.union(unionSet2);
		System.out.println("Union of unionSet1 & unionSet2: " + unionSet1.toString());
		
		//Intersection
		ArrayList<Integer> toCastSet3 = new ArrayList<>(Arrays.asList(1, 3, 10));
		IntegerSet set3= new IntegerSet(toCastSet3);
		System.out.println("\nset1: " + set1.toString());
		System.out.println("set3: " + set3.toString());
		set1.intersect(set3);
		System.out.println("Intersection of set1 & set3: " + set1.toString());
		
		//Difference
		ArrayList<Integer> toCastSet4 = new ArrayList<>(Arrays.asList(3));
		IntegerSet set4= new IntegerSet(toCastSet4);
		System.out.println("\nset1: " + set1.toString());
		System.out.println("set4: " + set4.toString());
		set1.diff(set4);
		System.out.println("Difference of set1 & set4: " + set1.toString());
		
		//Complement
		ArrayList<Integer> toCastSet5 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
		IntegerSet set5= new IntegerSet(toCastSet5);
		System.out.println("\nset1: " + set1.toString());
		System.out.println("set5: " + set5.toString());
		set1.complement(set5);
		System.out.println("Complement of set1 & set5: " + set1.toString());
		
		//Equal
		ArrayList<Integer> toCastSet6 = new ArrayList<>(Arrays.asList(2, 0, 5, 4, 3));
		IntegerSet set6= new IntegerSet(toCastSet6);
		System.out.println("\nset1: " + set1.toString());
		System.out.println("set6: " + set6.toString());
		System.out.println("set1 & set6 equal? " + set1.equals(set6));
		System.out.println("set1 & set3 equal? " + set1.equals(set3));
		
		//Clearing a set
		set1.clear();
		System.out.println("\nResult of clear ..." + set1.toString());
		System.out.println("Is set1 empty? " + set1.isEmpty());
	}

}
