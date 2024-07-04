/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;
import java.io.*;
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode ptr = head;
        while(ptr.next != null){
            ListNode ptr1 = ptr.next;
            int sum = 0;
            while(ptr1.val != 0){
                sum += ptr1.val;
                ptr1 = ptr1.next;
            }
            ptr = ptr.next;
            ptr.val = sum;
            ptr.next = ptr1;
            ptr = ptr1;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ptr = dummy;
        while(ptr != null){
            ptr.next = ptr.next.next;
            ptr = ptr.next;
        }
        return dummy.next;
    }
}
