class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        unordered_map<string, int> map;
        
        for (string d : cpdomains) {
            vector<string> splited;
            split(d, ' ', splited);
            
            int times = stoi(splited[0]);
            string domain = splited[1];
            
            vector<string> subdomains;
            split(domain, '.', subdomains);
            
            string cur_domain;
            
            for(int i = subdomains.size() - 1; i >= 0; i--) {
                if (cur_domain.length() > 0) {
                    cur_domain = "." + cur_domain;
                }
                cur_domain = subdomains[i] + cur_domain;
                map[cur_domain] += times;
            }
        }
        
        vector<string> res;
        
        for(unordered_map<string, int>::iterator it = map.begin(); it != map.end(); it++) {
            res.push_back(to_string(it->second) + " " + it->first);
        }
        
        return res;
    }
    
    void split(const string& str, char del, vector<string>& out) {
        stringstream ss;
        ss << str;
        string seg;
        while(getline(ss, seg, del)) {
            out.emplace_back(seg);
        }
    }
};