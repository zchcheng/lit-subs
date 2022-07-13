/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var map = new Map()
    var res = []
    
    nums.forEach((n, i) => {
        var dif = target - n
        if (map.has(dif)) {
            res = [map.get(dif), i]
        } else {
            map.set(n, i)
        }
    })
    
    return res
};