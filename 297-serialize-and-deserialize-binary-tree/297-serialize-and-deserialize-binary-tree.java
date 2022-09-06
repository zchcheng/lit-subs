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
        return helper(arr, 0).getKey();
    }
    
    Pair<TreeNode, Integer> helper(String[] arr, int s) {
        if (s >= arr.length || arr[s].isEmpty()) return new Pair(null, s + 1);
        
        TreeNode node = new TreeNode(Integer.valueOf(arr[s]));
        
        Pair<TreeNode, Integer> lp = helper(arr, s + 1);
        Pair<TreeNode, Integer> rp = helper(arr, lp.getValue());
        
        node.left = lp.getKey();
        node.right = rp.getKey();
        
        return new Pair(node, rp.getValue());
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));