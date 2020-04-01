package dzlab.leetcode.problems

import org.scalatest._

class Problem001Spec extends FlatSpec with Matchers {

  "Solution" should "return empty array if no solution" in {
    val result = Problem001.twoSum(Array(2, 7, 11, 15), 10)
    result should equal(Array())
  }

  "Solution" should "find the right type" in {
    val result = Problem001.twoSum(Array(2, 7, 11, 15), 9)
    result should equal(Array(0, 1))
  }

  "Solution" should "find the right type in huge array" in {
    val nums = (0 to 12599).map(i => 2 * i).toArray
    val target = nums(nums.length - 1) + nums(nums.length - 2)
    val result = Problem001.twoSum(nums, target)
    result should equal(Array(nums.length - 2, nums.length - 1))
  }
}
