package io.breitek.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import io.breitek.Main;

class MeanMedianModeTest {
	private static final List<Double> numArrTest1 = new ArrayList<>();
	private static final List<Double> numArrTest2 = new ArrayList<>();
	
	static {
		// Odd Number
		numArrTest1.add((double) 6);
		numArrTest1.add((double) 90);
		numArrTest1.add(6.5);
		numArrTest1.add(12.1);
		numArrTest1.add(19.8);
		numArrTest1.add(55.1);
		numArrTest1.add(6.5);
		numArrTest1.add((double) 6);
		numArrTest1.add((double)14);
		numArrTest1.add(76.1);
		numArrTest1.add(32.2);
		numArrTest1.add(5.5);
		numArrTest1.add(6.5);
		
		// Even Number
		numArrTest2.add((double) 6);
		numArrTest2.add((double) 5);
		numArrTest2.add((double) 5);
		numArrTest2.add((double) 6);
		numArrTest2.add(1.1);
		numArrTest2.add(25.3);
	}
	
	@Test
	void shouldComputeCorrectMean() {
		assertEquals(25.87, Main.getMean(numArrTest1));
		assertNotEquals(23.2, Main.getMean(numArrTest1));
		
		assertEquals(8.07, Main.getMean(numArrTest2));
		assertNotEquals(8.06, Main.getMean(numArrTest2));
	}
	
	@Test
	void shouldComputerCorrectMedian() {
		assertEquals(6.50, Main.getMedian(numArrTest1));
		assertNotEquals(6, Main.getMedian(numArrTest1));
		
		assertEquals(5.5, Main.getMedian(numArrTest2));
		assertNotEquals(5.1, Main.getMedian(numArrTest2));
	}
	
	@Test
	void shouldComputerCorrectMode() {
		Set<Double> tsTest1 = Main.getMode(numArrTest1);
		Set<Double> tsTest2 = Main.getMode(numArrTest2);
		
		Iterator<Double> i1 = tsTest1.iterator();
		Iterator<Double> i2 = tsTest2.iterator();
		
		while(i1.hasNext()) {
			double nex = i1.next();
			assertEquals(6.5, nex);
			assertNotEquals(6, nex);
		}
		
		while(i2.hasNext()) {
			double nex = i2.next();
			assertTrue(nex == 6.0 || nex == 5);
			assertFalse(nex == 5.5);
		}
	}
}
