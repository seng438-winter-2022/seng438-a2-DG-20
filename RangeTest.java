/*
 * Course: SENG 438
 * Assignment: 2
 * Team Members: Curtis Silva, Divyansh Goyal, Gurpartap Sohi, Liam Parmar
 */
package org.jfree.data.test;

// Import statements.
import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

// Creating a class for the RangeTest test cases.
public class RangeTest {
	// Declaring Range objects for testing purposes.
	private Range generalRange;
    private Range nullRange;
    private Range scaleRange;
    private Range shiftRangeTrueCrossing;
    private Range shiftRangeFalseCrossing;
    private Range shiftRangeBoundary;
    private Range centralValueTesterPositive;
    private Range centralValueTesterNegative;
    private Range centralValueTesterZero;
    private Range expandValidTester;
    private Range expandMarginBoundary;
    private Range toStringValidTester;

    // Before the test cases below begin running, setting the private Range objects by initializing them or setting them to null.
    @Before
    public void setUp() throws Exception { 
    	// General-purpose Range objects.
    	nullRange = null;
    	generalRange = new Range(0, 100);
    	
    	// Range objects for scale method test.
    	scaleRange = new Range(-2.25, 100);
    	
    	// Range objects for shift method tests.
    	shiftRangeTrueCrossing = new Range(-11.0, 10072.0);
    	shiftRangeFalseCrossing = new Range(3.5, 89.0);
    	shiftRangeBoundary = new Range(-50.35, 100.70);
    	
    	// Range objects for centralValue method tests.
    	centralValueTesterPositive = new Range(1.0, 100.00);
    	centralValueTesterNegative = new Range(-100.00, -8.00);
    	centralValueTesterZero = new Range(-20.0, 20.0);
    	
    	// Range objects for expand method tests.
    	expandValidTester = new Range(0.0, 14.0);
    	expandMarginBoundary = new Range(-2.0, 99.99);
    	
    	// Range objects for toString method test.
    	toStringValidTester = new Range(-12.0, 200.0);
    }


    // Tests for the scale() method.
    
    @Test(expected = IllegalArgumentException.class)
    public void scaleNullRangeNegativeFactor() throws Exception 
    {
    	Range returnObj = generalRange.scale(nullRange, -5.345);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void scaleValidRangeNegativeFactor() throws Exception
    {
    	Range returnObj = generalRange.scale(scaleRange, -5.123);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void scaleNullRangeValidFactor() throws Exception
    {
    	Range returnObj = generalRange.scale(nullRange, 1000);
    }

    @Test
    public void scaleValidRangeValidFactor()
    {
    	Range returnObj = generalRange.scale(scaleRange, 2.34);
    	Range expectedObj = new Range(-5.265, 234.00);
    	assertEquals(expectedObj, returnObj);
    }
    
    @Test
    public void scaleFactorZero()
    {
    	Range returnObj = generalRange.scale(scaleRange, 0.0);
    	Range expectedObj = new Range(0.0, 0.0);
    	assertEquals(expectedObj, returnObj);
    }
    
    
    
    @Test(expected = IllegalArgumentException.class)
    public void shiftNullRangeTrueZeroCrossing() throws Exception
    {
    	Range returnObj = generalRange.shift(nullRange, -4.2325, true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shiftNullRangeFalseZeroCrossing() throws Exception
    {
    	Range returnObj = generalRange.shift(nullRange, 500000, false);
    }
    
    @Test
    public void shiftValidRangeTrueZeroCrossing()
    {
    	Range returnObj = generalRange.shift(shiftRangeTrueCrossing, 500000.0, true);
    	Range expectedObj = new Range(499989.0, 510072.0);
    	assertEquals(expectedObj, returnObj);
    }
    
    @Test
    public void shiftValidRangeFalseZeroCrossing()
    {
    	Range returnObj = generalRange.shift(shiftRangeFalseCrossing, -4.2325, false);
    	Range expectedObj = new Range(0.00, 84.7675);
    	assertEquals(expectedObj, returnObj);
    }
    
    @Test
    public void shiftDeltaZero()
    {
    	Range returnObj = generalRange.shift(shiftRangeBoundary, 0.0, true);
    	Range expectedObj = new Range(-50.35, 100.70);
    	assertEquals(expectedObj, returnObj);
    }
    
    
    
    @Test
    public void getPositiveCentralValueValidRange()
    {
    	double expected = 50.5;
    	double actual = centralValueTesterPositive.getCentralValue();
    	assert(expected == actual);
    }
    
    @Test
    public void getNegativeCentralValueValidRange()
    {
    	double expected = -54.00;
    	double actual = centralValueTesterNegative.getCentralValue();
    	assert(expected == actual);
    }
    
    @Test
    public void getZeroCentralValueValidRange()
    {
    	double expected = 0.00;
    	double actual = centralValueTesterZero.getCentralValue();
    	assert(expected == actual);
    }
    
    @Test(expected = NullPointerException.class)
    public void getCentralValueNullRange()
    {
    	double actual = nullRange.getCentralValue();
    }
    
    
    
    @Test
    public void expandValidMargins()
    {
    	Range returnObj = Range.expand(expandValidTester, -0.10, 3.00);
    	Range expectedObj = new Range(1.4, 56.0);
    	double lowerBoundActual = Math.round(returnObj.getLowerBound() * 100000000.0) / 100000000.0;
    	double upperBoundActual = Math.round(returnObj.getUpperBound() * 100000000.0) / 100000000.0;
    	Range actualObj = new Range(lowerBoundActual, upperBoundActual);
    	assertEquals(expectedObj, actualObj);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void expandNullRange()
    {
    	Range returnObj = Range.expand(nullRange, -0.30, 0.10);
    }
    
    @Test
    public void expandZeroMargins()
    {
    	Range returnObj = Range.expand(expandMarginBoundary, 0.00, 0.00);
    	Range expectedObj = new Range(-2.0, 99.99);
    	assertEquals(expectedObj, returnObj);
    }
    
    
    
    @Test
    public void toStringValidRange()
    {
    	String actualMessage = toStringValidTester.toString();
    	String expectedMessage = "Range[-12.0,200.0]";
    	assertEquals(expectedMessage, actualMessage);
    }
    
    @Test(expected = NullPointerException.class)
    public void toStringNullRange() throws Exception
    {
    	String actualMessage = nullRange.toString();
    }
}
