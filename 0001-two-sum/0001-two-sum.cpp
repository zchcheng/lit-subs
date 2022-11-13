class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        
        for(int i = 0; i < nums.size(); i++) {
            int diff = target - nums[i];
            if (map.find(diff) != map.end()) return {i, map[diff]};
            map[nums[i]] = i;
        }
        
        return {-1, -1};
    }
};