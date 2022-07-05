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

        for (char symbol : s.toCharArray()) {
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

    // 125. Valid Palindrome
    public boolean isPalindrome(String s) {
        return cleanString(s).reverse().toString().compareToIgnoreCase(cleanString(s).toString()) == 0;
    }

    // Helper for 125. Valid Palindrome
    public StringBuilder cleanString(String s) {
        StringBuilder sb = new StringBuilder();

        for (Character c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                sb.append(c);
        }

        return sb;
    }

    // 121 Best time to buy and sell stock
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;
        int lowestBuy = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestBuy)
                lowestBuy = prices[i];
            currentProfit = prices[i] - lowestBuy;
            if (maxProfit < currentProfit)
                maxProfit = currentProfit;
        }

        return maxProfit;
    }

    // 168. Excel Sheet Column Title
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // we skip 0 otherwise it's classic base 26
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }

        return sb.reverse().toString();
    }

    // 169. Majority Element
    // probably a much smarter algorithm around
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hotmap = new HashMap<>();

        for (int elem : nums) {
            if (hotmap.containsKey(elem)) {
                hotmap.put(elem, hotmap.get(elem) + 1);
            } else {
                hotmap.put(elem, 1);
            }
            if (hotmap.get(elem) > nums.length / 2)
                return elem;
        }

        hotmap.forEach((key, value) -> System.out.println(key + ":" + value));

        return -1;
    }

    // Actual smart solution for 169
    // Boyer-Moore Majority Vote Algorithm
    // see http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
    public int majorityElementSmart(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }


    // 171. Excel sheet column number
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int power = 0;

        for (int i = columnTitle.length() - 1; 0 <= i; i--) {
            char c = columnTitle.charAt(i);
            int digit = (int) c - 'A' + 1;
            System.out.println("digit = " + digit);
            digit = (int) (digit * Math.pow(26, power++));
            result += digit;
        }

        return result;
    }

    // 190. Reverse Bits
    public int reverseBits(int n) {
        if (n == 0)
            return 0;

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1)
                result++;
            n >>= 1;
        }

        return result;
    }

    public int base2to10(String str) {
        int result = 0;
        int pow = str.length() - 1;

        for (Character c : str.toCharArray()) {
            result += (c - '0') * (int) Math.pow(2, pow--);
        }

        return result;
    }

    public String base10to2_reverse(int n) {
        StringBuilder binary = new StringBuilder();

        while (n >= 1) {
            binary.append(n % 2);
            n = n / 2;
        }

        return binary.toString();
    }

    // 191. Number of 1 bits (Hamming weight)
    public int hammingWeight(int n) {
        if (n == 0)
            return 0;

        int result = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                result++;
            n >>= 1;
        }

        return result;
    }


    // 202. Happy Number
    // naive (and probably bugged solution)
    public boolean isHappy(int n) {
        int sum = 0;
        int len = 0;

        if (n == 1 || n == 7)
            return true;

        while (0 < n) {
            len++;
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return len == 1 ? false : isHappy(sum);
    }

    // 205. Isomorphic Strings
    // naive solution
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) {
                return false;
            }
        }

        return true;
    }

    // 217 Contains Duplicate Elements
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num))
                return true;
            map.put(num, true);
        }

        return false;
    }

    // 219. Contains Duplicate Elements II
    public boolean containsDuplicateElements(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i] - i)) <= k)
                return true;
            map.put(nums[i], i);
        }

        return false;
    }

    // 231 Power of two
    // O(log n)
    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;

        while (n % 2 == 0)
            n /= 2;

        return (n == 1);
    }

    // 232 power of two
    //  O(1)
    public boolean isFastPowerOfTwo(int n) {
        return n > 0 && ((n & (n-1)) == 0);


        /*

    n = 2 ^ 0 = 1 = 0b0000...00000001, and (n - 1) = 0 = 0b0000...0000.
    n = 2 ^ 1 = 2 = 0b0000...00000010, and (n - 1) = 1 = 0b0000...0001.
    n = 2 ^ 2 = 4 = 0b0000...00000100, and (n - 1) = 3 = 0b0000...0011.
    n = 2 ^ 3 = 8 = 0b0000...00001000, and (n - 1) = 7 = 0b0000...0111.

    if n = 2^x, then n has only a single bit set to 1, thus n & (n - 1) = 0
         */
    }

    // 242 Valid anagram
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet)
            if (i != 0)
                return false;

        return true;
    }

    // 258. Add Digits
    public static int addDigits(int num) {
        while (10 < num) { // one digit number is smaller than 10
            num = sumOfDigits(num);
        }

        return num;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;

        while (0 < num) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }

    // 263. Ugly number
    public boolean isUgly(int num) {
        if (num==0)
            return false;

        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;

        return num==1;
    }

    // 268. Missing Number
    public int missingNumber(int[] nums) {
        int xor = 0;
        int i = 0;

        while (i < nums.length) {
            xor = xor ^ i ^ nums[i];
            i++;
        }

        return xor ^ i;
    }

    // we define this function to allow compilation for 278 first bad version
    public boolean isBadVersion(int version) {
        return true;
    }

    // 278. First Bad Version
    public int firstBadVersin(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left)/2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int lastPosition = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0)
                nums[lastPosition++] = nums[i];
        }

        for (int i=lastPosition; i<nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 290 Word Pattern
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map index = new HashMap();

        if (words.length != pattern.length())
            return false;

        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;

        return true;
    }

    // 292 Nim Game
    // i propably misunderstood this one
    public boolean canWinNim(int n)
    {
        return n%4 != 0;
    }

    // 326. Power of Three
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;

        while (n % 3 == 0)
            n /= 3;

        return n == 1;
    }

    // same as Hamming weight's, see 191
    public int numberOfOneBits(int n)
    {
        if (n == 0)
            return 0;

        int result = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                result++;
            n >>= 1;
        }

        return result;
    }

    // 338. Counting Bits
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for (int i = 0; i <= n; i++)
            result[i] = numberOfOneBits(i);

        return result;
    }

    // 342 Power of Four
    public boolean isPowerOfFour(int n)
    {
        if (n < 1)
            return false;

        while (n % 4 == 0)
            n /= 4;

        return n == 1;
    }

    public boolean isPowerOf(int n, int m)
    {
        if (n < 1)
            return false;

        while (n % m == 0)
            n /= m;

        return n == 1;
    }

    // 367. Valid Perfect Square
    public boolean isPerfectSquare(int num) {
        int i = 1;

        while (0 < num) {
            num -= i;
            i += 2;
        }

        return num == 0;
    }

    int guess(int n)
    {
        return Integer.compare(n, 42);
    }

    // 374. Guess Number Higher or Lower
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int ret = guess(mid);

            if (ret < 0) {
                high = mid - 1;
            } else if (ret > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
