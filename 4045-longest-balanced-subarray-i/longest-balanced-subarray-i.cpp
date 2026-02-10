class Solution {
public:
    int longestBalanced(vector<int>& nums) {
        int n = nums.size();
        int ans = 0;

        for (int left = 0; left < n; left++) {

            unordered_set<int> evenSet;
            unordered_set<int> oddSet;

            for (int right = left; right < n; right++) {

                if (nums[right] % 2 == 0)
                    evenSet.insert(nums[right]);
                else
                    oddSet.insert(nums[right]);

                if (evenSet.size() == oddSet.size())
                    ans = max(ans, right - left + 1);
            }
        }

        return ans;
    }
};
