public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode left = head, right = head;
        for (int i = 0; i < k; i++) {
            if (right == null) return head;
            /*这里多保留一个节点*/
            right = right.next;
        }
        ListNode newNode=reverse(left,right);
        left.next=reverseKGroup(right,k);
        return newNode;

    }

    public ListNode reverse(ListNode left, ListNode right) {
        ListNode pre=null;
        ListNode cur=left;
        while(cur!=right){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
