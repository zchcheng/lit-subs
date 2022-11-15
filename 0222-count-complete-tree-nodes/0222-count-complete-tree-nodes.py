# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        d = self.getDepth(root)
        
        if d == 0: return 0
        
        l, r = 2 ** (d - 1) - 1, 2 ** d - 1
        
        while l <= r:
            m = (l + r) // 2
            
            if self.exists(m, d, root):
                l = m + 1
            else:
                r = m - 1
                
        return r
        
        
    def getDepth(self, root):
        d = 0
        while root:
            d += 1
            root = root.left
        return d
    
    
    def exists(self, idx, d, root):
        l, r = 2 ** (d - 1), 2 ** d - 1
        
        while l < r:
            if not root:
                return False
            
            m = (l + r) // 2
            
            if idx > m:
                root = root.right
                l = m + 1
            else:
                root = root.left
                r = m
                
        return True if root else False
        
        