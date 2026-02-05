class Solution {
public:
    vector<int> constructTransformedArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n);

        for (int i = 0; i < n; i++) {

            // If value is 0, stays same
            if (nums[i] == 0) {
                result[i] = 0;
                continue;
            }

            int move = nums[i] % n;  // avoid unnecessary large jumps

            int newIndex = ((i + move) % n + n) % n;

            result[i] = nums[newIndex];
        }

        return result;
    }
};
