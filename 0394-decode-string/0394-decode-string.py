class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        cur_string = ''
        index = 0
        times = 0
        
        while index < len(s):
            c = s[index]
            
            if c == '[':
                stack.append((cur_string, times))
                times = 0
                cur_string = ''
            elif c == ']':
                prev_string, prev_times = stack.pop()
                for _ in range(prev_times):
                    prev_string += cur_string
                cur_string = prev_string
                times = 0
            elif c.isdigit():
                times = times * 10 + int(c)
            else:
                cur_string += c
            index += 1
            
        return cur_string
        
                
        
        