class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String ans=s;
        Queue<String> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        q.add(s);
        set.add(s);

        while(!q.isEmpty()) {
            String curr=q.poll();
            if(curr.compareTo(ans)<0) ans=curr;

            String rotate=curr.substring(curr.length()-b) + curr.substring(0,curr.length()-b);
            String add=add(curr,a);

            if(!set.contains(rotate)) {
                q.add(rotate);
                set.add(rotate);
            }

            if(!set.contains(add)) {
                q.add(add);
                set.add(add);
            }
        }
        return ans;
    }

    String add(String s,int a) {
        char arr[]=s.toCharArray();
        for(int i=1; i<s.length(); i+=2) {
           arr[i] = (char)(((arr[i] - '0' + a) % 10) + '0');
        }
        return new String(arr);
    }
}