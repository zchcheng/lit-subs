object Solution {
    def coinChange(coins: Array[Int], amount: Int): Int = {
        val memo: Array[Int] = Array.fill(amount + 1)(-2)
        memo(0) = 0
        helper(amount, coins, memo)
    }
    
    def helper(amount: Int, coins: Array[Int], memo: Array[Int]): Int = {
        if (memo(amount) != -2) { memo(amount) } 
        else {
            var min = -1
            
            for(coin <- coins) {
                if (amount >= coin) {
                    val v = helper(amount - coin, coins, memo)
                    if (v != -1) {
                        if (min == -1) {
                            min = 1 + v
                        } else {
                            min = Math.min(1 + v, min)
                        }
                    }
                }
            }
            
            memo(amount) = min
            min
        }
    }
}