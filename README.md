# LeetCode Top Interview 150 Solutions

This repository contains my solutions to the LeetCode Top Interview 150 problems. Each solution is provided as a separate Java file, with a detailed summary of the approach written below.

## Table of Contents
- [LeetCode Top Interview 150 Solutions](#leetcode-top-interview-150-solutions)
  - [Table of Contents](#table-of-contents)
  - [Key Ideas or approaches of the problems:](#key-ideas-or-approaches-of-the-problems)
  - [Q1. Merge Sorted Array](#q1-merge-sorted-array)
  - [Q2. Remove Element](#q2-remove-element)
  - [Q3. Remove Duplicates from Sorted Array](#q3-remove-duplicates-from-sorted-array)
  - [Q4. Remove Duplicates from Sorted Array II](#q4-remove-duplicates-from-sorted-array-ii)
  - [Q5. Majority Element](#q5-majority-element)
  - [Q6. Rotate Array](#q6-rotate-array)
  - [Q7. Best Time To Buy And Sell Stock](#q7-best-time-to-buy-and-sell-stock)
  - [Q8. Best Time To Buy And Sell Stock II](#q8-best-time-to-buy-and-sell-stock-ii)
  - [Q9. Jump Game](#q9-jump-game)
  - [Q10. Jump Game II](#q10-jump-game-ii)


## Key Ideas or approaches of the problems:  
  

## Q1. Merge Sorted Array  
  
**Problem link:** 
[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
The main key idea of this problem is to merge two sorted arrays in-place by starting from the end of both arrays. This prevents overwriting elements in the first array (nums1) while merging, as we place larger elements at the end first. The merging process is done by comparing the elements from both arrays and placing the larger element in the correct position of nums1.

We avoid traversing from the front because, if we started from the beginning of nums1, we would risk overwriting elements in nums1 that haven't been merged yet. Since nums1 has extra space at the end (to accommodate the elements from nums2), starting from the back ensures that we can safely compare and place the largest elements without disturbing the already-placed elements in nums1.

By starting from the back:

We can directly place the largest elements from both arrays into their correct positions in nums1 without worrying about shifting elements prematurely.
The last positions of nums1 (the extra space) are filled first, leaving the smaller elements to be placed at the start of the array.

[View Solution 👈](./Solutions/Q1-MergeSortedArray.java)  
  

## Q2. Remove Element  
  
**Problem link:** 
[Remove Element](https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
The main idea of this problem is to maintain a writeIndex variable that keeps track of the index to be filled with a value distinct from val. We iterate over the array, and if nums[i] != val, we fill nums[writeIndex] with nums[i] and then increment both indices. If nums[i] == val, we only increment i, as writeIndex remains unchanged in this case.

[View Solution 👈](./Solutions/Q2-RemoveElement.java)  
  
  
## Q3. Remove Duplicates from Sorted Array  
  
**Problem link:** 
[Remove Duplicates From Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
The main idea of this problem is to maintain a writeIndex variable that keeps track of the index to be filled with a value distinct from its previous one.  
As the array is already sorted this means the previous element from the writeIndex should not be the same as the new value that wants to be filled.  
We iterate over the array, We used (writeIndex<1) which means we fill the first index without checking anything as first element is always unique.  
For >=1 indices : if nums[i] != nums[writeIndex-1], we fill nums[writeIndex] with nums[i] and then increment both indices. Else if nums[i] == nums[writeIndex-1], we only increment i, as writeIndex remains unchanged in this case.

[View Solution 👈](./Solutions/Q3-RemoveDuplicatesFromSortedArray.java)  
  

## Q4. Remove Duplicates from Sorted Array II  
  
**Problem link:** 
[Remove Duplicates From Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
The approach is same as the [previous problem](#q3-remove-duplicates-from-sorted-array).  
As here we can keep maximum of 2 duplicates we will check the second last element of writeIndex i.e. nums[writeIndex-2] should not be equal to the current nums[i] then only we will fill the writeIndex.

[View Solution 👈](./Solutions/Q4-RemoveDuplicatesFromSortedArrayII.java)
  
  

## Q5. Majority Element  
  
**Problem link:** 
[Majority Element](https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150)

**Solution Key Idea or Approach:**  
Key Approach Summary for the Majority Element Solution:
Sorting the Array:

The array is first sorted, which has a time complexity of 
𝑂(𝑛log 𝑛)
O(nlogn). Sorting ensures that if an element is the majority, it will appear consecutively in the middle of the sorted array.
Identifying the Majority Element:

After sorting, the algorithm calculates the required count for a majority element, which is more than half the size of the array (n/2).
A loop is used to check if any element at index i is the same as the element majority - 1 positions ahead. If such an element is found, it is identified as the majority element.
Efficiency:

The approach leverages the sorted order to efficiently determine the majority element with a single scan of the array after sorting.
Return Value:
The identified majority element is returned.
  
Another way of solving this problem is by using a HashMap.
[View Solution 👈](./Solutions/Q5-MajorityElement.java)  
  
    
## Q6. Rotate Array 
  
**Problem link:** 
[Rotate Array](https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
Key Points for the Solution:
Function Purpose:

The rotate function rotates an array nums to the right by k steps.
Handling Rotations:

k = k % n: This step minimizes unnecessary rotations. If k is larger than the array's length n, the effective number of rotations is k % n.
Reversal Method:

The reverse method is a helper function that reverses elements of an array within a specified range (start to end).
Rotation Logic:

Step 1: Reverse the first part of the array from index 0 to n-k-1.
Step 2: Reverse the second part of the array from index n-k to n-1.
Step 3: Reverse the entire array to complete the rotation.
In-Place Modification:

The solution rotates the array in-place, meaning it doesn't use any extra space for another array. It modifies the original array directly.
Time Complexity:

The algorithm runs in O(n) time complexity because each reversal involves traversing part of the array, and in total, the entire array is traversed two times.
Space Complexity:

The space complexity is O(1) as no additional data structures are used except for a few variables.
This solution efficiently rotates an array using a three-step reversal method, making it both time and space-efficient..

[View Solution 👈](./Solutions/Q6-RotateArray.java)    
  
    
## Q7. Best Time To Buy And Sell Stock  
  
**Problem link:** 
[ Best Time To Buy And Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

An initial approach could involve using an array named max_profits to store the maximum number to the right of each element. The result is then calculated by subtracting each element from the maximum number to its right, with the maximum difference being the answer. However, this approach requires two traversals of the array.

We can optimize this by finding the result in a single traversal using the following approach:
Each element checks if it can generate more profit than the previous maximum profit. If the profit from the current element results in a loss (i.e., the profit is less than 0), we reset the currMaxProfit to 0. This approach is similar to Kadane's algorithm, where we track the maximum subarray sum to determine the best possible profit.

[View Solution 👈](./Solutions/Q7-BestTimeToBuyAndSellStock.java)  
  

## Q8. Best Time To Buy And Sell Stock II
  
**Problem link:** 
[ Best Time To Buy And Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

The first approach I thought was to apply the last problem's approach to keep finding the profit for a stock until it is increasing . If the profit of a stock decreases at any point sell that stock on the previous  max profit and buy the new stock that gives less profit,
One better and simpler approach is to maintain a variable start and initialize it with first day's price and if price of the stock increases any day sell that stock and add the profit to maxProfit.Initialize start with current stock value after every iteration.

[View Solution 👈](./Solutions/Q8-BestTimeToBuyAndSellStockII.java)  
  

## Q9. Jump Game
  
**Problem link:** 
[ Jump Game](https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

My key idea was that we iterate from right to left and if we find a 0 value that means it can cause problems. So we check to the left of 0 is there a value that can take us to the right side of 0.  
  
A more simpler code will for this approach that we initialize the variable goal with last index and i with second last index. And if we can reach to the goal from the ith index we initialize goal with the ith index.  
  
We check if we can reach to goal from ith index by :[ i + (maximum jump from i) should be >= goal ]

[View Solution 👈](./Solutions/Q9-JumpGame.java)  
  

## Q10. Jump Game II
  
**Problem link:** 
[ Jump Game II](https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

My key idea was that we iterate from right to left and use two pointers i and j where i=n-1 and j=i-1.
And iterate the array backwards from index j and find the minimum index that can take us to i and then increase the count .The next step is to make i=j , j=i-1 again and start iterating array again backwards and repeat the process until i becomes 0. This way we will find the minimum number of  steps needed to reach n-1 index . But this solution's time complexity is O(n^2).
  
So a O(n) approach would be to using a greedy approach to maximize the reach at each step while keeping track of the current jump's boundary.Whenever we find a new farthest reach we make connection with that index.
Breakdown of the central concepts:  
1. Farthest Reach:
At each index, calculate the farthest index that can be reached using the current jump. This ensures that we are always considering the maximum possible progress at every step.
2. Jump Boundary:
Use a variable (currentEnd) to track the end of the current jump range. Once you reach this boundary, it means you need to make another jump to continue progressing.
3. Greedy Decision Making:
Always aim to reach the farthest possible point with each jump. By making greedy choices, the algorithm minimizes the total number of jumps.
4. Efficiency:
This approach only iterates through the array once, updating the farthest reach and jump boundaries as necessary. By avoiding redundant calculations, the time complexity is reduced to 
O(n).
5. Termination Condition:
The loop stops as soon as the farthest reach is greater than or equal to the last index. This ensures that the algorithm doesn't perform unnecessary calculations once the goal is reached.
Example Walkthrough with Key Steps:
At each index:
Update farthest: Calculate the farthest index you can reach from the current index.
Check currentEnd: If the current index reaches the end of the current jump's range (currentEnd), increment the jump count and update currentEnd to farthest.
Stop when currentEnd reaches or exceeds the last index: This indicates that the last position is within reach with the current or next jump
[View Solution 👈](./Solutions/Q10-JumpGameII.java)
  