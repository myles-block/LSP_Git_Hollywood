package org.howard.edu.lsp.assignment5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test of IntegerSet class
 * @author Myles Block
 */
public class IntegerSetTest {
	private IntegerSet set;
	
	@BeforeEach
	void setUp() {
		set = new IntegerSet();
	}
	
	@Test
	@DisplayName("test add")
	public void testAdd() {
		ArrayList<Integer> toCastArrayList = new ArrayList<>(Arrays.asList(0, 1));
		IntegerSet expected = new IntegerSet(toCastArrayList);
		
		set.add(0);
		set.add(0); //adding dupe to see there is none in expected
		set.add(1);
		assertEquals(expected, set);
	} 
	
	@Test
	@DisplayName("test length")
	public void testLength() {
		int expected = 4;
		set.add(0);
		set.add(1);
		set.add(2);
		set.add(3);
		
		assertEquals(expected, set.length());
	}
	
	@Test
	@DisplayName("test clear")
	public void testClear() {
		int expected = 0;
		set.add(23);
        set.clear();
        assertEquals(expected, set.length());
	}
	
	@Test
	@DisplayName("test toString")
	public void testToString() {
		String expectedString = "[1, 2, 3, 4, 5]";
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		
		assertEquals(expectedString, set.toString());	
	}
	
	@Test
	@DisplayName("test Equals")
	public void testEquals() {
		ArrayList<Integer> toCastArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		IntegerSet trueSet = new IntegerSet();
		IntegerSet falseSet = new IntegerSet(toCastArrayList);
		ArrayList<Integer> toCastArrayList1 = new ArrayList<>(Arrays.asList(2, 3, 4, 1));//any order set
		IntegerSet jumbledSet = new IntegerSet(toCastArrayList1);
		
		trueSet.add(1);
		set.add(1);
		assertTrue(set.equals(trueSet));
		assertFalse(set.equals(falseSet));
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		assertTrue(set.equals(jumbledSet));//checks if the input (1,2,3,4) == (2,3,4,1)...as it should
	}
	
	@Test
	@DisplayName("test contains")
	public void testContains() {
		set.add(1);
		assertTrue(set.contains(1));
		assertFalse(set.contains(0));
	}
	
	@Test
	@DisplayName("test largest")
	public void testLargest() throws IntegerSetException {
		int expected = 60;
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		set.add(60);
		
		assertEquals(expected, set.largest());
	}
	
	@Test
	public void testLargest_IntegerSetException() throws IntegerSetException {
		Throwable exception = assertThrows(IntegerSetException.class, () -> set.largest());
		assertEquals("IntegerSet is empty", exception.getMessage());
	}
	
	@Test
	@DisplayName("test smallest")
	public void testSmallest() throws IntegerSetException {
		int expected = 10;
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		set.add(60);
		
		assertEquals(expected, set.smallest());
	}
	
	@Test
	public void testSmallest_IntegerSetException() throws IntegerSetException {
		Throwable exception = assertThrows(IntegerSetException.class, () -> set.smallest());
		assertEquals("IntegerSet is empty", exception.getMessage());
	}
	
	@Test
	@DisplayName("test remove")
	public void testRemove() {
		//Test Case 1: Removing from a set with items
		int expectedLength = 3;
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.remove(3);
		
		assertFalse(set.contains(3));
		assertEquals(expectedLength, set.length());
		
		//Test Case 2: Removing an item that isn't in there
		expectedLength = 0;
		set.clear();
		set.remove(1);
		assertFalse(set.contains(1));
		assertEquals(expectedLength, set.length());
	}
	
	@Test
	@DisplayName("test union")
	public void testUnion() {
		//Test Case 1: Unioning a set with items
		ArrayList<Integer> toCastArrayList = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
		IntegerSet set2 = new IntegerSet(toCastArrayList);
		ArrayList<Integer> toCastArrayList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		IntegerSet expectedSet = new IntegerSet(toCastArrayList1);
		
		int expectedLength = 8;
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.union(set2);
		
		assertEquals(expectedLength, set.length());
		assertEquals(expectedSet, set);
		
		//TestCase 2: Unioning an empty set
		set.clear();
		set2.clear();
		toCastArrayList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		expectedSet = new IntegerSet(toCastArrayList1);
		
		expectedLength = 4;
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.union(set2);
		
		assertEquals(expectedLength, set.length());
		assertEquals(expectedSet, set);
		
		//Test Case 3: Unioning Two Empty Sets
		expectedLength = 0;
		set.clear();
		set2.clear();
		expectedSet.clear();
		set.union(set2);
		
		assertEquals(expectedLength, set.length());
		assertEquals(expectedSet, set);
		assertTrue(set.isEmpty());
		
	}
	
	
	@Test
	@DisplayName("test intersect")
	public void testIntersect() {
		//Test Case 1: Intersecting a set that has intersections
		ArrayList<Integer> toCastArrayList = new ArrayList<>(Arrays.asList(10, 20, 30));
		IntegerSet set2 = new IntegerSet(toCastArrayList);
		ArrayList<Integer> toCastArrayList1 = new ArrayList<>(Arrays.asList(20));
		IntegerSet expectedSet = new IntegerSet(toCastArrayList1);
	
		set.add(100);
		set.add(200);
		set.add(20);
		set.add(1);
		set.intersect(set2);
		
		assertEquals(expectedSet, set);
		
		//Test Case 2: Intersecting a set that has no intersections
		set2.clear();
		expectedSet.clear();
		int expectedLength = 0;
		toCastArrayList = new ArrayList<>(Arrays.asList(1000, 9000, 5000)); // this set does have any commonalities with the first set
		set2 = new IntegerSet(toCastArrayList);
		
		set.intersect(set2);
		
		assertEquals(expectedSet, set);
		assertEquals(expectedLength, set.length());
		
		//Test Case 3: Intersecting a set with only intersections
		set.clear();
		set2.clear();
		expectedSet.clear();
		expectedLength = 3;
		toCastArrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
		set2 = new IntegerSet(toCastArrayList);
		toCastArrayList1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		expectedSet = new IntegerSet(toCastArrayList1);
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.intersect(set2);
		
		assertEquals(expectedSet, set);
		assertEquals(expectedLength, set.length());
		
		
	}
	
	@Test
	@DisplayName("test diff")
	public void testDiff() {
		//Test Case 1: Diffing a set that has a difference
		ArrayList<Integer> toCastArrayList = new ArrayList<>(Arrays.asList(2, 4));
		IntegerSet set2 = new IntegerSet(toCastArrayList);
		ArrayList<Integer> toCastArrayList1 = new ArrayList<>(Arrays.asList(6, 8));
		IntegerSet expectedSet = new IntegerSet(toCastArrayList1);
	
		set.add(2);
		set.add(4);
		set.add(6);
		set.add(8);
		set.diff(set2);
		
		assertEquals(expectedSet, set);
		
		//Test Case 2: Diffing a set with ALL matches
		set.clear();
		toCastArrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
		set2 = new IntegerSet(toCastArrayList);
		toCastArrayList1 = new ArrayList<>(Arrays.asList());
		expectedSet = new IntegerSet(toCastArrayList1);
	
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.diff(set2);
		
		assertEquals(expectedSet, set);
		assertTrue(set.isEmpty());
		
		//Test Case 3: Diffing a set with NO matches
		set.clear();
		toCastArrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
		set2 = new IntegerSet(toCastArrayList);
		toCastArrayList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		expectedSet = new IntegerSet(toCastArrayList1);
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.diff(set2);
		
		assertEquals(expectedSet, set);
	}
	
	@Test
	@DisplayName("test complement")
	public void testComplement() {
		//Test Case 1: A complement exist
		ArrayList<Integer> toCastArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		IntegerSet set2 = new IntegerSet(toCastArrayList);
		ArrayList<Integer> toCastArrayList1 = new ArrayList<>(Arrays.asList(5, 6));
		IntegerSet expectedSet = new IntegerSet(toCastArrayList1);
	
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.complement(set2);
		
		assertEquals(expectedSet, set);
		
		//Test Case 2: A complement does not exist
		set.clear();
		toCastArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		set2 = new IntegerSet(toCastArrayList);
		toCastArrayList1 = new ArrayList<>(Arrays.asList());//expected empty set
		expectedSet = new IntegerSet(toCastArrayList1);
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.complement(set2);
		
		assertEquals(expectedSet, set);
		assertTrue(set.isEmpty());
		
	}
	
	@Test
	@DisplayName("test isEmpty")
	public void testIsEmpty() {
		//Test Case 1: set is Empty
		assertEquals(0, set.length());
		assertTrue(set.isEmpty());
		
		//Test Case 2: set is not empty
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		assertFalse(set.isEmpty());
	}
	
	

}
