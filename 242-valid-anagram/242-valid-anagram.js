/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length != t.length) return false
    
    let cnt = Array(26).fill(0)
    
    for(let i = 0; i < s.length; i++) {
        cnt[s.charCodeAt(i) - 97]++
        cnt[t.charCodeAt(i) - 97]--
    }
    
    return cnt.reduce((p, c) => p && c == 0, true)
};