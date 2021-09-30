import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,
                (o1, o2) -> o1 - o2
        );
        for (int num : nums) {
            if (queue.size() == k) {
                Integer peek = queue.peek();
                if (peek < num) {
                    queue.poll();
                    queue.add(num);
                }
            } else {
                queue.add(num);
            }

        }
        return queue.peek();

    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }


}
