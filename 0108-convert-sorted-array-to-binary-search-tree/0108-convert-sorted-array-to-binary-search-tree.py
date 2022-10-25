# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        return self.helper(nums, 0, len(nums) - 1)
        
    def helper(self, nums: List[int], l: int, r: int) -> Optional[TreeNode]:
        if l > r: return None
        m = (l + r) // 2
        return TreeNode(nums[m], self.helper(nums, l, m - 1), self.helper(nums, m + 1, r))