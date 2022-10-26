class FileSystem:

    def __init__(self):
        self.rootDir = Directory('/')

    def ls(self, path: str) -> List[str]:
        d = self.rootDir
        subpaths = self.splitPath(path) 
        
        if len(subpaths) == 0:
            res = d.getDirs() + d.getFiles()
            res.sort()
            return res
        
        for i in range(len(subpaths) - 1):
            d = d.subdirs.get(subpaths[i], None)
            if not d:
                return []
                
        if subpaths[-1] in d.subdirs:
            d = d.subdirs[subpaths[-1]]
            res = d.getDirs() + d.getFiles()
            res.sort()
            return res
        
        return [ subpaths[-1] ]
        

    def mkdir(self, path: str) -> None:
        subpaths = self.splitPath(path)
        
        d = self.rootDir
        
        for p in subpaths:
            if p not in d.subdirs:
                d.subdirs[p] = Directory(p)
            d = d.subdirs[p]

    def addContentToFile(self, filePath: str, content: str) -> None:
        subpaths = self.splitPath(filePath)
        
        d = self.rootDir
        
        for i in range(len(subpaths) - 1):
            p = subpaths[i]
            d = d.subdirs[p]
            
        d.files[subpaths[-1]] = d.files.get(subpaths[-1], '') + content
        

    def readContentFromFile(self, filePath: str) -> str:
        subpaths = self.splitPath(filePath)
        
        d = self.rootDir
        
        for i in range(len(subpaths) - 1):
            p = subpaths[i]
            d = d.subdirs.get(p, None)
            if not d:
                return ''
            
        return d.files[subpaths[-1]] if subpaths[-1] in d.files else ''
        
        
    def splitPath(self, path: str) -> List[str]:
        # /a/b/c -> a b c
        return [ x for x in path.split('/') if x ]
        
        
class Directory:
    def __init__(self, name: str):
        self.name = name
        self.subdirs = {}
        self.files = {}
        
    def getDirs(self) -> List[str]:
        res = [ n for n, d in self.subdirs.items() ]
        res.sort()
        return res
    
    def getFiles(self) -> List[str]:
        res = [ n for n, c in self.files.items() ]
        res.sort()
        return res
        


# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.ls(path)
# obj.mkdir(path)
# obj.addContentToFile(filePath,content)
# param_4 = obj.readContentFromFile(filePath)