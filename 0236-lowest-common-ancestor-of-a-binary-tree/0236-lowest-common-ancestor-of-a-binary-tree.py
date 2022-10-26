# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parents = self.buildParentMap(root)
        
        path = set()
        
        while p:
            path.add(p)
            p = parents.get(p, None)
            
        while q and q not in path:
            q = parents.get(q, None)
            
        return q
        
    def buildParentMap(self, root: 'TreeNode') -> Dict['TreeNode', 'TreeNode']:
        res = {}
        q = []
        
        if root: q.append(root)
            
        while q:
            node = q.pop(0)
            if node.left:
                res[node.left] = node
                q.append(node.left)
            if node.right:
                res[node.right] = node
                q.append(node.right)
                
        return res
                
            
            
            