class Solution {
    public String fun(Node root, HashMap<String, Pair> map){
        if(root == null) return "N";
        String leftString = fun(root.left, map);
        String rightString = fun(root.right, map);
        String myString = root.data + "," + leftString  + "," + rightString;
        if(map.containsKey(myString)){
            Pair seenPair = map.get(myString);
            map.put(myString, new Pair(seenPair.root, seenPair.count + 1));
        } else {
            map.put(myString, new Pair(root, 1));
        }
        return myString;
    }
    public List<Node> printAllDups(Node root) {
        // code here
        HashMap<String, Pair> map = new HashMap<>();
        fun(root, map);
        ArrayList<Node> ans = new ArrayList<>();
        for(Map.Entry<String, Pair> entry: map.entrySet()){
            if(entry.getValue().count > 1) ans.add(entry.getValue().root);
        }
        return ans;
    }
}
class Pair{
    Node root;
    int count;
    Pair () {}
    Pair (Node root, int count){
        this.root = root;
        this.count = count;
    }
}
