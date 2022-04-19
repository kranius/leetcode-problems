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

    // 13. Roman to Integer
    public int romanToInt(String s) {
        int result = 0;
        int previous = 0;

        for (int i=0; i<s.length(); i++) {
            char symbol = s.charAt(i);
            int n = 0;
            switch (symbol) {
                case 'I':
                    n = 1; break;
                case 'V':
                    n = 5; break;
                case 'X':
                    n = 10; break;
                case 'L':
                    n = 50; break;
                case 'C':
                    n = 100; break;
                case 'D':
                    n = 500; break;
                case 'M':
                    n = 1000; break;
            }
            if (previous < n) {         // if we had I, X, C before current symbol
                result -= previous*2;   // they were added so we must remove them twice
            }                           // once for this iteration and once for prev iteration
            result += n;                // because we add regardless of symbol
            previous = n;
        }

        return result;
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

    // 69 sqrt(x)
    // binary search
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int low = 1;
        int high = x / 2 + 1; // sqrt(x) is smaller than x/2
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                return mid;
            else if (mid > x / mid) // left part
                high = mid;
            else
                low = mid + 1; // right part
        }
        return low;
    }
}
