class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<vector<int>> a(nums.size(),vector<int>(2));
        for(int i=0;i<nums.size();i++)
        {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        sort(a.begin(),a.end());
        int i = 0, j =nums.size()-1;
        vector<int> answer;
        while(i<j)
        {
           int result = a[i][0]+a[j][0] ;
            if(target == result)
            {
                answer.push_back(a[i][1]); answer.push_back(a[j][1]);
                break;
            }
            else if(target < result)
            {
                j--;
            }
            else
            {
                i++;
            }
            
        }
        return answer;
    }
};