public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int i = (nums1.length + nums2.length + 1) / 2, j = 0;
        while (i >= 0) {
            int l1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int r1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int l2 = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int r2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if (l1 > r2) {
                i--;
                j++;
            } else if (l2 > r1) {
                i++;
                j--;
            } else {
                return (nums1.length + nums2.length) % 2 == 0
                ? (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2
                : Math.max(l1, l2);
            }
        }

        throw new IllegalArgumentException();

    }
}
