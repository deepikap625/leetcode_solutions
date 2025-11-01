/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Arrays.sort(nums);
        ListNode nhead=new ListNode(0);
        ListNode ans=nhead;
        ListNode thead=head;
        while(thead!=null){
            if(!binarysearch(thead.val,nums)){
                nhead.next=thead;
                nhead=nhead.next;
            }
            thead=thead.next;
            nhead.next=null;
        }
        return ans.next;
    }
    public boolean binarysearch(int val,int []arr){
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==val)return true;
            if(arr[mid]>val)end=mid-1;
            else start=mid+1;
        }
        return false;
    }
}