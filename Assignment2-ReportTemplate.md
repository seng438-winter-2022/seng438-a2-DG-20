# SENG 438 - Software Testing, Reliability, and Quality**
# Lab. Report \#2 – Requirements-Based Test Generation**

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

<ul> 
<li>base = null and factor = -5.345
	<ul>
		<li>Covers partitions 1. and 4.</li>
		<li>Expected output: Error/Exception thrown.</li>
	</ul>
	</li>

<li>2. base = Range(-2.25, 100) and factor = -5.123
	<ul>
		<li>Covers partitions 1. and 5.</li>
		<li>Expected output: Error/Exception thrown.</li>
	</ul>
	</li>

<li>3. base = null and factor = 1000
	<ul>
		<li>Covers partitions 3. and 4.</li>
		<li>Expected output: Error/Exception thrown.</li>
	</ul>
	</li>

<li>4. base = Range(-2.25, 100) and factor = 2.34
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: Range object, where object.getLowerBound() = -5.265 and object.getUpperBound() = 234.00.</li>
	</ul>
	</li>

<li>5. base = Range(-2.25, 100) and factor = 0
	<ul>
		<li>Boundary condition test for factor variable.</li>
		<li>Expected output: Range object, where object.getLowerBound() = 0 and object.getUpperBound() = 0.</li>
	</ul>
	</li>
</ul>

<br>

_shift(Range base, double delta, boolean allowZeroCrossing):_

Partitions Used in This:
	base = {null, not null}
	delta = {any number}
	allowZeroCrossing = {true, false}

<ul>
<li>base = null, delta = -4.2325, allowZeroCrossing = true
	<ul>
		<li>Covers partitions 3., 4., 6.</li>
		<li>Expected output: Error/Exception thrown.</li>
	</ul>
	</li>
<li>base = null, delta = 500000.0, allowZeroCrossing = false
	<ul>
		<li>Covers partitions 3., 4., 7.</li>
		<li>Expected output: Error/Exception thrown.</li>
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
</ul>

<br>
 
_getCentralValue():_

No partitions used in this (no inputs).
 
Create a Range object with lower = 1.0 and upper = 100.00 and call getCentralValue() on it.
Expected output: 49.5 

<br>

_expand(Range range, double lowerMargin, double upperMargin):_

Partitions Used in This:
	range = {null, not null}
	lowerMargin = {any number}
	upperMargin = {any number}
	
<ul>
<li>Range = Range(0.0, 14.0), lowerMargin = -0.10, upperMargin = 3.00
	<ul>
		<li>Covers partitions 3. and 5.</li>
		<li>Expected output: Range object, where object.getLowerBound() = 1.4 and object.getUpperBound() = 56.0.</li>
	</ul>
	</li>
<li>Range = null, lowerMargin = -0.30, upperMargin = 0.10
	<ul>
		<li>Cover partitions 3. and 4.</li>
		<li>Expected output: Error/Exception thrown.</li>
	</ul>
	</li>
<li>Range = Range(-2.0, 99.99), lowerMargin = 0.00, upperMargin = 0.00
	<ul>
		<li>Boundary condition test for lowerMargin and upperMargin variables.</li>
		<li>Expected output: Range object, where object.getLowerBound() = -2.0 and object.getUpperBound() = 99.99.</li>
	</ul>
	</li>
</ul>

<br>
 
_toString():_

No partitions used in this (no inputs).
 
Create a Range object with lower = 1.0 and upper = 100.00 and call toString() on it.
Expected output: "Range[1.0,100.0]".

### DataUtilities



// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
