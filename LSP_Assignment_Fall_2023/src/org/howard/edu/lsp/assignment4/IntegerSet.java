package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of IntegerSet class
 * @author Myles Block
 */
public class IntegerSet {
	private List<Integer> set = new ArrayList<Integer>();
	
	/**
	 * Default Constructor of IntegerSet
	 */
	public IntegerSet() {
	}
	
	/**
	 * Creates an IntegerSet from an ArrayList of Integers
	 * @param inputSet the ArrayList of Integers to created into an IntegerSet
	 */
	public IntegerSet(ArrayList<Integer> inputSet) {
		IntegerSet new_set = new IntegerSet();
		for (int num : inputSet) {
			if (!set.contains(num)) {
				new_set.set.add(num);
			}
		}
		this.set = new_set.set;
	}
	
	/**
	 * Adds an int to an IntegerSet (duplicates are not added)
	 * @param item the item to be added to IntegerSet
	 */
	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);
		}
	}
	
	/**
	 * Clears all the integers in the IntegerSet
	 */
	public void clear() {
		set.clear();
	}
	
	/**
	 * Converts IntegerSet to string
	 * @return String representation of IntegerSet
	 */
	public String toString() {
		return set.toString();
	}
	
	/**
	 * Returns the current length of IntegerSet
	 * @return current length of IntegerSet
	 */
	public int length() {
		return set.size();
	}
	
	/**
	 * Checks if two sets are equal regardless of order, (false if otherwise)
	 * @param intSetb IntegerSet to be checked for equality
	 * @return true if the sets are equal, false if they are not
	 */
	public boolean equals(IntegerSet intSetb) {
		return this.set.containsAll(intSetb.set);
	}
	
	/**
	 * Checks if IntegerSet contains a specific int
	 * @param value input value
	 * @return true if the value exist in the IntegerSet
	 */
	public boolean contains(int value) {
		for (int current : set) {
			if (current == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Finds the maximum value in the IntegerSet (if it exists)
	 * @return maximum value in IntegerSet
	 * @throws IntegerSetException if the set is empty
	 */
	public int largest() throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("IntegerSet is empty");
		}
		int max = set.get(0);
		for (int current : set) {
			if (current > max) {
				max = current;
			}
		}
		return max;
	}
	
	/**
	 * Finds the minimum value in the IntegerSet (if it exists)
	 * @return minimum value in IntegerSet
	 * @throws IntegerSetException if the set is empty
	 */
	public int smallest() throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("IntegerSet is empty");
		}
		int min = set.get(0);
		for (int current : set) {
			if (current < min) {
				min = current;
			}
		}
		return min;
	}
	
	/**
	 * Removes an item from the IntegerSet (nothing happens if item doesn't exist)
	 * @param item the item to be removed from the IntegerSet
	 */
	public void remove(int item) {
		int related_index = set.indexOf(item);
		if(related_index != -1) {
			set.remove(related_index);
		}
		
	}
	
	/**
	 * Adds the inputted set to the called set
	 * @param intSetb the IntegerSet to be added
	 */
	public void union(IntegerSet intSetb) {
		set.addAll(intSetb.set);
	}
	
	
	/**
	 * Creates the intersection points with intSetb
	 * @param intSetb the IntegerSet to be intersected with
	 */
	public void intersect(IntegerSet intSetb) {
		IntegerSet new_set = new IntegerSet();
		for (int num : this.set) {
			if (intSetb.set.contains(num)) {
				new_set.set.add(num);
			}
		}
		this.set = new_set.set;
	}
	
	/**
	 * Set difference
	 * @param intSetb the IntegerSet to be diffed with
	 */
	public void diff(IntegerSet intSetb) {
		for (int num : intSetb.set) {
			if (this.set.contains(num)) {
				int index = this.set.indexOf(num);
				this.set.remove(index);
			}
		}
	}
	
	/**
	 * Set complement
	 * @param intSetb the IntegerSet to be complemented with
	 */
	public void complement(IntegerSet intSetb) {
		IntegerSet new_set = new IntegerSet();
		for (int num : intSetb.set) {
			if (!this.set.contains(num)) {
				new_set.set.add(num);
			}
		}
		this.set = new_set.set;
	}
	
	/**
	 * Checks if the IntegerSet is empty
	 * @return true if the set is empty, false if it is not
	 */
	public boolean isEmpty() {
		return (set.size() == 0);
	};


}
