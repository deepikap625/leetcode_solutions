class Solution {
public:
    long long minimumCost(vector<int>& nums, int k, int dist) {
        int n = nums.size();

        multiset<long long> small, large;
        long long sumSmall = 0;

        // Add element to data structure
        auto add = [&](long long x) {
            if ((int)small.size() < k - 1) {
                small.insert(x);
                sumSmall += x;
            } else {
                auto it = prev(small.end()); // largest in small
                if (x < *it) {
                    sumSmall -= *it;
                    large.insert(*it);
                    small.erase(it);
                    small.insert(x);
                    sumSmall += x;
                } else {
                    large.insert(x);
                }
            }
        };

        // Remove element from data structure
        auto remove = [&](long long x) {
            auto it = small.find(x);
            if (it != small.end()) {
                sumSmall -= x;
                small.erase(it);
                if (!large.empty()) {
                    auto it2 = large.begin();
                    sumSmall += *it2;
                    small.insert(*it2);
                    large.erase(it2);
                }
            } else {
                large.erase(large.find(x));
            }
        };

        // Initial window: nums[1 ... dist+1]
        for (int i = 1; i <= dist + 1; i++) {
            add(nums[i]);
        }

        long long ans = sumSmall;

        // Slide window
        for (int i = dist + 2; i < n; i++) {
            remove(nums[i - dist - 1]);
            add(nums[i]);
            ans = min(ans, sumSmall);
        }

        return nums[0] + ans;
    }
};
