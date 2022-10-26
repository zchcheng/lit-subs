# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        stack = []
        ancestor = None
        
        while root:
            if root == p or root == q:
                if not ancestor:
                    ancestor = root
                else:
                    return ancestor
            stack.append(root)
            root = root.left
            
        while stack:
            n = stack[-1]
            print('current = ' + str(n.val))
            
            if n.right:
                rn = n.right
                n.right = None
                while rn:
                    stack.append(rn)
                    if rn == p or rn == q:
                        print(str(rn.val) + ', ' + str(p.val) + ', ' + str(q.val))
                        if not ancestor:
                            ancestor = rn
                            print('ancestor = ' + str(ancestor.val))
                        else:
                            return ancestor
                    stack.append(rn)
                    rn = rn.left
            else:
                stack.pop()
                if ancestor and ancestor == n:
                    ancestor = stack[-1]
                    
        return None
            
        
            
