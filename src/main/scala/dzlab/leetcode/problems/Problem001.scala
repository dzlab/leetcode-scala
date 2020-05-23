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

object Problem001 {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    (0 until nums.length).foldLeft(Map[Int, Int]()) {
      (map: Map[Int, Int], right: Int) ⇒
        {
          val left_key = nums(right)
          if (map.contains(left_key)) {
            return Array(map(left_key), right)
          }
          map ++ Map((target - nums(right), right))
        }
    }
    Array()
  }
}
