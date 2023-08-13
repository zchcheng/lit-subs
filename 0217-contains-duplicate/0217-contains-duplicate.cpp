class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> set;

        for (auto i : nums) {
            if (set.find(i) != set.end()) {
                return true;
            }
            set.insert(i);
        }
        return false;
    }
};