Given the head of a singly linked list, your task is to left rotate the linked list k times.
class Solution {
    public Node rotate(Node head, int k) {
        // If the list is empty or k is 0, return the head as is
        if (head == null || k == 0) {
            return head;
        }

        // Find the length of the list
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Handle cases where k > length
        k = k % length;
        if (k == 0) return head; // No rotation needed

        // Make the list circular
        current.next = head;

        // Traverse to the kth node
        for (int i = 0; i < k; i++) {
            current = current.next;
        }

        // Set the new head and break the cycle
        head = current.next;
        current.next = null;

        return head;
    }
}
class Solution {
    public Node rotate(Node head, int k) {
        // If the list is empty or k is 0, return the head as is
        if (head == null || k == 0) {
            return head;
        }

        // Find the length of the list
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Handle cases where k > length
        k = k % length;
        if (k == 0) return head; // No rotation needed

        // Make the list circular
        current.next = head;

        // Traverse to the kth node
        for (int i = 0; i < k; i++) {
            current = current.next;
        }

        // Set the new head and break the cycle
        head = current.next;
        current.next = null;

        return head;
    }
}
