package leetcode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 * @author skyxt
 * Created 2019-07-09 17:32
 * Email skyxt.yang@gmail.com
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode begin = null;
//        ListNode tmp = null;
//        int remainder;
//        int carry = 0;
//        int singleSum;
//
//        while (l1 != null || l2 != null || carry != 0) {
//            if (l1 != null && l2 != null) {
//                singleSum = l1.val + l2.val + carry;
//            } else if (l1 != null) {
//                singleSum = l1.val + carry;
//            } else if (l2 != null) {
//                singleSum = l2.val + carry;
//            } else {
//                singleSum = carry;
//            }
//            carry = 0;
//            if (singleSum > 9) {
//                ++carry;
//                remainder = singleSum % 10;
//                if (begin == null) {
//                    begin = new ListNode(remainder);
//                    tmp = begin;
//                    begin.next = tmp;
//                } else {
//                    tmp.next = new ListNode(remainder);
//                    tmp = tmp.next;
//                }
//            } else {
//                if (begin == null) {
//                    begin = new ListNode(singleSum);
//                    tmp = begin;
//                } else {
//                    tmp.next = new ListNode(singleSum);
//                    tmp = tmp.next;
//                }
//            }
//            if(l1 != null) {
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                l2 = l2.next;
//            }
//        }
//        return begin;
//    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        l1.next = listNode1;
        listNode1.next = listNode2;
        ListNode l2 = new ListNode(5);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(4);
        l2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
    }
}
