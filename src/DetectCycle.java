public class DetectCycle {
    public ListNode detectCycle(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        while(true){
            if(fast==null||fast.next==null)return null;
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)break;
        }
        ListNode pre=head;
        while (pre!=slow){
            pre=pre.next;
            slow=slow.next;
        }
        return pre;

    }
}
