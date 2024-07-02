// User function Template for Java
class Solution {
    public boolean compute(Node root) {
        StringBuilder sb = new StringBuilder("");
        Node ptr = root;
        while(ptr != null) {
            sb.append(ptr.data);
            ptr = ptr.next;
        }
        int len = sb.length();
        int low = 0, high = len - 1;
        while(low < high){
            if(sb.charAt(low) != sb.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
