// Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list. The task is to remove the loop from the linked list (if it exists).

// Custom Input format:

// A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

// The generated output will be true if there is no loop in list and other nodes in the list remain unchanged, otherwise, false.
/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return; // No loop possible in an empty or single-node list
        }

        Node slow = head;
        Node fast = head;

        // Detect the loop using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, a loop is detected
            if (slow == fast) {
                break;
            }
        }

        // If no loop is detected
        if (fast == null || fast.next == null) {
            return;
        }

        // To remove the loop, set one pointer to the head
        slow = head;

        // If the loop starts at the head, move `fast` to the end of the loop
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            // Move both pointers one step at a time until they meet
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Break the loop
        fast.next = null;
    }
}
