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

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
}
