class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;
        
        for(string s : strs) {
            string encoded = encode(s);
            if (map.find(encoded) == map.end()) {
                map[encoded] = {};
            }
            map[encoded].emplace_back(s);
        }
        
        vector<vector<string>> res;
        
        for(auto &kv : map) {
            res.emplace_back(kv.second);
        }
        
        return res;
    }
    
    string encode(string &s) {
        int bucket[26] = {};
        
        for (int i = 0; i < s.size(); i++) {
            bucket[s[i] - 'a']++;
        }
        
        string res;
        
        for (int i = 0; i < 26; i++) {
            res += to_string(bucket[i]) + ",";
        }
        
        return res;
    }
};