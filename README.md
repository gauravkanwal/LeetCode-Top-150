# LeetCode Top Interview 150 Solutions

This repository contains my solutions to the LeetCode Top Interview 150 problems. Each solution is provided as a separate Java file, with a detailed summary of the approach written below.

## Table of Contents
1. [Merge Sorted Array](#q1-merge-sorted-array)
2. 


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

[View Solution 👈](./solutions/Q1-MergeSortedArray.java)

