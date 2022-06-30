// 303. Range Sum Query
class NumArray {

    int[] numbers;

    public NumArray(int[] nums) {
        numbers = nums;
    }

    public int sumRange(int left, int right) {
        int result = 0;

        for (int i=left; i<=right; i++) {
            result += numbers[i];
        }

        return result;
    }
}