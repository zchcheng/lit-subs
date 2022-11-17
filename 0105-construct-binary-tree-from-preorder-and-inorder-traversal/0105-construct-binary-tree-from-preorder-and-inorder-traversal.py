# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        index, n = {}, len(preorder)
        
        for i in range(n):
            index[inorder[i]] = i
            
        return self.helper(preorder, inorder, [0, n - 1], [0, n - 1], index)
        
    
    def helper(self, po: List[int], io: List[int], pr: List[int], ir: List[int], indexOfEl) -> Optional[TreeNode]:
        if pr[1] < pr[0] or ir[1] < ir[0]:
            return None
        
        val = po[pr[0]]
        idx = indexOfEl[val]
        numL = idx - ir[0]
        numR = ir[1] - idx
        node = TreeNode(val)
        
        node.left = self.helper(po, io, [pr[0] + 1, pr[0] + numL], [ir[0], idx - 1], indexOfEl)
        node.right = self.helper(po, io, [pr[0] + numL + 1, pr[1]], [idx + 1, ir[1]], indexOfEl)
        
        return node
        
        