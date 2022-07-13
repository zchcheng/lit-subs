/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stack = []
    let map = {']': '[', ')': '(', '}': '{'}
    
    for(const c of s) {
        if (c in map) {
            if (stack.length == 0 || stack[stack.length - 1] != map[c]) return false
            else stack.pop()
        } else {
            stack.push(c)
        }
    }
    
    return stack.length == 0
};