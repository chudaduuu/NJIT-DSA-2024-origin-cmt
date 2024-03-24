package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {

    private Object[] itemArray;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public QueueImplementation(int capacity) {
        this.capacity = capacity;
        itemArray = new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element cannot be null.");
        }
        if (size == capacity) {
            reallocate();
        }
        itemArray[tail] = element;
        tail = (tail + 1) % capacity;
        size++;
    }

    @Override
    public E dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty.");
        }
        E element = (E) itemArray[head];
        itemArray[head] = null;
        head = (head + 1) % capacity;
        size--;
        return element;
    }

    @Override
    public E element() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty.");
        }
        return (E) itemArray[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        itemArray = new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    private void reallocate() {
        int newCapacity = 2 * capacity;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = itemArray[(head + i) % capacity];
        }
        head = 0;
        tail = size;
        itemArray = newArray;
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(itemArray[(head + i) % capacity]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}