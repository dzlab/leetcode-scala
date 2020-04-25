package dzlab.leetcode.problems

import dzlab.leetcode.problems.Problem002.ListNode
import org.scalatest._

class Problem002Spec extends FlatSpec with Matchers {

  "Solution" should "return null if inputs are null" in {
    val result = Problem002.addTwoNumbers(null, null)
    result should equal(null)
    ListNode.stringify(result) should equal("")
  }

  it should "sum two equally sized lists" in {
    val l1 = ListNode(2, ListNode(4, ListNode(3)))
    val l2 = ListNode(5, ListNode(6, ListNode(4)))

    val result = Problem002.addTwoNumbers(l1, l2)
    ListNode.stringify(result) should equal("7->0->8")
  }

  it should "sum two equally sized lists and carrying on remains" in {
    val l1 = ListNode(5, ListNode(3))
    val l2 = ListNode(5, ListNode(6))

    val result = Problem002.addTwoNumbers(l1, l2)
    ListNode.stringify(result) should equal("0->0->1")
  }

  it should "sum when l2 is longer than l1" in {
    val l1 = ListNode(2, ListNode(4))
    val l2 = ListNode(5, ListNode(6, ListNode(1)))

    val result = Problem002.addTwoNumbers(l1, l2)
    ListNode.stringify(result) should equal("7->0->2")
  }

  it should "return l1 when l2 is null" in {
    val l1 = ListNode(2, ListNode(4))
    val l2 = null

    val result = Problem002.addTwoNumbers(l1, l2)
    ListNode.stringify(result) should equal("2->4")
  }

  it should "return l2 when l1 is null" in {
    val l1 = null
    val l2 = ListNode(5, ListNode(6, ListNode(4)))

    val result = Problem002.addTwoNumbers(l1, l2)
    ListNode.stringify(result) should equal("5->6->4")
  }
}
