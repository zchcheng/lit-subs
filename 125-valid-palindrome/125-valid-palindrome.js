/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    var isLetter = function(c) {
        return /[a-zA-Z0-9]/.test(c);
    }
    
    let left = 0;
    let right = s.length - 1;
    
    while(left < right) {
        while(left < right && !isLetter(s.charAt(left))) left++;
        while(left < right && !isLetter(s.charAt(right))) right--;
        
        if (left < right && s.charAt(left).toLowerCase() != s.charAt(right).toLowerCase()) return false;
        
        left++;
        right--;
    }
    
    return true;
};