import java.util.*;

public class Misc {

    // 1 Two Sum
    public int[] twoSum(int[] nums, int sum) {
        Map<Integer, Integer> indexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer target = sum - nums[i];
            if (indexes.containsKey(target)) {
                return new int[]{indexes.get(target), i};
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
            sum = sum * 10 + r;
            x = x / 10;
        }

        return (sum == y);
    }

    // 13. Roman to Integer
    public int romanToInt(String s) {
        int result = 0;
        int previous = 0;

        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            int n = switch (symbol) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if (previous < n) {         // if we had I, X, C before current symbol
                result -= previous * 2;   // they were added so we must remove them twice
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

    // 118. Pascal's triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    // 119. Pascal's triangle II
    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }

    // 20. Valid parenthesis
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            switch (c) {
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[')
                        return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{')
                        return false;
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(')
                        return false;
                    stack.pop();
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.isEmpty();
    }

    // 67. add binary
    public String addBinary(String a, String b) {
        if (a.isEmpty())                    // if a=0
            return b;                       // then a+b = b
        if (b.isEmpty())                    // if b=0
            return a;                       // then a+b = a

        StringBuilder sb = new StringBuilder(); // buffer to store results
        int i = a.length() - 1;             // we process `a` from the end (LSB)
        int j = b.length() - 1;             // we process `b` from the end (LSB)
        int carry = 0;                      // initial carry is 0

        while (0 <= i || 0 <= j) {          // while either `a` or `b` still have unprocessed digits
            int sum = carry;                // base sum is previous carry
            if (0 <= i)                     // if `a` still has unprocessed digits
                sum += a.charAt(i--) - '0'; // using ASCII conversion (man ascii) add `a` digit to sum, mark digit as processed
            if (0 <= j)                     // if `b` still has unprocessed digits
                sum += b.charAt(j--) + '0'; // using ASCII conversion (man ascii) add `b` digit to sum, mark digit as processed
            carry = sum > 1 ? 1 : 0;        // sum can only be {0,1,2,3} and carry is set to 1 iff sum=2 or sum=3
            sb.append(sum % 2);             // sum=0 -> result=0 carry=0, sum=1 -> result=1 carry=0, sum=2 -> result=0 carry=1, sum=3 -> result=1 carry=1
        }
        if (carry != 0)                     // if after last digit processed we have remaining carry
            sb.append(carry);               // add it to other digits

        return sb.reverse().toString();     // since we started from the end we have to reverse
    }
}
