import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null && headB != null) {
            if (set.contains(headA)) return headA;
            if (set.contains(headB)) return headB;
            set.add(headA);
            set.add(headB);
            headA = headA.next;
            headB = headB.next;
        }

        while (headA != null) {
            headA = headA.next;
            if (set.contains(headA)) return headA;

        }
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;

    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode point1 = headA, point2 = headB;
        while (point1 != point2) {
            point1 = point1 == null ? headB : point1.next;
            point2 = point2 == null ? headA : point2.next;
        }
        return point1;
    }

}
