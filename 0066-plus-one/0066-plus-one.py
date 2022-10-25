class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        
        carry = 1
        for i in range(len(digits) - 1, -1, -1):
            sum = digits[i] + carry
            digits[i] = sum % 10
            carry = sum / 10
            
        if carry > 0:
            digits.insert(0, carry)
            
        return digits
        