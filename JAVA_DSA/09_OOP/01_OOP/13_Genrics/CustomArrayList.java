/* 
ArrayList without genric

public class CustomArrayList {
    private Object[] items;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList() {
        items = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object item) {
        if (size == items.length) {
            resize();
        }
        items[size++] = item;
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return items[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newArrayObjects = new Object[items.length * 2];
        System.arraycopy(items, 0, newArrayObjects, 0, items.length);
        items = newArrayObjects; // Fix missing assignment to expand array.
    }
}*/


// custom array list with genric type
// genric type provide type safety
// <T> --> this is genric

class CustomArrayList<T> {
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        if (size == data.length) {
            resize();
        }
        data[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}

