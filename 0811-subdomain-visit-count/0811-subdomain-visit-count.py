class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        m = defaultdict(lambda: 0)
        for d in cpdomains:
                times, domain = d.split(' ')
                
                subdomains = domain.split('.')
                subdomains.reverse()
                
                cd = ''
                t = int(times)
                for sd in subdomains:
                    if cd:
                        cd = '{}.{}'.format(sd,cd)
                    else:
                        cd = sd
                        
                    m[cd] += t
                    
        return [ '{} {}'.format(str(x[1]), x[0]) for x in m.items() ]
                
                