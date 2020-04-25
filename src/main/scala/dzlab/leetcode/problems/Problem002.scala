package dzlab.leetcode.problems

/*
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each
 *   of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   Output: 7 -> 0 -> 8
 *   Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Problem002 {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  object ListNode {
    /**
     * Create a node and intialize it.
     */
    def apply(x: Int, next: ListNode = null): ListNode = {
      val node = new ListNode(x)
      node.next = next
      return node
    }
    /**
     * @return a string representation of the input list
     */
    def stringify(node: ListNode): String = {
      Option(node) match {
        case None => ""
        case Some(n) => {
          stringify(n.next) match {
            case str if str.isEmpty => s"${n.x}"
            case str                => s"${n.x}->${str}"
          }

        }
      }
    }
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    case class ExtendedNode(n: ListNode) {
      def add(other: ListNode, remain: Int = 0): ListNode = {
        Option(other) match {
          case None => {
            if (remain == 0) {
              if (n.x == 0) null else n
            } else {
              this.add(new ListNode(0), remain)
            }
          }
          case Some(m) => {
            val sum = n.x + m.x + remain
            val newNode = new ListNode(sum % 10)
            val remain2: Int = sum / 10
            val nextNode = Option(n.next) match {
              case None     => ExtendedNode(new ListNode(remain2)).add(m.next)
              case Some(n2) => ExtendedNode(n2).add(m.next, remain2)
            }
            newNode.next = nextNode
            newNode
          }
        }
      }
    }
    implicit def node2node(n: ListNode) = ExtendedNode(n)

    if (l1 == null) {
      return l2
    } else if (l2 == null) {
      return l1
    }
    l1.add(l2, 0)
  }
}
