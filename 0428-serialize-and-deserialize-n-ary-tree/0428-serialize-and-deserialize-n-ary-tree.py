"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=[]):
        self.val = val
        self.children = children
"""

class Codec:
    def serialize(self, root: 'Node') -> str:
        """Encodes a tree to a single string.
        
        :type root: Node
        :rtype: str
        """
        if not root:
            return ''

        res = str(root.val) + ',' + str(len(root.children))

        for child in root.children:
            substr = self.serialize(child)
            res += ',' + substr 
            
        return res
        
	
    def deserialize(self, data: str) -> 'Node':
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: Node
        """
        
        def helper(split, i, n): 
            res = []
            for _ in range(n):
                node = Node(split[i])
                i += 1
                nc = split[i]
                i += 1
                node.children, i = helper(split, i, nc)
                res.append(node)
                
            return (res, i)
        
        if not data: return None
        return helper([int(x) for x in data.split(',')], 0, 1)[0][0]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))