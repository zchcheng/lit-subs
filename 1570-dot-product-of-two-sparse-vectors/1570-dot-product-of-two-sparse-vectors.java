class SparseVector {
    public List<int[]> list = new ArrayList<>();
    
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new int[] {i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        List<int[]> other = vec.list;
        
        for(int i = 0, j = 0; i < list.size() && j < other.size();) {
            int[] pi = list.get(i);
            int[] pj = other.get(j);
            
            if (pi[0] <= pj[0]) {
                i++;
            }
            
            if (pi[0] >= pj[0]) {
                j++;
            }
                
            if (pi[0] == pj[0]) {
                res += pi[1] * pj[1];
            }
        }
        
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);