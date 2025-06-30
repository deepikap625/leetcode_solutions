class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(current, i);
        }

        return new int[] {}; 
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        // Input array length
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Input array elements
        int[] nums = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target
        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        // Call twoSum and print result
        int[] result = sol.twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }

        sc.close();
    }
}
