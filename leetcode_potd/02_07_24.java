import java.util.*;
import java.io.*;
class Solution {
    public int[] intersect(int[] arr1, int[] arr2) {
        int helper_size = 1001;
        int[] helperArr1 = new int[1001];
        int[] helperArr2 = new int[1001];
        for(int x: arr1) helperArr1[x]++;
        for(int x: arr2) helperArr2[x]++;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < helper_size; i++){
            int count = Math.min(helperArr1[i], helperArr2[i]);
            for(int j = 0; j < count; j++) list.add(i);
        }
        int sizeOfList = list.size();
        int[] ans = new int[sizeOfList];
        int ptr = 0;
        for(int i = 0; i < sizeOfList; i++){
            ans[ptr] = list.get(ptr);    
            ptr++;
        }
        return ans;
    }
}
