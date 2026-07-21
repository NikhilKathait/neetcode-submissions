class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        mergesort(nums, 0, n-1);

        return nums;
    }

    public void mergesort(int[] nums, int s, int e) {
        if (s >= e) return;

        int m = s + (e - s) / 2;

        mergesort(nums, s, m);
        mergesort(nums, m + 1, e);

        merge(nums, s, m , e);
    }

    public void merge(int[] nums, int s, int m, int e) {
        int[] c = new int[e - s + 1];

        int p1 = s, p2 = m + 1, k = 0;

        while (p1 <= m && p2 <= e) {

            if (nums[p1] <= nums[p2]) {
                c[k++] = nums[p1++];
            }
            else {
                c[k++] = nums[p2++];
            }
        }

        while (p1 <= m) {
            c[k++] = nums[p1++];
        }

        while (p2 <= e) {
            c[k++] = nums[p2++];
        }

        for (int i = 0; i < c.length; i++) {
            nums[s + i] = c[i];
        }
    }
}