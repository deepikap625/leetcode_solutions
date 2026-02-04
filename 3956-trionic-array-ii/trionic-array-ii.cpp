
class Solution {
public:
    long long maxSumTrionic(vector<int>& nums) {
        const long long INF = (1LL << 50);
        int n = nums.size();

        vector<long long> up(n, -INF), down(n, -INF), up2(n, -INF);

        for (int i = 1; i < n; i++) {
            // First increasing (len >= 2)
            if (nums[i - 1] < nums[i]) {
                up[i] = max(
                    (long long)nums[i - 1] + nums[i],
                    (up[i - 1] == -INF ? -INF : up[i - 1] + nums[i])
                );
            }

            // Decreasing (len >= 2)
            if (nums[i - 1] > nums[i]) {
                if (up[i - 1] != -INF)
                    down[i] = max(down[i], up[i - 1] + nums[i]);
                if (down[i - 1] != -INF)
                    down[i] = max(down[i], down[i - 1] + nums[i]);
            }

            // Final increasing (len >= 2)
            if (nums[i - 1] < nums[i]) {
                if (down[i - 1] != -INF)
                    up2[i] = max(up2[i], down[i - 1] + nums[i]);
                if (up2[i - 1] != -INF)
                    up2[i] = max(up2[i], up2[i - 1] + nums[i]);
            }
        }

        return *max_element(up2.begin(), up2.end());
    }
};
