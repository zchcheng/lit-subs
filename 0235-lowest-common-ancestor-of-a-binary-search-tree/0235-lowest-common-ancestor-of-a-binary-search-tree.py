# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        parents = {}
        
        queue = [root]
        while queue:
            node = queue.pop(0)
            
            if node.left:
                parents[node.left] = node
                queue.append(node.left)
            if node.right:
                parents[node.right] = node
                queue.append(node.right)
                
        seen = set()
        
        while p:
            seen.add(p)
            p = parents[p] if p in parents else None
            
        while q:
            if q in seen:
                return q
            q = parents[q] if q in parents else None
        
        return root
            
            
        