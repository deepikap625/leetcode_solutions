class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // We need a larger value
                } else {
                    right--; // We need a smaller value
                }
            }
        }

        return result;
    
    }
}

public class Main{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
            Solution dp = new Solution();

            System.out.println("enter no of elements");
            int n=sc.nextInt();

            int[] nums = new int[n];
            System.out.println("enter the elements");
            for(int i=0; i<n; i++){
                nums[i] =sc.nextInt();
            }   

            List<List<Integer>> triplets = dp.threeSum(nums);
        System.out.println("Triplets sum = 0:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }

        sc.close();
    }
}
