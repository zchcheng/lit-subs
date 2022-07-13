/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let res = 0
    let min = Number.MAX_VALUE
    
    prices.forEach(p => {
        min = Math.min(min, p)
        res = Math.max(p - min, res)
    })
    
    return res
};