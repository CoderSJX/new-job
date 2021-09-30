public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return s;
        int len = s.length();
        String res = "";
        for (int i = 0; i < len - 1; i++) {
            String s1 = expandFromCenter(s, i, i + 1);
            String s2 = expandFromCenter(s, i, i);
            if (s1.length() > s2.length()) {
                if (s1.length() > res.length()) res = s1;
            } else {
                if (s2.length() > res.length()) res = s2;
            }
        }
        return res;


    }

    public String expandFromCenter(String s, int left, int right) {
        int i = left, j = right;
        while (i >= 0 && j < s.length()) {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);
            if (leftChar != rightChar) break;
            i--;
            j++;
        }
        return s.substring(i + 1, j);

    }
}