class Solution {
    func judgePoint24(_ cards: [Int]) -> Bool {
        let nc = cards.map { Double($0) }
        return check(nc)
    }

    func check(_ cards: [Double]) -> Bool {
        if (cards.count == 1) {
            return abs(24 - cards[0]) < 0.01
        }

        func generateAllCombination(_ a: Double, _ b: Double) -> [Double] {
            var combs = [ a + b, a - b, b - a, a * b ]

            if (a != 0) {
                combs.append(b / a)
            }

            if (b != 0) {
                combs.append(a / b)
            }

            return combs
        }

        for i in 0...(cards.count - 2) {
            for j in (i + 1)...(cards.count - 1) {
                var nc = cards.enumerated().filter { $0.0 != i && $0.0 != j }.map { $0.1 }
                if (generateAllCombination(cards[i], cards[j]).filter {
                    check(nc.map { $0 } + [ $0 ])
                }.count != 0) {
                    return true
                }
            }
        }

        return false
    }
}