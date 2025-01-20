// Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.
class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // Base cases: if one of the lists is empty, return the other list
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        // Start with the smaller element
        Node result;
        if (head1.data <= head2.data) {
            result = head1;
            result.next = sortedMerge(head1.next, head2);
        } else {
            result = head2;
            result.next = sortedMerge(head1, head2.next);
        }

        return result;
    }
}
