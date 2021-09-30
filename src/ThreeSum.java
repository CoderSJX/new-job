import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        if(nums==null||nums.length<3)return results;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i]>0)return results;
            if(i>0&&nums[i]==nums[i-1])continue;
            int l=i+1,r=len-1;
            while(l<r){
                int sum=nums[i]+ nums[l]+nums[r];
                if(sum==0){
                    results.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r&&nums[l]==nums[l+1])l++;
                    while(l<r&&nums[r]==nums[r-1])r--;
                    l++;
                    r--;
                }else if(sum<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return results;
    }
}
