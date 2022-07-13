import java.util.HashMap;

public class MyString {

    // 344. Reverse String
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < s.length / 2) {
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }

    public boolean isVowel(char c)
    {
        return c == 'a' || c == 'i' || c == 'o' || c == 'e' || c == 'u' || c == 'A' || c == 'I' || c == 'O' || c == 'E' || c == 'U';
    }

    // 345. Reverse Vowels of a String
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int start = 0;
        int end = str.length - 1;

        while (start < end) {
            if (isVowel(str[start]) && isVowel(str[end])) {
                char tmp = str[start];
                str[start++] = str[end];
                str[end--] = tmp;
            }
            if (isVowel(str[start]) == false) {
                start++;
            }
            if (isVowel(str[end]) == false) {
                end--;
            }
        }

        return new String(str);
    }

    // 383. Ransom Note
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (alphabets_counter[c-'a'] == 0)
                return false;
            alphabets_counter[c-'a']--;
        }

        return true;
    }

    // 387. First Unique Character in a String
    public int firstUniqChar(String s) {
        var map = new HashMap<Character, Integer>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i=0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    // 389. Find the Difference
    // also possible to use XOR heure
    char findTheDifference(String s, String t)
    {
        char res = 0;

        for (char c : t.toCharArray())
            res += c;

        for (char c : s.toCharArray())
            res -= c;

        return res;
    }

    // 392 Is SubSequence
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int indexS = 0, indexT = 0;

        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length())
                    return true;
            }
            indexT++;
        }
        return false;
    }
}
