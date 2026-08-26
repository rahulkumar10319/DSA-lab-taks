public class doublylinklist {

    Node head, tail;

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Print forward
    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇆ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Print backward
    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ⇆ ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Delete first node
    public void deleteFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    // Delete last node
    public void deleteLast() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    // Reverse the doubly linked list
    public void reverse() {
        Node curr = head;
        Node temp = null;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Search for an element
    public boolean search(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == value) return true;
            curr = curr.next;
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        doublylinklist dll = new doublylinklist();

        dll.addFirst(20);
        dll.addFirst(10);
        dll.addLast(30);
        dll.addLast(40);

        System.out.print("Original list forward: ");
        dll.printForward();
        System.out.print("Original list backward: ");
        dll.printBackward();

        System.out.println("Search 30: " + dll.search(30));
        System.out.println("Search 50: " + dll.search(50));

        dll.reverse();
        System.out.print("Reversed list forward: ");
        dll.printForward();
        System.out.print("Reversed list backward: ");
        dll.printBackward();
    }
}

