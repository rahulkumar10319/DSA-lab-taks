public class stacklinklist {
    private Node top;

    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // push
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println(value + " pushed to stack");
    }

    // pop
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // check empty
    public boolean isEmpty() {
        return top == null;
    }

    // print stack without modifying it
    public void printStack() {
        Node current = top;
        System.out.print("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // print stack and empty it
    public void printStack2(){
        System.out.println("Printing and emptying stack:");
        while(!isEmpty()) {
            System.out.println(peek());
            pop();
        }
    }

    public static void main(String[] args) {
        stacklinklist stack = new stacklinklist();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack();

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());

        stack.printStack();

        // Use second print function
        stack.printStack2();

        // After printStack2, stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
