class Solution {
public:
    bool hasAlternatingBits(int n) {
        int rem = 0;
        while(n > 0)
        {
            rem = n%2;
            n /= 2;
            if(n%2 == rem)
                return false;
        }
        return true;
    }
};