# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        return self.helper(root)[1]
        
    def helper(self, root: Optional[TreeNode]) -> Tuple[int]:
        if not root:
            return (0, 0)
        
        l = self.helper(root.left)
        r = self.helper(root.right)
        
        return (max(l[0], r[0]) + 1, max(l[1], r[1], l[0] + r[0]))