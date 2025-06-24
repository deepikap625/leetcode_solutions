class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        Set<Integer> result = new HashSet<>();

        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                // i - j <= k
                int start = Math.max(0, j - k);
                int end = Math.min(nums.length - 1, j + k);
                for (int i = start; i <= end; i++) {
                    result.add(i); 
                }
            }
        }

        
        List<Integer> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);

        return sortedResult;
        
    }

    public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 4, 9, 1, 3, 9, 5};
        int key = 9;
        int k = 1;

        List<Integer> result = solution.findKDistantIndices(nums, key, k);
        System.out.println(result);  // Output: [1, 2, 3, 4, 5, 6]
    }
}

}

