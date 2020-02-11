### Missing Lowest Positive Integer

Given an array of integers, find the first missing positive integer in linear
time and constant space. In other words, find the lowest positive integer that
does not exist in the array. The array can contain duplicates and negative
numbers as well.

For example, the input `[3, 4, -1, 1]` should give `2`. The input `[1, 2,
0]` should give `3`

and [1, 2, 1] should give 3.

 

Arithmetic Series formula:

n/2[2a + (n-1) d]

5/2 \* (5\**2 + 4) =\> 2 * \* 14 =\> 28

5 + 6 + 7 + 8 + 9 =\> 35

5 + 7 + 8 + 9 =\> 29

 

3,4,-1,1 -\> 2 -\> 4/2[1\**2 + (4-1) *\* 1] =\> 10

1,2,0 -\> 3

5,7,-1, 8,9 -\> 6

 

1,2,1 -\> 3 =\> formula sum = 6 and

 

#### Algo

 

\`\`\`

BruteForce:

Step 1: Sort the array;

Step 2: Find min and Max

Step 3.a: If Max \< Array Size then return Find missing is Array Size

Step 3.b: If Max \> Array then start should be (Max - Array Size) + 1

Step 3.c: Else Loop min to max

 

\`\`\`
