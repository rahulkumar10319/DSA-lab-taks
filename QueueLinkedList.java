public class QueueLinkedList {

    private Node front;
    private Node rear;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // enqueue
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(value + " enqueued");
    }

    // dequeue
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int removed = front.data;
        front = front.next;
        if (front == null) rear = null;
        return removed;
    }

    // peek
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // print queue
    public void printQueue() {
        System.out.print("Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // main method to test
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Front element: " + queue.peek());

        queue.enqueue(40);
        queue.printQueue();
    }
}
