public class queuearray {
    private int[] arr;
    private int size;
    private int rear;
    private int front;

    public queuearray(int capacity) {
        arr = new int[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    // enqueue
    public void enqueue(int value) {
        if (size == arr.length) {
            resize();
        }
        rear++;
        arr[rear] = value;
        size++;
        System.out.println(value + " enqueued");
    }

    // dequeue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int removed = arr[front];
        // shift elements left
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        size--;
        return removed;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // resize
    private void resize() {
        int newSize = arr.length * 2;
        int[] newArr = new int[newSize];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.out.println("Queue resized to " + newSize);
    }

    // print
    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // main method to test
    public static void main(String[] args) {
        queuearray queue = new queuearray(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40); // triggers resize
        queue.printQueue();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Front element: " + queue.peek());
    }
}
