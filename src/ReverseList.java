public class ReverseList {
    public ListNode reverseList(ListNode head) {
        return helper(head);
    }

    public ListNode helper(ListNode node){
        if(node==null||node.next==null)return node;

        ListNode pre=node;
        ListNode cur=node.next;
        ListNode next=helper(node.next);

        cur.next=pre;
        pre.next=null;
        return next;
    }
}
