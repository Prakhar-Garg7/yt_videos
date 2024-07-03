class Solution {
    public Node removeAllDuplicates(Node head) {
        // code here
        Node ptr = head;
        HashSet<Integer> set = new HashSet<>();
        while(ptr != null){
            Node ptr1 = ptr;
            int flag = 0;
            while(ptr1.next != null && ptr1.next.data == ptr.data){
                ptr1.next = ptr1.next.next;
                flag = 1;
            }
            if(flag == 1) set.add(ptr.data);
            ptr = ptr1.next;
        }
        Node dummy = new Node(1);
        dummy.next = head;
        ptr = dummy;
        while(ptr.next != null){
            if(set.contains(ptr.next.data)) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }
}
