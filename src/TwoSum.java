import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(map.containsKey(target-cur)){
                Integer index = map.get(target - cur);
                return new int[]{index,i};
            }else{
                map.put(target-cur,i);
            }
        }
        return null;
    }
}
