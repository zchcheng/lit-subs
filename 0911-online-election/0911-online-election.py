class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.p = persons
        self.t = times
        
        self.w = []
        
        vs = defaultdict(lambda: 0)
        cw = None
        cv = 0
        for i in range(0, len(persons)):
            p = persons[i]
            vs[p] += 1
            if vs[p] >= cv:
                cw = p
                cv = max(cv, vs[p])
            self.w.append(cw)
        

    def q(self, t: int) -> int:
        return self.w[bisect.bisect(self.t, t) - 1]
                
# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)