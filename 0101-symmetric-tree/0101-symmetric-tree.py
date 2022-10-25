# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None: return True
        return self.helper(root.left, root.right)
        
        
    def helper(self, nl: Optional[TreeNode], nr: Optional[TreeNode]) -> bool:
        if nl is None and nr is None: return True
        if nl is None: return nr is None
        if nr is None: return False
        
        if nl.val != nr.val: return False
        
        return self.helper(nl.left, nr.right) and self.helper(nl.right, nr.left)