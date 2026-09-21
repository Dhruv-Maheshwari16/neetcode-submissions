class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        double median = 0;

        if ((n1 + n2) % 2 == 0) {
            int left = (n1 + n2) / 2;

            if (n1 <= n2) {
                int low = 0;
                int high = n1;

                while (low <= high) {
                    int l1 = Integer.MIN_VALUE;
                    int l2 = Integer.MIN_VALUE;
                    int r1 = Integer.MAX_VALUE;
                    int r2 = Integer.MAX_VALUE;

                    int mid = low + (high - low) / 2;

                    if (mid > 0) {
                        l1 = nums1[mid - 1];
                    }

                    if (left - mid > 0) {
                        l2 = nums2[left - mid - 1];
                    }

                    if (mid < n1) {
                        r1 = nums1[mid];
                    }

                    if (left - mid < n2) {
                        r2 = nums2[left - mid];
                    }

                    if (l1 > r2) {
                        high = mid - 1;
                        continue;
                    }

                    if (l2 > r1) {
                        low = mid + 1;
                        continue;
                    }

                    median = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    break;
                }
            }
            else {
                int low = 0;
                int high = n2;

                while (low <= high) {
                    int l1 = Integer.MIN_VALUE;
                    int l2 = Integer.MIN_VALUE;
                    int r1 = Integer.MAX_VALUE;
                    int r2 = Integer.MAX_VALUE;

                    int mid = low + (high - low) / 2;

                    if (mid > 0) {
                        l1 = nums2[mid - 1];
                    }

                    if (left - mid > 0) {
                        l2 = nums1[left - mid - 1];
                    }

                    if (mid < n2) {
                        r1 = nums2[mid];
                    }

                    if (left - mid < n1) {
                        r2 = nums1[left - mid];
                    }

                    if (l1 > r2) {
                        high = mid - 1;
                        continue;
                    }

                    if (l2 > r1) {
                        low = mid + 1;
                        continue;
                    }

                    median = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    break;
                }
            }
        }
        else {
            int left = (n1 + n2 + 1) / 2;

            if (n1 <= n2) {
                int low = 0;
                int high = n1;

                while (low <= high) {
                    int l1 = Integer.MIN_VALUE;
                    int l2 = Integer.MIN_VALUE;
                    int r1 = Integer.MAX_VALUE;
                    int r2 = Integer.MAX_VALUE;

                    int mid = low + (high - low) / 2;

                    if (mid > 0) {
                        l1 = nums1[mid - 1];
                    }

                    if (left - mid > 0) {
                        l2 = nums2[left - mid - 1];
                    }

                    if (mid < n1) {
                        r1 = nums1[mid];
                    }

                    if (left - mid < n2) {
                        r2 = nums2[left - mid];
                    }

                    if (l1 > r2) {
                        high = mid - 1;
                        continue;
                    }

                    if (l2 > r1) {
                        low = mid + 1;
                        continue;
                    }

                    median = Math.max(l1, l2);
                    break;
                }
            }
            else {
                int low = 0;
                int high = n2;

                while (low <= high) {
                    int l1 = Integer.MIN_VALUE;
                    int l2 = Integer.MIN_VALUE;
                    int r1 = Integer.MAX_VALUE;
                    int r2 = Integer.MAX_VALUE;

                    int mid = low + (high - low) / 2;

                    if (mid > 0) {
                        l1 = nums2[mid - 1];
                    }

                    if (left - mid > 0) {
                        l2 = nums1[left - mid - 1];
                    }

                    if (mid < n2) {
                        r1 = nums2[mid];
                    }

                    if (left - mid < n1) {
                        r2 = nums1[left - mid];
                    }

                    if (l1 > r2) {
                        high = mid - 1;
                        continue;
                    }

                    if (l2 > r1) {
                        low = mid + 1;
                        continue;
                    }

                    median = Math.max(l1, l2);
                    break;
                }
            }
        }

        return median;
    }
}