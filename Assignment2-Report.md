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

[3 Test Cases Developed](#test-cases-developed)
* [3.1 Range](#range)
* [3.2 DataUtilities](#datautilities)

[4 Notes on The Peer Review Process and Reporting Defects as A Group](#notes-on-the-peer-review-process-and-reporting-defects-as-a-group)

[5 Pair Testing Management and Division of Responsibilities](#pair-testing-management-and-division-of-responsibilities)

[6 Lessons Learned from Teamwork](#lessons-learned-from-teamwork)

[7 Difficulties Encountered, Challenges Overcome, and Lessons Learned](#difficulties-encountered-challenges-overcome-and-lessons-learned)

[8 Comments and Feedback on The Lab Assignment](#comments-and-feedback-on-the-lab-assignment)

<hr>

## Introduction

Text…

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
* getCumulativePercentages(KeyedValues data)

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

<hr>

# Test Cases Developed

### Range

_scale(Range base, double factor):_

Partitions Used in This:
	
	base = {null, not null}
	factor = {negative, non-negative}

<ol> 
<li>base = null and factor = -5.345
	<ul>
		<li>Covers partitions 1. and 4.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>

<li>base = Range(-2.25, 100) and factor = -5.123
	<ul>
		<li>Covers partitions 1. and 5.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>

<li>base = null and factor = 1000
	<ul>
		<li>Covers partitions 3. and 4.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>

<li>base = Range(-2.25, 100) and factor = 2.34
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: Range object, where object.getLowerBound() = -5.265 and object.getUpperBound() = 234.00.</li>
	</ul>
	</li>

<li>base = Range(-2.25, 100) and factor = 0
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
<li>base = null, delta = -4.2325, allowZeroCrossing = true
	<ul>
		<li>Covers partitions 3., 4., 6.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>
<li>base = null, delta = 500000.0, allowZeroCrossing = false
	<ul>
		<li>Covers partitions 3., 4., 7.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>
<li>base = Range(-11.0, 10072.0) delta = 500000.0, allowZeroCrossing = true
	<ul>
		<li>Cover partitions 3., 5., 7.</li>
<li>Expected output: Range object, where object.getLowerBound() = 499989.0 and object.getUpperBound() = 510072.0.</li>
	</ul>
<li>base = Range(3.5, 89.0), delta = -4.2325, allowZeroCrossing = false
	<ul>
		<li>Cover partitions 3., 5., 6.</li>
<li>Expected output: Range object, where object.getLowerBound() = 0.00 and object.getUpperBound() = 84.7675.</li>
	</ul>
<li>base = Range(-50.35, 100.70), delta = 0.0, allowZeroCrossing = true
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
<li>Create a Range object with lower = 1.0 and upper = 100.00 and call getCentralValue() on it.
	<ul>
		<li>Expected output: 50.5</li>
	</ul>
	</li>
<li>Create a Range object with lower = -100.0 and upper = -8.00 and call getCentralValue() on it.
	<ul>
		<li>Expected output: -54.00</li>
	</ul>
	</li>
<li>Create a Range object with lower = -20.00 and upper = -20.00 and call getCentralValue() on it.
	<ul>
		<li>Expected output: 0.00</li>
	</ul>
	</li>
<li>Create a null Range object and call getCentralValue() on it.
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
<li>range = Range(0.0, 14.0), lowerMargin = -0.10, upperMargin = 3.00
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: Range object, where object.getLowerBound() = 1.4 and object.getUpperBound() = 56.0.</li>
	</ul>
	</li>
<li>range = null, lowerMargin = -0.30, upperMargin = 0.10
	<ul>
		<li>Cover partitions 3. and 4.</li>
		<li>Expected output: IllegalArgumentException.</li>
	</ul>
	</li>
<li>range = Range(-2.0, 99.99), lowerMargin = 0.00, upperMargin = 0.00
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
<li>Create a Range object with lower = -12.0 and upper = 100.00 and call toString() on it.
	<ul>
		<li>Expected output: "Range[-12.0,100.0]".</li>
	</ul>
	</li>
<li>Create a null Range object call toString() on it.
	<ul>
		<li>Expected output: NullPointerException thrown.</li>
	</ul>
	</li>
	</ol>

### DataUtilities
_calculateColumnTotal(Values2D data, int column)_

Partitions Used in This:

	data = {null, not null}
	column = {negative, non-negative, above input range}

<ul>
<li>data = null and column = 2
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: IllegalArgumentException thrown.</li>
	</ul>
	</li>
First, create a mock object, set the return value of getRowCount() to 3. Set return values of getValue(0, 2) = 3.123, getValue(1, 2) = 4, getValue(2, 2) = -55.009. Set column = 2
Covers partitions 3. and 6.
Expected output: Returns a double of the summation of values in column 2, resulting in a return value of -47.886
First, create a mock object, set the return value of getRowCount() to 3. Set return values of getValue(0, 2) = 2.873, getValue(1, 2) = 0, getValue(1, 1) = 67.622, getValue(2, 2) = -43.132. Set column = 2
Covers partitions 3. and 6.
Expected output: Returns a double of the summation of values in column 2, resulting in a return value of -40.259
First, create a mock object, set the return value of getRowCount() to 4. Set return values of getValue(0, 3) = 17.17, getValue(1, 3) = -2, getValue(2, 3) = -0.93, getValue(3, 3) = 32.11 and column = -1
Covers partitions 1. and 6.
Expected output: NullPointerException thrown.
First, create a mock object, set the return value of getRowCount() to 3. Set return values of getValue(0, 1) = 90.80, getValue(1, 1) = 88.320, getValue(2, 1) = 7.8123,
getValue(0, 0) = 76.323, getValue(1, 0) = 59.92, getValue(2, 0) = 5.454, and column = 2
Covers partitions 2. and 6.
Expected output: NullPointerException thrown.
First, create a mock object, set the return value of getRowCount() to 3. Set return values of getValue(0, 1) = 58.62, getValue(1, 1) = 98.73, getValue(2, 1) = 5.123, getValue(0, 0) = 5.6, getValue(1, 0) = -9.3, getValue(2, 0) = 501.13 and column = 1
	      -	Boundary condition test for “column” variable.
	      -	Expected output: Returns a double of the summation of values in column 1, resulting in a return value of 162.473
 
 
 
 
calculateRowTotal(Values2D data, int row)
Partitions Used in This:
	data = {null, not null}
	row = {positive number, negative number, above input range}
 
data = null and row = 2
Covers partitions 3. and 4.
Expected output: IllegalArgumentException Thrown.
First, create a mock object, set the return value of getColumnCount() to 3. Set return values of getValue(0, 0) = 8.71, getValue(0, 1) = 1, getValue(0, 2) = -22.394. Set row = 0
Covers partitions 3. and 5.
Expected output: Returns a double of the summation of values in row 0, resulting in a return value of -12.684.
First, create a mock object, set the return value of getColumnCount() to 3. Set return values of getValue(1, 0) = 37.17, getValue(1, 1) = 0, getValue(1, 2) = 63.193, getValue(2, 2) = -200.837. Set row = 1
Covers partitions 3. and 5.
Expected output: Returns a double of the summation of values in column 2, resulting in a return value of -100.474
First, create a mock object, set the return value of getColumnCount() to 4. Set return values of getValue(0, 0) = 17.17, getValue(0, 1) = -9, getValue(0, 2) = -0.123, getValue(0, 3) = 8.127 and row = -1
Covers partitions 1. and 5.
Expected output: NullPointerException thrown.
First, create a mock object, set the return value of getColumnCount() to 3. Set return values of getValue(1, 0) = 90.80, getValue(1, 1) = 88.320, getValue(1, 2) = 7.8123, getValue(0, 0) = 31.912, getValue(0, 1) =8.29, getValue(0, 2) = 14.289 and row = 2
Covers partitions 2. and 6.
Expected output: NullPointerException thrown.
First, create a mock object, set the return value of getColumnCount() to 3. Set return values of getValue(1, 0) = 36.738, getValue(1, 1) = 89.324, getValue(1, 2) = 2.145, getValue(0, 0) = 32.483, getValue(0, 1) = 19.82, getValue(0, 2) = 71.21 and row = 1
	      -	Boundary condition test for column variable
	      -	Expected output: Returns a double of the summation of values in column 1, resulting in a return value of 128.207
 
 
 
 
 
 
createNumberArray(double[] data)
Partitions Used in This:
	data = {null, not null}
data = null
Covers partition 4.
Expected output: IllegalArgumentException thrown.
data = [-9.1, -100.43, -99.5555]
Covers partitions 3. and 5. (negative double input types)
Expected output: Constructs an array of Number objects = [-9.1, -100.43, -99.5555].
data = [123.123123123, 8.888888888]
Covers partitions 3. and 5. (positive double input types)
Expected output: Constructs an array of Number objects = [123.123123123, 8.888888888].
data = [1, 2, 3, 4]
Cover partitions 3. and 5. (integer input types)
Expected output: Constructs an array of Number objects = [1.00, 2.00, 3.00, 4.00
data = [20.91123123, -73.12, 7]
Covers partitions 3. and 5. (mixed input types)
Expected output: Constructs an array of Number objects = [20.91123123, -73.12, 7.00].
 
equal(double[][] a, double[][] b)
Partitions Used in This:
	a = {null, numbers}
	b = {null, numbers}
a = null and b = null
Cover partition 4.
Expected output: Returns true, the arrays a and b can be null.
a = null and b = {[0, 1, 2], [0, 1, 2]}
Cover partitions 3. and 4.
Expected output: Returns false.
a = {[0, 1, 2], [3, 4, 5]} and b = {[0, 1, 2], [3, 4, 5]}
Cover partitions 3. And 5.
Expected output: Returns true, the values in both arrays a and b match and have the same dimensions.
 
a = {[0, 1, 2], [3, 4, 5]} and b = {[3, 4, 5],[0, 1, 2]}
Cover partitions 3. And 5.
Expected output: Returns false, the values in both arrays a and b don’t match (reverse order).
a = {[0, 1], [3, 4]} and b = {[0, 1], [3, 4], [NaN, NaN]}
Cover partitions 3. and 5.
Expected output: Returns false, the arrays a and b do not have the same dimensions.
a = {[null, INF], [null, null]} and b = {[INF, null], [INF, INF]}
Cover partitions 3. and 5.
Expected output: Returns false, the arrays a and b have the same values (NaN considered equal)
a = {[NaN, NaN]} and b = {[NaN, NaN]}
Cover partitions 3. and 5.
Expected output: Returns true, the arrays a and b have the same values (NaNs are considered equal and so are INFs).
a = {[INF, INF]} and b = {[INF, INF]}
Cover partitions 3. and 5.
Expected output: Return true, the arrays a and b have the same values (NaNs are considered equal and so are INFs).
a = {[INF, INF], [NaN, NaN]} and b = {[INF, INF], [NaN, NaN]}
Cover partitions 3. and 5.
Expected output: Return true, the arrays a and b have the same values (NaNs are considered equal and so are INFs).
a = {[INF, INF], [NaN, NaN]} and b = {[NaN, NaN], [INF, INF]}
Cover partitions 3. and 5.
Expected output: Return false, the arrays a and b do not have the same values (NaNs are considered equal and so are INFs).

	</ul>


// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
