class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int> v1 = count(s);
        vector<int> v2 = count(t);
        
        for (int i = 0; i < 26; i++) {
            if (v1[i] != v2[i]) return false;
        }
        
        return true;
    }
    
    vector<int> count(string &s) {
        vector<int> bucket(26, 0);
        
        for(int i = 0; i < s.size(); i++) {
            bucket[s[i] - 'a']++;
        }
        
        return bucket;
    }
};