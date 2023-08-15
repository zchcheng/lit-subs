class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int result = 0;
        int lowest = INT_MAX;

        for (int p : prices) {
            if (p > lowest) result = max(result, p - lowest);
            lowest = min(lowest, p);
        }

        return result;
    }
};