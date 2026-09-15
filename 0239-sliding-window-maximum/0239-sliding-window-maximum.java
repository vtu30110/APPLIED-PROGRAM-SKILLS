import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove elements outside the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Add maximum to result
            if (i >= k - 1) {
                result[index++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}