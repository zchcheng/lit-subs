class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> result;
        unordered_map<string, vector<string>> map;

        for (string& str : strs) {
            string key = encode(str);

            auto it = map.find(key);

            if (it == map.end()) {
                map[key] = {str};
            } else {
                map[key].push_back(str);
            }
        }

        for (auto it : map) {
            result.push_back(it.second);
        }

        return result;
    }

    string encode(string& str) {
        string result;
        vector<int> arr(26, 0);
        for (char& i : str) {
            arr[i - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            result.append(to_string(arr[i]));
            result.append(",");
        }
        return result;
    }
};