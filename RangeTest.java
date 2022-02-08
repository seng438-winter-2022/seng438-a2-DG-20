package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
	private Range generalRange;
    private Range nullRange;
    private Range scaleRange;
    private Range shiftRangeTrueCrossing;
    private Range shiftRangeFalseCrossing;
    private Range shiftRangeBoundary;
    private Range centralValueTester;
    private Range expandValidTester;
    private Range expandMarginBoundary;
    private Range toStringValidTester;

    @Before
    public void setUp() throws Exception { 
    	nullRange = null;
    	generalRange = new Range(0, 100);
    	
    	scaleRange = new Range(-2.25, 100);
    	
    	shiftRangeTrueCrossing = new Range(-11.0, 10072.0);
    	shiftRangeFalseCrossing = new Range(3.5, 89.0);
    	shiftRangeBoundary = new Range(-50.35, 100.70);
    	
    	centralValueTester = new Range(1.0, 100.00);
    	
    	expandValidTester = new Range(0.0, 14.0);
    	expandMarginBoundary = new Range(-2.0, 99.99);
    	
    	toStringValidTester = new Range(1.0, 200.0);
    }


    @Test
    public void scaleNullRangeNegativeFactor() throws Exception 
    {
    	try
    	{
    		Range returnObj = generalRange.scale(nullRange, -5.345);
    	}
    	catch (Exception e)
    	{
    		assertEquals("java.lang.IllegalArgumentException", e.getClass().getName().toString());
    	}
    }
    
    @Test
    public void scaleValidRangeNegativeFactor() throws Exception
    {
    	try
    	{
    		Range returnObj = generalRange.scale(scaleRange, -5.123);
    	}
    	catch (Exception e)
    	{
    		assertEquals("java.lang.IllegalArgumentException", e.getClass().getName().toString());
    	}
    }
    
    @Test
    public void scaleNullRangeValidFactor() throws Exception
    {
    	try
    	{
    		Range returnObj = generalRange.scale(nullRange, 1000);
    	}
    	catch (Exception e)
    	{
    		assertEquals("java.lang.IllegalArgumentException", e.getClass().getName().toString());
    	}
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
    
    @Test
    public void shiftNullRangeTrueZeroCrossing() throws Exception
    {
    	try
    	{
    		Range returnObj = generalRange.shift(nullRange, -4.2325, true);
    	}
    	catch (Exception e)
    	{
    		assertEquals("java.lang.IllegalArgumentException", e.getClass().getName().toString());
    	}
    }
    
    @Test
    public void shiftNullRangeFalseZeroCrossing() throws Exception
    {
    	try
    	{
    		Range returnObj = generalRange.shift(nullRange, -4.2325, false);
    	}
    	catch (Exception e)
    	{
    		assertEquals("java.lang.IllegalArgumentException", e.getClass().getName().toString());
    	}
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
    public void getCentralValueValidRange()
    {
    	double expected = 50.5;
    	double actual = centralValueTester.getCentralValue();
    	assert(expected == actual);
    }
    
    @Test
    public void getCentralValueNullRange()
    {
    	try
    	{
    		double actual = nullRange.getCentralValue();
    	}
    	catch (Exception e)
    	{
    		assertEquals("java.lang.NullPointerException", e.getClass().getName().toString());
    	}
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
    
    @Test
    public void expandNullRange()
    {
    	try
    	{
    		Range returnObj = Range.expand(nullRange, -0.30, 0.10);
    	}
    	catch (Exception e)
    	{
    		assertEquals("java.lang.IllegalArgumentException", e.getClass().getName().toString());
    	}
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
    	String expectedMessage = "Range[1.0,200.0]";
    	assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    public void toStringNullRange() throws Exception
    {
    	try
    	{
    		String actualMessage = nullRange.toString();
    	}
    	catch (Exception e)
    	{
    		assertEquals("java.lang.NullPointerException", e.getClass().getName().toString());
    	}
    }
}