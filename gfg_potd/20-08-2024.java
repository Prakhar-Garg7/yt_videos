class Solution {
    static HashMap<Integer, Integer> map;

    public static int findNumberOfNodesInTree(Node root){      // Inorder traversal (iterative method)
        map = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        Node ptr = root;
        int ans = 0;
        while (true) {
            if (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            } else {
                if (stack.isEmpty()) break;
                Node delNode = stack.pop();
                map.put(delNode.data, ans);
                ans++;
                ptr = delNode.right;
            }
        }
        return ans;
    }


    //Recusive function  // its t.c. -> O(n) -> total number of nodes
    public static void fillDepthArr(Node root, int[] depthArr, HashSet<Integer> set) {
        if (root.left != null) {
            fillDepthArr(root.left, depthArr, set);
            if (!set.contains(map.get(root.left.data)))
                depthArr[map.get(root.data)] = Math.max(depthArr[map.get(root.data)], depthArr[map.get(root.left.data)] + 1);
        }
        if (root.right != null) {
            fillDepthArr(root.right, depthArr, set);
            if (!set.contains(map.get(root.right.data)))
                depthArr[map.get(root.data)] = Math.max(depthArr[map.get(root.data)], depthArr[map.get(root.right.data)] + 1);
        }
    }

    public static int minTime(Node root, int target) {
        // Your code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int numberOfNodes = findNumberOfNodesInTree(root);
        int[] parArr = new int[numberOfNodes];
        Arrays.fill(parArr, -1);
        
        
        //adj list building
        for (int i = 0; i < numberOfNodes; i++) adj.add(new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);                      // level order traversal
        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            while (sizeOfQueue-- > 0) {
                Node delNode = queue.poll();
                if (delNode.left != null) {
                    adj.get(map.get(delNode.data)).add(map.get(delNode.left.data));
                    parArr[map.get(delNode.left.data)] = map.get(delNode.data);
                    queue.offer(delNode.left);
                }
                if (delNode.right != null) {
                    adj.get(map.get(delNode.data)).add(map.get(delNode.right.data));
                    parArr[map.get(delNode.right.data)] = map.get(delNode.data);
                    queue.offer(delNode.right);
                }
            }
        }
        
                                                            // map for storing value -> idx
        
        
        // Calculating target to root path
        
        ArrayList<Integer> targetToRootPath = new ArrayList<>();
        int ptr = map.get(target);
        while (ptr != -1) {
            targetToRootPath.add(ptr);
            ptr = parArr[ptr];
        }
        Collections.reverse(targetToRootPath);       // target (5), root(3), targetToRootPth is (5 -> 2 -> 1 -> 3), (3 -> 1 -> 2 -> 5)
        
        
        
        
        
        
        
        
        
        
        // 1 -> 2 -> 5 -> 8
        // I am at node 1, now , depth 1 is 4, ans = 7
        // I am at node 2, now , depth 2 is 1, ans = max(3, 7) -> 7
        // I am at node 5, now , depth 5 is 1, ans = max(2, 7) -> 7
        // I am at node 8, now , depth 8 is 0, ans = max(0, 7) -> 7
        
        
        
        
        
        
        
        
        
        
        
        // storing path nodes in my set
        
        HashSet<Integer> targetToRootPathNodesSet = new HashSet<>();
        for (int idx : targetToRootPath) targetToRootPathNodesSet.add(idx);
        
        
        
        int[] depthArr = new int[numberOfNodes];
        fillDepthArr(root, depthArr, targetToRootPathNodesSet);
        
        int ans = 0;
        int targetToRootPathSize = targetToRootPath.size();
        for (int i = 0; i < targetToRootPathSize; i++) {
            ans = Math.max(ans, targetToRootPathSize - i - 1 + depthArr[targetToRootPath.get(i)]);
        }
        return ans;
    }
}

class Pair {
    Node node;
    int depth;
    Pair() {}
    Pair(Node n, int d) {
        node = n;
        depth = d;
    }
}
