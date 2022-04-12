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
