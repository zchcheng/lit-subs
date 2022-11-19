# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = -1
    
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.helper(root, k)
        return self.res
        

    def helper(self, root: Optional[TreeNode], k: int):
        if not root:
            return 0
        
        n = self.helper(root.left, k) + 1
        
        if k > n:
            return n + self.helper(root.right, k - n)
        
        if n >= k:
            if n == k: self.res = root.val
            return n
        