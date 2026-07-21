class Solution {
    public void sortColors(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
    }

    public void mergesort(int[] nums, int s, int e) {
        if (s >= e) return;

        int m = s + (e - s) / 2;

        mergesort(nums, s, m);
        mergesort(nums, m + 1, e);

        merge(nums, s, m, e);
    }

    public void merge(int[] nums, int s, int m, int e) {
        int[] temp = new int[e - s + 1];

        int p1 = s, p2 = m + 1, k = 0;

        while (p1 <= m && p2 <= e) {
            if (nums[p1] <= nums[p2]) {
                temp[k++] = nums[p1++];
            } else {
                temp[k++] = nums[p2++];
            }
        }

        while (p1 <= m) {
            temp[k++] = nums[p1++];
        }
        
        while (p2 <= e) {
            temp[k++] = nums[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[s + i] = temp[i];
        }
    }
}