class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); //Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with first 3 elements

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++; // Need bigger sum
                } else if (currentSum > target) {
                    right--; // Need smaller sum
                } else {
                    return currentSum; // Exact match
                }
            }
        }

        return closestSum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solver = new Solution();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        int result = solver.threeSumClosest(nums, target);
        System.out.println("Closest sum to target is: " + result);

        sc.close();
    }
}
