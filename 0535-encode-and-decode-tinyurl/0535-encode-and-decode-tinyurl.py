class Codec:
    
    def __init__(self):
        self.keys = []
        self.dict = {}
        self.generateKeys()

    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        k = self.keys.pop(0)
        self.dict[k] = longUrl
        self.generateKeys()
        return 'https://tinyurl.com/' + k
        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        k = shortUrl.split('/')[-1]
        return self.dict[k]
        
        
    def generateKeys(self):
        while len(self.keys) < 3:
            k = self.getRandomKey()
            if k in self.keys or k in self.dict:
                continue
            self.keys.append(k)
            
                
    def getRandomKey(self):
        res = ''
        for _ in range(3):
            res += chr(random.randint(0, 26) + ord('a'))
            res += chr(random.randint(0, 10) + ord('0'))
            res += chr(random.randint(0, 26) + ord('A'))
        return res
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))