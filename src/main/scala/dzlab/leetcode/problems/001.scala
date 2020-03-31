package dzlab.leetcode.problems

/*
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *   Given nums = [2, 7, 11, 15], target = 9,
 *   Because nums[0] + nums[1] = 2 + 7 = 9,
 *   return [0, 1].
 */

object Solution {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    (0 to nums.length).map(left =>
      (left + 1 to nums.length).map(right =>
        if (nums(left) + nums(right) == target) return Array(left, right)
      )
    )
    Array()
  }
}
