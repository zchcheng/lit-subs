class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        arr = [ str(x) for x in nums ]
        arr.sort(key = functools.cmp_to_key(lambda a, b: -1 if (a + b) >= (b + a) else 1))
        return str(int(''.join(arr)))