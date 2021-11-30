class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int mid;
        int count;
        while (low < high) {
            mid = low + (high - low) / 2;
            count = 0;
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}