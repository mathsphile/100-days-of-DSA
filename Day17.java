// Given the head of a linked list, the task is to reverse this list and return the reversed head.
class Solution {
    Node reverseList(Node head) {
        Node prev = null; // To store the previous node
        Node current = head; // To traverse the list
        Node next = null; // To store the next node temporarily
        
        while (current != null) {
            next = current.next; // Save the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move the prev pointer to the current node
            current = next; // Move to the next node in the list
        }
        
        return prev; // prev becomes the new head of the reversed list
    }
}
