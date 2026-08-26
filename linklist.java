class LL {

    private Node head;
    private int size;

    LL() {
        head = null;
        size = 0;
    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Add at beginning
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add at
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Remove first node
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    // Remove last node
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Get size
    public int getSize() {
        return size;
    }

    // Main method
    public static void main(String[] args) {
        LL list = new LL();

        list.addFirst("A");
        list.addFirst("B");
        list.addLast("C");
        list.addLast("D");

        list.printList();  // B -> A -> C -> D -> null
        System.out.println("Size: " + list.getSize());

        list.removeFirst();
        list.printList();  // A -> C -> D -> null

        list.removeLast();
        list.printList();  // A -> C -> null

        System.out.println("Size: " + list.getSize());
    }
}


