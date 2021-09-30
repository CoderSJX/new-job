import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {
    private Map<String,Integer> memo=new HashMap<>();
    public int superEggDrop(int k, int n) {

        return dp(k,n);
    }

    private int dp(int k, int n) {
        if(k==1)return n;
        if(n==0)return 0;

        if(memo.containsKey(k+";"+n)){
            return memo.get(k+";"+n);
        }

        int min= Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            min=Math.min(min,Math.max(dp(k,n-i),dp(k-1,i-1))+1);
        }

        memo.put(k+";"+n,min);
        return min;

    }
}
