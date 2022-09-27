/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return helper(arr, 0).getValue();
    }
    
    Pair<Integer, TreeNode> helper(String[] arr, int i) {
        if (i >= arr.length || arr[i] == null || arr[i].isEmpty()) return new Pair(i + 1, null);
        
        TreeNode node = new TreeNode(Integer.valueOf(arr[i]));
        
        Pair<Integer, TreeNode> lp = helper(arr, i + 1);
        Pair<Integer, TreeNode> rp = helper(arr, lp.getKey());
        
        node.left = lp.getValue();
        node.right = rp.getValue();
        
        return new Pair(rp.getKey(), node);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));