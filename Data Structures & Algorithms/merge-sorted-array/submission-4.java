class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0, k = 0;
        int[] ans = new int[m + n];

        for (int i = 0; i < m + n; i++) {

            if (j == m) {
                ans[i] = nums2[k++];
            }
            else if (k == n) {
                ans[i] = nums1[j++];
            }
            else if (nums1[j] <= nums2[k]) {
                ans[i] = nums1[j++];
            }
            else {
                ans[i] = nums2[k++];
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
    }
}