class Solution:
    def numSquarefulPerms(self, nums: List[int]) -> int:
        nums.sort()
        
        canPair = defaultdict(lambda: set())
        
        for i in range(len(nums)):
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            for j in range(i + 1, len(nums)):
                if j > i + 1 and nums[j - 1]  == nums[j]:
                    continue
                    
                s = nums[i] + nums[j]
                sqrt = int(math.sqrt(s))
                if sqrt * sqrt == s:
                    canPair[nums[i]].add(nums[j])
                    canPair[nums[j]].add(nums[i])
                    
        cnt = collections.Counter(nums)
        
        return self.backtracking(cnt, canPair, [], len(nums))
    
    def backtracking(self, cnt, canPair, current, n):
        if len(current) == n:
            return 1
        
        res = 0
        if not current:
            for k in cnt:
                current.append(k)
                cnt[k] -= 1
                res += self.backtracking(cnt, canPair, current, n)
                current.pop()
                cnt[k] += 1
        else:
            prev = current[-1]
            for k in canPair[prev]:
                if cnt[k] <= 0:
                    continue
                    
                current.append(k)
                cnt[k] -= 1
                res += self.backtracking(cnt, canPair, current, n)
                current.pop()
                cnt[k] += 1
                
        return res
                    
            
            
            
        
        
                
        