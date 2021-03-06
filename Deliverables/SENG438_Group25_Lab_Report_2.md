# SENG 438 - Software Testing, Reliability, and Quality
# Lab. Report \#2 – Requirements-Based Test Generation

| Group \#:      | 25    |
| -------------- | --- |
|   Divyansh Goyal             |     |
|   Curtis Silva             |     |
|   Liam Parmar             |     |
|   Gurpartap Sohi |    |

<hr>

**Table of Contents**

[1 Introduction](#introduction)

[2 Detailed Plan of JUnit Testing](#detailed-plan-of-junit-testing)
* [2.1 Introduction](#introduction-1)
* [2.2 Methods To Be Tested](#methods-to-be-tested)
* [2.3 Test Determination Procedures and Team Work Division](#test-determination-procedures-and-team-work-division)
* [2.4 Designed Partitions](#designed-partitions)
* [2.5 Discussion on Benefits and Drawbacks of Mocking](#discussion-on-benefits-and-drawbacks-of-mocking)

[3 Test Cases Developed](#test-cases-developed)
* [3.1 Range](#range)
* [3.2 DataUtilities](#datautilities)

[4 Division of Effort and Lessons Learned From Teamwork](#division-of-effort-and-lessons-learned-from-teamwork)

[5 Difficulties Encountered, Challenges Overcome, and Lessons Learned](#difficulties-encountered-challenges-overcome-and-lessons-learned)

[6 Comments and Feedback on The Lab Assignment](#comments-and-feedback-on-the-lab-assignment)

<hr>

## Introduction

This assignment intends to provide students a generalized overview of the fundamentals of automated unit testing based on the requirements of each unit. In order to develop automated test code in JUnit, students are required to devise a high level plan to test functionality of the methods in the Range and DataUtilities classes, and document and report these tests. Furthermore, students will explore and work with mock objects in the test-code development stages.

<hr>

## Detailed Plan of JUnit Testing

### Introduction
The following test plan is designed to perform a thorough testing on 5 methods each from the Range class and DataUtilities class. Specifically, the creation of unit tests will be utilized to test the requirements of Range and DataUtilities. The intention of these tests is to determine the code quality of the methods, according to the JavaDocs description of each. The purpose of this black-box testing is to scrutinize the requirements for each method and create tests solely based on those requirements, without looking at the source code. The plan will identify the methods intended to be tested, test determination procedures and division of work in the team, and the partitions created.

### Methods To Be Tested
<strong>Range:</strong>

* scale(Range base, double factor)
* shift(Range base, double delta, boolean allowZeroCrossing)
* getCentralValue()
* expand(Range range, double lowerMargin, double upperMargin)
* toString()

<strong>DataUtilities:</strong>
* calculateColumnTotal(Values2D data, int column)
* calculateRowTotal(Values2D data, int row, int[] validCols)
* createNumberArray(double[] data)
* equal(double[][] a, double[][] b)
* clone(double [][] source)

### Test Determination Procedures and Team Work Division
To develop the unit tests that will be used to thoroughly test the Range class and DataUtilities class, the group will employ the use of peer-programming. As such, the group will divide into pairs, where one pair will focus on the development of test cases for the Range class and the other will focus on the development of test cases for the DataUtilities test cases. Prior to splitting into pairs, each member of the group will read through the JavaDocs of the selected methods and discuss what exactly each method should be doing. After splitting into pairs, each pair will take as long as they require to determine edge cases, equivalence classes, and invalid input tests to ensure every possible functionality of the method works as specified. 
 
To avoid redundancy, equivalence classes must be analyzed. To create equivalence classes, each pair will list each type of input for an individual method. After listing every possible type of input, the pair will identify any inputs which are similar and will provide the same expected output. These groupings will be the classes, and thus when creating test cases, only one test case will be created per class. This will lead to a more efficient testing process. 
 
To cover all edge cases, each pair will also look towards performing boundary-value analysis. To do so, the pair will look at the boundaries of the equivalence classes, and choose an input that lies on that boundary, or just outside of it. For example, if the JavaDocs specify that the input range of a variable is [0, 10], boundary test cases would be to provide an input of -1, 0, 10, and 11. These test cases allow the program specifications to be held accountable and ensures that those edge cases are properly handled by the system.

### Designed Partitions
1) A value below the accepted input range. (For numeric inputs).
2) A value above the accepted input range. (For numeric inputs).
3) A value which is a part of the accepted input range. (For numeric inputs).
4) NULL input. (For object, String, and Array inputs).
5) Valid objects. (For object inputs).
6) True input. (For boolean inputs).
7) False input. (For boolean inputs).

### Discussion on Benefits and Drawbacks of Mocking
Mocking is a very useful concept which allows for more efficient unit testing. At the same time however, it does contain drawbacks. One of the major benefits of mocking is that it allows users to partially simulate behavior of an object, based on the parts on which they are testing. This leads to a more efficient process as time is not spent creating the components of the object which will not be tested upon in each individual test. As such, isolation of particular functionality becomes much easier. One drawback however, is that each component must be individually set/determined, which could lead to a larger setup time before testing even begins. As such, it is imperative to use mocking only when the time saved outweighs the time spent on setting each value in the object.

<hr>

# Test Cases Developed

### Range

_scale(Range base, double factor):_

Partitions Used in This:
	
	base = {null, not null}
	factor = {negative, non-negative}

<ol> 
	<li>scaleNullRangeNegativeFactorTest: base = null and factor = -5.345
	<ul>
		<li>Covers partitions 1. and 4.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>

<li>scaleNullRangeNegativeFactorTest: base = Range(-2.25, 100) and factor = -5.123
	<ul>
		<li>Covers partitions 1. and 5.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>

<li>scaleNullRangeValidFactorTest: base = null and factor = 1000
	<ul>
		<li>Covers partitions 3. and 4.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>

<li>scaleValidRangeValidFactorTest: base = Range(-2.25, 100) and factor = 2.34
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: Range object, where object.getLowerBound() = -5.265 and object.getUpperBound() = 234.00.</li>
	</ul>
	</li>

<li>scaleFactorZeroTest: base = Range(-2.25, 100) and factor = 0
	<ul>
		<li>Boundary condition test for factor variable.</li>
		<li>Expected output: Range object, where object.getLowerBound() = 0.0 and object.getUpperBound() = 0.0.</li>
	</ul>
	</li>
</ol>

<hr>

_shift(Range base, double delta, boolean allowZeroCrossing):_

Partitions Used in This:
	
	base = {null, not null}
	delta = {any number}
	allowZeroCrossing = {true, false}

<ol>
<li>shiftNullRangeTrueZeroCrossingTest: base = null, delta = -4.2325, allowZeroCrossing = true
	<ul>
		<li>Covers partitions 3., 4., 6.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>
<li>shiftNullRangeFalseZeroCrossingTest: base = null, delta = 500000.0, allowZeroCrossing = false
	<ul>
		<li>Covers partitions 3., 4., 7.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>
<li>shiftValidRangeTrueZeroCrossingTest: base = Range(-11.0, 10072.0) delta = 500000.0, allowZeroCrossing = true
	<ul>
		<li>Cover partitions 3., 5., 7.</li>
		<li>Expected output: Range object, where object.getLowerBound() = 499989.0 and object.getUpperBound() = 510072.0.</li>
	</ul>
<li>shiftValidRangeFalseZeroCrossingTest: base = Range(3.5, 89.0), delta = -4.2325, allowZeroCrossing = false
	<ul>
		<li>Cover partitions 3., 5., 6.</li>
<li>Expected output: Range object, where object.getLowerBound() = 0.00 and object.getUpperBound() = 84.7675.</li>
	</ul>
<li>shiftDeltaZeroTest: base = Range(-50.35, 100.70), delta = 0.0, allowZeroCrossing = true
	<ul>
		<li>Boundary condition test for delta variable.</li>
<li>Expected output: Range object, where object.getLowerBound() = -50.35 and object.getUpperBound() = 100.70.</li>
	</ul>
	</li>
</ol>

<hr>
 
_getCentralValue():_

No partitions used in this (no inputs).

<ol>
<li>getPositiveCentralValueValidRangeTest: Create a Range object with lower = 1.0 and upper = 100.00 and call getCentralValue() on it.
	<ul>
		<li>Expected output: 50.5</li>
	</ul>
	</li>
<li>getNegativeCentralValueValidRangeTest: Create a Range object with lower = -100.0 and upper = -8.00 and call getCentralValue() on it.
	<ul>
		<li>Expected output: -54.00</li>
	</ul>
	</li>
<li>getZeroCentralValueValidRangeTest: Create a Range object with lower = -20.00 and upper = -20.00 and call getCentralValue() on it.
	<ul>
		<li>Expected output: 0.00</li>
	</ul>
	</li>
<li>getCentralValueNullRangeTest: Create a null Range object and call getCentralValue() on it.
	<ul>
		<li>Expected output: NullPointerException thrown</li>
	</ul>
	</li>
	</ol>

<hr>

_expand(Range range, double lowerMargin, double upperMargin):_

Partitions Used in This:

	range = {null, not null}
	lowerMargin = {any number}
	upperMargin = {any number}
	
<ol>
<li>expandValidMarginsTest: range = Range(0.0, 14.0), lowerMargin = -0.10, upperMargin = 3.00
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: Range object, where object.getLowerBound() = 1.4 and object.getUpperBound() = 56.0.</li>
	</ul>
	</li>
<li>expandNullRangeTest: range = null, lowerMargin = -0.30, upperMargin = 0.10
	<ul>
		<li>Cover partitions 3. and 4.</li>
		<li>Expected output: IllegalArgumentException.</li>
	</ul>
	</li>
<li>expandZeroMarginsTest: range = Range(-2.0, 99.99), lowerMargin = 0.00, upperMargin = 0.00
	<ul>
		<li>Boundary condition test for lowerMargin and upperMargin variables.</li>
		<li>Expected output: Range object, where object.getLowerBound() = -2.0 and object.getUpperBound() = 99.99.</li>
	</ul>
	</li>
</ol>

<hr>
 
_toString():_

No partitions used in this (no inputs).

<ol> 
<li>toStringValidRangeTest: Create a Range object with lower = -12.0 and upper = 100.00 and call toString() on it.
	<ul>
		<li>Expected output: "Range[-12.0,100.0]".</li>
	</ul>
	</li>
<li>toStringNullRangeTest: Create a null Range object call toString() on it.
	<ul>
		<li>Expected output: NullPointerException thrown.</li>
	</ul>
	</li>
	</ol>

<hr>

### DataUtilities
_calculateColumnTotal(Values2D data, int column)_

Partitions Used in This:

	data = {null, not null}
	column = {negative, non-negative, above input range}

<ol>
<li>calculateColumnTotalForNullDataTest: data = null and column = 2
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>
<li>calculateColumnTotalValidDataRealTest: First, create a mock object, set the return value of getRowCount() to 3. Set return values of getValue(0, 2) = 3.123, getValue(1, 2) = 4, getValue(2, 2) = -55.009. Set column = 2
	<ul>
		<li>Covers partitions 3. and 6.</li>
		<li>Expected output: Returns a double of the summation of values in column 2, resulting in a return value of -47.886.</li>
	</ul>
	</li>
<li>calculateColumnTotalValidDataExtraTest: First, create a mock object, set the return value of getRowCount() to 3. Set return values of getValue(0, 2) = 2.873, getValue(1, 2) = 0, getValue(1, 1) = 67.622, getValue(2, 2) = -43.132. Set column = 2
	<ul>
		<li>Covers partitions 3. and 6.</li>
		<li>Expected output: Returns a double of the summation of values in column 2, resulting in a return value of -40.259.</li>
	</ul>
	</li>
<li>calculateColumnTotalUnderAcceptableColTest: First, create a mock object, set the return value of getRowCount() to 4. Set return values of getValue(0, 3) = 17.17, getValue(1, 3) = -2, getValue(2, 3) = -0.93, getValue(3, 3) = 32.11 and column = -1
	<ul>
		<li>Covers partitions 1. and 6.</li>
		<li>Expected output: ExpectationError from JMock API.</li>
	</ul>
	</li>
<li>calculateColumnTotalOverAcceptableColTest: First, create a mock object, set the return value of getRowCount() to 3. Set return values of getValue(0, 1) = 90.80, getValue(1, 1) = 88.320, getValue(2, 1) = 7.8123, getValue(0, 0) = 76.323, getValue(1, 0) = 59.92, getValue(2, 0) = 5.454, and column = 2
	<ul>
		<li>Covers partitions 2. and 6.</li>
		<li>Expected output: ExpectationError from JMock API.</li>
	</ul>
	</li>
<li>calculateColumnTotalBoundaryTest: First, create a mock object, set the return value of getRowCount() to 3. Set return values of getValue(0, 1) = 58.62, getValue(1, 1) = 98.73, getValue(2, 1) = 5.123, getValue(0, 0) = 5.6, getValue(1, 0) = -9.3, getValue(2, 0) = 501.13 and column = 1
	<ul>
		<li>Boundary condition test for “column” variable.</li>
		<li>Expected output: Returns a double of the summation of values in column 1, resulting in a return value of 162.473.</li>
	</ul>
	</li>
 </ol>
 
 <hr>
 
_calculateRowTotal(Values2D data, int row)_

Partitions Used in This:

	data = {null, not null}
	row = {positive number, negative number, above input range}
	
<ol>
<li>calculateRowTotalForNullDataTest: data = null and row = 2
	<ul>
		<li>Covers partitions 3. and 4.</li>
		<li>Expected output: IllegalArgumentException Thrown.</li>
	</ul>
	</li>
<li>calculateRowTotalValidDataRealTest: First, create a mock object, set the return value of getColumnCount() to 3. Set return values of getValue(0, 0) = 8.71, getValue(0, 1) = 1, getValue(0, 2) = -22.394. Set row = 0
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: Returns a double of the summation of values in row 0, resulting in a return value of -12.684.</li>
	</ul>
	</li>
<li>calculateRowTotalValidDataExtraTest: First, create a mock object, set the return value of getColumnCount() to 3. Set return values of getValue(1, 0) = 37.17, getValue(1, 1) = 0, getValue(1, 2) = 63.193, getValue(2, 2) = -200.837. Set row = 1
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: Returns a double of the summation of values in column 2, resulting in a return value of 100.363.</li>
	</ul>
	</li>
<li>calculateRowTotalUnderAcceptableColTest: First, create a mock object, set the return value of getColumnCount() to 4. Set return values of getValue(0, 0) = 17.17, getValue(0, 1) = -9, getValue(0, 2) = -0.123, getValue(0, 3) = 8.127 and row = -1
	<ul>
		<li>Covers partitions 1. and 5.</li>
		<li>Expected output: ExpectationError from JMock API.</li>
	</ul>
	</li>
<li>calculateRowTotalOverAcceptableColTest: First, create a mock object, set the return value of getColumnCount() to 3. Set return values of getValue(1, 0) = 90.80, getValue(1, 1) = 88.320, getValue(1, 2) = 7.8123, getValue(0, 0) = 31.912, getValue(0, 1) =8.29, getValue(0, 2) = 14.289 and row = 2
	<ul>
		<li>Covers partitions 2. and 6.</li>
		<li>Expected output: ExpectationError from JMock API.</li>
	</ul>
	</li>
<li>calculateRowTotalBoundaryTest: First, create a mock object, set the return value of getColumnCount() to 3. Set return values of getValue(1, 0) = 36.738, getValue(1, 1) = 89.324, getValue(1, 2) = 2.145, getValue(0, 0) = 32.483, getValue(0, 1) = 19.82, getValue(0, 2) = 71.21 and row = 1
	<ul>
		<li>Boundary condition test for column variable.</li>
		<li>Expected output: Returns a double of the summation of values in column 1, resulting in a return value of 128.207.</li>
	</ul>
	</li>
</ol>
 
<hr>
 
_createNumberArray(double[] data)_

Partitions Used in This:

	data = {null, not null}
	
<ol>	
<li>createNumberArrayNullDataTest: data = null
	<ul>
		<li>Covers partition 4.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>
<li>createNumberArrayNegativeDoublesTest: data = [-9.1, -100.43, -99.5555]
	<ul>
		<li>Covers partitions 3. and 5. (negative double input types).</li>
		<li>Expected output: Constructs an array of Number objects = [-9.1, -100.43, -99.5555].</li>
	</ul>
	</li>
<li>createNumberArrayPositiveDoublesTest: data = [123.123123123, 8.888888888]
	<ul>
		<li>Covers partitions 3. and 5. (positive double input types).</li>
		<li>Expected output: Constructs an array of Number objects = [123.123123123, 8.888888888].</li>
	</ul>
	</li>
<li>createNumberArrayIntsTest: data = [1, 2, 3, 4]
	<ul>
		<li>Cover partitions 3. and 5. (integer input types).</li>
		<li>Expected output: Constructs an array of Number objects = [1.00, 2.00, 3.00, 4.00].</li>
	</ul>
	</li>
<li>createNumberArrayMixedTest: data = [20.91123123, -73.12, 7]
	<ul>
		<li>Covers partitions 3. and 5. (mixed input types).</li>
		<li>Expected output: Constructs an array of Number objects = [20.91123123, -73.12, 7.00].</li>
	</ul>
	</li>
</ol>

<hr>
 
_equal(double[][] a, double[][] b)_

Partitions Used in This:

	a = {null, numbers}
	b = {null, numbers}

<ol>
<li>equalNullsTest: a = null and b = null
	<ul>
		<li>Cover partition 4.</li>
		<li>Expected output: Returns true, the arrays a and b can be null.</li>
	</ul>
	</li>
<li>equalNullAndValidTest: a = null and b = {[0, 1, 2], [0, 1, 2]}
	<ul>
		<li>Cover partitions 3. and 4.</li>
		<li>Expected output: Returns false.</li>
	</ul>
	</li>
<li>equalNumbersMatchTest: a = {[0, 1, 2], [3, 4, 5]} and b = {[0, 1, 2], [3, 4, 5]}
	<ul>
		<li>Cover partitions 3. And 5.</li>
		<li>Expected output: Returns true, the values in both arrays a and b match and have the same dimensions.</li>
	</ul>
	</li>
<li>equalNumbersWrongOrderTest: a = {[0, 1, 2], [3, 4, 5]} and b = {[3, 4, 5],[0, 1, 2]}
	<ul>
		<li>Cover partitions 3. And 5.</li>
		<li>Expected output: Returns false, the values in both arrays a and b don’t match (reverse order).</li>
	</ul>
	</li>
<li>equalNumbersDifferentDimensionsTest: a = {[0, 1], [3, 4]} and b = {[0, 1], [3, 4], [NaN, NaN]}
	<ul>
		<li>Cover partitions 3. and 5.</li>
		<li>Expected output: Returns false, the arrays a and b do not have the same dimensions.</li>
	</ul>
	</li>
<li>equalNaNMatchTest: a = {[NaN, NaN]} and b = {[NaN, NaN]}
	<ul>
		<li>Cover partitions 3. and 5.</li>
		<li>Expected output: Returns true, the arrays a and b have the same values (NaNs are considered equal and so are INFs).</li>
	</ul>
	</li>
<li>equalINFMatchTest: a = {[INF, INF]} and b = {[INF, INF]}
	<ul>
		<li>Cover partitions 3. and 5.</li>
		<li>Expected output: Return true, the arrays a and b have the same values (NaNs are considered equal and so are INFs).</li>
	</ul>
	</li>
<li>equalINFAndNaNMatchTest: a = {[INF, INF], [NaN, NaN]} and b = {[INF, INF], [NaN, NaN]}
	<ul>
		<li>Cover partitions 3. and 5.</li>
		<li>Expected output: Return true, the arrays a and b have the same values (NaNs are considered equal and so are INFs).</li>
	</ul>
	</li>
<li>equalINFAndNaNMismatchTest: a = {[INF, INF], [NaN, NaN]} and b = {[NaN, NaN], [INF, INF]}
	<ul>
		<li>Cover partitions 3. and 5.</li>
		<li>Expected output: Return false, the arrays a and b do not have the same values (NaNs are considered equal and so are INFs).</li>
	</ul>
	</li>
</ol>

<hr>

_clone(double [][] source)_

Partitions Used in This:

	source = {null, not null}
	
<ol>
<li>cloneNullTest: source = null
	<ul>
		<li>Covers partition 4.</li>
		<li>Expected output: IllegalArgumentExceptionThrown.</li>	
	</ul>
	</li>
<li>clonePositiveDoublesTest: source = {[12.32, 29.48, 30.7], [91.91, 8.19, 28.29]}
	<ul>
		<li>Covers partition 3. and 5.</li>
		<li>Expected output: a 2D double array, which is the exact copy of the original: {[12.32, 29.48, 30.7], [91.91, 8.19, 28.29]}.</li>
	</ul>
	</li>
<li>cloneNegativeDoublesTest: source = {[-9.88, -9766.2, -0.1], [-0.2], [-908.123]}
	<ul>
		<li>Covers partition 3. and 5.</li>
		<li>Expected output: a 2D double array, which is the exact copy of the original: {[-9.88, -9766.2, -0.1], [-0.2], [-908.123]}.</li>
	</ul>
	</li>
<li>cloneIntegersTest: source = {[-2,3,5], [6,13,-12], [4,9,2], [7,8,9]}
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: a 2D array, which is the exact copy of the original: {[-2,3,5], [6,13,-12], [4,9,2], [7,8,9]}.</li>
	</ul>
	</li>
<li>cloneMixedTest: source = {[12, 13.1, -1, 123.456456]}
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: a 2D double array, which is the exact copy of the original: {[12, 13.1, -1, 123.456456]}.</li>
	</ul>
	</li>
	
</ol>

<hr>

# Division of Effort and Lessons Learned From Teamwork

The team work was divided among the two pairs and the group decided to implement peer programming where one student piloted the writing of the code while the other communicated the created test cases and oversaw the writing of the code. One pair focused on creating test cases on paper for the Range class, whereas the other pair focused on creating test cases on paper for the DataUtilities class. Once the test cases were created, the group came together and developed the code for the tests simultaneously using Replit. The general formatting of the test cases were thought of as a group along with the splitting of each test into general partitions. The lessons learned from the teamwork in this lab were the importance of having an organized approach to developing test cases to be more efficient as a group. Furthermore, this lab allowed us to utilize peer programming in an efficient way, partnered with simultaneous group programming to complete the coding in the least amount of time possible. 

# Difficulties Encountered, Challenges Overcome, and Lessons Learned

Difficulties encountered in this lab were the clarity in the designing of test cases. None of the team members had much experience in the designing of test cases and since the group couldn’t look at the source code the group had to make interpretations about each function. The setup of all the mock objects, specifically the DataUtilities class, took a long time as many mock objects needed to be implemented, especially since this was the first time any of the members had to implement a mock object for testing. Creating and grouping input domains for each method into partitions based on the given requirements was a difficult task and required a lot of correcting and backtracking. One of the challenges that the group encountered was when implementing the test cases into JUnit methods, only one member could code at a time to avoid conflicts in GitHub. To overcome this, the group decided to use Replit which allowed all members of the group to simultaneously code, increasing productivity significantly. Another challenge that the group encountered was the creation of too many test cases per method, which would lead to duplicate test domains. The way the group overcame the challenge was by going through all of the test cases that were created on paper, and deciding which ones were redundant and thus should be discarded after discussing possible duplicates. Through this assignment, the group learned the specifics of black-box testing techniques, in which the source code is not provided, and only the requirements can be scrutinized. Furthermore, this assignment served to further familiarize the group members with JUnit testing and good approaches to take when developing tests, such as splitting them up by partitions. 

# Comments and Feedback on The Lab Assignment

This lab allowed us to better understand how to create unit tests, perform JUnit testing, and work with mock objects in a collaborative environment. Overall, it taught us how to work effectively as a team and use each other's strengths to achieve a common goal. However, the instructions for this lab conflicted with the JavaDocs actually given (in terms of the number of methods). Furthermore, the provided test case example for a mock object did not run without the inclusion of a jar file that students had to externally download. A suggestion for the future would be to ensure that all materials provided work with the system that was provided, and that the instructions matched the JavaDocs to avoid any confusion.
