// You are given the head of a singly linked list. Your task is to determine if the linked list contains a loop. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.

// Custom Input format:
// A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.
class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Initialize two pointers, slow and fast.
        Node slow = head;
        Node fast = head;

        // Traverse the list with the two pointers.
        while (fast != null && fast.next != null) {
            // Move slow by one step and fast by two steps.
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there's a loop.
            if (slow == fast) {
                return true;
            }
        }

        // If we exit the loop, there's no loop in the list.
        return false;
    }
}