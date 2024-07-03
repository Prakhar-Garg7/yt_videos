import java.util.*;
import java.io.*;
class Solution {
    public int minDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        if(n <= 4) return 0;
        int fact1 = arr[n - 3] - arr[1];
        int fact2 = arr[n - 2] - arr[2];
        int fact3 = arr[n - 4] - arr[0];
        int fact4 = arr[n - 1] - arr[3];
        return Math.min(Math.min(fact1, fact2), Math.min(fact3, fact4));
    }
}
