class Deleteopration {
    private int[] items;
    private int count;

    public Deleteopration(int length) {
        items = new int[length];
        count = 0;
    }

    public void insert(int value) {
        if (count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        items[count++] = value;
    }

    public void delete(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Invalid index");
            return;
        }
        for (int i = index; i < count - 1; i++)
            items[i] = items[i + 1];
        count--;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.print(items[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Deleteopration numbers = new Deleteopration(2);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.print();

        numbers.delete(1);
        numbers.print();

        numbers.delete(0);
        numbers.print();
    }
}
