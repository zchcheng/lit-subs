"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        return self.helper(node, {})
        
    def helper(self, node: 'Node', m: Dict[int, 'Node']) -> 'Node':
        if not node: return None
        if node.val in m: return m[node.val]
        
        cloned = Node(node.val)
        m[node.val] = cloned
        if node.neighbors:
            cloned.neighbors = []
            for n in node.neighbors:
                cloned.neighbors.append(self.helper(n, m))
                
        return cloned
