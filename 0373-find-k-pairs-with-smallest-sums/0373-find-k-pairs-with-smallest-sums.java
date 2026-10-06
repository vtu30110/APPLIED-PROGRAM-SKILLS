class Solution {
    public List<List<Integer>> kSmallestPairs(
            int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        // Min heap: [index1, index2]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                long sumA = (long) nums1[a[0]] + nums2[a[1]];
                long sumB = (long) nums1[b[0]] + nums2[b[1]];
                return Long.compare(sumA, sumB);
            }
        );

        // Add first pair from each row
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        // Get k smallest pairs
        while (k > 0 && !minHeap.isEmpty()) {

            int[] current = minHeap.poll();

            int i = current[0];
            int j = current[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Move to next element in nums2
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }

            k--;
        }

        return result;
    }
}
