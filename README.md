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
  