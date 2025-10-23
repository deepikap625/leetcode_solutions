class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<s.length()-1;i++){
                ans.append(((s.charAt(i)-'0')+(s.charAt(i+1)-'0'))%10);
            }
            s=ans.toString();
        }
        return s.charAt(0)==s.charAt(1);
    }
}