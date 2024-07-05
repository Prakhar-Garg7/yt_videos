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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        ListNode ptr = head;
        while(ptr.next != null && ptr.next.next != null){
            if((ptr.next.val > ptr.val && ptr.next.next.val < ptr.next.val) || (ptr.next.val < ptr.val && ptr.next.next.val > ptr.next.val)) list.add(count);
            count++;
            ptr = ptr.next;
        }
        int mini = Integer.MAX_VALUE;
        int listSize = list.size();
        if(listSize < 2) return new int[] {-1, -1};
        for(int i = 0; i < listSize - 1; i++){
            mini = Math.min(mini, list.get(i + 1) - list.get(i));
        }
        Collections.sort(list);
        return new int[] {mini, list.get(listSize - 1) - list.get(0)};
    }
}
