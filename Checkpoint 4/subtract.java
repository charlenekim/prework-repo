/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode firstHalfPtr = A;
        ListNode secondHalfPtr = A;
        
        int L = 1;
        while (secondHalfPtr.next != null) {
            secondHalfPtr = secondHalfPtr.next;
            L++;
        }
        secondHalfPtr = A;
        ListNode secondHalfPtrMinus1 = A;
        int secondHalfIndex = L%2 == 0 ? L/2 + 1 : L/2 + 2;
        for (int i = 2; i <= secondHalfIndex; i++) {
            if (i > 2) {
                secondHalfPtrMinus1 = secondHalfPtrMinus1.next;
            }
            secondHalfPtr = secondHalfPtr.next;
        }
        ListNode reversed = reverse(secondHalfPtr);
        ListNode secondHalfPtr2 = reversed;
        for (int i = 1; i <= L/2; i++) {
            firstHalfPtr.val = secondHalfPtr2.val - firstHalfPtr.val;
            firstHalfPtr = firstHalfPtr.next;
            secondHalfPtr2 = secondHalfPtr2.next;
        }
        ListNode unreversed = reverse(reversed);
        secondHalfPtrMinus1 = unreversed;

        return A;
    }
    
    public ListNode reverse(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode first = A;
        ListNode second = A.next;
        ListNode third = A.next.next;
        first.next = null;
        while (third != null) {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }
        second.next = first;
        return second;
    }
    
    public void printList(ListNode A) {
        while (A != null) {
            System.out.print(A.val + " -> ");
            A = A.next;
        }
        System.out.println();
    }
}
