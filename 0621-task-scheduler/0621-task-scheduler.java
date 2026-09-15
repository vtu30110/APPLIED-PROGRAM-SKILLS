class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of every task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Count how many tasks have maximum frequency
        int countMax = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                countMax++;
            }
        }

        // Calculate minimum intervals
        int answer = (maxFreq - 1) * (n + 1) + countMax;

        // We cannot have fewer intervals than the number of tasks
        return Math.max(tasks.length, answer);
    }
}