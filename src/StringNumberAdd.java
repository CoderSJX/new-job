public class StringNumberAdd {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.isEmpty()) return num2;
        if (num2 == null || num2.isEmpty()) return num1;
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 - 1, j = len2 - 1;
        int left = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int cur1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int cur2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int temp = (cur1 + cur2 + left) % 10;
            left = (cur1 + cur2 + left) / 10;
            res.append(temp);
        }
        if (left != 0) {
            res.append(left);
        }
        return res.reverse().toString();
    }
}
