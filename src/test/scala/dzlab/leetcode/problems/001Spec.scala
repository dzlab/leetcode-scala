package dzlab.leetcode.problems

import org.scalatest._

class StackSpec extends FlatSpec with Matchers {

  "Solution" should "find the right type" in {
    val result = Solution.twoSum(Array(2, 7, 11, 15), 9)
    result should equal(Array(0, 1))
  }

}
