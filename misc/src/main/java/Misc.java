import java.util.HashMap;
import java.util.Map;

public class Misc {

    // 1 Two Sum
    public int[] twoSum(int[] nums, int sum) {
        Map<Integer, Integer> indexes = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            Integer target = sum - nums[i];
            if (indexes.containsKey(target)) {
                int[] result = {indexes.get(target), i};
                return result;
            }
            indexes.put(nums[i], i);
        }

        return null;
    }

    // 9. Palindrome number
    public boolean isPalindrome(int x) {
        int y = x;
        int sum = 0;
        int r;

        while (x > 0) {
            r = x % 10;
            sum = sum*10 + r;
            x = x/10;
        }

        return (sum == y);
    }

    // 136 single number
    // we make use of xor property, if we xor chain all elements only the single one will be remaining
    // for all n, n xor n = 0
    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int n : nums) {
            xor ^= n;
        }

        return xor;
    }
}
