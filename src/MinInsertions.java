public class MinInsertions {
    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        /*dp代表s[i]到s[j]的最小构造次数*/
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if(s.charAt(i)==s.charAt(j)){
//                    如果两端的字符相同,则最小构造次数不会增加
                    dp[i][j]=dp[i+1][j-1];
                }else{
                    /*如果不相同,则需要把之前的子串变成回文串
                    *有三种情况
                    * 1.插入两次,在左边插入右端的值,在右边插入左端的值,但这是最坏的情况,可能会存在更优的方案
                    * 2.把i+1,j变成回文串，付出dp[i+1][j]的代价，再加上一次插入
                    * 3.把i,j-1变成回文串，付出dp[i][j-1]的代价，再加上一次插入*/

                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[0][n-1];

    }
}
