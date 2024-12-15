import java.util.Arrays;

/*
 * Find the longest increasing subsequence in an array
 */
public class LongestIncreasingSubsequence {
	public static int findLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; ++i) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = Math.max(dp[i], dp[i - 1] + 1);
			}
		}

		return Arrays.stream(dp).max().orElse(0);
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 1, 2, 6, 3, 7, 8, 101, 18, 19, 20, 34, 66, 0 };
		System.out.println("Length of Longest Increasing Subsequence: " + findLIS(nums));
	}
}
