# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = False
    
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        self.encode(root, self.encode(subRoot, None))
        return self.res
        
    
    def encode(self, root: Optional[TreeNode], check: Optional[str]):
        if not root: return ''
        
        s = str(root.val) + ',' + self.encode(root.left, check) + ',' + self.encode(root.right, check)
        
        if check and check == s:
            self.res = True
            
        return s