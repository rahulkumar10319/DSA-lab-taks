class Dynamicarray {
    private int[] items;
    private int count;

    public Dynamicarray(int length) {
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

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.print(items[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Dynamicarray numbers = new Dynamicarray(2);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.print();
    }
}
