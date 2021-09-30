import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char cur = s.charAt(right);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            right++;
            while (window.getOrDefault(cur, 0) > 1) {
                char delete = s.charAt(left);
                window.put(delete, window.getOrDefault(delete, 1) - 1);
                left++;
            }
            res = Math.max(right - left, res);
        }
        return res;

    }
}
