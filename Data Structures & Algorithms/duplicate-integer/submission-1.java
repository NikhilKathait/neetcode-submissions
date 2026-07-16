class Solution {
    public boolean hasDuplicate(int[] nums) {
        int size = nums.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            else {
                set.add(nums[i]);
            }
        }

        return false;
    }
}