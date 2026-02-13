#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    int longestSameChar(const string &s){
        int best=1, cur=1;
        for(int i=1;i<s.size();i++){
            if(s[i]==s[i-1]) cur++;
            else cur=1;
            best=max(best,cur);
        }
        return best;
    }

    int solveSegment(const string &s, int l, int r, int type) {
        unordered_map<long long,int> first;
        first[0]=l-1;

        int a=0,b=0,c=0, ans=0;

        for(int i=l;i<=r;i++){
            if(s[i]=='a') a++;
            else if(s[i]=='b') b++;
            else c++;

            long long key;
            if(type==0) key=a-b;
            else if(type==1) key=a-c;
            else if(type==2) key=b-c;
            else key=((long long)(a-b)<<32)^(a-c);

            if(first.count(key)) ans=max(ans,i-first[key]);
            else first[key]=i;
        }
        return ans;
    }

    int process(const string &s, char banned, int type){
        int n=s.size(), ans=0, start=0;
        for(int i=0;i<=n;i++){
            if(i==n || s[i]==banned){
                if(start<=i-1)
                    ans=max(ans,solveSegment(s,start,i-1,type));
                start=i+1;
            }
        }
        return ans;
    }

    int longestBalanced(string s) {

        int ans = longestSameChar(s); // handle single-character substrings

        ans=max(ans,process(s,'c',0)); // a=b
        ans=max(ans,process(s,'b',1)); // a=c
        ans=max(ans,process(s,'a',2)); // b=c
        ans=max(ans,solveSegment(s,0,s.size()-1,3)); // a=b=c

        return ans;
    }
};
