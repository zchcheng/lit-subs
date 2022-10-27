class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        self.qselect(points, 0, len(points) - 1, k - 1)
        return [ p for p in points[:k] ]
        
    def qselect(self, ps, s, e, k):
        rd = random.randint(s, e)
        ps[s], ps[rd] = ps[rd], ps[s]
        
        p = self.partition(ps, s, e)
        
        if p == k:
            return
        if p < k:
            self.qselect(ps, p + 1, e, k)
        else:
            self.qselect(ps, s, p - 1, k)
        
    def partition(self, ps, s, e) -> int:
        pvt = ps[s]
        v = pvt[0] ** 2 + pvt[1] ** 2
        j = s + 1
        for i in range(s + 1, e + 1):
            tv = ps[i][0] ** 2 + ps[i][1] ** 2
            if tv <= v:
                ps[i], ps[j] = ps[j], ps[i]
                j += 1
        j -= 1
        ps[j], ps[s] = ps[s], ps[j]
        return j