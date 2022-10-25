# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        r = []
        q = []
        
        if root: q.append(root)
            
        while len(q) > 0:
            tr = []
            for i in range(len(q)):
                n = q.pop(0)
                tr.append(n.val)
                
                if n.left is not None: q.append(n.left)
                if n.right is not None: q.append(n.right)
            r.append(tr)
            
        return r
                    
                
                
            