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
  - [Q11. H-Index](#q11-h-index)
  - [Q12. Insert Delete GetRandom O(1)](#q12-insert-delete-getrandom-o1)
  - [Q13. Product of Array Except Self](#q13-product-of-array-except-self)
  - [Q14. Gas Station](#q14-gas-station)
  - [Q15. Candy](#q15-candy)
  - [Q16. Trapping Rain Water](#q16-trapping-rain-water)
  - [Q17. Roman To Integer](#q17-roman-to-integer)
  - [Q18. Integer To Roman](#q18-integer-to-roman)
  - [Q19. Length of Last Word](#q19-length-of-last-word)
  - [Q20. Longest Common Prefix](#q20-longest-common-prefix)
  - [Q21. Reverse Words in a String](#q21-reverse-words-in-a-string)
  - [Q22. Zigzag Conversion](#q22-zigzag-conversion)
  - [Q23. Find the Index of the First Occurrence in a String](#q23-find-the-index-of-the-first-occurrence-in-a-string)
  - [Q24. Text Justification](#q24-text-justification)
  - [Q25. Vaild Palindrome](#q25-valid-palindrome)
  - [Q26. Is Subsequence](#q26-is-subsequence)
  - [Q27. Two Sum II - Input Array Is Sorted](#q27-two-sum-ii---input-array-is-sorted)
  - [Q28. Container With Most Water](#q28-container-with-most-water)
  - [Q29. 3Sum](#q29-3sum)
  - [Q30. Minimum SIze Subarray Sum](#q30-minimum-size-subarray-sum)
  - [Q31. Longest Substring Without Repeating Characters](#q31-longest-substring-without-repeating-characters)
  - [Q32. Substring with Concatenation of All Words](#q32-substring-with-concatenation-of-all-words)
  - [Q33. Minimum Window Substring](#q33-minimum-window-substring)
  - [Q34. Valid Sudoku](#q34-valid-sudoku)
  - [Q35. Spiral Matrix](#q35-spiral-matrix)
  - [Q36. Rotate Image](#q36-rotate-image)
  - [Q37. Set Matrix Zeroes](#q37-set-matrix-zeroes)
  - [Q38. Game of Life](#q38-game-of-life)
  - [Q39. Ransom Note](#q39-ransom-note)
  - [Q40. Isomorphic Strings](#q40-isomorphic-strings)
  - [Q41. Word Pattern](#q41-word-pattern)
  - [Q42. Valid Anagram](#q42-valid-anagram)
  - [Q43. Group Anagrams](#q43-group-anagrams)
  - [Q44. Two Sum](#q44-two-sum)
  - [Q45. Happy Number](#q45-happy-number)
  - [Q46. Contains Duplicate II](#q46-contains-duplicate-ii)
  - [Q47. Longest Consecutive Sequence](#q47-longest-consecutive-sequence)
  - [Q48. Summary Ranges](#q48-summary-ranges)
  - [Q49. Merge Intervals](#q49-merge-intervals)
  - [Q50. Insert Interval](#q50-insert-interval)
  - [Q51. Minimum Number of Arrows to Burst Balloons](#q51-minimum-number-of-arrows-to-burst-balloons)
  - [Q52. Valid Parentheses](#q52-valid-parentheses)
  

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
Logic of increasing the jump count when you reach maxIndex is on the right track conceptually, but without a separate variable like currEnd, it’s hard to know when you’ve exhausted the current jump’s range. currEnd is the marker that tells you, "Okay, we can't extend this jump any further; it's time to commit to it and set a new range based on what we've seen."
[View Solution 👈](./Solutions/Q10-JumpGameII.java)  
  
  
## Q11. H-Index
  
**Problem link:** 
[H-Index](https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

 1. Bucket Counting:
- Instead of sorting the entire array, the code creates a **bucket array** where each index represents a specific number of citations.
- Each bucket (`buckets[i]`) counts how many papers have exactly `i` citations.

 2. Handling Large Citations:
- Any paper with citations greater than or equal to `n` (the total number of papers) is placed in the last bucket (`buckets[n]`). This effectively caps the maximum citations considered for the h-index calculation to `n`.

 3. Efficient Cumulative Count:
- The code iterates backward through the `buckets` array, accumulating the number of papers with at least `i` citations.
- Once it finds the largest `i` where the cumulative count of papers (`count`) is greater than or equal to `i`, it determines this `i` as the h-index.

 Why This Works:
- The h-index requires finding the maximum `h` where there are at least `h` papers with `h` citations. By using bucket counting, the code efficiently counts and accumulates citation data without the need for sorting, which would take more time.

 Advantages of This Key Idea:
- **Time Efficiency**: The bucket counting approach runs in O(n) time complexity, making it efficient for large datasets.
- **Space Efficiency**: The extra space used (bucket array) is proportional to the number of papers, making it manageable.

 Summary:
The key idea is to **use a counting mechanism (buckets)** to avoid sorting and directly determine the h-index by accumulating citation counts.


[View Solution 👈](./Solutions/Q11-h-Index.java)  
  
  

## Q12. Insert Delete GetRandom O(1)
  
**Problem link:** 
[ Insert Delete GetRandom O(1) ](https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

Initially, we used a HashSet to store the elements, which ensured O(1) time complexity for insertion and removal. However, getting a random element from the HashSet was causing O(n) time complexity because HashSet does not allow accessing elements by index. We had to iterate over the entire set to get a random element, which was inefficient.

To improve this, we switched to a combination of ArrayList and HashSet. The ArrayList allowed us to access elements by index, making the getRandom() method an O(1) operation. However, when removing elements, we encountered the issue of not knowing the index of the element to remove, which led to O(n) time complexity for removal.

The key idea in the final solution is using both HashMap and ArrayList:

HashMap stores the element as the key and its corresponding index in the ArrayList as the value. This allows us to get the index of any element in O(1) time.
ArrayList allows us to access elements by index in O(1) time.
To remove an element efficiently, instead of removing the element directly, we swap it with the last element in the ArrayList and then remove the last element. This ensures that removal also happens in O(1) time.
Finally, the listSize variable keeps track of the current size of the ArrayList, enabling efficient random access and removal.
This approach ensures that all operations (insert, remove, and getRandom) are executed in O(1) time.


[View Solution 👈](./Solutions/Q12-InsertDeleteGetRandomO(1).java)   
  

## Q13. Product of Array Except Self
  
**Problem link:** 
[ Product of Array Except Self ](https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

First Approach: Using Prefix and Suffix Products

Prefix Product Calculation: Create prefixProduct where each element is the product of all elements before it in nums.

Suffix Product Calculation: Create suffixProduct where each element is the product of all elements after it in nums.

Final Output: Multiply corresponding elements of prefixProduct and suffixProduct.

Time Complexity: O(n) (three passes through nums).
Space Complexity: O(n) (two additional arrays).

Improved Approach: Optimized Space Complexity

Single Output Array: Use a single array ans to store prefix products initially.

Combine Suffix Calculation: In a second pass, calculate suffix products and update ans on the fly.

Time Complexity: O(n) (two passes through nums).
Space Complexity: O(1) (ignoring the output array).

Summary

First Approach: O(n) time, O(n) space.

Improved Approach: O(n) time, O(1) space (excluding the output array).



[View Solution 👈](./Solutions/Q13-ProductOfArrayExceptSelf.java) 
  


## Q14. Gas Station
  
**Problem link:** 
[ Gas Station ](https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

Main key ideas for this problem are:
1. If total cost > total gas , there is no way to complete the rotation.
2. Else we only have to find the correct starting point . For this the main idea is that if you start at station i and can't reach station j, then no station k (where i < k ≤ j) can be the starting point either, because the gas accumulated between i and k is less than the cost.This allows us to skip certain starting points instead of iterating through all of them. So we put the next starting point direct as j+1.
  

Algorithm:

Calculate the total gas (totalGas) and total cost (totalCost).
If totalGas < totalCost, it's impossible to complete the circuit, so return -1.
Use a currentGas variable to track the remaining gas while traversing. If currentGas becomes negative at station i, reset the starting station to i+1 and reset currentGas.



[View Solution 👈](./Solutions/Q14-GasStation.java) 
  


## Q15. Candy
  
**Problem link:** 
[ Candy ](https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

My Approach:<!-- omit in toc -->
------------

The problem requires distributing candies to children such that:

Each child must have at least one candy.
A child with a higher rating must get more candies than their neighbors.
This approach solves the problem in two main passes:

Left-to-Right Pass:

Start by assigning one candy to each child (candies[i] = 1).
For every child i from left to right:
If the rating of the current child (ratings[i]) is greater than the rating of the previous child (ratings[i-1]), assign the current child candies[i-1] + 1 candies.
Maintain a running total (totalCandies) of all candies during this pass.
Right-to-Left Pass:

Traverse the array from right to left.
For every child i:
If the rating of the current child (ratings[i]) is greater than the rating of the next child (ratings[i+1]), update the current child's candy count to be the maximum of its current candy count and candies[i+1] + 1.
Adjust the totalCandies to account for changes in candy distribution.
Key Insight:
The two-pass strategy ensures that the candy distribution satisfies the constraints in both directions:

The left-to-right pass ensures that children with higher ratings than their left neighbors get more candies.
The right-to-left pass ensures the same for children with higher ratings than their right neighbors, while also maintaining the larger candy count from both passes.
This results in an optimal candy distribution in O(n) time and O(n) space.

Optimal Approach:<!-- omit in toc -->
-----------------
  

The solution relies on identifying and handling three distinct segments in the ratings array:

Flat Segment:

If consecutive ratings are equal, no additional candies are needed for these children; they each get exactly one candy.
Increasing Slope:

When ratings are increasing, the candies are distributed in ascending order. For example, if the slope length is 3, the candies would be distributed as 1, 2, 3.
The length of this increasing slope (peak) determines the additional candies required.
Decreasing Slope:

When ratings are decreasing, candies are distributed in descending order. For example, if the slope length is 3, the candies would be distributed as 3, 2, 1.
The length of this decreasing slope (valley) determines the additional candies required.
Peak Adjustment:

If an increasing slope is immediately followed by a decreasing slope, the peak value (highest point in the increasing slope) will be double-counted.
To correct this, subtract the smaller of the peak or valley length from the total candies.
Key Insights:
Efficiency: By analyzing the slopes in a single traversal, the solution avoids the need for separate passes or arrays, making it highly efficient.
Dynamic Candy Adjustment: The algorithm dynamically calculates the total candies required without pre-computing values for each child.
Double-Counting Fix: Adjusting for the overlap at the peak ensures that candies are distributed optimally.
This approach ensures the problem's constraints are met with an efficient O(n) time complexity and O(1) space complexity.

[View Solution 👈](./Solutions/Q15-Candy.java)  
  

## Q16. Trapping Rain Water
  
**Problem link:** 
[ Trapping Rain Water ](https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

My Approach:<!-- omit in toc -->
------------  
We start with two pointers, i and j, where i represents the left tallest bar, and j is the closest bar to i that is greater than or equal to the height of i. We increment j until we find such a bar. Once we find that bar, we add the trapped water between these two bars to res. After this, we update i to j and repeat the process.

However, if there is no taller bar than height[i], j will become equal to n, and we may miss all the trapped water between i and n-1. To handle this case, we traverse the array from the back until the last value of i to ensure that no trapped water is missed.
     
Optimal approach:<!-- omit in toc -->
----------------- 
Instead of starting both pointers together (which can lead to traversing the array twice in the worst case), we can optimize the process by using two pointers:

maxLeft initialized at index 0.  
maxRight initialized at index n-1.  
Additionally, we have two other pointers:  
left initialized at 1.  
right initialized at n-2.  
  
Algorithm:  
Compare the values of maxLeft and maxRight.  
Whichever is smaller (maxLeft or maxRight), check its corresponding pointer:  
If maxLeft is smaller, check the value at left:  
If array[left] > maxLeft, update maxLeft.  
Otherwise, add (maxLeft - array[left]) to the result (trapped water).  
Increment the left pointer.  
If maxRight is smaller, check the value at right:  
If array[right] > maxRight, update maxRight.  
Otherwise, add (maxRight - array[right]) to the result (trapped water).  
Decrement the right pointer.  
This approach ensures that we process each element only once, making it more efficient.  
[View Solution 👈](./Solutions/Q16-TrappingRainWater.java)  
  

## Q17. Roman To Integer
  
**Problem link:** 
[ Roman To Integer ](https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  

We map all the value like I=1 ,V=5 etc in a HashMap. Then we just iterate the string s and check if the current character's value is less than the next character's value. If yes we subtract the current character's value otherwise we add current character's value.  
[View Solution 👈](./Solutions/Q17-RomanToInteger.java)  
  

## Q18. Integer To Roman
  
**Problem link:** 
[ Integer To Roman ](https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We start by initializing an empty StringBuilder named res to store the resulting Roman numeral. We also use two arrays: nums, which contains integer values in ascending order, and romans, which holds their corresponding Roman numeral symbols.

The algorithm works by iterating through the nums array from right to left. In each iteration, we check for the largest number in nums that is less than or equal to the current value of num. When such a number is found, we append its corresponding Roman numeral symbol from the romans array to res and subtract the number from num. This process repeats until num is reduced to 0, at which point res contains the complete Roman numeral representation of the original number.
[View Solution 👈](./Solutions/Q18-IntegerToRoman.java)   
  
  
## Q19. Length of Last Word
  
**Problem link:** 
[  Length of Last Word ](https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We initialize a variable count and iterate the string brof right to left . Whenever we find a space we check if count>0 if yes we return count otherwise loop continues. If the loop ends we return count.
[View Solution 👈](./Solutions/Q19-LengthOfLastWord.java)  


## Q20. Longest Common Prefix
  
**Problem link:** 
[  Longest Common Prefix ](https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
First Solution:<!-- omit in toc -->
-------------
The idea is to create a seprate function commonPrefix() which gives common prefix between two strings. Then initialize a String res="" and iterate over the strs array and update res=commonPrefix(res,strs[i]) and return res at the end of loop.
  
Second Solution:<!--omit in toc-->
----------------
We sort the array in lexicographical order i.e. dictionary order and then directly compare the first and the last strings of the array.  
[View Solution 👈](./Solutions/Q20-LongestCommonPrefix.java)   
  

## Q21. Reverse Words in a String
  
**Problem link:** 
[  Reverse Words in a String ](https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use an empty StringBuilder str. Then we loop through the input string and find index of a word's starting and ending point and append it to stringbuilder. 
  
Iterate through the string while tracking word boundaries.
Extract each word using substring(temp, i) whenever a non-space character is found.
Insert words at the beginning of StringBuilder to maintain reverse order.
Skip spaces efficiently to handle multiple spaces properly.
Return the final reversed sentence as a string.  

🔹 Why this works?

Preserves word order in reverse by inserting at the start.
Handles multiple spaces naturally without extra processing.
Uses StringBuilder efficiently instead of additional data structures. 🚀

[View Solution 👈](./Solutions/Q21-ReverseWordsInAString.java)   
  

## Q22. Zigzag Conversion
  
**Problem Link:**
[Zigzag Conversion ](https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We initialize an array of StringBuilders of size numRows and a StringBuilder ans. And then we loop the input string and for each StringBuilder  in the array we add the correct string index wise.
The main key point here is to use a boolean forward to check ig we have to go forward or backward in array. 
[View Solution 👈](./Solutions/Q22-ZigzagConversion.java)   
  
  
## Q23. Find the Index of the First Occurrence in a String
  
**Problem Link:**
[Find the Index of the First Occurrence in a String ](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
 MY Solution:
 ------------
 Two pointers (i for haystack, j for needle) track matching characters.
If characters match, j moves forward to check the next character of needle.
If a mismatch occurs after some matches (j > 0):
i -= j moves i back to the position where the match started.
Then, i++ ensures the next attempt starts from the next position after the failed match (avoiding an infinite loop).
j = 0 resets needle tracking to start fresh.
If j == n, a full match is found at i - n.
If no match is found, return -1.
This method avoids checking every position from scratch, making it more efficient than a naive brute-force approach. 🚀
[View Solution 👈](./Solutions/Q23-FindTheIndexOfTheFirstOccurrenceInAString.java)   
  

## Q24. Text Justification
  
**Problem Link:**
[Text Justification ](https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We break the problem into separate functions to solve it step by step. The functions we create are:

1. Finding the end index for each starting index, ensuring the words fit within maxWidth.
2. Generating spaces as a string of a given length.
3. Justifying a line from start to end in the words array, ensuring proper spacing.  

The solution follows these steps:

-> For each start index, we find the corresponding end index using the first function.  
-> We then justify the line from start to end using the justification function.  
-> The justified line is added to the result array.  
-> Finally, we update start = end + 1 to process the next line..  
[View Solution 👈](./Solutions/Q24-TextJustification.java)   
  

## Q25. Valid Palindrome
  
**Problem Link:**
[Valid Palindrome ](https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use the method Character.isLetterOrDigit(ch) to check if ch is alphanumeric. We initialize two pointers: i = 0 and j = s.length() - 1. Then, we increment i and decrement j until we find an alphanumeric character. After that, we compare both characters after converting them to lowercase. If they are not equal, we return false. Finally, after the loop completes which means the string is valid palindrome, we return true.  
[View Solution 👈](./Solutions/Q25-ValidPalindrome.java)   
  

## Q26. Is Subsequence
  
**Problem Link:**
[Is Subsequence ](https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use two pointers i for s string and j for t string. Then we run a loop on t string by incrementing j index after every iteration and start matching characters of both strings if they match we increase i index . And if at any point i==m we return true.   
[View Solution 👈](./Solutions/Q26-IsSubsequence.java)  


## Q27. Two Sum II - Input Array Is Sorted
  
**Problem Link:**
[Two Sum II - Input Array Is Sorted ](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use two pointers i=0 and j=numbers.length-1. We compare numbers[i]+numbers[j] with target and move i and j accordingly. Whenever we find numbers[i]==numbers[j] we return a new array with values i+1 and j+1;   
[View Solution 👈](./Solutions/Q27-TwoSumII-InputArrayIsSorted.java)   


## Q28. Container With Most Water
  
**Problem Link:**
[Container With Most Water ](https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use two pointers i=0 and j=heights.length-1. We calculate water between two index by  
 currWater=Math.min(height[i],height[j])*(j-i);  
And keep track of the maximum water level. We increment i if heights[i]<=heights[j] else we decrement j. At last we return the maximum water level.
[View Solution 👈](./Solutions/Q28-ContainerWithMostWater.java)   


## Q29. 3sum
  
**Problem Link:**
[3Sum ](https://leetcode.com/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
1️⃣ Sort the Array  
Sorting helps efficiently find pairs that sum to a target value.
🔹 Why sort?  
Makes duplicate removal easier.
Allows the use of the two-pointer technique for faster searching.  
  
2️⃣ Fix the First Element (i) & Find Two Other Numbers (left & right)
Iterate i from 0 to n-1 (we need at least 3 numbers).
Use two pointers:
left = i + 1 (next element)
right = n - 1 (last element)
Goal: Find two numbers that sum to -nums[i].  
   
3️⃣ Use Two-Pointer Technique to Find left & right
If nums[left] + nums[right] > target, decrease right (need a smaller sum).
If nums[left] + nums[right] < target, increase left (need a larger sum).
If they add up to target, store the triplet and skip duplicates.  
  
4️⃣ Skip Duplicates to Avoid Repeated Triplets  
For i: If nums[i] == nums[i - 1], skip to the next distinct number.
For left and right: If nums[left] or nums[right] is the same as the previous, move to the next distinct element.  
[View Solution 👈](./Solutions/Q29-3Sum.java)   


## Q30. Minimum Size Subarray Sum
  
**Problem Link:**
[Minimum Size Subarray Sum ](https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use a sliding winodow approach if the sum of window is less than target we expand the window otherwise we update the answer and shrink the window.   
[View Solution 👈](./Solutions/Q30-MinimumSizeSubarraySum.java)   


## Q31. Longest Substring Without Repeating Characters
  
**Problem Link:**
[Longest Substring Without Repeating Characters ](https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use a hash set to check if a character is already present in the selected substring. Then we find the result by sliding winodow approach: if the character is not present in substring we expand the window otherwise shrink the window.At last we return the maximum length of window at any time.   
[View Solution 👈](./Solutions/Q31-LongestSubstringWithoutRepeatingCharacters.java)   


## Q32. Substring with Concatenation of All Words
  
**Problem Link:**
[Substring with Concatenation of All Words ](https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use a Sliding Window + HashMap approach to efficiently find all starting indices where the concatenation of all words in words[] appears as a contiguous substring in s.   
   
**Why Sliding Window?**  

Instead of checking every substring independently (O(NM) brute force), we slide a window across s, processing words in-place to reduce redundant computations.  
  
**Why HashMap?**  
We use two HashMaps:  
  
wordMap → Stores the frequency of words from words[].  
seenWords → Tracks words inside the current window.    
  
**Why Run the Algorithm wordLen Times?**    
Since words in words[] have a fixed length wordLen, we start the sliding window at every possible offset from 0 to wordLen - 1.  
  
This ensures we catch all possible valid substrings, even when words start at different positions.  
Otherwise, we might miss valid combinations due to misalignment.  
  
**Overall Optimization:**  
Each word is checked only once per shift → O(N / wordLen) outer loop.  
Each inner iteration processes words in-place → O(N) complexity.  
Total complexity: O(N * W), where W = wordLen, making it much faster than brute force.  
🚀 This ensures an optimal and efficient solution for large inputs.  
  
[View Solution 👈](./Solutions/Q32-SubstringWithConcatenationOfAllWords.java)   


## Q33. Minimum Window Substring
  
**Problem Link:**
[Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use sliding window approach to solve this problem . We increase the window until we found a valid ans and after founding the valid answer we shrink the window to check if there's a less sized window .  
To match the strings with t, we use an array map of size 128 (for ASCII characters) to store the frequency of characters in t. As we expand the window by moving the right pointer, we decrement the corresponding character count in map. If a character in s is part of t and its count in map is still non-negative, we increase the matchedCount, which tracks how many required characters are fully matched.
  
Once all characters of t are matched (matchedCount == t.length()), we attempt to shrink the window from the left by moving the left pointer. While shrinking, we restore the character count in map and check if removing s[left] causes a mismatch. If it does, we stop shrinking and continue expanding to find another valid window. Throughout this process, we keep track of the smallest valid window found so far and return it as the result. This ensures we get the minimum window substring efficiently.
[View Solution 👈](./Solutions/Q33-MinimumWindowSubstring.java)   

## Q34. Valid Sudoku
  
**Problem Link:**
[Valid Sudoku](https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
## 🔹 First Approach: Using Multiple Loops (Brute Force)

### Summary:
- We check **each row, column, and 3×3 sub-box separately** using **three independent loops**.
- For each check, a **HashSet** is used to track encountered numbers.
- If a duplicate is found in any row, column, or sub-box, return `false`.

### Key Points:
✅ Easy to understand  
✅ Uses three HashSets for better clarity  
❌ Inefficient due to three separate loops  
❌ Unnecessary HashSet creation in each iteration  

---

## 🔹 Second Approach: Using a Single HashSet (Optimized)

### Summary:
- Instead of multiple loops, we **combine all three checks** inside a **single loop**.
- Use **one HashSet** to store unique keys in the format:
  - `"5 in row 0"` → Tracks row uniqueness.
  - `"5 in column 3"` → Tracks column uniqueness.
  - `"5 in box 0-1"` → Tracks 3×3 sub-box uniqueness.
- If any key already exists in the HashSet, return `false`.

### Key Points:
✅ **Single loop** to handle all conditions  
✅ **Simplifies logic** compared to multiple loops  
✅ **Less memory usage** than brute force  
❌ **String operations** (slightly slower than direct array checks)  

---

## 🔹 Third Approach: Using 3 Boolean 2D Arrays (Most Optimal)

### Summary:
- Instead of using **a HashSet**, we use **three 2D boolean arrays** to track:
  1. `rowCheck[9][9]` → Tracks if a number appears in a row.
  2. `colCheck[9][9]` → Tracks if a number appears in a column.
  3. `boxCheck[9][9]` → Tracks if a number appears in a 3×3 sub-box.
- Since numbers in Sudoku are **between 1 and 9**, we map them to an index (`num = board[i][j] - '1'`).
- The **3×3 box index** is calculated using:  
  ```java
  boxCheck[(i / 3) * 3 + (j / 3)][num]

[View Solution 👈](./Solutions/Q34-ValidSudoku.java)   

## Q35. Spiral Matrix
  
**Problem Link:**
[Spiral Matrix](https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We traverse to right then to down then to left and then to up . We maintain another 2Darray visited where we check if the index is visited before or not so that we don't add duplicate elements.

[View Solution 👈](./Solutions/Q35-SpiralMatrix.java)   

## Q36. Rotate Image
  
**Problem Link:**
[Rotate Image](https://leetcode.com/problems/rotate-image/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
first transpose the matrix i.e. swap matrix[i][j] with matrix[j][i]  
then flip the matrix hoeizontally i.e. swap matrix[i][j] with matrix[i][n-1-j]

[View Solution 👈](./Solutions/Q36-RotateImage.java)   

## Q37. Set Matrix Zeroes
  
**Problem Link:**
[Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
## Initial HashSet Approach (O(m + n) Space)
We initially used two HashSets (`rowSet` and `colSet`) to store row and column indices that should be set to zero.

### Steps:
1. **First Pass:** Traverse the matrix and store row and column indices where `matrix[i][j] == 0` in `rowSet` and `colSet`.
2. **Second Pass:** Use `rowSet` to set entire rows to zero.
3. **Third Pass:** Use `colSet` to set entire columns to zero.

### Issue:
- Extra space of **O(m + n)** is used for HashSets, which can be optimized.

---

## Optimizing to O(1) Space using the Matrix itself
To eliminate the extra space, we can use the **first row and first column as markers** instead of HashSets.

### **Key Insight:**
- Instead of using separate data structures, we store zero indicators directly in the first row and first column.

### **Optimized Steps:**
1. **Check if the first row or first column should be zeroed** (since they will be used as markers).
2. **Mark zeroes in the first row and column:** If `matrix[i][j] == 0`, mark `matrix[i][0] = 0` and `matrix[0][j] = 0`.
3. **Use these markers to zero out other cells:**
   - If `matrix[i][0] == 0`, zero out the entire row `i`.
   - If `matrix[0][j] == 0`, zero out the entire column `j`.
4. **Handle the first row and column separately**, as they were originally part of the input and not just markers.

---

### **Why is This Better?**
| Approach             | Time Complexity | Space Complexity |
|----------------------|----------------|------------------|
| **HashSet Approach** | O(m × n)        | **O(m + n)**      |
| **Optimized Approach** | O(m × n)        | **O(1)**          |

- The optimized approach achieves the same result while eliminating extra space by cleverly reusing the matrix itself.
- This is a classic example of how **in-place modifications** can improve efficiency without affecting correctness.

[View Solution 👈](./Solutions/Q37-SetMatrixZeroes.java)   


## Q38. Game of Life
  
**Problem Link:**
[Game of Life](https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
The brute force approach for this problem would be to use another 2D array, but we need to come up with a solution that uses O(1) extra space. To achieve this, we track the changes as follows:

    If an element transitions from dead to live, we set it as 2.
    If an element transitions from live to dead, we set it as -1.

This way, we can retain both the previous and next states of each element.

Finally, we modify the array according to the next state of each element:

We set elements with a value of 2 to 1.
We set elements with a value of -1 to 0.

[View Solution 👈](./Solutions/Q38-GameOfLife.java)   


## Q39. Ransom Note
  
**Problem Link:**
[Ransom Note](https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
1. HashMap Approach
Uses a HashMap<Character, Integer> to store character frequencies of magazine.

Iterates through ransomNote, checking if each character exists in magaMap with a non-zero count.

If a character is missing or exhausted, returns false, otherwise decrements the count.

Time Complexity: O(n+m), where n is the length of ransomNote and m is the length of magazine.

Space Complexity: O(∣Σ∣), where Σ
Σ is the character set (26 for lowercase English letters).

2. Optimized Array Approach
Uses an int[26] array instead of a HashMap for character frequency counting.

Array lookup is faster (𝑂(1)) compared to HashMap operations.

Time Complexity: 
𝑂(𝑛+𝑚), same as HashMap but with lower overhead.

Space Complexity: 𝑂(1)
O(1), as it always uses a fixed-size array.

✅ Conclusion: The array approach is more memory-efficient and faster due to constant-time lookups. 🚀

[View Solution 👈](./Solutions/Q39-RansomNote.java)   


## Q40. Isomorphic Strings
  
**Problem Link:**
[Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
We use two hashmaps one for s string and one for t string. If we get a different value than previously mapped value for a character we return false. If not at last after checking al;l characters in both strings we return true. 
[View Solution 👈](./Solutions/Q40-IsomorphicStrings.java)   

## Q41. Word Pattern
  
**Problem Link:**
[Word Pattern](https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
The code checks if a string s follows the same pattern as the string pattern.

It uses two hash maps:

patternMap to map each character in pattern to a word in s.

sMap to map each word in s back to a character in pattern (for bijective mapping).

It splits s manually by spaces while iterating over pattern.

For each character-word pair, it ensures:

The current character maps to the same word as before (if already mapped).

The current word maps to the same character as before.

If any mismatch or length inconsistency occurs, it returns false.

✅ If all mappings are consistent and lengths match, it returns true.  
[View Solution 👈](./Solutions/Q41-WordPattern.java)   


## Q42. Valid Anagram
  
**Problem Link:**
[Valid Anagram](https://leetcode.com/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
✅ HashMap Approach
Uses a HashMap to count character frequencies in s, then decrements for each character in t.
If all frequencies balance out and the map is empty, the strings are anagrams.
Time: O(n), Space: O(1) (for fixed charset)

✅ Array Approach
Uses an int[26] array for character counts (only lowercase letters).
Increments for s, decrements for t, then checks if all counts are zero.
Time: O(n), Space: O(1)
[View Solution 👈](./Solutions/Q42-ValidAnagram.java) 


## Q43. Group Anagrams
  
**Problem Link:**
[Group Anagrams](https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
Anagrams have the same characters in different order.

So, for each string, sort its characters to get a common key for all its anagrams.

Use a HashMap where:

Key = sorted version of the string

Value = list of original strings that are anagrams

Finally, return all values from the map.

This ensures all anagrams are grouped together efficiently.
[View Solution 👈](./Solutions/Q43-GroupAnagrams.java) 


## Q44. Two Sum
  
**Problem Link:**
[Two Sum](https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
Initialize a HashMap to store numbers and their indices:
map<number, index>

Iterate through the array:

For each nums[i], compute the complement: target - nums[i]

If complement exists in the map, return its index and current index.

Else, store nums[i] and its index in the map.

Why it works:

Ensures we find the pair in O(n) time.

Handles duplicates naturally by checking while iterating.


[View Solution 👈](./Solutions/Q44-TwoSum.java) 


## Q45. Happy Number
  
**Problem Link:**
[Happy Number](https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
To determine if a number is happy, repeatedly replace the number with the sum of the squares of its digits. If this process eventually leads to 1, the number is happy. If it enters a cycle (i.e., a repeated number that doesn’t reach 1), then it’s not happy.

We use a HashSet to keep track of numbers we've seen before to detect cycles.
If we see a number again, it means we’re in a loop — so return false.
If we reach 1, return true.

[View Solution 👈](./Solutions/Q45-HappyNumber.java) 


## Q46. Contains Duplicate II
  
**Problem Link:**
[Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
  1. HashMap Approach – Track Last Seen Index
Key Idea:
Use a HashMap to store the last seen index of each number.
If you encounter the same number again and the index difference ≤ k, return true.

  2. HashSet + Sliding Window Approach – Maintain Recent Elements
Key Idea:
Use a HashSet as a sliding window of size k to store recently seen elements.
If a number already exists in the window, return true.
Otherwise, keep adding current elements and remove the oldest one when the window exceeds size k.

[View Solution 👈](./Solutions/Q46-ContainsDuplicateII.java) 


## Q47. Longest Consecutive Sequence
  
**Problem Link:**
[Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
Use a HashSet to store all numbers for O(1) lookups.
Then, for each number, only start counting a sequence if it's the beginning (i.e., num - 1 is not in the set).
From there, count how long the consecutive sequence continues by checking num + 1, num + 2, etc.
This ensures each number is visited at most once, giving an optimal O(n) time solution.


[View Solution 👈](./Solutions/Q47-LongestConsecutiveSequence.java) 


## Q48. Summary Ranges
  
**Problem Link:**
[Summary Ranges](https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
Use two pointers to find continuous increasing sequences. When a sequence ends, build the corresponding range string using StringBuilder and add it to the result list.
  
[View Solution 👈](./Solutions/Q48-SummaryRanges.java) 


## Q49. Merge Intervals
  
**Problem Link:**
[Merge Intervals](https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
Sort all intervals by their starting point to bring overlapping ones together.

Iterate through intervals and keep track of the current merged interval.

If the next interval overlaps (i.e., its start ≤ current end), merge by extending the end.

If it doesn't overlap, add the current interval to the result and move to the next one.

After the loop, add the last merged interval.

➡️ This ensures all overlapping intervals are combined efficiently in a single pass after sorting.
  
[View Solution 👈](./Solutions/Q49-MergeIntervals.java) 


## Q50. Insert Interval
  
**Problem Link:**
[Insert Interval](https://leetcode.com/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
Separate Non-Overlapping Intervals:

Add all intervals that end before the new interval starts.

Merge Overlapping Intervals:

Combine all intervals that overlap with the new interval by updating its start and end.

Add Remaining Intervals:

Append intervals that start after the merged interval.

Return the Result:

Convert the list of merged intervals to a 2D array.
  
[View Solution 👈](./Solutions/Q50-InsertInterval.java) 


## Q51. Minimum Number of Arrows to Burst Balloons
  
**Problem Link:**
[Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
1. Sorting by Start Points (Your Approach)
Key Idea:

Sort intervals by starting points.

Maintain a common overlapping interval and update it as long as intervals overlap.

Increment the arrow count when a new non-overlapping interval is encountered.

2. Sorting by End Points (Alternative Approach)
Key Idea:

Sort intervals by ending points.

Shoot an arrow at the end of the current non-overlapping group.

Increment the arrow count when a new interval starts after the last shot arrow.

Sorting by end points ensures that the next interval will always have an equal or greater end point compared to the current one.

If the start point of the next interval is less than or equal to the current end point, it means they overlap and can be burst with a single arrow.

If the start point is greater, it means the next interval does not overlap, requiring a new arrow.
[View Solution 👈](./Solutions/Q51-MinimumNumberOfArrowsToBurstBalloons.java) 


## Q52. Valid Parentheses
  
**Problem Link:**
[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150)  

**Solution Key Idea or Approach:**  
The goal is to check whether a string of parentheses, curly braces, and square brackets is balanced and properly nested.

Stack Data Structure: Use a stack to store opening brackets as they appear.

Matching Pairs: Use a HashMap to map each closing bracket to its corresponding opening bracket.

Validation Process:

Push opening brackets onto the stack.

For closing brackets, check if the stack is non-empty and the top matches the corresponding opening bracket.

If matched, pop the stack; if not, return false.

Final Check: After processing the entire string, the stack should be empty for a valid sequence.
[View Solution 👈](./Solutions/Q52-ValidParentheses.java) 