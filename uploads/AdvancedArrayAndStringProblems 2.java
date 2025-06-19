
// Advanced Array and String Problems Solutions

// 1. Maximum Subarray Sum (Kadane’s Algorithm)
public class MaxSubarraySum {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}

// 2. Trapping Rain Water
public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int left = 0, right = n - 1, leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}

// 3. Median of Two Sorted Arrays
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int x = nums1.length, y = nums2.length;
        int low = 0, high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0) return ((double)Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                else return (double)Math.max(maxX, maxY);
            } else if (maxX > minY) high = partitionX - 1;
            else low = partitionX + 1;
        }
        throw new IllegalArgumentException();
    }
}

// 4. Subarray with Given XOR
import java.util.HashMap;
public class SubarrayWithGivenXOR {
    public static int subarrayXor(int[] arr, int m) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int xor = 0, count = 0;
        for (int num : arr) {
            xor ^= num;
            if (xor == m) count++;
            if (freq.containsKey(xor ^ m)) count += freq.get(xor ^ m);
            freq.put(xor, freq.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}

// 5. Sliding Window Maximum
import java.util.Deque;
import java.util.LinkedList;
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) result[i - k + 1] = nums[deque.peek()];
        }
        return result;
    }
}

// 6. Find All Duplicates Without Extra Space
public class FindAllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) result.add(index + 1);
            nums[index] = -nums[index];
        }
        return result;
    }
}

// 7. Product of Array Except Self
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) result[i] = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= left;
            left *= nums[i];
            result[n - 1 - i] *= right;
            right *= nums[n - 1 - i];
        }
        return result;
    }
}

// 8. Minimum Swaps to Sort
public class MinimumSwapsToSort {
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(temp[i], i);
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || map.get(nums[i]) == i) continue;
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                cycleSize++;
            }
            if (cycleSize > 0) swaps += (cycleSize - 1);
        }
        return swaps;
    }
}

// 9. Longest Palindromic Substring
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

// 10. Z-Algorithm for Pattern Matching
public class ZAlgorithm {
    public static int[] calculateZ(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int L = 0, R = 0, K;
        for (int i = 1; i < n; ++i) {
            if (i > R) {
                L = R = i;
                while (R < n && s.charAt(R) == s.charAt(R - L)) R++;
                Z[i] = R - L;
                R--;
            } else {
                K = i - L;
                if (Z[K] < R - i + 1) Z[i] = Z[K];
                else {
                    L = i;
                    while (R < n && s.charAt(R) == s.charAt(R - L)) R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }
}

// 11. Group Anagrams
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

// 12. Minimum Window Substring
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, right = 0, count = t.length(), minLen = Integer.MAX_VALUE, minLeft = 0;
        while (right < s.length()) {
            if (map.getOrDefault(s.charAt(right), 0) > 0) count--;
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
            right++;
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
                if (map.get(s.charAt(left)) > 0) count++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}

// 13. Word Break Problem
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// 14. Count and Say Sequence
public class CountAndSay {
    public static String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) count++;
                else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }
        return result;
    }
}

// 15. Edit Distance (Levenshtein Distance)
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }
}

// 16. Longest Repeating Subsequence
public class LongestRepeatingSubsequence {
    public static int longestRepeatingSubseq(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }
}
